package com.andawell.material.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
* @ClassName: TCkWjk
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月15日 下午03:44:37
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCkWjkVO {

    /**
     * 单位代码
     */
    @ApiModelProperty(value = "单位代码")
    private String dwid;

    /**
     * 机型
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
     * 件号
     */
    @ApiModelProperty(value = "件号名称")
    private String jhmc;

    /**
     * 序号
     */
    @ApiModelProperty(value = "序号")
    private String xh;

    /**
     * 质量
     */
    @ApiModelProperty(value = "质量")
    private String zl;

    /**
     * 质量名称
     */
    @ApiModelProperty(value = "质量名称")
    private String zlmc;


    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    private String bh;

    /**
     * 数量(外借)
     */
    @ApiModelProperty(value = "数量(外借)")
    private Long sl;

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
    @ApiModelProperty(value = "出厂日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date ccrq;

    /**
     * 验收日期
     */
    @ApiModelProperty(value = "验收日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date ysrq;


    /**
     * 外借日期
     */
    @ApiModelProperty(value = "外借日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date rkrq;

    /**
     * 总寿命：年
     */
    @ApiModelProperty(value = "总寿命：年")
    private Integer zsmn;

    /**
     * 总寿命 ： 小时
     */
    @ApiModelProperty(value = "总寿命 ： 小时")
    private Integer zsmxs;

    /**
     * 总寿命 ： 循环
     */
    @ApiModelProperty(value = "总寿命 ： 循环")
    private Integer zsmxh;

    /**
     * 总寿命 ： 起落
     */
    @ApiModelProperty(value = "总寿命 ： 起落")
    private Integer zsmql;

    /**
     * 总飞行次数
     */
    @ApiModelProperty(value = "总飞行次数")
    private Integer zfxcs;

    /**
     * 油封日期
     */
    @ApiModelProperty(value = "油封日期")
    private Date yfrq;

    /**
     * 油封期限
     */
    @ApiModelProperty(value = "油封期限")
    private Integer yfqx;

    /**
     * 总油封次数
     */
    @ApiModelProperty(value = "总油封次数")
    private Integer zyfcs;

    /**
     * 油封次数
     */
    @ApiModelProperty(value = "油封次数")
    private Integer yfcs;

    /**
     * 飞行日期
     */
    @ApiModelProperty(value = "飞行日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date fxrq;

    /**
     * 飞行寿命：年
     */
    @ApiModelProperty(value = "飞行寿命：年")
    private Integer fxsmn;

    /**
     * 飞行寿命：小时
     */
    @ApiModelProperty(value = "飞行寿命：小时")
    private Integer fxsmxs;

    /**
     * 飞行次数
     */
    @ApiModelProperty(value = "飞行次数")
    private Integer fxcs;

    /**
     * 商保期限 ： 年
     */
    @ApiModelProperty(value = "商保期限 ： 年")
    private Integer sbqxn;

    /**
     * 商保期限 ： 小时
     */
    @ApiModelProperty(value = "商保期限 ： 小时")
    private Integer sbqxxs;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String bz;

    /**
     * 总飞行小时
     */
    @ApiModelProperty(value = "总飞行小时")
    private Integer zfxxs;

    /**
     * 本次总飞行小时
     */
    @ApiModelProperty(value = "本次总飞行小时")
    private Integer bczfxxs;

    /**
     * 本次飞行小时
     */
    @ApiModelProperty(value = "本次飞行小时")
    private Integer bcfxxs;

    /**
     * 总循环次数
     */
    @ApiModelProperty(value = "总循环次数")
    private Integer zxhcs;

    /**
     * 本次总循环次数
     */
    @ApiModelProperty(value = "本次总循环次数")
    private Integer bczxhcs;

    /**
     * 本次循环次数
     */
    @ApiModelProperty(value = "本次循环次数")
    private Integer bcxhcs;

    /**
     * 总起落次数
     */
    @ApiModelProperty(value = "总起落次数")
    private Integer zqlcs;

    /**
     * 本次总起落次数
     */
    @ApiModelProperty(value = "本次总起落次数")
    private Integer bczqlcs;

    /**
     * 本次起落次数
     */
    @ApiModelProperty(value = "本次起落次数")
    private Integer bcqlcs;

    /**
     * 借出单位/归还单位
     */
    @ApiModelProperty(value = "借出单位/归还单位")
    private String dw;

    /**
     * 架位信息
     */
    @ApiModelProperty(value = "架位信息/")
    private String jwh;

    /**
     * 1为序号管理;2为批次号管理
     */
    @ApiModelProperty(value = "1为序号管理;2为批次号管理/")
    private Long glfs;



    /**
     * 汇率
     */
    @ApiModelProperty(value = "hl")
    private BigDecimal hl;

    /**
     * 币种
     */
    @ApiModelProperty(value = "bbz")
    private Integer bbz;

    /**
     * 飞机号
     */
    @ApiModelProperty(value = "fjh")
    private String fjh;

    /**
     * 首翻日历期
     */
    @ApiModelProperty(value = "首翻日历期")
    private Integer sfrlq;

    /**
     * 总日历期
     */
    @ApiModelProperty(value = "总日历期")
    private Integer zrlq;

    /**
     * 总翻修次数
     */
    @ApiModelProperty(value = "总翻修次数")
    private Integer zfanxcs;

    /**
     * 翻修次数
     */
    @ApiModelProperty(value = "翻修次数")
    private Integer fanxcs;

    /**
     * 修复日期
     */
    @ApiModelProperty(value = "修复日期")
    private Date xfrq;

    /**
     * 首翻期寿命
     */
    @ApiModelProperty(value = "首翻期寿命")
    private Integer sfqsm;

    /**
     * 首翻期剩余寿命
     */
    @ApiModelProperty(value = "首翻期剩余寿命")
    private Integer sfqsysm;

    /**
     * 航材类别
     */
    @ApiModelProperty(value = "航材类别")
    private Integer hclb;

    /**
     * 计价
     */
    @ApiModelProperty(value = "计价")
    private BigDecimal jj;

    /**
     * 归还数量
     */
    @ApiModelProperty(value = "归还数量")
    private Long ghsl;

    /**
     * 归还日期
     */
    @ApiModelProperty(value = "归还日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date ghrq;

  /*  *//**
     * 出库人
     *//*
    @ApiModelProperty(value = "出库人")
    private String srr;*/
}