package com.andawell.material.vo;/**
 * @Date： 2020/6/10 11:09
 */

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 *@Auther:liuys
 *@Date:2020/6/10 11:09
 *@Description:
 */
public class TWxNlqdTempVO {
    /**
     * PID
     */
    @ApiModelProperty(name = "pid", value = "PID", dataType = "Integer")
    private Integer pid;

    /**
     * 厂方ID
     */
    @ApiModelProperty(name = "cfid", value = "厂方ID", dataType = "String")
    private String cfid;

    /**
     * 维修类别
     */
    @ApiModelProperty(name = "wxlb", value = "维修类别", dataType = "String")
    private String wxlb;

    /**
     * 设备名称
     */
    @ApiModelProperty(name = "sbmc", value = "设备名称", dataType = "String")
    private String sbmc;

    /**
     * 设备型号
     */
    @ApiModelProperty(name = "sbxh", value = "设备型号", dataType = "String")
    private String sbxh;

    /**
     * 设备状况
     */
    @ApiModelProperty(name = "sbzk", value = "设备状况", dataType = "String")
    private String sbzk;

    /**
     * 制造厂家
     */
    @ApiModelProperty(name = "sbzk", value = "设备状况", dataType = "String")
    private String zccj;

    /**
     * 计量单位
     */
    @ApiModelProperty(name = "sbzk", value = "设备状况", dataType = "String")
    private String jlzq;

    /**
     * 资料名称
     */
    @ApiModelProperty(name = "sbzk", value = "设备状况", dataType = "String")
    private String zlmc;

    /**
     * 资料版次
     */
    @ApiModelProperty(name = "sbzk", value = "设备状况", dataType = "String")
    private String zlbc;

    /**
     * 章节号
     */
    @ApiModelProperty(name = "sbzk", value = "设备状况", dataType = "String")
    private String zjh;

    /**
     * 内部编号
     */
    @ApiModelProperty(name = "sbzk", value = "设备状况", dataType = "String")
    private String nbbh;

    /**
     * 资料来源
     */
    @ApiModelProperty(name = "sbzk", value = "设备状况", dataType = "String")
    private String zlly;

    /**
     * 受控状态
     */
    @ApiModelProperty(name = "sbzk", value = "设备状况", dataType = "String")
    private String skzt;

    /**
     * 工作环境
     */
    @ApiModelProperty(name = "sbzk", value = "设备状况", dataType = "String")
    private String gzhj;

    /**
     * 备件来源
     */
    @ApiModelProperty(name = "sbzk", value = "设备状况", dataType = "String")
    private String bjly;

    /**
     * 备注
     */
    @ApiModelProperty(name = "sbzk", value = "设备状况", dataType = "String")
    private String bz;

    /**
     * 内部编号
     */
    @ApiModelProperty(name = "sbzk", value = "设备状况", dataType = "String")
    private BigDecimal sxbl;
}
