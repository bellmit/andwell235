package com.andawell.upms.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
* @ClassName: TXtDw
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月07日 上午11:16:52
*/
@Data
@Getter
@ApiModel("单位查询")
public class TXtDwDto  {
    @ApiModelProperty(name = "id", value = "id", dataType = "String")
    private String id;

    @ApiModelProperty(name = "mc", value = "mc", dataType = "String")
    private String mc;

    @ApiModelProperty(name = "ejm", value = "ejm", dataType = "String")
    private String ejm;

    @ApiModelProperty(name = "pid", value = "pid", dataType = "String")
    private String pid;
    @ApiModelProperty(name = "ip", value = "ip", dataType = "String")
    private String ip;

    @ApiModelProperty(name = "fh", value = "fh", dataType = "String")
    private String fh;

    @ApiModelProperty(name = "lx", value = "lx", dataType = "String")
    private String lx;

    @ApiModelProperty(name = "lxdz", value = "lxdz", dataType = "String")
    private String lxdz;

    @ApiModelProperty(name = "username", value = "username", dataType = "String")
    private String username;

    @ApiModelProperty(name = "password", value = "password", dataType = "String")
    private String password;

    @ApiModelProperty(name = "jc", value = "jc", dataType = "String")
    private String jc;

    @ApiModelProperty(name = "dsn", value = "dsn", dataType = "String")
    private String dsn;

    @ApiModelProperty(name = "istrans", value = "istrans", dataType = "String")
    private String istrans;
}