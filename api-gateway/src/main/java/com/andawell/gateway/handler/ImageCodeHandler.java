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

import java.util.HashMap;
import java.util.Map;

/**
 * @author DCY
 * @date 2018/7/5
 * 验证码生成逻辑处理类
 */
@Component
public class ImageCodeHandler implements HandlerFunction<ServerResponse> {
    private final static Logger logger = LoggerFactory.getLogger(ImageCodeHandler.class);

    @Override
    public Mono<ServerResponse> handle(ServerRequest serverRequest) {
        String uuid = serverRequest.headers().asHttpHeaders().getFirst("UUID");
        if (CaptchaCacheMap.getSimpleCaptcha(uuid) != null) {
            CaptchaCacheMap.removeOnly(uuid);
        }
        try {
            //返回验证码和图片的map
            Map<String, String> map = CaptchaUtil.getImageCode(86, 37);
            Map<String, Object> result = new HashMap<String, Object>();
            CaptchaCacheMap.put(uuid, result);
            return ServerResponse
                    .status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .body(BodyInserters.fromObject(map));
        } catch (Exception e) {
            logger.error("ImageIO write err", e);
            return Mono.error(e);
        }

    }
}
