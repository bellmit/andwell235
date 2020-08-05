package com.andawell.material.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TXhpCkHjQuery {
    @ApiModelProperty(name = "mc",value = "名称",dataType = "String")
    private String mc;
    @ApiModelProperty(name = "gg",value = "规格",dataType = "String")
    private String gg;
    @ApiModelProperty(name = "pch",value = "批次号",dataType = "String")
    private String pch;
}
