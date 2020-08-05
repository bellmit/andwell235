package com.andawell.material.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/***
 * @author hwd
 * @Date: 2020-05-09 18:00
 * @Description:
 * @version : V1.0
 */
@Data
@ApiModel("内部油封计划")
public class TCkCkPlanVO
{
    /**
     * 行号
     */
    private Integer rowNum;

    /**
     * 单位ID
     */
    private String dwid;

    /**
     * 机型
     */
    private String jx;

    /**
     * 机型名称
     */
    private String jxmc;

    /**
     * 件号
     */
    private String jh;

    /**
     * 件号名称
     */
    private String jhmc;

    /**
     * 序号
     */
    private String xh;

    /**
     * 质量
     */
    private String zl;

    /**
     * 选择标志位
     */
    private String xz = "0";

    /**
     * 数量
     */
    private Long sl;

    /**
     * 单价
     */
    private BigDecimal dj;


    /**
     * 总价
     */
    private BigDecimal zj;

    /**
     * 仓库代码
     */
    private String ckdm;

    /**
     * 出厂日期
     */
    private Date ccrq;


    /**
     * 质量名称
     */
    private String zlmc;


    /**
     * 油封期限
     */
    private BigDecimal yfqx;

    /**
     * 油封日期
     */
    private Date yfrq;

    /**
     * 计量单位
     */
    private String jldw;

    /**
     * 验收日期
     */
    private Date ysrq;

    /**
     * 入库日期
     */
    private Date rkrq;


    /**
     * 油封期止
     */
    private Date yfqz;


    /**
     * 备注
     */
    private String bz;

    /**
     * 单位
     */
    private String dw;

    /**
     * 架位号
     */
    private String jwh;


    /**
     * 汇率
     */
    private BigDecimal hl;



    /**
     * 飞机号
     */
    private String fjh;


    /**
     * 修复日期
     */
    private Date xfrq;


    /**
     * 出入库类别简码
     */
    private String jm;


}
