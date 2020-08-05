package com.andawell.material.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: zje
 * @date: 2020/5/26
 * @description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZbKcVO {

    @ApiModelProperty(name = "jx", value = "机型")
    private String jx;

    @ApiModelProperty(name = "jx", value = "机型")
    private String jh;

    @ApiModelProperty(name = "jx", value = "机型")
    private String mc;

    @ApiModelProperty(name = "jx", value = "机型")
    private String xh;

    @ApiModelProperty(name = "sl", value = "实收数")
    private Long sl;

    @ApiModelProperty(name = "ccrq", value = "出厂日期")
    private Date ccrq;

    @ApiModelProperty(name = "ysrq", value = "验收日期")
    private Date ysrq;

    private Integer syxs;

    @ApiModelProperty(name = "rkrq", value = "入库日期")
    private Date rkrq;

    @ApiModelProperty(name = "yfrq", value = "油封日期")
    private Date yfrq;

    @ApiModelProperty(name = "yfrq", value = "油封日期")
    private Date yfqz;

    @ApiModelProperty(name = "zl", value = "质量")
    private String zl;

    @ApiModelProperty(name = "ckdm", value = "仓库代码")
    private String ckdm;

    @ApiModelProperty(name = "hclb", value = "航材类别")
    private Integer hclb;

    @ApiModelProperty(name = "hclbmc", value = "航材类别名称")
    private String hclbmc;

    @ApiModelProperty(name = "dj", value = "单价")
    private BigDecimal dj;

    @ApiModelProperty(name = "zj", value = "总价")
    private BigDecimal zj;

    @ApiModelProperty(name = "hl", value = "汇率")
    private BigDecimal hl;

    @ApiModelProperty(name = "newhl", value = "新汇率")
    private BigDecimal newhl;

    @ApiModelProperty(name = "bbz", value = "币种")
    private Integer bbz;

    @ApiModelProperty(name = "bzmc", value = "币种名称")
    private String bzmc;

    @ApiModelProperty(name = "bz", value = "备注")
    private String bz;

    @ApiModelProperty(name = "zsmn", value = "总寿命年")
    private Integer zsmn;

    @ApiModelProperty(name = "zsmxs", value = "总寿命小时")
    private Integer zsmxs;

    @ApiModelProperty(name = "sfrlq", value = "首翻日历期")
    private Integer sfrlq;

    @ApiModelProperty(name = "zrlq", value = "总日历期")
    private Integer zrlq;

    @ApiModelProperty(name = "zfanxcs", value = "总翻修次数")
    private Integer zfanxcs;

    @ApiModelProperty(name = "fanxcs", value = "翻修次数")
    private Integer fanxcs;

    @ApiModelProperty(name = "xfrq", value = "修复日期")
    private Date xfrq;

    @ApiModelProperty(name = "sfqsm", value = "首翻期寿命")
    private Integer sfqsm;

    @ApiModelProperty(name = "sfqsysm", value = "首翻期剩余寿命")
    private Integer sfqsysm;

    @ApiModelProperty(name = "zgqcs", value = "总供气次数")
    private Integer zgqcs;

    @ApiModelProperty(name = "gqcs", value = "供气次数")
    private Integer gqcs;

    @ApiModelProperty(name = "sfqxs", value = "首翻期小时")
    private Integer sfqxs;

    @ApiModelProperty(name = "yhldj", value = "原汇率单价")
    private BigDecimal yhldj;

    @ApiModelProperty(name = "yhlzj", value = "原汇率总价")
    private BigDecimal yhlzj;

    @ApiModelProperty(name = "xhldj", value = "现汇率单价")
    private BigDecimal xhldj;

    @ApiModelProperty(name = "xhlzj", value = "现汇率总价")
    private BigDecimal xhlzj;

    @ApiModelProperty(name = "jxqn", value = "间修期年")
    private Integer jxqn;

    @ApiModelProperty(name = "jxqxs", value = "间修期小时")
    private Integer jxqxs;

    @ApiModelProperty(name = "jwh", value = "架位号")
    private String jwh;
}
