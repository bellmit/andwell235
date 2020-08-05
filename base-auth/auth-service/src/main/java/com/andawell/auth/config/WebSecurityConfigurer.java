package com.andawell.auth.config;

import com.andawell.common.service.SysUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author dcy
 * @date 2019/4/22
 * 认证相关配置
 */
@Primary
@Order(90)
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
    @Autowired
    private SysUserDetailService sysUserDetailService;

    /**
     * 与Http的安全配置相关
     *
     * @param http
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.logout().permitAll()
                .and()
                .authorizeRequests()
                .antMatchers(
                        "/actuator/**",
                        "/token/**", "/oauth/**", "/principal/getLoginStatus/**", "/staff/info/detail/**",
                        "/principal/remove/token/**","/login/system/info").permitAll()
                // 其余所有请求全部需要鉴权认证
                .anyRequest().authenticated()
                .and().csrf().disable().httpBasic().disable();
    }

    /**
     * 配置AuthenticationManager
     */

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(sysUserDetailService);
        provider.setPasswordEncoder(passwordEncoder());
        provider.setHideUserNotFoundExceptions(false);
        return provider;
    }

    /**
     * 配置这个bean会在做AuthorizationServerConfigurer配置的时候使用   配置password模式
     *
     * @return
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    /**
     * password 支持多种编码，通过密码的前缀区分编码方式,推荐
     * 用于声名账户名和密码的加密方式
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        DelegatingPasswordEncoder delegatingPasswordEncoder =
                (DelegatingPasswordEncoder) PasswordEncoderFactories.createDelegatingPasswordEncoder();
        //设置defaultPasswordEncoderForMatches为NoOpPasswordEncoder
        delegatingPasswordEncoder.setDefaultPasswordEncoderForMatches(NoOpPasswordEncoder.getInstance());
        return delegatingPasswordEncoder;
    }

}
