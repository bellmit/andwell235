package com.andawell.material.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
* @ClassName: TDbSjsqqd
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月29日 上午11:45:03
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TDbSjsqqd {
    /**
     * 申请单号
     */
    private String sqdh;

    /**
     * 机型
     */
    private String jx;

    /**
     * 件号
     */
    private String jh;

    /**
     * 质量
     */
    private String zl;

    /**
     * 调拨单号
     */
    private String dbdh;

    /**
     * 数量
     */
    private Integer sl;

    /**
     * 备注
     */
    private String bz;

    /**
     * 申请原因
     */
    private String sqyy;

    /**
     * 接受单位(第一次申请的单位)
     */
    private String jsdw;

    /**
     * 发付单位
     */
    private String ffdw;

    /**
     * 平均单价
     */
    private BigDecimal dj;

    /**
     * 日期
     */
    private Date rq;

    /**
     * 项次
     */
    private String xc;
}