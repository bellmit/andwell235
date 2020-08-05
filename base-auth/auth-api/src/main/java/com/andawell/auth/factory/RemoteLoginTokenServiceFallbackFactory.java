package com.andawell.auth.factory;


import com.andawell.auth.RemoteLoginTokenService;
import com.andawell.auth.fallback.RemoteLoginTokenServiceFallbackImpl;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author dcy
 * @date 2019/4/22
 */
@Component
public class RemoteLoginTokenServiceFallbackFactory implements FallbackFactory<RemoteLoginTokenService> {

    @Override
    public RemoteLoginTokenService create(Throwable throwable) {
        RemoteLoginTokenServiceFallbackImpl remoteLoginTokenServiceFallback = new RemoteLoginTokenServiceFallbackImpl();
        remoteLoginTokenServiceFallback.setCause(throwable);
        return remoteLoginTokenServiceFallback;
    }
}
