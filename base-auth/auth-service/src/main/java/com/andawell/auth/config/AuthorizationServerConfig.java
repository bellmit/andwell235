package com.andawell.auth.config;

import com.andawell.common.entity.BaseUser;
import com.andawell.common.entity.constant.SecurityConstant;
import com.andawell.common.service.BaseClientDetailsService;
import com.andawell.common.service.SysUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAuthenticationKeyGenerator;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author DCY
 * 配置一个认证服务器，启动后会自动生成几个Endpoints
 * /oauth/authorize：验证
 * /oauth/token：获取token
 * /oauth/confirm_access：用户授权
 * /oauth/error：认证失败
 * /oauth/check_token：资源服务器用来校验token
 * /oauth/token_key：如果jwt模式则可以用此来从认证服务器获取公钥
 * @EnableAuthorizationServer 注解来配置OAuth2.0 授权服务机制，通过使用@Bean注解的几个方法一起来配置这个授权服务
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    /**
     * 注入authenticationManager
     * 来支持 password grant type
     */
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SysUserDetailService sysUserDetailService;
    //@Value("")
    //private String authCenterType;

    @Autowired
    private DataSource dataSource;

    /**
     * 配置OAuth2的客户端相关信息
     *
     * @param clients ClientDetailsServiceConfigurer：用来配置客户端详情服务（ClientDetailsService），客户端详情信息在这里进行初始化，你能够把客户端详情信息写死在这里或者是通过数据库来存储调取详情信息
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //   将信息存储在数据库中
        BaseClientDetailsService clientDetailsService = new BaseClientDetailsService(dataSource);
        clientDetailsService.setSelectClientDetailsSql(SecurityConstant.DEFAULT_SELECT_STATEMENT);
        clientDetailsService.setFindClientDetailsSql(SecurityConstant.DEFAULT_FIND_STATEMENT);
        clients.withClientDetails(clientDetailsService);
    }


    /**
     * 配置AuthorizationServer安全认证的相关信息，创建ClientCredentialsTokenEndpointFilter核心过滤器
     *
     * @param oauthServer AuthorizationServerSecurityConfigurer：用来配置令牌端点(Token Endpoint)的安全约束.
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
        /**
         *  允许进行表单认证
         */
        oauthServer
                //允许security和oauth使用相同的认证方式
                .allowFormAuthenticationForClients()
                // 开启/oauth/check_token验证端口认证权限访问
                // 验证获取Token的验证信息
                //配置检验令牌允许访问端点
                .checkTokenAccess("isAuthenticated()")
                // 开启/oauth/token_key验证端口无权限访问
                // 对获取Token的请求不再拦截
                // 配置请求令牌端点允许访问规则
                .tokenKeyAccess("permitAll()");
    }

    /**
     *    配置AuthorizationServerEndpointsConfigurer众多相关类，包括配置身份认证器，配置认证方式，TokenStore，TokenGranter，OAuth2RequestFactory
     * @param endpoints
     */
    /**
     * oauth_access_token表是存放访问令牌的
     * 但是并没有直接在字段中存放token。Spring 使用OAuth2AccessToken来抽象与令牌有关的所有属性
     * 在写入到数据库时，Spring将该对象通过JDK自带的序列化机制序列成字节直接保存到了该表的token字段中
     * 也就是说，如果只看数据表你是看不出access_token的值是多少，过期时间等信息的
     * AuthorizationServerEndpointsConfigurer：用来配置授权（authorization）以及令牌（token）的访问端点和令牌服务(token services)。
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {

        endpoints
                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST)
                .userDetailsService(sysUserDetailService)
                .authenticationManager(authenticationManager)
                .reuseRefreshTokens(false);
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(tokenStore());
        tokenServices.setClientDetailsService(endpoints.getClientDetailsService());
        tokenServices.setTokenEnhancer(tokenEnhancer());
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setAccessTokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(30));
        tokenServices.setRefreshTokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(30));
        endpoints.tokenServices(tokenServices);

//        UserDetailsService userDetailsService=null;
//        if("old".equals(authCenterType)){
//            userDetailsService=sysUserDetailService;
//        }else{
//            userDetailsService=null;
//        }
//        endpoints.userDetailsService(userDetailsService);
    }

    /**
     * 三个实现方式如下：
     * (1)默认的InMemoryTokenStore对于单台服务器的实现，是一个很好的选择
     * (2)JdbcTokenStore是一个JDBC版本的实现。要使用JdbcTokenStore，你需要引用spring-jdbc库。
     * (3)JSON Web Token (JWT)版本的实现，将所有的信息编码到token本身之中。这个实现的弊端在于，
     * 你不能轻易的使token失效。所以其一般配以较短的失效时间，而失效时再refresh token中处理。
     * 另一个弊端是，如果存储了过多的用户信息在token中，该token可能变得十分庞大。
     * 从这个意义上来说JwtTokenStore并不是一个真正的Store，因为其并不持久化任何数据，但其处理了token与授权信息之间的转换工作。
     *
     * @return
     */

    @Bean
    public TokenStore tokenStore() {
        JdbcTokenStore tokenStore = new JdbcTokenStore(dataSource);
        tokenStore.setAuthenticationKeyGenerator(new DefaultAuthenticationKeyGenerator() {
            @Override
            public String extractKey(OAuth2Authentication authentication) {
                return super.extractKey(authentication);
            }
        });
        return tokenStore;
    }

    /**
     * token加强，客户端模式下不进行增强。
     *
     * @return TokenEnhancer
     */
    @Bean
    public TokenEnhancer tokenEnhancer() {
        return (accessToken, authentication) -> {
            if (SecurityConstant.CLIENT_CREDENTIALS.equals(authentication.getOAuth2Request().getGrantType())) {
                return accessToken;
            }
            /**
             * 验证token是否存在
             */
            final Map<String, Object> authUserInfo = new HashMap<>(8);
            BaseUser authUser = (BaseUser) authentication.getUserAuthentication().getPrincipal();
            authUserInfo.put(SecurityConstant.DETAILS_USER_ID, authUser.getId());
            authUserInfo.put(SecurityConstant.DETAILS_USERNAME, authUser.getUsername());
            authUserInfo.put(SecurityConstant.DETAILS_NAME, authUser.getName());
            authUserInfo.put(SecurityConstant.DETAILS_DEPT_ID, authUser.getDeptId());
            authUserInfo.put(SecurityConstant.DETAILS_DOOR_ID, authUser.getDoorId());
            authUserInfo.put(SecurityConstant.DETAILS_ROLE_ID, authUser.getRoleId());
            authUserInfo.put(SecurityConstant.DETAILS_LICENSE, SecurityConstant.ANDAWELL_LICENSE);
            authUserInfo.put(SecurityConstant.DETAILS_PERMISSION, authUser.getPermission());
            authUserInfo.put(SecurityConstant.DETAILS_DEFAULT_INVENTORY, authUser.getDefaultInventory());
            authUserInfo.put(SecurityConstant.DETAILS_DEFAULT_USABLE_INVENTORY, authUser.getDefaultUsableInventory());
            authUserInfo.put(SecurityConstant.DETAILS_DEFAULT_REPAIR_INVENTORY, authUser.getDefaultRepairInventory());
            authUserInfo.put(SecurityConstant.DETAILS_DEFAULT_SCRAP_INVENTORY, authUser.getDefaultScrapInventory());
            authUserInfo.put(SecurityConstant.DETAILS_MENUAPPPERMISSION, authUser.getMenuAppPermission());
            authUserInfo.put(SecurityConstant.DETAILS_DATEDEPTPERMESSION, authUser.getDateDeptPermission());
            authUserInfo.put(SecurityConstant.DETAILS_DATEPLANEPERMISSION, authUser.getDatePlanePermission());
            authUserInfo.put(SecurityConstant.DETAILS_DATEMATEPERMISSION, authUser.getDateMatePermission());
            ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(authUserInfo);
            return accessToken;
        };
    }

}
