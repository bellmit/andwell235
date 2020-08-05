package com.andawell.material.vo;/**
 * @Date： 2020/6/4 8:59
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *@Auther:liuys
 *@Date:2020/6/4 08:59
 *@Description:
 */
@Data
@ApiModel("库存数量信息")
public class StockVO {
    @ApiModelProperty(value = "全新数", name = "qxsl", dataType = "Integer")
    private Integer qxsl;

    @ApiModelProperty(value = "可用数", name = "kysl", dataType = "Integer")
    private Integer kysl;

    @ApiModelProperty(value = "待修数", name = "dxsl", dataType = "Integer")
    private Integer dxsl;

    @ApiModelProperty(value = "在修数  ", name = "zxsl", dataType = "Integer")
    private Integer zxsl;

    @ApiModelProperty(value = "单机安装数  ", name = "djazsl", dataType = "Integer")
    private Integer djazsl;

    @ApiModelProperty(value = "订货未到数  ", name = "dhwdsl", dataType = "Integer")
    private Integer dhwdsl;
}
