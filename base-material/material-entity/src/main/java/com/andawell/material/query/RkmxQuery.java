package com.andawell.material.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Accessors(chain = true)
public class RkmxQuery {
    @ApiModelProperty(name = "mc",value = "名称",dataType = "String")
    private String mc;
    @ApiModelProperty(name = "gg",value = "规格",dataType = "String")
    private String gg;
    @ApiModelProperty(name = "wjlb",value = "五金类别",dataType = "String")
    private String wjlb;
    @ApiModelProperty(name = "rkdj",value = "入库单价",dataType = "BigDecimal")
    private BigDecimal rkdj;
    @ApiModelProperty(name = "tzs",value = "通知数",dataType = "BigDecimal")
    private BigDecimal tzs;
    @ApiModelProperty(name = "rks",value = "入库数",dataType = "BigDecimal")
    private BigDecimal rks;
    @ApiModelProperty(name = "yxq",value = "有效期",dataType = "Date")
    private Date yxq;
    @ApiModelProperty(name = "jldw",value = "计量单位",dataType = "String")
    private String jldw;
    @ApiModelProperty(name = "ckh",value = "仓库号",dataType = "String")
    private String ckh;
    @ApiModelProperty(name = "dwid",value = "单位id",dataType = "String")
    private String dwid;
    @ApiModelProperty(name = "jwh",value = "架位号",dataType = "String")
    private String jwh;
    @ApiModelProperty(name = "cfwz",value = "存放位置",dataType = "String")
    private String cfwz;
    @ApiModelProperty(name = "jyr",value = "检验人",dataType = "String")
    private String jyr;
    @ApiModelProperty(name = "jhr",value = "交货人",dataType = "String")
    private String jhr;
    @ApiModelProperty(name = "bgy",value = "保管员",dataType = "String")
    private String bgy;
    @ApiModelProperty(name = "rkbz",value = "出入库备注",dataType = "String")
    private String rkbz;
}
