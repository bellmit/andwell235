package com.andawell.purchase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
* @ClassName: THtQd
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月04日 下午05:58:22
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class THtQd {
    /**
     * 合同编号
     */
    private String hth;

    /**
     * 计划编号
     */
    private String jhbh;

    /**
     * 机型
     */
    private String jx;

    /**
     * 件号
     */
    private String jh;

    /**
     * 采购目录清单Id
     */
    private Long mlQdid;

    /**
     * 数量
     */
    private Integer sl;

    /**
     * 总价
     */
    private String zj;

    /**
     * 备注
     */
    private String bz;

    /**
     * 创建日期
     */
    private Date cjrq;

    /**
     * 修改日期
     */
    private Date xgrq;

    /**
     * 交付进度
     */
    private String jfjd;

    /**
     * 汇率
     */
    private BigDecimal hl;

    /**
     * 币种
     */
    private String bzlb;
}