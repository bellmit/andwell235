package com.andawell.auth;

import com.andawell.common.annotation.EnableBaseSwagger2Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaClient
@EnableTransactionManagement
@EnableFeignClients(basePackages = {"com.andawell"})
@EnableHystrix
@EnableSwagger2
@SpringBootApplication
@ComponentScan(basePackages = {"com.andawell"})
@EnableBaseSwagger2Configuration
public class AuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }

}
