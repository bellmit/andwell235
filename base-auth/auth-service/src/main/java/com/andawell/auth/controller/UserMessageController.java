package com.andawell.auth.controller;

import com.andawell.auth.service.BaseTokenService;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "principal")
public class UserMessageController {

    @Autowired
    private BaseTokenService baseTokenService;
    @Value("${security.oauth2.client.client-id}")
    private String clientId;

    @GetMapping("/user-me")
    public Authentication principal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication;
    }
//
//    /**
//     * 验证当前用户是否登录
//     */
//    @GetMapping("/getLoginStatus/{username}")
//    public RestResultVo<?> loginLimit(@PathVariable(value = "username") String username) {
//        OAuth2AccessToken oAuth2AccessTokenDetail = baseTokenService.findTokenByUsername(clientId, username);
//        Boolean tokenStatus = baseTokenService.findTokenStatus(oAuth2AccessTokenDetail);
//        return new RestResultVo<>(RestStatus.SUCCESS, "查询成功", tokenStatus);
//    }
//
//
//    /**
//     * 删除token信息
//     */
//    @GetMapping("/remove/token/{nameCode}")
//    public RestResultVo<?> loginRemoveTokenByUsername(@PathVariable(value = "nameCode") String nameCode) {
//        try {
//            OAuth2AccessToken oAuth2AccessTokenDetail = baseTokenService.findTokenByUsername(clientId, nameCode);
//            Boolean tokenStatus = baseTokenService.findTokenStatus(oAuth2AccessTokenDetail);
//            if (tokenStatus) {
//                baseTokenService.removeAccessToken(oAuth2AccessTokenDetail);
//            }
//            return new RestResultVo<>(RestStatus.SUCCESS, "删除成功", Boolean.TRUE);
//        }catch (Exception e){
//            e.printStackTrace();
//            return new RestResultVo<>(RestStatus.SUCCESS, "删除失败", Boolean.FALSE);
//        }
//
//    }

}