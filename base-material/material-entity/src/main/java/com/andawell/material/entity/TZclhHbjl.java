package com.andawell.material.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @ClassName: TZclhHbjl
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月20日 下午04:15:13
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TZclhHbjl {
    /**
     * 轮换出库编号
     */
    private String bh;

    /**
     * 轮换单位
     */
    private String lhdw;

    /**
     * 机型
     */
    private String jx;

    /**
     * 件号
     */
    private String jh;

    /**
     * 轮换出库序号(批次号)
     */
    private String xh;

    /**
     * 轮换出库质量
     */
    private String zl;

    /**
     * 标志位
     */
    private String xz;

    /**
     * 轮换出库数量
     */
    private Long sl;

    /**
     * 航材类别
     */
    private String hclb;

    /**
     * 轮换出库单价
     */
    private BigDecimal dj;

    /**
     * 轮换出库汇率
     */
    private BigDecimal hl;

    /**
     * 币种
     */
    private String bzlb;

    /**
     * 轮换出库出厂日期
     */
    private Date ccrq;

    /**
     * 轮换出库油封日期
     */
    private Date yfrq;

    /**
     * 轮换出库油封期限
     */
    private BigDecimal yfqx;

    /**
     * 轮换出库日期
     */
    private Date ckrq;

    /**
     * 轮换入库编号
     */
    private String rkbh;

    /**
     * 轮换入库数量
     */
    private Long lrsl;

    /**
     * 轮换入库质量
     */
    private String lrzl;

    /**
     * 轮换入库序号
     */
    private String lrxh;

    /**
     * 轮换入库出厂日期
     */
    private Date lrccrq;

    /**
     * 轮换入库油封日期
     */
    private Date lryfrq;

    /**
     * 轮换入库油封期限
     */
    private BigDecimal lryfqx;

    /**
     * 轮换入库单价
     */
    private BigDecimal lrdj;

    /**
     * 轮换入库汇率
     */
    private BigDecimal lrhl;

    /**
     * 备注
     */
    private String bz;

    /**
     * 轮换出库入库日期
     */
    private Date rkrq;

    /**
     * 创建日期
     */
    private Date cjrq;

    // 业务字段，非数据库组合字段

    // 件号名称
    private String jhmc;

    // 计量单位
    private String jldw;

    // 机型名称
    private String jxmc;

    // 币种名称
    private String bzlbmc;

    // 航材类别名称
    private String hclbmc;

    // 轮换单位名称
    private String lhdwmc;
}