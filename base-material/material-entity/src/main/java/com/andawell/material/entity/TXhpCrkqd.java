package com.andawell.material.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @ClassName: TXhpCrkqd
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月07日 下午02:08:49
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TXhpCrkqd {
    /**
     * null
     */
    private String bh;

    /**
     * 批次号
     */
    private String pch;

    /**
     * 件号名称
     */
    private String mc;

    /**
     * 规格
     */
    private String gg;

    /**
     * 日期
     */
    private Date rq;

    /**
     * 单位
     */
    private String dw;

    /**
     * 单价
     */
    private BigDecimal dj;

    /**
     * 数量
     */
    private BigDecimal sl;

    /**
     * 类别
     */
    private String lb;

    /**
     * 检验人
     */
    private String jyr;

    /**
     * 交货人
     */
    private String jhr;

    /**
     * 接收人
     */
    private String jsr;

    /**
     * 库管员
     */
    private String kgy;

    /**
     * 领用人，分发出库时共用
     */
    private String lyr;

    /**
     * 备注
     */
    private String bz;

    /**
     * 仓库号
     */
    private String ckdm;

    /**
     * 架位号
     */
    private String jwh;

    /**
     * 有效期
     */
    private Date yxq;

    /**
     * 器材类别
     */
    private String hclb;

    /**
     * dwid
     */
    private String dwid;

    /**
     * 通知数
     */
    private BigDecimal tzs;

    /**
     * 使用单位，分发出库时用
     */
    private String sydw;

    /**
     * 入库来源类别
     */
    private String lylb;
}