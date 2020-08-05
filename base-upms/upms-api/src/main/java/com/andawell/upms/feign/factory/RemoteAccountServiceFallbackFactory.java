package com.andawell.upms.feign.factory;

import com.andawell.upms.feign.RemoteAccountService;
import com.andawell.upms.feign.fallback.RemoteAccountServiceFallbackImpl;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author dcy
 * @date 2019/4/22
 */
@Component
public class RemoteAccountServiceFallbackFactory implements FallbackFactory<RemoteAccountService> {

    @Override
    public RemoteAccountService create(Throwable throwable) {
        RemoteAccountServiceFallbackImpl remoteAccountServiceFallback = new RemoteAccountServiceFallbackImpl();
        remoteAccountServiceFallback.setCause(throwable);
        return remoteAccountServiceFallback;
    }
}
