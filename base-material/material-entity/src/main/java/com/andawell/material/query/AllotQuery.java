package com.andawell.material.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/***
 * @author hwd
 * @Date: 2020-05-30 11:29
 * @Description:调拨查询
 * @version : V1.0
 */
@Data
@Accessors(chain = true)
public class AllotQuery {

    @ApiModelProperty(value = "申请单号",dataType = "String")
    private String sqdh;
    @ApiModelProperty(value = "机型",dataType = "String")
    private String jx;
    @ApiModelProperty(value = "件号",dataType = "String")
    private String jh;
    @ApiModelProperty(value = "发付单位",dataType = "String")
    private String ffdw;
    @ApiModelProperty(value = "接收单位",dataType = "String")
    private String jsdw;
    @ApiModelProperty(value = "用户单位",dataType = "String")
    private String userdw;

    private String dbdh;

    private String zl;
}
