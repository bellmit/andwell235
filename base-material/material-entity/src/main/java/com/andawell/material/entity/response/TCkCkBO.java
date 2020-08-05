package com.andawell.material.entity.response;/**
 * @Date： 2020/5/9 11:19
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 *@Auther:liuys
 *@Date:2020/5/9 11:19
 *@Description:
 */
@Data
@ApiModel("出库详细信息")
public class TCkCkBO {
    /**
     * 件号名称
     */
    @ApiModelProperty(value = "件号名称", name = "jhmc", dataType = "String")
    private String jhmc;

    /**
     * 件号
     */
    @ApiModelProperty(value = "件号", name = "jh", dataType = "Date")
    private String jh;

    /**
     * 计量单位
     */
    @ApiModelProperty(value = "计量单位", name = "jldw", dataType = "String")
    private String jldw;

    /**
     * 计量单位名称
     */
    @ApiModelProperty(value = "计量单位名称", name = "jldwmc", dataType = "String")
    private String jldwmc;

    /**
     * 序号
     */
    @ApiModelProperty(value = "序号", name = "xh", dataType = "String")
    private String xh;

    /**
     * 质量
     */
    @ApiModelProperty(value = "质量", name = "zl", dataType = "String")
    private String zl;

    /**
     * 机型
     */
    @ApiModelProperty(value = "机型", name = "jx", dataType = "String")
    private String jx;

    /**
     * 机型
     */
    @ApiModelProperty(value = "机型名称", name = "jxmc", dataType = "String")
    private String jxmc;

    /**
     * 库存数量
     */
    @ApiModelProperty(value = "库存数量", name = "sl", dataType = "Long")
    private Long sl;

    /**
     * 航材类别
     */
    @ApiModelProperty(value = "航材类别", name = "hclb", dataType = "Integer")
    private Integer hclb;

    /**
     * 器材类别
     */
    @ApiModelProperty(value = "器材类别id", name = "qclb", dataType = "String")
    private String qclb;

    /**
     * 器材类别
     */
    @ApiModelProperty(value = "器材类别", name = "qclbmc", dataType = "String")
    private String qclbmc;

    /**
     * 架位号
     */
    @ApiModelProperty(value = "架位号", name = "jwh", dataType = "String")
    private String jwh;

    /**
     * 出厂日期
     */
    @ApiModelProperty(value = "出厂日期", name = "ccrq", dataType = "Date")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date ccrq;

    /**
     * 入库日期
     */
    @ApiModelProperty(value = "入库日期", name = "rkrq", dataType = "Date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date rkrq;

    /**
     * 油封日期
     */
    @ApiModelProperty(value = "油封日期", name = "yfrq", dataType = "Date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date yfrq;

    /**
     * 油封期限
     */
    @ApiModelProperty(value = "油封期限", name = "yfqx", dataType = "BigDecimal")
    private BigDecimal yfqx;

/*    *//**
     * 油封期止
     *//*
    @ApiModelProperty(value = "油封期止", name = "cgf", dataType = "String")
    private String cgf;*/

    /**
     * 翻修日期
     */
    @ApiModelProperty(value = "翻修日期", name = "fxrq", dataType = "String")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date fxrq;

    /**
     * 总日历期
     */
    @ApiModelProperty(value = "总日历期", name = "zrlq", dataType = "Integer")
    private Integer zrlq;

    /**
     * 首翻日历期
     */
    @ApiModelProperty(value = "首翻日历期", name = "sfrlq", dataType = "Integer")
    private Integer sfrlq;

    /**
     * 修复日期
     */
    @ApiModelProperty(value = "修复日期", name = "xfrq", dataType = "Date")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date xfrq;

    /**
     * 间修期年
     */
    @ApiModelProperty(value = "间修期年", name = "ysfs", dataType = "String")
    private String jxqn;

    /**
     * 间修期小时
     */
    @ApiModelProperty(value = "间修期小时", name = "jhdd", dataType = "String")
    private String jxqxs;
//
    /**
     * 仓库代码
     */
    @ApiModelProperty(value = "间修期小时", name = "ckdm", dataType = "String")
    private String ckdm;

    /**
     * 单位ID
     */
    @ApiModelProperty(value = "单位ID", name = "dwid", dataType = "String")
    private String dwid;


    /**
     * 质量名称
     */
    @ApiModelProperty(value = "质量名称", name = "zlmc", dataType = "String")
    private String zlmc;

    /**
     * 航材类别名称
     */
    @ApiModelProperty(value = "航材类别名称", name = "hclbmc", dataType = "Integer")
    private String hclbmc;

    /**
     * 出库数量
     */
    @ApiModelProperty(value = "出库数量", name = "cksl", dataType = "Integer")
    private Integer cksl;

    @ApiModelProperty(value = "", name = "glfs", dataType = "Integer")
    private Integer glfs;

    @ApiModelProperty(value = "汇率")
    private BigDecimal hl;

    @ApiModelProperty(value = "单价")
    private String dj;

    @ApiModelProperty(value = "总价")
    private String zj;

    @ApiModelProperty(value = "备注")
    private String bz;
}
