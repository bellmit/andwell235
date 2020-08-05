package com.andawell.upms;

import com.andawell.common.annotation.EnableBaseResourceServer;
import com.andawell.common.annotation.EnableBaseSwagger2Configuration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author DCY
 * @Description 权限系统管理功能
 */
@EnableEurekaClient
@EnableTransactionManagement
@EnableFeignClients(basePackages = {"com.andawell"})
@EnableHystrix
@EnableSwagger2
@SpringBootApplication
@ComponentScan(basePackages = {"com.andawell"})
@EnableBaseResourceServer
@EnableBaseSwagger2Configuration
@EnableScheduling
@MapperScan("com.andawell.*.mapper")
public class UpmsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UpmsServiceApplication.class, args);
    }

}
