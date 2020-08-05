package com.andawell.material.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 合同清单详细信息
 * @Date： 2020/4/29 11:53
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class THtDhqdVO {

    /**
     * 选择
     */
    @ApiModelProperty(value = "项次", name = "xz", dataType = "String")
    private String xz;

    /**
     * 合同编号
     */
    @ApiModelProperty(value = "合同", name = "xz", dataType = "String")
    private String htbh;

    /**
     * 件号中文名称
     */
    @ApiModelProperty(value = "名称", name = "jhmc", dataType = "String")
    private String jhmc;

    /**
     * 件号
     */
    @ApiModelProperty(value = "件号", name = "jh", dataType = "String")
    private String jh;

    /**
     * 机型中文名称
     */
    @ApiModelProperty(value = "机型中文名称", name = "jxMc", dataType = "String")
    private String jxMc;

    /**
     * 航材类别
     */
    @ApiModelProperty(value = "航材类别", name = "hclbmc", dataType = "String")
    private String hclbmc;

    /**
     * 单价
     */
    @ApiModelProperty(value = "单价", name = "dj", dataType = "BigDecimal")
    private BigDecimal dj;

    /**
     * 币种
     */
    @ApiModelProperty(value = "币种名称", name = "bzmc", dataType = "BigDecimal")
    private String bzmc;

    /**
     * 总价
     */
    @ApiModelProperty(value = "总价", name = "zj", dataType = "BigDecimal")
    private BigDecimal zj;

    /**
     * 总寿命年
     */
    @ApiModelProperty(value = "总寿命年", name = "zsmn", dataType = "Integer")
    private Integer zsmn;

    /**
     * 总寿命小时
     */
    @ApiModelProperty(value = "总寿命小时", name = "zsmxs", dataType = "Integer")
    private Integer zsmxs;

    /**
     * 翻修寿命小时
     */
    @ApiModelProperty(value = "翻修寿命小时", name = "sfxsmxs", dataType = "Integer")
    private Integer sfxsmxs;

    /**
    /**
     * 首翻期年
     */
    @ApiModelProperty(value = "首翻期年", name = "sfqsm", dataType = "Integer")
    private Integer sfqsm;

    /**
     * 已到数量
     */
    @ApiModelProperty(value = "已到数量", name = "ydsl", dataType = "Long")
    private Long ydsl;

    /**
     * 订货数量
     */
    @ApiModelProperty(value = "订货数量", name = "dhsl", dataType = "Long")
    private Integer dhsl;

    /**
     * 到货日期
     */
    @ApiModelProperty(value = "到货日期", name = "dhrq", dataType = "Date")
    private Date dhrq;

    /**
     * 间修期年
     */
    @ApiModelProperty(value = "间修期年", name = "jxqn", dataType = "Integer")
    private Integer jxqn;

    /**
     * 间修期小时
     */
    @ApiModelProperty(value = "间修期小时", name = "jxqxs", dataType = "Integer")
    private Integer jxqxs;

    /**
     * 件号id
     */
    @ApiModelProperty(value = "件号id", name = "jhid", dataType = "String")
    private String jhid;

    /**
     * 计量单位
     */
    @ApiModelProperty(value = "计量单位", name = "jldw", dataType = "String")
    private String jldw;

    /**
     * 汇率
     */
    @ApiModelProperty(value = "汇率", name = "hl", dataType = "BigDecimal")
    private BigDecimal hl;

    /**
     * 汇率id
     */
    @ApiModelProperty(value = "汇率id", name = "bbz", dataType = "String")
    private String bbz;

    /**
     * 库存类别
     */
    @ApiModelProperty(value = "库存类别", name = "fklb", dataType = "String")
    private String fklb;

    /**
     * 件号名称
     */
    @ApiModelProperty(value = "件号名称", name = "jhMc", dataType = "String")
    private String jhMc;

    /**
     * 厂方名称
     */
    @ApiModelProperty(value = "厂方名称", name = "cfmc", dataType = "String")
    private String cfmc;


}
