package com.andawell.common.log.config;

import com.andawell.common.log.event.SysLogListener;
import com.andawell.upms.feign.RemoteLogService;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@Configuration
@AllArgsConstructor
@ConditionalOnWebApplication
public class LogAutoConfiguration {
    private final RemoteLogService remoteLogService;

    @Bean
    public SysLogListener sysLogListener() {
        return new SysLogListener(remoteLogService);
    }

    @Bean
    public LogConfig logConfig(ApplicationEventPublisher publisher) {
        return new LogConfig(publisher);
    }
}
