package com.andawell.material.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("全新，待修，在修，报废信息")
public class HcBfjVO {
    /**
     * 待报废项数
     */
    @ApiModelProperty(name = "hcbfj", value = "航材报废件", dataType = "String")
    private String hcbfj="航材报废件";
    /**
     * 待报废项数
     */
    @ApiModelProperty(name = "dbfxs", value = "待报废项数", dataType = "Integer")
    private Integer dbfxs;

    /**
     * 待报废件数
     */
    @ApiModelProperty(name = "dbfjs", value = "待报废件数", dataType = "Integer")
    private Integer dbfjs;

    /**
     * 报废项数
     */
    @ApiModelProperty(name = "bfxs", value = "报废项数", dataType = "Integer")
    private Integer bfxs;

    /**
     * 报废件数
     */
    @ApiModelProperty(name = "bfjs", value = "报废件数", dataType = "Integer")
    private Integer bfjs;

}
