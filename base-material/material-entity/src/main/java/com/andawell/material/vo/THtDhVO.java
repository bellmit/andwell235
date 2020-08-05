package com.andawell.material.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Date： 2020/4/28 17:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class THtDhVO {
    /**
     * 计划类型 用于计划外和计划内的区分标志
     */
    @ApiModelProperty(value = "计划类型", name = "htbh", dataType = "String")
    private String htbh;

    /**
     * 签订日期
     */
    @ApiModelProperty(value = "签订日期", name = "qdrq", dataType = "Date")
    private Date qdrq;

    /**
     * 采购方代表
     */
    @ApiModelProperty(value = "采购方代表", name = "cgfdb", dataType = "String")
    private String cgfdb;

    /**
     * 军事代表室
     */
    @ApiModelProperty(value = "军事代表室", name = "jsdbs", dataType = "String")
    private String jsdbs;

    /**
     * 驻厂
     */
    @ApiModelProperty(value = "驻厂", name = "zc", dataType = "String")
    private String zc;

    /**
     * 军代室
     */
    @ApiModelProperty(value = "军代室", name = "jds", dataType = "String")
    private String jds;

    /**
     * 军代室联系电话
     */
    @ApiModelProperty(value = "军代室联系电话", name = "jdslxdh", dataType = "String")
    private String jdslxdh;

    /**
     * 军代室代表签字
     */
    @ApiModelProperty(value = "军代室代表签字", name = "jdsdbqz", dataType = "String")
    private String jdsdbqz;

    /**
     * 承制方
     */
    @ApiModelProperty(value = "承制方", name = "czf", dataType = "String")
    private String czf;

    /**
     * 帐户名称
     */
    @ApiModelProperty(value = "帐户名称", name = "zhmc", dataType = "String")
    private String zhmc;

    /**
     * 帐号
     */
    @ApiModelProperty(value = "帐号", name = "zh", dataType = "String")
    private String zh;

    /**
     * 开户银行
     */
    @ApiModelProperty(value = "开户银行", name = "khyh", dataType = "String")
    private String khyh;

    /**
     * 承制方联系电话
     */
    @ApiModelProperty(value = "承制方联系电话", name = "czflxdh", dataType = "String")
    private String czflxdh;

    /**
     * 承制方代表签字
     */
    @ApiModelProperty(value = "承制方代表签字", name = "czfdbqz", dataType = "String")
    private String czfdbqz;

    /**
     * 采购方
     */
    @ApiModelProperty(value = "采购方", name = "cgf", dataType = "String")
    private String cgf;

    /**
     * 邮政编码
     */
    @ApiModelProperty(value = "邮政编码", name = "yzbm", dataType = "String")
    private String yzbm;

    /**
     * 采购方代表签字
     */
    @ApiModelProperty(value = "采购方代表签字", name = "cgfdbqz", dataType = "String")
    private String cgfdbqz;

    /**
     * 采购方联系电话
     */
    @ApiModelProperty(value = "采购方联系电话", name = "cgflxdh", dataType = "String")
    private String cgflxdh;

    /**
     * 通信地址
     */
    @ApiModelProperty(value = "通信地址", name = "txdz", dataType = "String")
    private String txdz;

    /**
     * 运输方式
     */
    @ApiModelProperty(value = "运输方式", name = "ysfs", dataType = "String")
    private String ysfs;

    /**
     * 交货地点
     */
    @ApiModelProperty(value = "交货地点", name = "jhdd", dataType = "String")
    private String jhdd;

    /**
     * 收货地址
     */
    @ApiModelProperty(value = "收货地址", name = "shdz", dataType = "String")
    private String shdz;

    /**
     * 收货人
     */
    @ApiModelProperty(value = "收货人", name = "shr", dataType = "String")
    private String shr;

    /**
     * 收货联系人
     */
    @ApiModelProperty(value = "收货联系人", name = "shlxr", dataType = "String")
    private String shlxr;

    /**
     * 收货联系电话
     */
    @ApiModelProperty(value = "收货联系电话", name = "shlxdh", dataType = "String")
    private String shlxdh;

    /**
     * 机型
     */
    @ApiModelProperty(value = "机型", name = "jx", dataType = "String")
    private String jx;

    /**
     * 合同关闭
     */
    @ApiModelProperty(value = "合同关闭", name = "gb", dataType = "String")
    private String gb;

    /**
     * 计划编号
     */
    @ApiModelProperty(value = "计划编号", name = "jhbh", dataType = "String")
    private String jhbh;

    /**
     * 计划内、外
     */
    @ApiModelProperty(value = "计划内、外", name = "lb", dataType = "String")
    private String lb;

    /**
     * 付款状态
     */
    @ApiModelProperty(value = "付款状态", name = "fkzt", dataType = "String")
    private String fkzt;

    /**
     * 创建日期
     */
    @ApiModelProperty(value = "创建日期", name = "cjrq", dataType = "Date")
    private Date cjrq;

    /**
     * null
     */
    @ApiModelProperty(value = "jhlx", name = "", dataType = "String")
    private String jhlx;

    /**
     * null
     */
    @ApiModelProperty(value = "htlx", name = "", dataType = "Short")
    private Long htlx;

    /**
     * null
     */
    @ApiModelProperty(value = "cjlx", name = "", dataType = "Short")
    private Long cjlx;

    /**
     * null
     */
    @ApiModelProperty(value = "cgfs", name = "", dataType = "Short")
    private Long cgfs;

    /**
     * null
     */
    @ApiModelProperty(value = "fklb", name = "", dataType = "Short")
    private Long fklb;

    /**
     * 合同年度
     */
    @ApiModelProperty(value = "htnd", name = "合同年度", dataType = "Short")
    private Long htnd;
    /**
     * 来货单位（T_CF查询出来）
     */
    @ApiModelProperty(value = "cfmc", name = "来货单位", dataType = "Short")
    private String cfmc;
}
