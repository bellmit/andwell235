package com.andawell.material.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

@Data
@Accessors(chain = true)
public class XhpCkQuery {
    @ApiModelProperty(name = "lbjm",value = "类别简码",dataType = "String")
    private String lbjm;
    @ApiModelProperty(name = "dwid",value = "单位id",dataType = "String")
    private String dwid;
    @ApiModelProperty(name = "pch",value = "批次号",dataType = "String")
    private String pch;
    @ApiModelProperty(name = "ffdw",value = "发付单位",dataType = "String")
    private String ffdw;
    @ApiModelProperty(name = "cklb",value = "出库类别",dataType = "String")
    private String cklb;
    @ApiModelProperty(name = "ckrq",value = "出库日期",dataType = "ckrq")
    private Date ckrq;
    @ApiModelProperty(name = "dbdw",value = "调拨单位",dataType = "String")
    private String dbdw;
    @ApiModelProperty(name = "gjwh",value = "根据文号",dataType = "String")
    private String gjwh;
    @ApiModelProperty(name = "ckwh",value = "出库文号",dataType = "String")
    private String ckwh;
    @ApiModelProperty(name = "gg",value = "规格",dataType = "String")
    private String lyr;
    @ApiModelProperty(name = "ckmx",value = "出库明细",dataType = "List")
    private List<CkmxQuery> ckmx;
}
