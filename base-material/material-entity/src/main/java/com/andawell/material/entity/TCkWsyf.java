package com.andawell.material.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @ClassName: TCkWsyf
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月08日 下午04:35:57
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCkWsyf {
    /**
     * 出库编号
     */
    private String bh;

    /**
     * 机型
     */
    private String jx;

    /**
     * 件号
     */
    private String jh;

    /**
     * 序号
     */
    private String xh;

    /**
     * 质量
     */
    private String zl;

    /**
     * 选择
     */
    private Short xz;

    /**
     * 所属单位
     */
    private String dwid;

    /**
     * 接收单位
     */
    private String jsdw;

    /**
     * 数量
     */
    private Integer sl;

    /**
     * null
     */
    private Date yfrq;

    /**
     * null
     */
    private BigDecimal yfqx;

    /**
     * 日期
     */
    private Date rq;

    /**
     * 入库编号
     */
    private String rkbh;

    /**
     * 单价
     */
    private BigDecimal dj;

    /**
     * 总价
     */
    private BigDecimal zj;

    /**
     * 出厂日期
     */
    private Date ccrq;

    /**
     * 备注
     */
    private String bz;

    /**
     * 汇率
     */
    private BigDecimal hl;
}