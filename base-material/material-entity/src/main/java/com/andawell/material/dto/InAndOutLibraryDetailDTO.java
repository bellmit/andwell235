package com.andawell.material.dto;

import com.andawell.material.dto.groups.First;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/***
 * @author lhb
 * @Date: 2020/4/28 11:14
 * @Description:
 * @version : V1.0
 */
@Data
@Accessors(chain = true)
@ApiModel("入库明细")
@NoArgsConstructor
@AllArgsConstructor
public class InAndOutLibraryDetailDTO {


    /**
     * 件号
     */
    @NotBlank(message = "件号不能为空")
    @ApiModelProperty(value = "件号",required = true)
    private String jh;

    /**
     * 序号
     */
    @NotBlank(message = "序号不能为空")
    @ApiModelProperty(name = "xh", value = "序号",required = true)
    private String xh;

    /**
     * 单位
     */
   // @NotBlank(message = "计量单位不能为空")
    @ApiModelProperty(name = "dw", value = "计量单位",required = true)
    private String dw;


    /**
     * 航材类别
     */
    @NotNull(message = "航材类别不能为空")
    @ApiModelProperty(name = "hclb", value = "航材类别",required = true)
    private Integer hclb;

    /**
     * 数量
     */
    @NotNull(message = "实收数不能为空")
    @ApiModelProperty(name = "sl", value = "实收数",required = true)
    private Long sl;

    /**
     * 通知数
     */
    @ApiModelProperty(name = "tzs", value = "通知数")
    private Long tzs;

    /**
     * 币种
     */
   // @NotNull(message = "bbz不能为空")
    @ApiModelProperty(name = "bbz", value = "币种",required = true)
    private Integer bbz;

    /**
     * 汇率
     */
    @NotNull(message = "汇率不能为空")
    @ApiModelProperty(name = "hl", value = "汇率",required = true)
    private BigDecimal hl;


    /**
     * 单价
     */
    @ApiModelProperty(name = "dj", value = "单价")
    private BigDecimal dj;

    /**
     * 计价
     */
    @ApiModelProperty(name = "jj", value = "计价")
    private BigDecimal jj;

    /**
     * 总价
     */
    @ApiModelProperty(name = "zj", value = "总价")
    private BigDecimal zj;

    /**
     * 仓库代码
     */
   // @NotBlank(message = "库房代码不为空")
    @ApiModelProperty(name = "ckdm", value = "仓库代码",required = true)
    private String ckdm;


    /**
     * 架位号
     */
    @ApiModelProperty(name = "jwh", value = "架位号")
    private String jwh;


    /**
     * 质量
     */
    @NotBlank(message = "质量不能为空")
    @ApiModelProperty(name = "zl", value = "质量",required = true)
    private String zl;

    /**
     * 备注
     */
    @ApiModelProperty(name = "bz", value = "备注")
    private String bz;


    /**
     * 出厂日期
     */
    @ApiModelProperty(name = "ccrq", value = "出厂日期")
    private Date ccrq;

    /**
     * 总寿命年
     */
    @ApiModelProperty(name = "zsmn", value = "总寿命年")
    private Integer zsmn;

    /**
     * 总寿命小时
     */
    @ApiModelProperty(name = "zsmxs", value = "总寿命小时")
    private Integer zsmxs;

    /**
     * 总寿命循环
     */
    @ApiModelProperty(name = "zsmxh", value = "总寿命循环")
    private Integer zsmxh;

    /**
     * 总寿命起落
     */
    @ApiModelProperty(name = "zsmql", value = "总寿命起落")
    private Integer zsmql;

    /**
     * 总翻修次数
     */
    @ApiModelProperty(name = "zfxcs", value = "总翻修次数")
    private Integer zfxcs;

    /**
     * 油封日期
     */
    @ApiModelProperty(name = "yfrq", value = "油封日期")
    private Date yfrq;

    /**
     * 总油封次数
     */
    @ApiModelProperty(name = "zyfcs", value = "总油封次数")
    private Integer zyfcs;

    /**
     * 油封次数
     */
    @ApiModelProperty(name = "yfcs", value = "油封次数")
    private Integer yfcs;

    /**
     * 翻修日期
     */
    @ApiModelProperty(name = "fxrq", value = "翻修日期")
    private Date fxrq;


    /**
     * 翻修寿命年
     */
    @ApiModelProperty(name = "fxsmn", value = "翻修寿命年")
    private Integer fxsmn;

    /**
     * 翻修寿命小时
     */
    @ApiModelProperty(name = "fxsmxs", value = "翻修寿命小时")
    private Integer fxsmxs;

    /**
     * 翻修次数
     */
    @ApiModelProperty(name = "fxcs", value = "翻修次数")
    private Integer fxcs;

    /**
     * 商保期限年
     */
    @ApiModelProperty(name = "sbqxn", value = "商保期限年")
    private Integer sbqxn;

    /**
     * 商保期限小时
     */
    @ApiModelProperty(name = "sbqxxs", value = "商保期限小时")
    private Integer sbqxxs;


    /**
     * 生产厂家
     */
    @ApiModelProperty(name = "sccj", value = "生产厂家")
    private String sccj;

    /**
     * 故障原因
     */
    @ApiModelProperty(name = "gzyy", value = "故障原因")
    private String gzyy;

    /**
     * 故障原因
     */
    @ApiModelProperty(name = "sysj", value = "使用时间")
    private String sysj;

    /**
     * 编号
     */
    @ApiModelProperty(name = "bh", value = "编号")
    private String bh;

    /**
     * 编号
     */
    @ApiModelProperty(name = "jx", value = "机型")
    private String jx;

    /**
     * 编号
     */
    @ApiModelProperty(name = "xz", value = "选择")
    private String xz = "0";


    /**
     * 单位Id
     */
    @ApiModelProperty(name = "dwid", value = "单位id")
    private String dwid;



    /**
     * 总飞行小时
     */
    @ApiModelProperty(name = "zfxxs", value = "总飞行小时")
    private Integer zfxxs;

    /**
     * 本次总飞行小时
     */
    @ApiModelProperty(name = "bczfxxs", value = "本次总飞行小时")
    private Integer bczfxxs;

    /**
     * 本次飞行小时
     */
    @ApiModelProperty(name = "bcfxxs", value = "本次飞行小时")
    private Integer bcfxxs;

    /**
     * 总循环次数
     */
    @ApiModelProperty(name = "zfxxs", value = "总循环次数")
    private Integer zxhcs;

    /**
     * 本次总循环次数
     */
    @ApiModelProperty(name = "bczxhcs", value = "本次总循环次数")
    private Integer bczxhcs;

    /**
     * 本次循环次数
     */
    @ApiModelProperty(name = "bcxhcs", value = "本次循环次数")
    private Integer bcxhcs;

    /**
     * 总起落次数
     */
    @ApiModelProperty(name = "zfxxs", value = "总起落次数")
    private Integer zqlcs;

    /**
     * 本次总起落次数
     */
    @ApiModelProperty(name = "bczqlcs", value = "本次总起落次数")
    private Integer bczqlcs;

    /**
     * 本次起落次数
     */
    @ApiModelProperty(name = "bcqlcs", value = "本次起落次数")
    private Integer bcqlcs;

    /**
     * 首翻日历期
     */
    @ApiModelProperty(name = "sfrlq", value = "首翻日历期")
    @Max(value = 100,message = "首翻日历期最大两位数100以内")
    private Integer sfrlq;

    /**
     * 总日历期
     */
    @ApiModelProperty(name = "zrlq", value = "总日历期")
    @Max(value = 100,message = "总日历期最大两位数100以内")
    private Integer zrlq;

    /**
     * 总翻修次数
     */
    @ApiModelProperty(name = "zfanxcs", value = "总翻修次数")
    private Integer zfanxcs;

    /**
     * 翻修次数
     */
    @ApiModelProperty(name = "fanxcs", value = "翻修次数")
    private Integer fanxcs;

    /**
     * 修复日期
     */
    @ApiModelProperty(name = "xfrq", value = "修复日期")
    private Date xfrq;

    /**
     * 首翻期寿命
     */
    @ApiModelProperty(name = "sfqsm", value = "首翻期寿命")
    private Integer sfqsm;

    /**
     * 首翻期剩余寿命
     */
    @ApiModelProperty(name = "zfxxs", value = "首翻期剩余寿命")
    private Integer sfqsysm;



    /**
     * 专业类别
     */
    @ApiModelProperty(name = "zylb", value = "专业类别")
    private Integer zylb;

    /**
     * 总供气次数
     */
    @ApiModelProperty(name = "zgqcs", value = "总供气次数")
    private Integer zgqcs;

    /**
     * 供气次数
     */
    @ApiModelProperty(name = "gqcs", value = "供气次数")
    private Integer gqcs;

    /**
     * 首翻期小时
     */
    @ApiModelProperty(name = "sfqxs", value = "首翻期小时")
    private Integer sfqxs;

    /**
     * 油封期限
     */
    @ApiModelProperty(name = "yfqx", value = "油封期限")
    private BigDecimal yfqx;

    /**
     * 间修期年
     */
    @ApiModelProperty(name = "jxqn", value = "间修期年")
    private Integer jxqn;

    /**
     * 间修期小时
     */
    @ApiModelProperty(name = "jxqn", value = "间修期小时")
    private Integer jxqxs;

    /**
     * 返厂升级编号
     */
    @ApiModelProperty(name = "ckbh", value = "出库编号")
    private String ckbh;

    /**
     * 新件号
     */
    @ApiModelProperty( value = "新件号")
    private String xjh;

    @ApiModelProperty( value = "新序号")
    private String xxh;


/*    *//**
     * 器材类别 1：周转器材；2：战备器材
     *//*
    private String qclb;*/

    // 冗余字段
    @ApiModelProperty( value = "飞机号")
    private  String fjh;

    /**
     * 质量
     */
    @NotBlank(message = "新质量不能为空",groups = {First.class})
    @ApiModelProperty(name = "newzl", value = "质量",required = true)
    private String newzl;
}
