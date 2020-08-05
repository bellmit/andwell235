package com.andawell.purchase.dto.htprint;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: yzy
 * @Description:
 * @Date: created in 2020/6/9 13:38
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class THtPrintDTO {


    @ApiModelProperty(value = "合同号")
    private String hth;

    @ApiModelProperty(value = "年度")
    private String nd;

    @ApiModelProperty(value = "计划编号")
    private String jhbh;

    @ApiModelProperty(value = "签订地点")
    private String qddd;

    @ApiModelProperty(value = "签订日期")
    private Date qdrq;

    @ApiModelProperty(value = "运输方式")
    private String ysfs;

    @ApiModelProperty(value = "监管方名称")
    private String jgfmc;

    @ApiModelProperty(value = "监管方地址")
    private String jgfdz;

    @ApiModelProperty(value = "监管方邮编")
    private String jgfyb;

    @ApiModelProperty(value = "监管方电话")
    private String jgfdh;

    @ApiModelProperty(value = "采购方名称")
    private String cgfmc;

    @ApiModelProperty(value = "采购方地址")
    private String cgfdz;

    @ApiModelProperty(value = "采购方电话")
    private String cgfdh;

    @ApiModelProperty(value = "采购方开户名称")
    private String cgfkhmc;

    @ApiModelProperty(value = "采购方开户银行")
    private String cgfkhyh;

    @ApiModelProperty(value = "采购方银行账户")
    private String cgfyhzh;

    @ApiModelProperty(value = "厂方名称")
    private String cfmc;

    @ApiModelProperty(value = "厂方地址")
    private String cfdz;

    @ApiModelProperty(value = "厂方电话")
    private String cfdh;

    @ApiModelProperty(value = "厂方开户名称")
    private String cfkhmc;

    @ApiModelProperty(value = "厂方开户银行")
    private String cfkhyh;

    @ApiModelProperty(value = "厂方银行账户")
    private String cfyhzh;

    @ApiModelProperty(value = "厂方简称")
    private String cfjc;

    @ApiModelProperty(value = "合同依据")
    private String htyj;

    @ApiModelProperty(value = "价格类型")
    private Integer jglx;
//    @ApiModelProperty(value = "机型名称")
//    private String jxmc;
//
//    @ApiModelProperty(value = "件号名称")
//    private String jhmc;
//
//    @ApiModelProperty(value = "器材型号")
//    private String qcxh;
//
//    @ApiModelProperty(value = "数量")
//    private Integer sl;
//
//    @ApiModelProperty(value = "总价")
//    private Integer zj;
//
//    @ApiModelProperty(value = "价格类型")
//    private String jglx;
//
//    @ApiModelProperty(value = "备注")
//    private String bz;
//
//    @ApiModelProperty(value = "总数量")
//    private Integer zsl;
//
//    @ApiModelProperty(value = "总金额")
//    private Integer zje;
//
//    /**
//     * 对应下方表格的行数
//     */
//    @ApiModelProperty(value = "总条数")
//    private Integer zts;




}
