package com.andawell.purchase.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @ClassName: TCgMlQd
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月29日 下午03:43:07
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCgMlQd {
    /**
     * null
     */
    private Long id;

    /**
     * 目录编号
     */
    private String mlbh;

    /**
     * 机型Id
     */
    private String jx;

    /**
     * 件号
     */
    private String jh;

    /**
     * 单价
     */
    private String dj;

    /**
     * 厂家
     */
    private String cj;

    /**
     * 价格依据
     */
    private String jgyy;

    /**
     * 价格类型
     */
    private String jglx;

    /**
     * 监管单位
     */
    private String jgdw;

    /**
     * 憋住
     */
    private String bz;

    /**
     * 创建时间
     */
    private Date cjrq;

    /**
     * 更新时间
     */
    private Date gxrq;


    /**
     * 汇率
     */
    private BigDecimal hl;

    /**
     * 币种
     */
    private String bzlb;

    /**
     * 器材类别
     */
    private String qclx;

    // 冗余字段
    /**
     * 机型名称
     */
    private String jxmc;

    /**
     * 件号名称
     */
    private String jhmc;

    /**
     * 单位名称
     */
    private String dwmc;
}