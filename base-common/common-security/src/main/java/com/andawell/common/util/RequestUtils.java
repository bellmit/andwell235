package com.andawell.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import javassist.*;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;
import org.aspectj.lang.JoinPoint;

import java.util.HashMap;
import java.util.Map;

public class RequestUtils {
    public static Map<String,Object> getJoinPointInfoMap(JoinPoint joinPoint){
        Map<String,Object> joinPointInfo=new HashMap<String, Object>();
        String classPath=joinPoint.getTarget().getClass().getName();
        String methodName=joinPoint.getSignature().getName();
        joinPointInfo.put("classPath",classPath);
        joinPointInfo.put("methodName",methodName);
        Class<?> clazz=null;
        CtMethod ctMethod=null;
        LocalVariableAttribute attr=null;
        int length=0;
        int pos=0;
        try{
            clazz=Class.forName(classPath);
            String clazzName=clazz.getName();
            ClassPool pool=ClassPool.getDefault();
            ClassClassPath classClassPath=new ClassClassPath(clazz);
            pool.insertClassPath(classClassPath);
            CtClass ctClass=pool.get(clazzName);
            MethodInfo methodInfo=ctMethod.getMethodInfo();
            CodeAttribute codeAttribute=methodInfo.getCodeAttribute();
            attr=(LocalVariableAttribute)codeAttribute.getAttribute(LocalVariableAttribute.tag);
            if(attr==null){
                return joinPointInfo;
            }
            length=ctMethod.getParameterTypes().length;
            pos= Modifier.isStatic(ctMethod.getModifiers())?0:1;
        }catch (Exception e){
            e.printStackTrace();
        }
        Map<String,Object> paramMap=new HashMap<String, Object>();
        Object[] paramArgsValues=joinPoint.getArgs();
        String[] paramsArgsNames=new String[length];
        for(int i=0;i<length;i++){
            paramsArgsNames[i]=attr.variableName(i+pos);
            String paramsArgsName=attr.variableName(i+pos);
            if(paramsArgsName.equalsIgnoreCase("request")||paramsArgsName.equalsIgnoreCase("response")||paramsArgsName.equalsIgnoreCase("session")){
                break;
            }
            Object paramsArgsValue=paramArgsValues[i];
            paramMap.put(paramsArgsName,paramsArgsValue);
        }
        joinPointInfo.put("paramsMap", JSON.toJSONString(paramMap, SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue));
        return joinPointInfo;
    }
}
