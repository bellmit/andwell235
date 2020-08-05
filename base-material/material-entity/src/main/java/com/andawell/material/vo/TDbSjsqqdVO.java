package com.andawell.material.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: zje
 * @date: 2020/5/28
 * @description:
 */

@Data
@ApiModel("机关调拨清单")
public class TDbSjsqqdVO {

    @ApiModelProperty(value = "调拨单号", name = "dbdh", dataType = "String")
    private String dbdh;

    @ApiModelProperty(value = "申请单号", name = "sqdh", dataType = "String")
    private String sqdh;

    @ApiModelProperty(value = "机型", name = "jx", dataType = "String")
    private String jx;

    @ApiModelProperty(value = "机型名称", name = "jxmc", dataType = "String")
    private String jxmc;

    @ApiModelProperty(value = "件号", name = "jh", dataType = "String")
    private String jh;

    @ApiModelProperty(value = "件号名称", name = "jhmc", dataType = "String")
    private String jhmc;

    @ApiModelProperty(value = "计量单位", name = "jldw", dataType = "String")
    private String jldw;

    @ApiModelProperty(value = "接收单位", name = "jsdw", dataType = "String")
    private String jsdw;

    @ApiModelProperty(value = "接收单位名称", name = "jsdwmc", dataType = "String")
    private String jsdwmc;

    @ApiModelProperty(value = "发付单位", name = "ffdw", dataType = "String")
    private String ffdw;

    @ApiModelProperty(value = "发付单位名称", name = "ffdwmc", dataType = "String")
    private String ffdwmc;

    @ApiModelProperty(value = "申请数量", name = "sl", dataType = "Integer")
    private Integer sl;

    @ApiModelProperty(value = "平均单价", name = "dj", dataType = "BigDecimal")
    private BigDecimal dj;

    @ApiModelProperty(value = "质量", name = "zl", dataType = "String")
    private String zl;

    @ApiModelProperty(value = "库存", name = "kc", dataType = "Integer")
    private Integer kc;

    @ApiModelProperty(value = "可调拨数量", name = "kdbsl", dataType = "Integer")
    private Integer kdbsl;

    @ApiModelProperty(value = "调拨数量", name = "dbsl", dataType = "Integer")
    private Integer dbsl;

}
