package com.andawell.common.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsChecker;

public class BasePreAuthenticationChecks implements UserDetailsChecker {
    private static final Logger logger = LoggerFactory.getLogger(BasePreAuthenticationChecks.class);
    private MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();

    @Override
    public void check(UserDetails user) {

        if (!user.isAccountNonLocked()) {
            logger.debug("User account is locked");
            throw new LockedException(messages.getMessage(
                    "AbstractUserDetailsAuthenticationProvider.locked",
                    "当前账户被锁定"));
        }

        if (!user.isEnabled()) {
            logger.debug("User account is disabled");
            throw new DisabledException(messages.getMessage(
                    "AbstractUserDetailsAuthenticationProvider.disabled",
                    "账户不可用"));
        }

        if (!user.isAccountNonExpired()) {
            logger.debug("User account is expired");
            throw new AccountExpiredException(messages.getMessage(
                    "AbstractUserDetailsAuthenticationProvider.expired",
                    "用户登陆信息过期"));
        }
    }
}
