package com.andawell.material.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Date： 2020/5/3 16:17
 */
@Data
@Accessors(chain = true)
@ApiModel("送修返回入库信息")
public class RepairReturnDTO {

    @NotNull(message = "实入序号不能为空")
    @ApiModelProperty(name = "newxh;", value = "实入序号")
    private String xh;

    @NotNull(message = "实入件号不能为空")
    @ApiModelProperty(name = "jh;", value = "实入件号")
    private String jh;

    @NotNull(message = "待修编号不能为空")
    @ApiModelProperty(name = "dxbh;", value = "待修编号")
    private String dxbh;

    @NotNull(message = "处理不能为空")
    @ApiModelProperty(name = "clsj;", value = "处理时间，即出入库时间")
    private Date clsj;

  /*  @NotNull(message = "出入库编号不能位空")
    @ApiModelProperty(name = "clbh;", value = "处理编号，即对应的出入库编号")
    private String clbh;*/


    /**
     * 送修编号
     */
    @NotBlank(message = "送修编号不能为空")
    @ApiModelProperty(value= "送修编号", name =  "bh")
    private String bh;

    @NotBlank(message = "机型不能为NULL")
    @ApiModelProperty(name = "jx;", value = "实入件号")
    private String jx;

    /**
     * 承修单位
     */
    // @NotBlank(message = "承修单位不能为空")
    @ApiModelProperty( value= "承修单位", name = "cxdw")
    private String cxdw;

    /**
     * 序号
     */
    @NotBlank(message = "件号不能为空")
    @ApiModelProperty(name = "xh;", value = "序号")
    private String yxh;

    /**
     * 件号
     */
    @NotBlank(message = "件号不能为空")
    @ApiModelProperty(name = "jh;", value = "件号")
    private String yjh;


    /**
     * 单位
     */
    @NotBlank(message = "单位不能为空")
    @ApiModelProperty(name = "dw;", value = "单位")
    private String dw;

    /**
     * 航材类别
     */
    @NotNull(message = "航材类别不能为空")
    @ApiModelProperty(name = "hclb;", value = "航材类别")
    private Integer hclb;

    /**
     * 数量
     */
    @NotNull(message = "实收数不能为空")
    @ApiModelProperty(name = "sl;", value = "实收数")
    private Long sl;

    /**
     * 通知数
     */
    @ApiModelProperty(name = "tzs;", value = "通知数")
    private Long tzs;

    /**
     * 币种
     */
    @NotNull
    @ApiModelProperty(name = "bbz;", value = "币种")
    private Integer bbz;

    /**
     * 汇率
     */
    @NotNull
    @ApiModelProperty(name = "hl;", value = "汇率")
    private BigDecimal hl;


    /**
     * 单价
     */
    @ApiModelProperty(name = "dj;", value = "单价")
    private BigDecimal dj;

    /**
     * 计价
     */
    @ApiModelProperty(name = "jj;", value = "计价")
    private BigDecimal jj;

    /**
     * 总价
     */
    @ApiModelProperty(name = "zj;", value = "总价")
    private BigDecimal zj;

    /**
     * 仓库代码
     */
    @ApiModelProperty(name = "ckdm;", value = "仓库代码")
    private String ckdm;


    /**
     * 架位号
     */
    @ApiModelProperty(name = "jwh;", value = "架位号")
    private String jwh;

    /**
     * 质量
     */
    @NotBlank(message = "质量不能为空")
    @ApiModelProperty(name = "zl;", value = "质量")
    private String zl;

    /**
     * 备注
     */
    @ApiModelProperty(name = "bz;", value = "备注")
    private String bz;


    /**
     * 出厂日期
     */
    @ApiModelProperty(name = "ccrq;", value = "出厂日期")
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date ccrq;

    /**
     * 总寿命年
     */
    @ApiModelProperty(name = "zsmn;", value = "总寿命年")
    private Integer zsmn;

    /**
     * 总寿命小时
     */
    @ApiModelProperty(name = "zsmxs;", value = "总寿命小时")
    private Integer zsmxs;

    /**
     * 总寿命循环
     */
    @ApiModelProperty(name = "zsmxh;", value = "总寿命循环")
    private Integer zsmxh;

    /**
     * 总寿命起落
     */
    @ApiModelProperty(name = "zsmql;", value = "总寿命起落")
    private Integer zsmql;

    /**
     * 总翻修次数
     */
    @ApiModelProperty(name = "zfxcs;", value = "总翻修次数")
    private Integer zfxcs;

    /**
     * 油封日期
     */
    @ApiModelProperty(name = "yfrq;", value = "油封日期")
    private Date yfrq;

    /**
     * 总油封次数
     */
    @ApiModelProperty(name = "zyfcs;", value = "总油封次数")
    private Integer zyfcs;

    /**
     * 油封次数
     */
    @ApiModelProperty(name = "yfcs;", value = "油封次数")
    private Integer yfcs;

    /**
     * 翻修日期
     */
    @ApiModelProperty(name = "fxrq;", value = "翻修日期")
    private Date fxrq;

    /**
     * 翻修寿命年
     */
    @ApiModelProperty(name = "fxsmn;", value = "翻修寿命年")
    private Integer fxsmn;

    /**
     * 翻修寿命小时
     */
    @ApiModelProperty(name = "fxsmxs;", value = "翻修寿命小时")
    private Integer fxsmxs;

    /**
     * 翻修次数
     */
    @ApiModelProperty(name = "fxcs;", value = "翻修次数")
    private Integer fxcs;

    /**
     * 商保期限年
     */
    @ApiModelProperty(name = "sbqxn;", value = "商保期限年")
    private Integer sbqxn;

    /**
     * 商保期限小时
     */
    @ApiModelProperty(name = "sbqxxs;", value = "商保期限小时")
    private Integer sbqxxs;


    /**
     * 总飞行小时
     */
    @ApiModelProperty(name = "zfxxs;", value = "总飞行小时")
    private Integer zfxxs;

    /**
     * 本次总飞行小时
     */
    @ApiModelProperty(name = "zfxxs;", value = "本次总飞行小时")
    private Integer bczfxxs;

    /**
     * 本次飞行小时
     */
    @ApiModelProperty(name = "zfxxs;", value = "本次飞行小时")
    private Integer bcfxxs;

    /**
     * 总循环次数
     */
    @ApiModelProperty(name = "zfxxs;", value = "总循环次数")
    private Integer zxhcs;

    /**
     * 本次总循环次数
     */
    @ApiModelProperty(name = "zfxxs;", value = "本次总循环次数")
    private Integer bczxhcs;

    /**
     * 本次循环次数
     */
    @ApiModelProperty(name = "zfxxs;", value = "本次循环次数")
    private Integer bcxhcs;

    /**
     * 总起落次数
     */
    @ApiModelProperty(name = "zfxxs;", value = "总起落次数")
    private Integer zqlcs;

    /**
     * 本次总起落次数
     */
    @ApiModelProperty(name = "zfxxs;", value = "本次总起落次数")
    private Integer bczqlcs;

    /**
     * 本次起落次数
     */
    @ApiModelProperty(name = "zfxxs;", value = "本次起落次数")
    private Integer bcqlcs;

    /**
     * 首翻日历期
     */
    @ApiModelProperty(name = "zfxxs;", value = "首翻日历期")
    @Max(value = 100,message = "首翻日历期最大两位数100以内")
    private Integer sfrlq;

    /**
     * 总日历期
     */
    @ApiModelProperty(name = "zfxxs;", value = "总日历期")
    @Max(value = 100,message = "总日历期最大两位数100以内")
    private Integer zrlq;

    /**
     * 总翻修次数
     */
    @ApiModelProperty(name = "zfxxs;", value = "总翻修次数")
    private Integer zfanxcs;

    /**
     * 翻修次数
     */
    @ApiModelProperty(name = "zfxxs;", value = "翻修次数")
    private Integer fanxcs;

    /**
     * 修复日期
     */
    @ApiModelProperty(name = "zfxxs;", value = "修复日期")
    private Date xfrq;

    /**
     * 首翻期寿命
     */
    @ApiModelProperty(name = "zfxxs;", value = "首翻期寿命")
    private Integer sfqsm;

    /**
     * 首翻期剩余寿命
     */
    @ApiModelProperty(name = "zfxxs;", value = "首翻期剩余寿命")
    private Integer sfqsysm;


    /**
     * 资源类别
     */
    @ApiModelProperty(name = "zylb;", value = "资源类别")
    private Integer zylb;

    /**
     * 总供气次数
     */
    @ApiModelProperty(name = "zgqcs;", value = "总供气次数")
    private Integer zgqcs;

    /**
     * 供气次数
     */
    @ApiModelProperty(name = "gqcs;", value = "供气次数")
    private Integer gqcs;

    /**
     * 首翻期小时
     */
    @ApiModelProperty(name = "sfqxs;", value = "首翻期小时")
    private Integer sfqxs;

    /**
     * 油封期限
     */
    @ApiModelProperty(name = "yfqx;", value = "油封期限")
    private BigDecimal yfqx;

    /**
     * 间修期年
     */
    @ApiModelProperty(name = "jxqn;", value = "间修期年")
    private Integer jxqn;

    /**
     * 间修期小时
     */
    @ApiModelProperty(name = "jxqn;", value = "间修期小时")
    private Integer jxqxs;

    /**
     * 编号
     */
    @ApiModelProperty(name = "xz", value = "选择")
    private String xz="0";

    //以下参数目前不需要
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
    @ApiModelProperty(name = "dwid", value = "单位id")
    private String dwid;


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
}
