package com.andawell.material.entity;
import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @ClassName: TCkFcsj
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月08日 上午09:12:14
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCkFcsj {
    /**
     * 编号
     */
    private String bh;

    /**
     * 单位代码
     */
    private String dwid;

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
    private String xz;

    /**
     * 仓库号
     */
    private String ckdm;

    /**
     * 升级单位
     */
    private String sjdw;

    /**
     * 日期
     */
    private Date rq;

    /**
     * 数量
     */
    private Integer sl;

    /**
     * 航材类别
     */
    private Integer hclb;

    /**
     * 升级原因
     */
    private String sjyy;

    /**
     * 间修期年
     */
    private Integer jxqn;

    /**
     * 间修期小时
     */
    private Integer jxqxs;

    /**
     * 生产厂家
     */
    private String sccj;

    /**
     * 剩余时间
     */
    private String sysj;

    /**
     * 备注
     */
    private String bz;

    /**
     * 入库编号
     */
    private String rkbh;

    /**
     * 升级后件号
     */
    private String sjjh;

    /**
     * 升级后序号
     */
    private String sjxh;

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
     * 出厂日期
     */
    private Date rkrq;


    /**
     * 汇率
     */
    private BigDecimal hl;
}