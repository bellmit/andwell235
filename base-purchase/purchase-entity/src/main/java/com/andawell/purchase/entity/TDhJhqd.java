package com.andawell.purchase.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @ClassName: TDhJhqd
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月02日 上午10:38:57
*/
@Data
@AllArgsConstructor
public class TDhJhqd {
    /**
     * 订货计划编号
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
     * 器材类型
     */
    private String qclx;

    /**
     * 申请数量
     */
    private Integer sqsl;

    /**
     * 备注
     */
    private String bz;

    /**
     * 创建时间
     */
    private Date cjrq;

    /**
     * 修改时间
     */
    private Date xgrq;

    /**
     * 0.草稿 1,生效 3，删除
     */
    private Short status;

    /**
     * 关联目录清单Id
     */
    private Long mlQdid;

    /**
     * 订货计划数量
     */
    private Integer dhJhsl;

    // 冗余字段 厂家Id
    private String cj;

    // 厂家名称
    private String cjmc;

    // 监管单位
    private String Jgdw;

    // 机型名称
    private String jxmc;

    // 机型名称
    private String jxjm;


    // 价格类型
    private String jglxmc;

    // 价格类型
    private String jglx;

    // 用于计划生成合同时的合同号组成
    private String htbz;

    // 生成合同号机型jm
    private String htjxjm;

    // 合同机型
    private String htjx;
    /**
     * 汇率
     */
    private BigDecimal hl;

    /**
     * 币种
     */
    private String bzlb;


    // 单价
    private String dj;

    public TDhJhqd(String bh, String jx, String jh) {
        this.bh = bh;
        this.jx = jx;
        this.jh = jh;
    }

    public TDhJhqd() {
    }
}