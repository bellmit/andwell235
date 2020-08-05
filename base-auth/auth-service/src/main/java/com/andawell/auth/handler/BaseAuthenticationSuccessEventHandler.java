package com.andawell.auth.handler;

import com.andawell.common.handler.AbstractAuthenticationSuccessEventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 *   处理登录成功方法
 *
 * @author DCY
 */
@Component
public class BaseAuthenticationSuccessEventHandler extends AbstractAuthenticationSuccessEventHandler {
    private static final Logger logger = LoggerFactory.getLogger(BaseAuthenticationSuccessEventHandler.class);
    /**
     * 处理登录成功方法
     * <p>
     * 获取到登录的authentication 对象
     *
     * @param authentication 登录对象
     */
    @Override
    public void handle(Authentication authentication) {
        logger.info("用户：{} 登录成功", authentication.getPrincipal());
    }
}
