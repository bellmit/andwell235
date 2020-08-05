package com.andawell.common.log.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.andawell.common.entity.enumeration.RequestExecuteStatus;
import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.log.event.SysLogEvent;
import com.andawell.common.log.util.SysLogUtils;
import com.andawell.upms.entity.LogInfo;
import javassist.*;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.*;

@Component
@Aspect
@Order(3)
public class LogConfig {
    private static final Logger logger = LoggerFactory.getLogger(LogConfig.class);
    private ApplicationEventPublisher publisher;

    LogConfig(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }


    private LogInfo logInfo = new LogInfo();
    private Long startTime = null;
    private Long endTime = null;

    @Pointcut("@annotation(com.andawell.common.entity.annotation.SysLog)")
    public void web() {

    }

    @Before("web()")
    public void doBefore(JoinPoint point) throws NotFoundException, ClassNotFoundException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //获取当前系统时间
        startTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        // 请求的方法名
        String className = point.getTarget().getClass().getName();


        logger.info("类名称:" + className);
        //获取方法名
        String methodName = signature.getName();
        logger.info("方法名称:" + methodName);
        logger.info("[类名]:{},[方法]:{}", className, methodName);


        //operateContent(point, methodName, request);

        //存值
        SysLogUtils.getSysLogInfo(logInfo);
        SysLog syslog = method.getAnnotation(SysLog.class);
        if (syslog != null) {
            // 注解上的描述
            logInfo.setOperation(syslog.value());
            logInfo.setType(syslog.operationType());
        }
        // 系统当前时间
        Date date = new Date();
        logInfo.setCreateTime(date);
        logger.info("请求参数值+++++" + Arrays.toString(point.getArgs()));
        List<Object> argList = new ArrayList<>();
        for (Object arg : point.getArgs()) {
            // request /response 无法使用 toJSON
            if (arg instanceof HttpServletRequest) {
                argList.add("request");
            } else if (arg instanceof HttpServletResponse) {
                argList.add("response");
            } else if (arg instanceof MultipartFile) {
                continue;
            } else {
                argList.add(JSON.toJSON(arg));
            }
        }
        logInfo.setParams(argList.toString());
    }

    @AfterReturning(value = "web()", returning = "returnValue")
    public void doAfterReturning(JoinPoint point, Object returnValue) {
        endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        logInfo.setTime(time);
        logger.info("返回参数值+++++" + JSON.toJSONString(returnValue, SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue));
        logInfo.setStatus(RequestExecuteStatus.Y);
        logInfo.setReturnValue(JSON.toJSONString(returnValue, SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteMapNullValue));
        publisher.publishEvent(new SysLogEvent(logInfo));
    }

    @AfterThrowing(pointcut = "web()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        logInfo.setExceptionCode(e.getClass().getName());
        logInfo.setExceptionDetail(e.getMessage());
        logInfo.setStatus(RequestExecuteStatus.N);
        publisher.publishEvent(new SysLogEvent(logInfo));
    }


    public String operateContent(JoinPoint joinPoint, String methodName, HttpServletRequest request) throws ClassNotFoundException, NotFoundException {
        String className = joinPoint.getTarget().getClass().getName();
        Object[] params = joinPoint.getArgs();
        String classType = joinPoint.getTarget().getClass().getName();
        Class<?> clazz = Class.forName(classType);
        String clazzName = clazz.getName();
        Map<String, Object> nameAndArgs = getFieldsName(this.getClass(), clazzName, methodName, params);
//        StringBuffer bf = new StringBuffer();
//        if (!CollectionUtils.isEmpty(nameAndArgs)){
//            Iterator it = nameAndArgs.entrySet().iterator();
//            while (it.hasNext()){
//                Map.Entry entry = (Map.Entry) it.next();
//                String key = (String) entry.getKey();
//                String value = JSONObject.toJSONString(entry.getValue());
//                bf.append(key).append("=");
//                bf.append(value).append("&");
//            }
//        }
//        if (StringUtils.isEmpty(bf.toString())){
//            bf.append(request.getQueryString());
//        }
        return "测试";
    }

    private Map<String, Object> getFieldsName(Class cls, String clazzName, String methodName, Object[] args) throws NotFoundException {
        Map<String, Object> map = new HashMap<String, Object>();

        ClassPool pool = ClassPool.getDefault();
        ClassClassPath classPath = new ClassClassPath(cls);
        pool.insertClassPath(classPath);

        CtClass cc = pool.get(clazzName);
        CtMethod cm = cc.getDeclaredMethod(methodName);
        MethodInfo methodInfo = cm.getMethodInfo();
        CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
        LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
        if (attr == null) {
            // exception
            return map;
        }
        int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;
        for (int i = 0; i < cm.getParameterTypes().length; i++) {
            //paramNames即参数名
            map.put(attr.variableName(i + pos), args[i]);
            logger.info("第" + i + "参数:参数名为" + attr.variableName(i + pos) + "，参数值为：" + args[i]);
        }
        return map;
    }
}
