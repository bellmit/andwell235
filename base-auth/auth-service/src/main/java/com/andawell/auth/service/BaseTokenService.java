package com.andawell.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


@Service
public class BaseTokenService {
    @Autowired
    private TokenStore tokenStore;

    public void removeAccessToken(OAuth2AccessToken oAuth2AccessTokenDetail) {
        tokenStore.removeAccessToken(oAuth2AccessTokenDetail);
    }

    public Boolean findTokenStatus(OAuth2AccessToken oAuth2AccessTokenDetail) {
        if (oAuth2AccessTokenDetail != null) {
            if (oAuth2AccessTokenDetail.isExpired()) {
                return Boolean.FALSE;
            } else {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public OAuth2AccessToken findTokenByUsername(String clientId, String username) {
        List<OAuth2AccessToken> oAuth2AccessTokenList = new ArrayList<>();
        Collection<OAuth2AccessToken> oAuth2AccessTokenCollection = tokenStore.findTokensByClientIdAndUserName(clientId, username);
        if (!oAuth2AccessTokenCollection.isEmpty()) {
            Iterator it = oAuth2AccessTokenCollection.iterator();
            while (it.hasNext()) {
                OAuth2AccessToken oAuth2AccessToken = (OAuth2AccessToken) it.next();
                oAuth2AccessTokenList.add(oAuth2AccessToken);
            }
        }
        OAuth2AccessToken oAuth2AccessTokenDetail = null;
        if (oAuth2AccessTokenList != null && oAuth2AccessTokenList.size() > 0) {
            oAuth2AccessTokenDetail = oAuth2AccessTokenList.get(0);
        }
        return oAuth2AccessTokenDetail;
    }
}
