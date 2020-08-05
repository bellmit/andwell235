package com.andawell.auth;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author dcy
 * @date 2019/4/22
 */
@Component
@FeignClient(value = "auth-service")
public interface RemoteOauth2LoginService {
    /**
     * 获取access_token<br>
     * 这是spring-security-oauth2底层的接口，类TokenEndpoint<br>
     *
     * @param parameters
     * @return
     */
    @PostMapping(path = "/oauth/token")
    ResponseEntity<?> postAccessToken(@RequestParam Map<String, String> parameters);

}
