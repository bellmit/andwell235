package com.andawell.material.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
@AllArgsConstructor
public class TXhpCkCkQuery {
    @ApiModelProperty(name = "cks",value = "出库数",dataType = "BigDecimal")
    private BigDecimal cks;
    @ApiModelProperty(name = "mc",value = "名称",dataType = "String")
    private String mc;
    @ApiModelProperty(name = "gg",value = "规格",dataType = "String")
    private String gg;
    @ApiModelProperty(name = "pch",value = "批次号",dataType = "String")
    private String pch;
}
