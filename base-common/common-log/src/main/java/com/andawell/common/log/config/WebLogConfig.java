package com.andawell.common.log.config;

import com.alibaba.fastjson.JSON;
import com.andawell.common.entity.dto.PageDto;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.common.log.util.WebUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author DCY
 * @Description 系统操作日志打印
 */
@Component
@Aspect
@Order(2)
public class WebLogConfig {
    private static final Logger logger = LoggerFactory.getLogger(WebLogConfig.class);

    /**
     * 两个..代表所有子目录，最后括号里的两个..代表所有参数
     */
    @Pointcut("execution(public com.andawell.common.entity.vo.RestResultVo com.andawell..*.controller.*Controller.*(." +
            ".))")
    public void web() {
    }

    @Before("web()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        logger.info("请求IP" + WebUtils.getIpAddr(request));
        logger.info("请求地址 : " + request.getRequestURL().toString());
        logger.info("HTTP METHOD : " + request.getMethod());
        // 获取真实的ip地址
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName());
        logger.info("请求参数 : " + Arrays.toString(joinPoint.getArgs()));
        // 参数名 组名
        String[] parameterNames = ((MethodSignature) joinPoint.getSignature()).getParameterNames();

        List<Object> argList = new ArrayList<>();
        for (Object arg : joinPoint.getArgs()) {
            // request /response 无法使用 toJSON
            if(arg instanceof  HttpServletRequest){
                argList.add("request");
            }else if(arg instanceof HttpServletResponse){
                argList.add("response");
            }else if(arg instanceof MultipartFile){
                continue;
            }else {
                argList.add(JSON.toJSON(arg));
            }
        }
       // System.out.println(JSON.toJSON(argList));

        logger.info("{}-> 方法({}) ->参数：{} - {}",
                joinPoint.getSignature().getDeclaringTypeName(),joinPoint.getSignature().getName(),
                JSON.toJSON(parameterNames),
                JSON.toJSON(argList));

    }

    /**
     * returning的值和doAfterReturning的参数名一致
     *
     * @param ret
     */

    @AfterReturning(returning = "ret", pointcut = "web()")
    public void doAfterReturning(Object ret) {
        // 处理完请求，返回内容(返回值太复杂时，打印的是物理存储空间的地址)
        if(ret==null){
            logger.info("返回参数={} ", "");
        }else {
            RestResultVo<?> resultVo = new RestResultVo<>();
            BeanUtils.copyProperties(ret,resultVo,"data");
            logger.info("返回参数={}: ",  JSON.toJSONString(resultVo));
        }
    }

    @Around("web()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object ob = pjp.proceed();
        // ob 为方法的返回值
        logger.info("当前请求耗时 : " + (System.currentTimeMillis() - startTime));
        return ob;
    }
}
