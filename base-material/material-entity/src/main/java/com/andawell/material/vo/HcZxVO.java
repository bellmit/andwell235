package com.andawell.material.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("全新，待修，在修，报废信息")
public class HcZxVO {
    /**
     * 待报废项数
     */
    @ApiModelProperty(name = "hczx", value = "航材在修件", dataType = "String")
    private String hczx="航材在修件";
    /**
     * 航材在修项数
     */
    @ApiModelProperty(name = "zxxs", value = "在修项数", dataType = "Integer")
    private Integer zxxs;

    /**
     * 航材在修件数
     */
    @ApiModelProperty(name = "zxjs", value = "在修件数", dataType = "Integer")
    private Integer zxjs;
}
