package com.andawell.material.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("全新，待修，在修，报废信息")
public class HcQxKyVO {
    /**
     * 待报废项数
     */
    @ApiModelProperty(name = "hcqxky", value = "航材全新可用件", dataType = "String")
    private String hcqxky="航材全新可用件";
    /**
     * 航材全新可用项数
     */
    @ApiModelProperty(name = "qxxs", value = "全新可用项数", dataType = "Integer")
    private Integer qxxs;

    /**
     * 航材全新可用件数
     */
    @ApiModelProperty(name = "qxjs", value = "全新可用件数", dataType = "Integer")
    private Integer qxjs;
}
