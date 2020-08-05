package com.andawell.gateway.handler;

import com.andawell.gateway.cache.CaptchaCacheMap;
import com.andawell.gateway.util.CaptchaUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author DCY
 * @date 2018/7/5
 * 验证码生成逻辑处理类
 */
@Component
public class LocalIpHandler implements HandlerFunction<ServerResponse> {
    private final static Logger logger = LoggerFactory.getLogger(LocalIpHandler.class);

    @Override
    public Mono<ServerResponse> handle(ServerRequest serverRequest) {
        try {
            return ServerResponse
                    .status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .body(BodyInserters.fromObject(getLocalIP()));
        } catch (Exception e) {
            e.printStackTrace();
            return Mono.error(e);
        }

    }

    public static String getLocalIP() throws UnknownHostException {
        if (isWindowOS()) {
            return InetAddress.getLocalHost().getHostName();
        }
        return null;
    }

    public static boolean isWindowOS() {
        boolean isWindowOs = false;
        String osName = System.getProperty("os.name");
        if (osName.toLowerCase().indexOf("windows") > -1) {
            isWindowOs = true;
        }
        return isWindowOs;
    }
}
