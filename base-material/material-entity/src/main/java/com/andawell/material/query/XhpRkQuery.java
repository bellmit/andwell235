package com.andawell.material.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

@Data
@Accessors(chain = true)
public class XhpRkQuery {
    @ApiModelProperty(name = "lbjm",value = "类别简码",dataType = "String")
    private String lbjm;
    @ApiModelProperty(name = "dwid",value = "单位id",dataType = "String")
    private String dwid;
    @ApiModelProperty(name = "jsr",value = "接收人",dataType = "String")
    private String jsr;
    @ApiModelProperty(name = "rklb",value = "入库类别",dataType = "String")
    private String rklb;
    @ApiModelProperty(name = "lydw",value = "来源单位",dataType = "String")
    private String lydw;
    @ApiModelProperty(name = "srdw",value = "收入单位",dataType = "String")
    private String srdw;
    @ApiModelProperty(name = "pch",value = "批次号",dataType = "String")
    private String pch;
    @ApiModelProperty(name = "rkrq",value = "入库日期",dataType = "Date")
    private Date rkrq;
    @ApiModelProperty(name = "gjwh",value = "根据文号",dataType = "String")
    private String gjwh;
    @ApiModelProperty(name = "rkwh",value = "入库文号",dataType = "String")
    private String rkwh;
    @ApiModelProperty(name = "rkmx",value = "入库明细list",dataType = "List")
    private List<RkmxQuery>  rkmx;
}
