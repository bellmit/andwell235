package com.andawell.material.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author: zje
 * @date: 2020/5/29
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TDbJgdbqdDTO {

    @ApiModelProperty(value = "调拨单号", name = "dbdh", dataType = "String")
    private String dbdh;

    @ApiModelProperty(value = "申请单号", name = "sqdh", dataType = "String")
    private String sqdh;

    @ApiModelProperty(value = "机型", name = "jx", dataType = "String")
    private String jx;

    @ApiModelProperty(value = "件号", name = "jh", dataType = "String")
    private String jh;

    @ApiModelProperty(value = "接收单位", name = "jsdw", dataType = "String")
    private String jsdw;

    @ApiModelProperty(value = "发付单位", name = "ffdw", dataType = "String")
    private String ffdw;

    @ApiModelProperty(value = "平均单价", name = "dj", dataType = "BigDecimal")
    private BigDecimal dj;

    @ApiModelProperty(value = "申请数量", name = "sl", dataType = "Integer")
    private Integer sl;

    @ApiModelProperty(value = "质量", name = "zl", dataType = "String")
    private String zl;

    @ApiModelProperty(value = "其他调剂", name = "qtdj", dataType = "String")
    private String qtdj;

    @ApiModelProperty(value = "运输方式", name = "ysfs", dataType = "Integer")
    private Integer ysfs;
}
