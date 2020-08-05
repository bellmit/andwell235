package com.andawell.material.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @ClassName: TCkCrk
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月06日 下午04:28:25
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCkCrk extends TCkPgly {
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
    private String fjlx;

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

    /**
     * 回执接收时间
     */
    private Date hzsj;

    /**
     * 回执接收人
     */
    private String hzjsr;

    /**
     * 回执状态0:未收到；1:已收到
     */
    private String hzzt;

    /**
     * 器材类别
     */
    private String qclb;

    /**
     * 出入库类型，单据打印时用
     */
    private String crklx;

    /**
     * 交付日期
     */
    private Date jfrq;


}