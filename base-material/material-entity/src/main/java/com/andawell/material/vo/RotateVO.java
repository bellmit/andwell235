package com.andawell.material.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/***
 * @author lhb
 * @Date: 2020/4/27 10:11
 * @Description:
 * @version : V1.0
 */
@Data
@ApiModel("轮换信息")
public class RotateVO {

    /**
     * 轮换出库编号
     */
    @ApiModelProperty(name = "bh", value = "轮换出库编号")
    private String bh;

    /**
     * 轮换单位
     */
    @ApiModelProperty(name = "轮换单位Id", value = "轮换单位Id")
    private String lhdw;

    /**
     * 机型
     */
    @ApiModelProperty(name = "机型Code", value = "机型Code")
    private String jx;

    /**
     * 件号
     */
    @ApiModelProperty(name = "件号code", value = "件号code")
    private String jh;


    /**
     * 轮换出库数量
     */
    @ApiModelProperty(name = "轮换出库数量", value = "轮换出库数量")
    private Long sl;


    /**
     * 航材类别
     */
    @ApiModelProperty(name = "航材类别", value = "航材类别")
    private String hclb;

    /**
     * 轮换出库单价
     */
    @ApiModelProperty(name = "轮换出库单价", value = "轮换出库单价")
    private BigDecimal dj;

    /**
     * 轮换出库汇率
     */
    @ApiModelProperty(name = "轮换出库汇率", value = "轮换出库汇率")
    private BigDecimal hl;

    /**
     * 币种
     */
    @ApiModelProperty(name = "币种", value = "币种")
    private String bzlb;

    /**
     * 轮换出库出厂日期
     */
    @ApiModelProperty(name = "轮换出库出厂日期", value = "轮换出库出厂日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date ccrq;

    // 业务字段，非数据库组合字段

    // 件号名称
    @ApiModelProperty(name = "件号名称", value = "件号名称")
    private String jhmc;

    // 计量单位
    @ApiModelProperty(name = "计量单位", value = "计量单位")
    private String jldw;

    // 机型名称
    @ApiModelProperty(name = "机型名称", value = "机型名称")
    private String jxmc;

    // 币种名称
    @ApiModelProperty(name = "币种名称", value = "币种名称")
    private String bzlbmc;

    // 航材类别名称
    @ApiModelProperty(name = "航材类别名称", value = "航材类别名称")
    private String hclbmc;

    // 轮换单位名称
    @ApiModelProperty(name = "轮换单位名称", value = "轮换单位名称")
    private String lhdwmc;

    // 轮换单位名称
    @ApiModelProperty(name = "轮换出库序号", value = "轮换单位名称")
    private String xh;

    @ApiModelProperty(name = "轮换质量", value = "轮换质量")
    private String zl;

}
