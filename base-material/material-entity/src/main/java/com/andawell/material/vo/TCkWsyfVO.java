package com.andawell.material.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
* @ClassName: TCkWsyf
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月08日 下午04:35:57
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCkWsyfVO {
    /**
     * 出库编号
     */
    @ApiModelProperty(value = "出库编号")
    private String bh;

    /**
     * 机型名称
     */
    @ApiModelProperty(value = "机型")
    private String jx;

    /**
     * 机型名称
     */
    @ApiModelProperty(value = "机型名称")
    private String jxmc;

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
     * 质量名称
     */
    @ApiModelProperty(value = "质量名称")
    private String zlmc;

    /**
     * 序号
     */
    @ApiModelProperty(value = "序号")
    private String xh;


    /**
     * 数量
     */
    @ApiModelProperty(value = "数量")
    private Integer sl;

    /**
     * 单价
     */
    @ApiModelProperty(value = "单价")
    private BigDecimal dj;

    /**
     * 总价
     */
    @ApiModelProperty(value = "总价")
    private BigDecimal zj;

    /**
     * 出厂日期
     */
    @ApiModelProperty(value = "出库日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date rq;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String bz;

    /**
     * 质量Id
     */
    @ApiModelProperty(value = "质量Id")
    private String zl;

    /**
     * 油封日期
     */
    @ApiModelProperty(value = "油封日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date yfrq;


    @ApiModelProperty(value = "出厂日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date ccrq;

    @ApiModelProperty(value = "油封期限")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Integer yfqx;


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

    /**
     * 航材类别
     */
    @ApiModelProperty(value = "航材类别")
    private String hclb;


    /**
     * 航材类别
     */
    @ApiModelProperty(value = "航材类别")
    private String hl;


}