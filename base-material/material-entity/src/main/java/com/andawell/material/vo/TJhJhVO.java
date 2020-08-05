package com.andawell.material.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/***
 * @author lhb
 * @Date: 2020/4/27 10:11
 * @Description:
 * @version : V1.0
 */
@Data
@ApiModel("件号儿信息")
public class TJhJhVO {
    @ApiModelProperty(value = "件号名称", name = "mc", dataType = "String")
    private String mc;

    @ApiModelProperty(value = "单位Id", name = "dw", dataType = "String")
    private String dw;

    @ApiModelProperty(value = "id", name = "id", dataType = "String")
    private String id;

    /**
     *单位名称
     */
    @ApiModelProperty(value = "JhDwMc", name = "单位名称", dataType = "String")
    private String jhDwMc;
}
