package com.andawell.auth.factory;


import com.andawell.auth.RemoteOauth2LoginService;
import com.andawell.auth.fallback.RemoteOauth2LoginServiceFallbackImpl;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author dcy
 * @date 2019/4/22
 */
@Component
public class RemoteOauth2LoginServiceFallbackFactory implements FallbackFactory<RemoteOauth2LoginService> {

    @Override
    public RemoteOauth2LoginService create(Throwable throwable) {
        RemoteOauth2LoginServiceFallbackImpl remoteLoginTokenServiceFallback = new RemoteOauth2LoginServiceFallbackImpl();
        remoteLoginTokenServiceFallback.setCause(throwable);
        return remoteLoginTokenServiceFallback;
    }
}
