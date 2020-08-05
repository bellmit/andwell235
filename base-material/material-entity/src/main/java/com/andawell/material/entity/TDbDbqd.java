package com.andawell.material.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName: TDbDbqd
 * @Description:
 * @author: Mybatis Generator
 * @date 2020年05月21日 下午05:27:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TDbDbqd {
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
     * 发付单位（对应页面仓库）
     */
    private String ffdw;

    /**
     * 接受单位（申请单位）
     */
    private String jsdw;
    /**
     * 上级申请0：不需要上级申请；1：需要上级申请；
     */
    private String sjsq;

    /**
     * 申请状态
     */
    private String sqzt;
}
