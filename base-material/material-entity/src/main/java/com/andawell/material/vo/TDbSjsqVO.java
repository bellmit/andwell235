package com.andawell.material.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author: zje
 * @date: 2020/5/29
 * @description:
 */

@Data
@ApiModel("机关调拨信息")
public class TDbSjsqVO {

    @ApiModelProperty(value = "调拨单号", name = "dbdh", dataType = "String")
    private String dbdh;

    @ApiModelProperty(value = "申请编号", name = "sqdh", dataType = "String")
    private String sqdh;

    @ApiModelProperty(value = "申请单位名称", name = "sqdw", dataType = "String")
    private String sqdwmc;

    @ApiModelProperty(value = "申请单位", name = "sqdw", dataType = "String")
    private String sqdw;

    @ApiModelProperty(value = "申请人名称", name = "sqr", dataType = "String")
    private String sqrmc;

    @ApiModelProperty(value = "申请人", name = "sqr", dataType = "String")
    private String sqr;

    @ApiModelProperty(value = "申请日期", name = "rq", dataType = "Date")
    private String rq;

    @ApiModelProperty(value = "调拨类型", name = "dblx", dataType = "String")
    private String dblx;

    @ApiModelProperty(value = "处理状态", name = "clzt", dataType = "String")
    private String clzt;
}
