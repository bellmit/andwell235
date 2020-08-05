package com.andawell.material.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Accessors(chain = true)
public class CkmxQuery {
    @ApiModelProperty(name = "mc",value = "名称",dataType = "String")
    private String mc;
    @ApiModelProperty(name = "gg",value = "规格",dataType = "String")
    private String gg;
    @ApiModelProperty(name = "pch",value = "批次号",dataType = "String")
    private String pch;
    @ApiModelProperty(name = "dw",value = "单位",dataType = "String")
    private String dw;
    @ApiModelProperty(name = "dj",value = "单价",dataType = "BigDecimal")
    private BigDecimal dj;
    @ApiModelProperty(name = "cks",value = "出库数",dataType = "BigDecimal")
    private BigDecimal cks;
    @ApiModelProperty(name = "jyr",value = "检验人",dataType = "BigDecimal")
    private String jyr;
    @ApiModelProperty(name = "jhr",value = "交货人",dataType = "BigDecimal")
    private String jhr;
    @ApiModelProperty(name = "jsr",value = "接收人",dataType = "BigDecimal")
    private String jsr;
    @ApiModelProperty(name = "lyr",value = "领用人",dataType = "BigDecimal")
    private String lyr;
    @ApiModelProperty(name = "kcs",value = "库存数",dataType = "BigDecimal")
    private BigDecimal kcs;
    @ApiModelProperty(name = "dwid",value = "单位id",dataType = "BigDecimal")
    private String dwid;
    @ApiModelProperty(name = "tzs",value = "通知数",dataType = "BigDecimal")
    private BigDecimal tzs;
    @ApiModelProperty(name = "wjlb",value = "五金类别",dataType = "String")
    private String wjlb;
    @ApiModelProperty(name = "lylb",value = "来源类别",dataType = "String")
    private String lylb;
    @ApiModelProperty(name = "jwh",value = "架位号",dataType = "String")
    private String jwh;
    @ApiModelProperty(name = "kfh",value = "库房号",dataType = "String")
    private String kfh;
    @ApiModelProperty(name = "kgy",value = "库管员",dataType = "String")
    private String kgy;
    @ApiModelProperty(name = "yxq",value = "有效期",dataType = "Date")
    private Date yxq;
    @ApiModelProperty(name = "bz",value = "备注",dataType = "String")
    private String bz;
}
