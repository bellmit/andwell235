package com.andawell.auth;

import com.andawell.common.entity.vo.RestResultVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author dcy
 * @date 2019/4/22
 */
@Component
@FeignClient(value = "auth-service")
public interface RemoteLoginTokenService {
    @RequestMapping(value = "/principal/getLoginStatus/{username}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method =
            RequestMethod.GET)
    public RestResultVo<Boolean> loginLimit(@PathVariable(value = "username") String username);


    @RequestMapping(value = "/principal/remove/token/{nameCode}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method =
                    RequestMethod.GET)
    public RestResultVo<Boolean> loginRemoveTokenByUsername(@PathVariable(value = "nameCode") String nameCode);

}
