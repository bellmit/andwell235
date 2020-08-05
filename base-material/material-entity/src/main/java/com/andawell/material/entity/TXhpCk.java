package com.andawell.material.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @ClassName: TXhpCk
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月07日 下午03:58:16
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TXhpCk {
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
     * 计量单位
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
     * 架位号
     */
    private String jwh;

    /**
     * 仓库号
     */
    private String ckdm;

    /**
     * 单位ID
     */
    private String dwid;

    /**
     * 入库日期
     */
    private Date rkrq;

    /**
     * 有效期
     */
    private Date yxq;

    /**
     * 来源单位
     */
    private String lydw;

    /**
     * null
     */
    private String bz;

    /**
     * 入库来源类别
     */
    private String lylb;
}