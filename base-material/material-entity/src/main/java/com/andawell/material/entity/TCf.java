package com.andawell.material.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
* @ClassName: TCf
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月09日 下午02:29:15
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCf {
    /**
     * 编码规则： 承制方M+4位代码 维修方R+4位代码 油封方O+4为代码 军代表A+4位代码 军代表小组 军代表+2位代码
     */
    private String id;

    /**
     * 厂方类别 1: 承制方 2: 维修方 3: 军代表
     */
    private String lb;

    /**
     * 名称
     */
    private String mc;

    /**
     * 简码
     */
    private String jm;

    /**
     * 专业类别
     */
    private String zylb;

    /**
     * 备注
     */
    private String bz;

    /**
     * 账户名称
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
     * 国家
     */
    private String gj;

    /**
     * 城市
     */
    private String cs;

    /**
     * 地址
     */
    private String dz;

    /**
     * 邮编
     */
    private String yb;

    /**
     * 联系人
     */
    private String lxr;

    /**
     * 电话
     */
    private String dh;

    /**
     * 传真
     */
    private String cz;

    /**
     * 电子邮件
     */
    private String yj;

    /**
     * 适航证书
     */
    private String zs;

    /**
     * 适航证书截止日期
     */
    private Date zsrq;

    /**
     * 维修证书编号
     */
    private String wxzs;

    /**
     * 维修证书截止日期
     */
    private Date wxzsrq;

    /**
     * 保密资质
     */
    private String bmzz;

    /**
     * 保密开始日期
     */
    private Date bmksrq;

    /**
     * 父ID
     */
    private String pid;

    /**
     * 证照号码
     */
    private String zzhm;

    /**
     * 试航证书颁发日期
     */
    private Date bfrq;

    /**
     * 维修证书开始日期
     */
    private Date wxzsksrq;

    /**
     * 保密结束日期
     */
    private Date bmjsrq;
}