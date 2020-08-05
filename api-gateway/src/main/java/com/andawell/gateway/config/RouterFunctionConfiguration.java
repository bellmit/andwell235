
package com.andawell.gateway.config;

import com.andawell.gateway.handler.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

/**
 * 路由配置信息
 */
@Configuration
public class RouterFunctionConfiguration {
    @Autowired
    private HystrixFallbackHandler hystrixFallbackHandler;
    @Autowired
    private SwaggerResourceHandler swaggerResourceHandler;
    @Autowired
    private SwaggerSecurityHandler swaggerSecurityHandler;
    @Autowired
    private SwaggerUiHandler swaggerUiHandler;
    @Autowired
    private ImageCodeHandler imageCodeHandler;

    @Bean
    public RouterFunction routerFunction() {
        return RouterFunctions.route(
                RequestPredicates.path("/fallback")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON_UTF8)), hystrixFallbackHandler)
                .andRoute(RequestPredicates.GET("/code")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON_UTF8)), imageCodeHandler)
                .andRoute(RequestPredicates.GET("/swagger-resources")
                        .and(RequestPredicates.accept(MediaType.ALL)), swaggerResourceHandler)
                .andRoute(RequestPredicates.GET("/swagger-resources/configuration/ui")
                        .and(RequestPredicates.accept(MediaType.ALL)), swaggerUiHandler)
                .andRoute(RequestPredicates.GET("/swagger-resources/configuration/security")
                        .and(RequestPredicates.accept(MediaType.ALL)), swaggerSecurityHandler)
                .andRoute(RequestPredicates.GET("/getSystemIP")
                        .and(RequestPredicates.accept(MediaType.ALL)), swaggerSecurityHandler);


    }

}
