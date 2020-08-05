package com.andawell.purchase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
* @ClassName: THtDh
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月10日 下午02:10:03
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class THtDh {
    /**
     * 计划类型 用于计划外和计划内的区分标志
     */
    private String htbh;

    /**
     * 签订日期
     */
    private Date qdrq;

    /**
     * 采购方代表
     */
    private String cgfdb;

    /**
     * 军事代表室
     */
    private String jsdbs;

    /**
     * 驻厂
     */
    private String zc;

    /**
     * 军代室
     */
    private String jds;

    /**
     * 军代室联系电话
     */
    private String jdslxdh;

    /**
     * 军代室代表签字
     */
    private String jdsdbqz;

    /**
     * 承制方
     */
    private String czf;

    /**
     * 帐户名称
     */
    private String zhmc;

    /**
     * 帐号
     */
    private String zh;

    /**
     * 开户银行
     */
    private String khyh;

    /**
     * 承制方联系电话
     */
    private String czflxdh;

    /**
     * 承制方代表签字
     */
    private String czfdbqz;

    /**
     * 采购方
     */
    private String cgf;

    /**
     * 邮政编码
     */
    private String yzbm;

    /**
     * 采购方代表签字
     */
    private String cgfdbqz;

    /**
     * 采购方联系电话
     */
    private String cgflxdh;

    /**
     * 通信地址
     */
    private String txdz;

    /**
     * 运输方式
     */
    private String ysfs;

    /**
     * 交货地点
     */
    private String jhdd;

    /**
     * 收货地址
     */
    private String shdz;

    /**
     * 收货人
     */
    private String shr;

    /**
     * 收货联系人
     */
    private String shlxr;

    /**
     * 收货联系电话
     */
    private String shlxdh;

    /**
     * 机型
     */
    private String jx;

    /**
     * 合同关闭
     */
    private String gb;

    /**
     * 计划编号
     */
    private String jhbh;

    /**
     * 计划内、外
     */
    private String lb;

    /**
     * 付款状态
     */
    private String fkzt;

    /**
     * 创建日期
     */
    private Date cjrq;

    /**
     * null
     */
    private String jhlx;

    /**
     * null
     */
    private Short htlx;

    /**
     * null
     */
    private Short cjlx;

    /**
     * null
     */
    private Short cgfs;

    /**
     * null
     */
    private Short fklb;

    /**
     * 合同年度
     */
    private Short htnd;
}