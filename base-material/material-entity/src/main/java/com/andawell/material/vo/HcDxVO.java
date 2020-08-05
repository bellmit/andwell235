package com.andawell.material.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("全新，待修，在修，报废信息")
public class HcDxVO {
    /**
     * 待报废项数
     */
    @ApiModelProperty(name = "hcdx", value = "航材待修件", dataType = "String")
    private String hcdx="航材待修件";
    /**
     * 航材待修项数
     */
    @ApiModelProperty(name = "dxxs", value = "待修项数", dataType = "Integer")
    private Integer dxxs;

    /**
     * 航材待修件数
     */
    @ApiModelProperty(name = "dxjs", value = "待修件数", dataType = "Integer")
    private Integer dxjs;
}
