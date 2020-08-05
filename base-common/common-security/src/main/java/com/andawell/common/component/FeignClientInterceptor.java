package com.andawell.common.component;

import cn.hutool.core.collection.CollUtil;
import com.andawell.common.entity.constant.AuthFlagConstant;
import feign.RequestTemplate;
import org.springframework.cloud.security.oauth2.client.AccessTokenContextRelay;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;

import java.util.Collection;

public class FeignClientInterceptor extends OAuth2FeignRequestInterceptor {
    private OAuth2ClientContext oAuth2ClientContext;
    private AccessTokenContextRelay accessTokenContextRelay;
    public FeignClientInterceptor(OAuth2ClientContext oAuth2ClientContext
            , OAuth2ProtectedResourceDetails resource, AccessTokenContextRelay accessTokenContextRelay) {
        super(oAuth2ClientContext, resource);
        this.oAuth2ClientContext = oAuth2ClientContext;
        this.accessTokenContextRelay = accessTokenContextRelay;
    }
    /**
     * Create a template with the header of provided name and extracted extract
     * 1. 如果使用 非web 请求，header 区别
     * 2. 根据authentication 还原请求token
     *
     * @param template
     */
    @Override
    public void apply(RequestTemplate template) {
         Collection<String> fromHeader = template.headers().get(AuthFlagConstant.AUTH_FLAG_HEADER_NAME);
         //获取请求来源的标志
        if (CollUtil.isNotEmpty(fromHeader) && fromHeader.contains(AuthFlagConstant.AUTH_FLAG_FALSE)) {
            //内部标志
            return;
        }
        accessTokenContextRelay.copyToken();
        if (oAuth2ClientContext != null
                && oAuth2ClientContext.getAccessToken() != null) {
            super.apply(template);
        }
    }
}
