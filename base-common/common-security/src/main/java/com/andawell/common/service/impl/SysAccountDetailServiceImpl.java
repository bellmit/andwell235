package com.andawell.common.service.impl;

import com.andawell.auth.RemoteOauth2LoginService;
import com.andawell.common.service.SysAccountDetailService;
import com.andawell.upms.entity.SysAccountInfo;
import com.andawell.upms.feign.RemoteAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.util.OAuth2Utils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 构建平台系统登陆信息
 */
@Service("sysAccountDetailService")
public class SysAccountDetailServiceImpl implements SysAccountDetailService {
    @Autowired
    private RemoteAccountService remoteAccountService;
    @Autowired
    private RemoteOauth2LoginService remoteOauth2LoginService;

    /**
     * 用户名密码登陆
     *
     * @param username
     * @return
     */
    @Override
    public SysAccountInfo loadAccountByUsername(String username) {
        /**
         * 判断当前用户是否登陆，如果已经登陆则，获取登陆后缓存的信息 并返回
         */
        SysAccountInfo sysAccountInfo = remoteAccountService.findAccountInfoDetail(username);
        return sysAccountInfo;
    }

    @Override
    public Map<String, Object> sysLogin(String username, String password, String grantType) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put(OAuth2Utils.GRANT_TYPE, grantType);
        parameters.put(OAuth2Utils.CLIENT_ID, "andawell");
        parameters.put("client_secret", "andawell");
        parameters.put(OAuth2Utils.SCOPE, "server");
        parameters.put("username", username);
        parameters.put("password", password);
        Map<String, Object> responseEntity =
                (Map<String, Object>) remoteOauth2LoginService.postAccessToken(parameters).getBody();
        return responseEntity;
    }


}
