package com.andawell.common.config;

import com.andawell.common.annotation.Inner;
import com.andawell.common.entity.constant.AuthFlagConstant;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author dcy
 * @date 2019/04/26
 * <p>
 * 服务间访问接口不进行权限鉴定处理
 */
@Component
@Aspect
public class BaseSecurityInnerConfig implements Ordered {
	private static final Logger logger = LoggerFactory.getLogger(BaseSecurityInnerConfig.class);
	@Autowired
	private  HttpServletRequest request;
	@Pointcut("@annotation(com.andawell.common.annotation.Inner)")
	public void web() {

	}

	@Around("web()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		MethodSignature signature = (MethodSignature) point.getSignature();
		Method method = signature.getMethod();
		logger.warn("请求头:"+request.getHeaderNames());
		String header = request.getHeader(AuthFlagConstant.AUTH_FLAG_HEADER_NAME);
		logger.warn("header:"+header);
		Inner inner = method.getAnnotation(Inner.class);
		if (inner.value() && !StringUtils.equals(AuthFlagConstant.AUTH_FLAG_FALSE, header)) {
			logger.error("访问接口 {} 没有权限", point.getSignature().getName());
			throw new AccessDeniedException("拒绝访问");
		}
		return point.proceed();
	}
	@Override
	public int getOrder() {
		return Ordered.HIGHEST_PRECEDENCE + 1;
	}
}
