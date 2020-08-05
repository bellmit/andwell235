package com.andawell.material.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
* @ClassName: TDbJgdbqd
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月28日 下午04:58:25
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TDbJgdbqd {
    /**
     * 调拨单号
     */
    private String dbdh;

    /**
     * 件号
     */
    private String jh;

    /**
     * 质量
     */
    private String zl;

    /**
     * 机型
     */
    private String jx;

    /**
     * 数量
     */
    private Integer sl;

    /**
     * 备注
     */
    private String bz;

    /**
     * null
     */
    private Short bzw;

    /**
     * 最迟发付日期
     */
    private Date zcffrq;

    /**
     * 平均单价
     */
    private BigDecimal dj;

    /**
     * 发付单位（登录人单位）
     */
    private String ffdw;

    /**
     * 接受单位（用户单位id)
     */
    private String jsdw;

    /**
     * 其他调剂
     */
    private String qtdj;

    /**
     * 申请单号
     */
    private String sqdh;

    /**
     * 运输方式
     */
    private Integer ysfs;
}