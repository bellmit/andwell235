package com.andawell.material.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/***
 * @author shs
 * @Date: 2020/5/14 16:11
 * @Description:
 * @version : V1.0
 */
@Data
@ApiModel("旅团申请明细信息")
public class TDbLtsqqdVO {

    @ApiModelProperty(value = "全新数", name = "qxsl", dataType = "Integer")
    private Integer qxsl;

    @ApiModelProperty(value = "可用数", name = "kysl", dataType = "Integer")
    private Integer kysl;

    @ApiModelProperty(value = "待修数", name = "dxsl", dataType = "Integer")
    private Integer dxsl;

    @ApiModelProperty(value = "在修数  ", name = "zxsl", dataType = "Integer")
    private Integer zxsl;

    /**
     * 申请单号
     */
    @ApiModelProperty(value = "申请单号  ", name = "ltsqdh", dataType = "String")
    private String ltsqdh;
    /**
     * 件号
     */
    @ApiModelProperty(value = "件号  ", name = "jh", dataType = "String")
    private String jh;

    /**
     * 机型
     */
    @ApiModelProperty(value = "机型  ", name = "jx", dataType = "String")
    private String jx;

}
