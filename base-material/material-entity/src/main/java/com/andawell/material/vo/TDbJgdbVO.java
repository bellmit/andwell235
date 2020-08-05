package com.andawell.material.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: zje
 * @date: 2020/5/28
 * @description:
 */
@Data
@ApiModel("机关调拨信息")
public class TDbJgdbVO {

    @ApiModelProperty(value = "调拨单号", name = "dbdh", dataType = "String")
    private String dbdh;

    @ApiModelProperty(value = "申请编号", name = "sqdh", dataType = "String")
    private String sqdh;

    @ApiModelProperty(value = "申请单位", name = "sqdw", dataType = "Integer")
    private Integer sqdw;

    @ApiModelProperty(value = "申请人", name = "sqr", dataType = "String")
    private String sqr;

    @ApiModelProperty(value = "申请日期", name = "rq", dataType = "Date")
    private Date rq;

    @ApiModelProperty(value = "机型", name = "jx", dataType = "String")
    private String jx;

    @ApiModelProperty(value = "机型名称", name = "jxmc", dataType = "String")
    private String jxmc;

    @ApiModelProperty(value = "件号", name = "jh", dataType = "String")
    private String jh;

    @ApiModelProperty(value = "件号名称", name = "jhmc", dataType = "String")
    private String jhmc;

    @ApiModelProperty(value = "计量单位", name = "jldwmc", dataType = "String")
    private String  jldwmc;

    @ApiModelProperty(value = "申请数量", name = "sl", dataType = "Integer")
    private Integer sl;

    @ApiModelProperty(value = "申请原因名称", name = "sqyymc", dataType = "String")
    private String sqyymc;

    @ApiModelProperty(value = "申请原因", name = "sqyy", dataType = "String")
    private String sqyy;

    @ApiModelProperty(value = "质量", name = "zl", dataType = "String")
    private String zl;

    @ApiModelProperty(value = "平均单价", name = "dj", dataType = "BigDecimal")
    private BigDecimal dj;

    @ApiModelProperty(value = "接收单位", name = "jsdw", dataType = "String")
    private String jsdw;

}
