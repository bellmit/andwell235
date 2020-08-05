package com.andawell.gateway.filter;

import com.andawell.common.entity.constant.SecurityConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.gateway.cache.CaptchaCacheMap;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Map;

@Component
public class VerifyHeaderFilter extends AbstractGatewayFilterFactory {
    private final static Logger logger = LoggerFactory.getLogger(VerifyHeaderFilter.class);
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            String path = request.getURI().getPath();
            logger.info("过滤的请求路径:" + path);
            // 不是登录请求，直接向下执行
            String loginSignFlag = "1";
            String loginSign = request.getQueryParams().getFirst("loginSign");
            if (!StringUtils.containsIgnoreCase(path, SecurityConstant.LOGIN_URL)) {
                return chain.filter(exchange);
            }
            if (StringUtils.containsIgnoreCase(path, SecurityConstant.LOGIN_URL) && loginSignFlag.equals(loginSign)) {
                return chain.filter(exchange);
            }
//            if (!StringUtils.containsIgnoreCase(path,
//                    SecurityConstant.OAUTH_TOKEN_URL)) {
//                return chain.filter(exchange);
//            }
//            String grantType = request.getQueryParams().getFirst("grant_type");
//            // 刷新token，直接向下执行
//            if (StringUtils.containsIgnoreCase(path,
//                    SecurityConstant.OAUTH_TOKEN_URL) && StringUtils.equals(SecurityConstant.REFRESH_TOKEN, grantType)) {
//                return chain.filter(exchange);
//            }

            try {
                //校验验证码
                checkCode(request);
            } catch (Exception e) {
                ServerHttpResponse response = exchange.getResponse();
                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                try {
                    return response.writeWith(Mono.just(response.bufferFactory()
                            .wrap(objectMapper.writeValueAsBytes(
                                    RestResultVo.builder().message(e.getMessage())
                                            .statusCode(RestStatus.UNAUTHORIZED).build()))));
                } catch (JsonProcessingException e1) {
                    logger.error("对象输出异常", e1);
                }
            }
            return chain.filter(exchange);
        };
    }


    private void checkCode(ServerHttpRequest request) throws Exception {
        String code = request.getHeaders().getFirst("code");
        if (StringUtils.isBlank(code)) {
            throw new Exception("验证码不能为空");
        }
        String uuid = request.getHeaders().getFirst("UUID");
        if (StringUtils.isEmpty(uuid)) {
            logger.error("未找到对应的验证码信息{}:");
            throw new Exception("未找到对应的验证码信息{}:");

        }
        Map<String, Object> map = CaptchaCacheMap.getSimpleCaptcha(uuid);
        if (map == null) {
            throw new Exception("验证码不能为空");
        }
        String str = (String) map.get(SecurityConstant.CAPTCHA_STRING_ENSURE);
        if (StringUtils.isEmpty(str)) {
            logger.error("验证码已过期{}:" + str);
            throw new Exception("验证码已过期");

        }
        if (!str.equals(code)) {
            logger.error("验证码错误{}:" + code);
            throw new Exception("验证码错误");
        }
        if (uuid != null) {
            CaptchaCacheMap.removeOnly(uuid);
        }

    }

}