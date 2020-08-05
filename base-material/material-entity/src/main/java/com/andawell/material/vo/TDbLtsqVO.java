package com.andawell.material.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/***
 * @author lhb
 * @Date: 2020/4/27 10:11
 * @Description:
 * @version : V1.0
 */
@Data
@ApiModel("件号儿信息")
public class TDbLtsqVO {

    /**
     * 申请单位
     */
    @ApiModelProperty(value = "申请单位", name = "sqdw", dataType = "String")
    private String sqdw;

    /**
     * 接收人
     */
    @ApiModelProperty(value = "接收人", name = "jsr", dataType = "String")
    private String jsr;


    /**
     * 联系电话
     */
    @ApiModelProperty(value = "联系电话", name = "lxdh", dataType = "String")
    private String lxdh;

    /**
     * 申请单号
     */
    @ApiModelProperty(value = "申请单号", name = "ltsqdh", dataType = "String")
    private String ltsqdh;

    /**
     * 年度
     */
    @ApiModelProperty(value = "年度", name = "nd", dataType = "Integer")
    private Integer nd;

    /**
     * 季度
     */
    @ApiModelProperty(value = "季度", name = "jd", dataType = "Integer")
    private Integer jd;

    /**
     * 申请人
     */
    @ApiModelProperty(value = "申请人", name = "sqr", dataType = "String")
    private String sqr;

    /**
     * 日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "日期", name = "rq", dataType = "Date")
    private Date rq;
/**
 *@Author: liuys
 *@Data: 2020/5/26
 *@Description:
 */
    /**
     * 申请单位名称
     */
    @ApiModelProperty(value = "申请单位名称", name = "sqdwmc", dataType = "String")
    private String sqdwmc;
    /**
     * 接收人名称
     */
    @ApiModelProperty(value = "接收人名称", name = "jsrmc", dataType = "String")
    private String jsrmc;

    /**
     * 申请人名称
     */
    @ApiModelProperty(value = "申请人名称", name = "sqrmc", dataType = "String")
    private String sqrmc;

    /**
     * 机型
     */
    @ApiModelProperty(value = "机型", name = "jx", dataType = "String")
    private String jx;


    /**
     * 处理状态
     */
    @ApiModelProperty(value = "处理状态", name = "clzt", dataType = "String")
    private String clzt;

    /**
     * 处理状态名称
     */
    @ApiModelProperty(value = "处理状态名称", name = "clztmc", dataType = "String")
    private String clztmc;

    /**
     * 机型名称
     */
    @ApiModelProperty(value = "机型名称", name = "jxmc", dataType = "String")
    private String jxmc;
}
