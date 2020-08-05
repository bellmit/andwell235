package com.andawell.material.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/***
 * @author hwd
 * @Date: 2020-05-25 09:13
 * @Description:
 * @version : V1.0
 */
@Data
@ApiModel("库房信息，用于战区调拨")
public class BursaryVO {

    @ApiModelProperty(name = "总库存", dataType = "Integer")
    private Integer zsl;
    @ApiModelProperty(name = "可调拨数", dataType = "Integer")
    private Integer sysl;
    @ApiModelProperty(name = "单位id", dataType = "String")
    private String dwid;
    @ApiModelProperty(name = "单位名称", dataType = "String")
    private String mc;
    @ApiModelProperty(name = "调拨数量", dataType = "Integer")
    private Integer dcsl;
    @ApiModelProperty(name = "上级申请数量", dataType = "Integer")
    private Integer sjsq;
    /**
     * 单价
     */
    private BigDecimal dj;


    /**
     * 件号
     */
    private String jh;

    /**
     * 件号名称
     */
    private String jhmc;

    /**
     * 申请数量
     */
    private Integer sqsl;

    /**
     * 更换原因名称
     */
    private String ghyymc;


    /**
     * 更换原因代码
     */
    private String ghyy;

    /**
     * 计量单位
     */
    private String jldwmc;

    /**
     * 机型
     */
    private String jx;

    /**
     * 机型名称
     */
    private String jxmc;

}
