package com.andawell.auth.controller;

import com.andawell.auth.constant.NoticeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 提供针对外部的访问的接口
 */
@Api(value = "token", description = "信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
@RequestMapping(value = "token", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BaseTokenEndpoints {
    @Autowired
    private TokenStore tokenStore;

    /**
     * 退出并删除token
     *
     * @param authHeader Authorization
     */
    @DeleteMapping("/logout")
    public RestResultVo<?> logout(@RequestHeader(value = HttpHeaders.AUTHORIZATION) String authHeader,
                                  HttpServletRequest request) {
        if (StringUtils.isBlank(authHeader)) {
            return new RestResultVo<Boolean>(RestStatus.UNAUTHORIZED,
                    NoticeConstant.RESPONSE_LOGOUT_ERROR_MESSAGE + ',' + NoticeConstant.RESPONSE_TOKEN_ISNULL_MESSAGE, Boolean.FALSE);
        }
        String tokenValue = authHeader.replace(OAuth2AccessToken.BEARER_TYPE, StringUtils.EMPTY).trim();
        OAuth2AccessToken accessToken = tokenStore.readAccessToken(tokenValue);
        if (accessToken == null || StringUtils.isBlank(accessToken.getValue())) {
            return new RestResultVo(RestStatus.UNAUTHORIZED,
                    NoticeConstant.RESPONSE_LOGOUT_ERROR_MESSAGE + ',' + NoticeConstant.RESPONSE_TOKEN_IS_DISABLED_MESSAGE, Boolean.FALSE);
        }
        tokenStore.removeAccessToken(accessToken);
        return new RestResultVo(RestStatus.SUCCESS, NoticeConstant.RESPONSE_LOGOUT_SUCCESS_MESSAGE, Boolean.TRUE);
    }

    /**
     * 验证token的状态
     *
     * @param authHeader Authorization
     */
    @GetMapping("/status")
    public RestResultVo<?> tokenStatus(@RequestHeader(value = HttpHeaders.AUTHORIZATION) String authHeader) {

        //获取token值
        String tokenValue = authHeader.replace(OAuth2AccessToken.BEARER_TYPE, StringUtils.EMPTY).trim();
        if (StringUtils.isBlank(tokenValue)) {
            return new RestResultVo<Boolean>(RestStatus.ERROR, NoticeConstant.RESPONSE_TOKEN_ISNULL_MESSAGE, Boolean.FALSE);
        }
        //获取token对应的信息
        OAuth2AccessToken accessToken = tokenStore.readAccessToken(tokenValue);

        if (accessToken == null || StringUtils.isBlank(accessToken.getValue())) {
            return new RestResultVo<Boolean>(RestStatus.ERROR, NoticeConstant.RESPONSE_TOKEN_IS_DISABLED_MESSAGE, Boolean.FALSE);
        }
        if (accessToken.isExpired()) {
            return new RestResultVo<Boolean>(RestStatus.ERROR, NoticeConstant.RESPONSE_TOKEN_IS_DISABLED_MESSAGE, Boolean.FALSE);
        }
        return new RestResultVo<Boolean>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE, Boolean.TRUE);
    }


}
