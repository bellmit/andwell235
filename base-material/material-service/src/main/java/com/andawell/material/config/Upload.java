package com.andawell.material.config;/**
 * @Date： 2020/6/10 13:23
 */

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *@Auther:liuys
 *@Date:2020/6/10 13:23
 *@Description:
 */
@Data
@Component
@ConfigurationProperties(prefix = "upload")
public class Upload {

    private String path;
}
