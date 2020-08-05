package com.andawell.material.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
* @ClassName: TCkPgly
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月15日 下午05:09:48
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCkPgly {
    /**
     * 编号
     */
    private String bh;

    /**
     * 单位ID
     */
    private String dwid;

    /**
     * 依据
     */
    private String yj;

    /**
     * 文号
     */
    private String wh;

    /**
     * 依据日期
     */
    private Date yjrq;

    /**
     * 类别
     */
    private String lb;

    /**
     * 日期
     */
    private Date rq;

    /**
     * 飞机类型
     */
    private String jx;

    /**
     * 飞机机号
     */
    private String fjjh;

    /**
     * 发票号
     */
    private String fph;

    /**
     * 运输方式
     */
    private String ysfs;

    /**
     * 发付单位
     */
    private String ffdw;

    /**
     * 发付人
     */
    private String fcr;

    /**
     * 接收单位
     */
    private String jsdw;

    /**
     * 收入人
     */
    private String srr;

    /**
     * 接收日期
     */
    private Date jsrq;

    /**
     * 运输单号
     */
    private String ysdh;

    /**
     * 总箱数
     */
    private BigDecimal zxs;

    /**
     * 装箱编号
     */
    private String zxbh;

    /**
     * 股长
     */
    private String gz;

    /**
     * 助理员
     */
    private String zly;

    /**
     * 分库主任
     */
    private String fkzr;

    /**
     * 批准人
     */
    private String pzr;

    /**
     * 保管员
     */
    private String bgy;

    /**
     * 验收人
     */
    private String ysr;

    /**
     * 创建人
     */
    private String cjr;

    /**
     * 创建日期
     */
    private Date cjrq;

    /**
     * 修改人
     */
    private String xgr;

    /**
     * 修改日期
     */
    private Date xgrq;

    /**
     * 发付单位名称
     */
    private String ffdwmc;

    /**
     * 接受单位名称
     */
    private String jsdwmc;

    /**
     * null
     */
    private String cydw;

    /**
     * null
     */
    private String hydh;

    /**
     * 装备编号
     */
    private String zbbh;

    /**
     * null
     */
    private String rfid;

    /**
     * null
     */
    private String ysid;
}