package com.andawell.material.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

/***
 * @author hwd
 * @Date: 2020-05-11 11:24
 * @Description:
 * @version : V1.0
 */
@Data
@ApiModel("油封计划入参")
public class TCkCkPlanDTO
{
    /**
     * 编号
     */
    private String bh;


    /**
     * 入库日期/送交日期
     */
    private Date rkrq;


    /**
     * 送封单位/发付单位
     */
    private String ffdw;


    /**
     * 油封单位
     */
    private String yfdw;


    /**
     * 类别简码
     */
    @NotBlank(message = "类别简码不能为空")
    @ApiModelProperty(value = "类别简码不能为空",required = true)
    private String jm;


    /**
     * 单位ID
     */
    @NotBlank(message = "单位ID不能为空")
    @ApiModelProperty(value = "单位ID不能为空",required = true)
    private String dwid;

    /**
     * 机型
     */
    @NotBlank(message = "机型不能为空")
    @ApiModelProperty(value = "机型不能为空",required = true)
    private String jx;

    /**
     * 机型名称
     */
    private String jxmc;

    /**
     * 件号
     */
    @NotBlank(message = "件号不能为空")
    @ApiModelProperty(value = "件号不能为空",required = true)
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
}
