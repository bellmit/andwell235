package com.andawell.common.annotation;

import com.andawell.common.component.BaseResourceServerAutoConfiguration;
import com.andawell.common.component.BaseSecurityBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.lang.annotation.*;

@Documented
@Inherited
@EnableResourceServer
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Import({BaseResourceServerAutoConfiguration.class, BaseSecurityBeanDefinitionRegistrar.class})
public @interface EnableBaseResourceServer {

}
