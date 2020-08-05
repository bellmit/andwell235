package com.andawell.upms.feign.factory;

import com.andawell.upms.feign.RemoteLogService;
import com.andawell.upms.feign.fallback.RemoteLogServiceFallbackImpl;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author dcy
 * @date 2019/4/22
 */
@Component
public class RemoteLogServiceFallbackFactory implements FallbackFactory<RemoteLogService> {

    @Override
    public RemoteLogService create(Throwable throwable) {
        RemoteLogServiceFallbackImpl remoteLogServiceFallback = new RemoteLogServiceFallbackImpl();
        remoteLogServiceFallback.setCause(throwable);
        return remoteLogServiceFallback;
    }
}
