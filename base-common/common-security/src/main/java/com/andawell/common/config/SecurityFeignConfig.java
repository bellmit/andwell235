package com.andawell.common.config;

import com.andawell.common.entity.constant.AuthFlagConstant;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author DCY   请求拦截标识判断
 */
@Configuration
public class SecurityFeignConfig implements RequestInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);
    @Override
    public void apply(RequestTemplate template) {
        logger.info("------feign设置token" + Thread.currentThread().getId());
        template.header(AuthFlagConstant.AUTH_FLAG_HEADER_NAME, AuthFlagConstant.AUTH_FLAG_FALSE);
        HttpServletRequest request=getHttpServletRequest();
        if(null==request){
            return;
        }
        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String name = headerNames.nextElement();
                String values = request.getHeader(name);
                template.header(name, values);
            }
            logger.info("feign interceptor header:{}",template);
        }
    }


    private HttpServletRequest getHttpServletRequest(){
        try{
            return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        }catch (Exception e){
            return null;
        }
    }
}
