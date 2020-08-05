package com.andawell.common.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;
import org.springframework.web.client.RestTemplate;

/**
 * @author dcy
 * @date 2019/4/28
 * <p>
 * 1. 支持remoteTokenServices 负载均衡
 * 2. 支持 获取用户全部信息
 */
public class BaseResourceServerConfigurerAdapter extends ResourceServerConfigurerAdapter {

    @Autowired
    protected ResourceAuthExceptionEntryPoint resourceAuthExceptionEntryPoint;
    @Autowired
    protected RemoteTokenServices remoteTokenServices;
    @Autowired
    private PermitAllUrlProperties permitAllUrlProperties;
    @Autowired
    private RestTemplate lbRestTemplate;
    /**
     * 默认的配置，对外暴露    http安全配置相关
     *     默认OAuth还是拦截所有
     * @param httpSecurity
     */
    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        //允许使用iframe 嵌套，避免swagger-ui 不被加载的问题
        httpSecurity.headers().frameOptions().disable();
        //设置资源服务器对外暴露的接口，并无需权限配置
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>
                .ExpressionInterceptUrlRegistry registry = httpSecurity
                .authorizeRequests();
        permitAllUrlProperties.getIgnoreUrls()
                .forEach(url -> registry.antMatchers(url).permitAll());
        registry.anyRequest().authenticated()
                .and().csrf().disable();
    }

    /**
     *    资源完全配置相关
     *    以Adapter结尾的是适配器，以Configurer结尾的是配置器，以Builder结尾的是建造器
     * @param resources
     */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        //默认的token转换器
        DefaultAccessTokenConverter accessTokenConverter = new DefaultAccessTokenConverter();

        UserAuthenticationConverter userTokenConverter = new BaseUserAuthenticationConverter();
        accessTokenConverter.setUserTokenConverter(userTokenConverter);

        remoteTokenServices.setRestTemplate(lbRestTemplate);
        //设置远程token的转换器
        remoteTokenServices.setAccessTokenConverter(accessTokenConverter);

        //设置异常处理的返回值
        resources.authenticationEntryPoint(resourceAuthExceptionEntryPoint)
                .tokenServices(remoteTokenServices);
//        resources
//                .tokenServices(remoteTokenServices);
    }

}
