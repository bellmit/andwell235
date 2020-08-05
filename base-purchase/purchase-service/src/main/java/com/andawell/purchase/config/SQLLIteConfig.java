package com.andawell.purchase.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/***
 * @author lhb
 * @Date: 2020/6/10 15:56
 * @Description:
 * @version : V1.0
 */
@ConfigurationProperties(
        prefix = "sqlite"
)
@Component
@Data
public class SQLLIteConfig {

    private String className;

    private String jdbcDriver;

    private String path;

    private String tempDbFilePath;

    private String dbUploadPath;

}
