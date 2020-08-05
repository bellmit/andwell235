package com.andawell.purchase.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
* @ClassName: TCgMlQd
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月29日 下午03:43:07
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "")
public class TCgMlQdVO {
    /**
     * null
     */
    @ApiModelProperty(value = "Id 主键")
    private Long id;

    /**
     * 目录编号
     */
    @ApiModelProperty(value = "目录编号")
    private String mlbh;

    /**
     * 机型Id
     */
    @ApiModelProperty(value = "机型Id")
    private String jx;

    /**
     * 机型名称
     */
    @ApiModelProperty(value = "机型名称")
    private String jxmc;


    /**
     * 件号
     */
    @ApiModelProperty(value = "件号Id")
    private String jh;

    /**
     * 件号名称
     */
    @ApiModelProperty(value = "件号名称")
    private String jhmc;

    /**
     * 计量单位
     */
    @ApiModelProperty(value = "计量单位")
    private String dw;

    /**
     * 计量单位名称
     */
    @ApiModelProperty(value = "计量名称")
    private String dwmc;

    /**
     * 单价
     */
    @ApiModelProperty(value = "单价")
    private String dj;

    /**
     * 厂家
     */
    @ApiModelProperty(value = "厂家")
    private String cj;

    /**
     * 厂家名称
     */
    @ApiModelProperty(value = "厂家名称")
    private String cjmc;

    /**
     * 价格依据
     */
    @ApiModelProperty(value = "价格依据")
    private String jgyy;

    /**
     * 价格类型
     */
    @ApiModelProperty(value = "价格类型")
    private String jglx;

    /**
     * 监管单位
     */
    @ApiModelProperty(value = "监管单位")
    private String jgDw;

    /**
     * 监管单位名称
     */
    @ApiModelProperty(value = "监管单位名称")
    private String jgfmc;

    /**
     * 价格类型名称
     */
    @ApiModelProperty(value = "价格类型名称")
    private String jglxmc;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date cjrq;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date gxrq;

    /**
     *币种名称
     */
    @ApiModelProperty(value = "币种名称")
    private String bzmc;

    /**
     *币种类别
     */
    @ApiModelProperty(value = "币种类别")
    private String bzlb;

    /**
     *汇率
     */
    @ApiModelProperty(value = "汇率")
    private BigDecimal hl;

    /**
     * 器材类别
     */
    private String qclx;

    /**
     * 器材类型名称
     */
    private String qclxmc;

    /**
     * 备注
     */
    private String bz;
}