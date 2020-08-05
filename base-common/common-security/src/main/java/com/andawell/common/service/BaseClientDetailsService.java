package com.andawell.common.service;

import com.andawell.common.entity.constant.SecurityConstant;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.oauth2.common.exceptions.InvalidClientException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

import javax.sql.DataSource;

public class BaseClientDetailsService extends JdbcClientDetailsService {
    public BaseClientDetailsService(DataSource dataSource) {
        super(dataSource);
    }
    /**
     * 重写原生方法支持redis缓存
     *         将获取到的信息放置在Cache缓存中
     * @param clientId
     * @return
     * @throws InvalidClientException
     */
    @Override
    @Cacheable(value = SecurityConstant.CLIENT_DETAILS_KEY, key = "#clientId", unless = "#result == null")
    public ClientDetails loadClientByClientId(String clientId) {
        return super.loadClientByClientId(clientId);
    }
}
