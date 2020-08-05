package com.andawell.auth.handler;

import com.andawell.common.handler.AbstractAuthenticationFailureEvenHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * @author DCY   处理登陆失败的方法
 */
@Component
public class BaseAuthenticationFailureEvenHandler extends AbstractAuthenticationFailureEvenHandler {
    private static final Logger logger = LoggerFactory.getLogger(BaseAuthenticationFailureEvenHandler.class);

    /**
     * 处理登录失败方法
     * <p>
     *
     * @param authenticationException 登录的authentication 对象
     * @param authentication          登录的authenticationException 对象
     */
    @Override
    public void handle(AuthenticationException authenticationException, Authentication authentication) {
        logger.error("用户：{} 登录失败，异常：{}", authentication.getPrincipal(), authenticationException.getLocalizedMessage());
    }
}
