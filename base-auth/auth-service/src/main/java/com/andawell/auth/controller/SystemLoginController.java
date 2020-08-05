package com.andawell.auth.controller;

import com.andawell.auth.constant.NoticeConstant;
import com.andawell.auth.service.BaseTokenService;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.common.service.SysAccountDetailService;
import com.andawell.common.util.WebUtils;
import com.andawell.upms.entity.LoginInfo;
import com.andawell.upms.entity.SysAccountInfo;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

@Api(value = "SystemLoginControllerApi", description = "SystemLoginController的接口", produces =
        MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController

@RequestMapping(value = "login/system")
public class SystemLoginController {
    @Autowired
    private BaseTokenService baseTokenService;
    @Value("${security.oauth2.client.client-id}")
    private String clientId;
    @Autowired
    private SysAccountDetailService sysAccountDetailService;
    private TokenEndpoint tokenEndpoint;
    private static final PasswordEncoder ENCODER = new BCryptPasswordEncoder();

    @GetMapping(value = "/info", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RestResultVo login(LoginInfo loginInfo, HttpServletRequest request) {
        try {
            String username = loginInfo.getUsername();
            String password = loginInfo.getPassword();
            String grantType = null;
            String loginSign = loginInfo.getLoginSign();
            String loginSignFlag = "1";
//            if (StringUtils.isEmpty(username.trim())) {
//                return new RestResultVo(RestStatus.ERROR, NoticeConstant.RESPONSE_ACCOUNT_USERNAME_ISNULL_MESSAGE);
//            }
            SysAccountInfo sysAccountInfo = sysAccountDetailService.loadAccountByUsername(username);
            if (sysAccountInfo == null) {
                return new RestResultVo(RestStatus.ERROR, NoticeConstant.RESPONSE_ACCOUNT_NOT_EXIST_MESSAGE);
            }
//            if (StringUtils.isEmpty(password.trim())) {
//                return new RestResultVo(RestStatus.ERROR, NoticeConstant.RESPONSE_ACCOUNT_PASSWORD_ISNULL_MESSAGE);
//            }
//            Boolean passwordStatus = passwordCheckOut(password, sysAccountInfo.getPassword());
//            if (passwordStatus) {
//                return new RestResultVo(RestStatus.ERROR, NoticeConstant.RESPONSE_ACCOUNT_PASSWORD_ERROR_MESSAGE);
//            }
//
//            OAuth2AccessToken oAuth2AccessTokenDetail = baseTokenService.findTokenByUsername(clientId, username);
//            Boolean tokenStatus = baseTokenService.findTokenStatus(oAuth2AccessTokenDetail);
//            String ip = WebUtils.getIpAddr(request);
//            if (StringUtils.isNotEmpty(loginSign) && loginSignFlag.equals(loginSign) && tokenStatus && !ip.equals(sysAccountInfo.getLastLoginIp())) {
//                //判断当前的登录IP是否和原登录IP一致
//                return new RestResultVo(RestStatus.WAIT_VERIFY, NoticeConstant.RESPONSE_ACCOUNT_LOGIN_LOCATION_IS_OTHER_MESSAGE);
//            }
//            if (tokenStatus) {
//                baseTokenService.removeAccessToken(oAuth2AccessTokenDetail);
//            }
            if (StringUtils.isEmpty(grantType)) {
                grantType = "password";
            } else {
                grantType = loginInfo.getGrantType();
            }

            Map<String, Object> responseEntity = sysAccountDetailService.sysLogin(username, password, grantType);
            return new RestResultVo(RestStatus.SUCCESS, NoticeConstant.RESPONSE_LOGIN_SUCCESS_MESSAGE, responseEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR, NoticeConstant.RESPONSE_LOGIN_ERROR_MESSAGE);
        }
    }

    private Boolean passwordCheckOut(String inputPassword, String originalPassword) {
        if (!ENCODER.matches(inputPassword, originalPassword)) {
            //密码校验失败
            return true;
        } else {
            //密码校验成功
            return false;
        }
    }
}
