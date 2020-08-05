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
@ApiModel("仓库信息")
public class TXtCkVO {

    @ApiModelProperty(value = "单位代码", name = "dwid", dataType = "String")
    private String dwid;

    @ApiModelProperty(value = "仓库代码", name = "ckid", dataType = "String")
    private String ckid;

    @ApiModelProperty(value = "仓库名称", name = "mc", dataType = "String")
    private String mc;

    @ApiModelProperty(value = "仓库类型", name = "LX", dataType = "Integer")
    private Integer LX;
}
