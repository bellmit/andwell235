package com.andawell.material.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Date： 2020/4/27 14:01
 */
@Data
@ApiModel("统计类别信息")
public class TXtHclbVO {
    @ApiModelProperty(name = "id", value = "id", dataType = "String")
    private String id;

    @ApiModelProperty(name = "mc", value = "航材名称", dataType = "String")
    private String mc;

    @ApiModelProperty(name = "id", value = "航材简称", dataType = "String")
    private String jm;
}
