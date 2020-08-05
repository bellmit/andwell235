package com.andawell.purchase.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @ClassName: THtDhqd
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月22日 下午05:14:47
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class THtDhqd {
    /**
     * 合同编号
     */
    private String htbh;

    /**
     * 机型
     */
    private String jx;

    /**
     * 件号
     */
    private String jh;

    /**
     * 订货数量
     */
    private Integer dhsl;

    /**
     * 单价
     */
    private BigDecimal dj;

    /**
     * 总价
     */
    private BigDecimal zj;

    /**
     * 一季度
     */
    private Integer yjd;

    /**
     * 二季度
     */
    private Integer ejd;

    /**
     * 三季度
     */
    private Integer sjd;

    /**
     * 四季度
     */
    private Integer ssjd;

    /**
     * 备注
     */
    private String bz;

    /**
     * 已到数量
     */
    private Long ydsl;

    /**
     * 到货日期
     */
    private Date dhrq;

    /**
     * 选择
     */
    private String xz;

    /**
     * 币种
     */
    private String bzlb;

    /**
     * 本次到货数量
     */
    private Long bcdhsl;

    /**
     * 汇率
     */
    private BigDecimal hl;

    /**
     * 航材类别
     */
    private String hclb;

    /**
     * 翻修寿命小时
     */
    private Integer sfxsmxs;

    /**
     * 总寿命小时
     */
    private Integer zsmxs;

    /**
     * 总寿命年
     */
    private Integer zsmn;

    /**
     * 首翻期年
     */
    private Integer sfqsm;

    /**
     * 到货月数
     */
    private Short daohys;

    /**
     * 间修期小时
     */
    private Integer jxqxs;

    /**
     * 间修期年
     */
    private Integer jxqn;
}