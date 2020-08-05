package com.andawell.gateway.config;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.support.NameUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

@Component
@Primary
@AllArgsConstructor
public class SwaggerProvider implements SwaggerResourcesProvider {
    private final static Logger logger = LoggerFactory.getLogger(SwaggerProvider.class);
    public static final String API_URI = "/v2/api-docs";
    private final RouteLocator routeLocator;
    private final GatewayProperties gatewayProperties;

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        List<String> routes = new ArrayList<>();
        //取出gateway的route
        routeLocator.getRoutes().subscribe(route -> routes.add(route.getId()));
        logger.info("gateway中的route"+routes.toString());
        //结合配置的route-路径(Path)，和route过滤，只获取有效的route节点
        gatewayProperties.getRoutes().stream().filter(routeDefinition -> routes.contains(routeDefinition.getId()))
                .forEach(
                        routeDefinition -> routeDefinition.getPredicates().stream()
                        .filter(
                                predicateDefinition -> ("Path").equalsIgnoreCase(predicateDefinition.getName())
                        )
                        .forEach(
                                predicateDefinition -> resources.add(swaggerResource(routeDefinition.getId(),
                                predicateDefinition.getArgs().get(NameUtils.GENERATED_NAME_PREFIX + "0").replace("/**", API_URI)))
                        )
                );
        for(SwaggerResource swaggerResource:resources){
            logger.info("有效的route配置信息:"+swaggerResource.getUrl());
        }
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion("2.0");
        return swaggerResource;
    }
}