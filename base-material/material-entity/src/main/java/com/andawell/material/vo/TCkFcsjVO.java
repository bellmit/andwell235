package com.andawell.material.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
* @ClassName: TCkFcsj
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月08日 上午09:12:14
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "返厂升级列表")
public class TCkFcsjVO {
    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    private String bh;

    /**
     * 机型
     */
    @ApiModelProperty(value = "机型")
    private String jx;


    /**
     * 机型
     */
    @ApiModelProperty(value = "机型名称")
    private String jxmc;

    /**
     * 计量单位
     */
    @ApiModelProperty(value = "计量单位")
    private String jldwmc;

    /**
     * 单价
     */
    @ApiModelProperty(value = "单价")
    private BigDecimal dj;

    /**
     * 单价
     */
    @ApiModelProperty(value = "总价")
    private String zj;

    /**
     * 件号
     */
    @ApiModelProperty(value = "件号")
    private String jh;

    /**
     * 件号名称
     */
    @ApiModelProperty(value = "件号名称")
    private String jhmc;

    /**
     * 序号
     */
    @ApiModelProperty(value = "序号")
    private String xh;

    /**
     * 质量名称
     */
    @ApiModelProperty(value = "质量名称")
    private String zlmc;


    /**
     * 数量
     */
    @ApiModelProperty(value = "数量")
    private Integer sl;


    /**
     * 升级原因
     */
    @ApiModelProperty(value = "升级原因")
    private String sjyy;

    /**
     * 生产厂家
     */
    @ApiModelProperty(value = "生产厂家")
    private String sccj;

    /**
     * 剩余时间
     */
    @ApiModelProperty(value = "剩余时间")
    private String sysj;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String bz;

    /**
     * 出厂日期
     */
    @ApiModelProperty(value = "出厂日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date ccrq;

    /**
     * 汇率
     */
    @ApiModelProperty(value = "汇率")
    private String hl;

    /**
     * 质量
     */
    @ApiModelProperty(value = "质量")
    private String zl;

    /**
     * 航材类别
     */
    @ApiModelProperty(value = "航材类别")
    private String hclb;


    /**
     * 计量单位
     */
    @ApiModelProperty(value = "计量单位")
    private String dw;

    /**
     * 币种
     */
    @ApiModelProperty(value = "币种")
    private String bbz;


}