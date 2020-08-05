package com.andawell.material.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/***
 * @author hwd
 * @Date: 2020-05-09 10:42
 * @Description:
 * @version : V1.0
 */
@Data
@ApiModel("外部油封信息")
public class TCkYfkVO {

    /**
     * 行号
     */
    @ApiModelProperty(value = "行号", name = "rowNum", dataType = "Integer")
    private Integer rowNum;

    /**
     * 单位名称
     */
    @ApiModelProperty(value = "单位名称", name = "dwcc", dataType = "String")
    private String dwcc;

    /**
     * 件号名称
     */
    @ApiModelProperty(value = "件号名称", name = "jhmc", dataType = "String")
    private String jhmc;

    /**
     * 编号
     */
    @ApiModelProperty(value = "编号", name = "bh", dataType = "String")
    private String bh;

    /**
     * 单位代码
     */
    @ApiModelProperty(value = "单位代码", name = "dwid", dataType = "String")
    private String dwid;

    /**
     * 机型
     */
    @ApiModelProperty(value = "机型", name = "jx", dataType = "String")
    private String jx;

    /**
     * 机型名称
     */
    @ApiModelProperty(value = "机型名称", name = "jxmc", dataType = "String")
    private String jxmc;

    /**
     * 件号
     */
    @ApiModelProperty(value = " 件号", name = "jh", dataType = "String")
    private String jh;

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
     * 选择(冗余)
     */
    @ApiModelProperty(value = "选择(冗余)", name = "xz", dataType = "String")
    private String xz;

    /**
     * 数量
     */
    @ApiModelProperty(value = "数量", name = "sl", dataType = "Long")
    private Long sl;

    /**
     * 单价
     */
    @ApiModelProperty(value = "单价", name = "dj", dataType = "BigDecimal")
    private BigDecimal dj;

    /**
     * 总价
     */
    @ApiModelProperty(value = "总价", name = "zj", dataType = "BigDecimal")
    private BigDecimal zj;

    /**
     * 出厂日期
     */
    @ApiModelProperty(value = "出厂日期", name = "ccrq", dataType = "Date")
    private Date ccrq;

    /**
     * 验收日期
     */
    @ApiModelProperty(value = "验收日期", name = "ysrq", dataType = "Date")
    private Date ysrq;

    /**
     * 寿命状态(保留)
     */
    @ApiModelProperty(value = "寿命状态(保留)", name = "smzt", dataType = "String")
    private String smzt;

    /**
     * 入库日期
     */
    @ApiModelProperty(value = "入库日期", name = "rkrq", dataType = "Date")
    private Date rkrq;

    /**
     * 总寿命：年
     */
    @ApiModelProperty(value = "总寿命：年", name = "zsmn", dataType = "Integer")
    private Integer zsmn;

    /**
     * 总寿命 ： 小时
     */
    @ApiModelProperty(value = "总寿命 ： 小时", name = "zsmxs", dataType = "Integer")
    private Integer zsmxs;

    /**
     * 总寿命 ： 循环
     */
    @ApiModelProperty(value = "总寿命 ： 循环", name = "zsmxh", dataType = "Integer")
    private Integer zsmxh;

    /**
     * 总寿命 ： 起落
     */
    @ApiModelProperty(value = "总寿命 ： 起落", name = "zsmql", dataType = "Integer")
    private Integer zsmql;

    /**
     * 总飞行次数
     */
    @ApiModelProperty(value = "总飞行次数", name = "zfxcs", dataType = "Integer")
    private Integer zfxcs;

    /**
     * 油封日期
     */
    @ApiModelProperty(value = "油封日期", name = "yfrq", dataType = "Date")
    private Date yfrq;

    /**
     * 油封期限
     */
    @ApiModelProperty(value = "油封期限", name = "yfqx", dataType = "Integer")
    private BigDecimal yfqx;

    /**
     * 总油封次数
     */
    @ApiModelProperty(value = "总油封次数", name = "zyfcs", dataType = "Integer")
    private Integer zyfcs;

    /**
     * 油封次数
     */
    @ApiModelProperty(value = "油封次数", name = "yfcs", dataType = "Integer")
    private Integer yfcs;

    /**
     * 飞行日期
     */
    @ApiModelProperty(value = "飞行日期", name = "fxrq", dataType = "Date")
    private Date fxrq;

    /**
     * 飞行寿命：年
     */
    @ApiModelProperty(value = "飞行寿命：年", name = "fxsmn", dataType = "Integer")
    private Integer fxsmn;

    /**
     * 飞行寿命：小时
     */
    @ApiModelProperty(value = "飞行寿命：小时", name = "fxsmxs", dataType = "Integer")
    private Integer fxsmxs;

    /**
     * 飞行次数
     */
    @ApiModelProperty(value = "飞行次数", name = "fxcs", dataType = "Integer")
    private Integer fxcs;

    /**
     * 商保期限 ： 年
     */
    @ApiModelProperty(value = "商保期限 ： 年", name = "sbqxn", dataType = "Integer")
    private Integer sbqxn;

    /**
     * 商保期限 ： 小时
     */
    @ApiModelProperty(value = "商保期限 ： 小时", name = "sbqxxs", dataType = "Integer")
    private Integer sbqxxs;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注", name = "bz", dataType = "String")
    private String bz;

    /**
     * 总飞行小时
     */
    @ApiModelProperty(value = "总飞行小时", name = "zfxxs", dataType = "Integer")
    private Integer zfxxs;

    /**
     * 本次总飞行小时
     */
    @ApiModelProperty(value = "本次总飞行小时", name = "bczfxxs", dataType = "Integer")
    private Integer bczfxxs;

    /**
     * 本次飞行小时
     */
    @ApiModelProperty(value = "本次飞行小时", name = "bcfxxs", dataType = "Integer")
    private Integer bcfxxs;

    /**
     * 总循环次数
     */
    @ApiModelProperty(value = "总循环次数", name = "zxhcs", dataType = "Integer")
    private Integer zxhcs;

    /**
     * 本次总循环次数
     */
    @ApiModelProperty(value = "本次总循环次数", name = "bczxhcs", dataType = "Integer")
    private Integer bczxhcs;

    /**
     * 本次循环次数
     */
    @ApiModelProperty(value = "本次循环次数", name = "bcxhcs", dataType = "Integer")
    private Integer bcxhcs;

    /**
     * 总起落次数
     */
    @ApiModelProperty(value = "总起落次数", name = "zqlcs", dataType = "Integer")
    private Integer zqlcs;

    /**
     * 本次总起落次数
     */
    @ApiModelProperty(value = "本次总起落次数", name = "bczqlcs", dataType = "Integer")
    private Integer bczqlcs;

    /**
     * 本次起落次数
     */
    @ApiModelProperty(value = "本次起落次数", name = "bcqlcs", dataType = "Integer")
    private Integer bcqlcs;

    /**
     * 单位
     */
    @ApiModelProperty(value = "单位", name = "dw", dataType = "String")
    private String dw;

    /**
     * 架位信息
     */
    @ApiModelProperty(value = "架位信息", name = "jwh", dataType = "String")
    private String jwh;

    /**
     * 1为序号管理;2为批次号管理
     */
    @ApiModelProperty(value = "1为序号管理;2为批次号管理", name = "glfs", dataType = "Long")
    private Long glfs;

    /**
     * 仓库代码
     */
    @ApiModelProperty(value = "仓库代码", name = "ckdm", dataType = "String")
    private String ckdm;

    /**
     * 汇率
     */
    @ApiModelProperty(value = "汇率", name = "hl", dataType = "BigDecimal")
    private BigDecimal hl;

    /**
     * 币种
     */
    @ApiModelProperty(value = "币种", name = "bbz", dataType = "Integer")
    private Integer bbz;

    /**
     * null
     */
    @ApiModelProperty(value = "fjh", name = "fjh", dataType = "String")
    private String fjh;

    /**
     * 首翻日历期
     */
    @ApiModelProperty(value = "首翻日历期", name = "sfrlq", dataType = "Integer")

    private Integer sfrlq;

    /**
     * 总日历期
     */
    @ApiModelProperty(value = "总日历期", name = "zrlq", dataType = "Integer")
    private Integer zrlq;

    /**
     * 总翻修次数
     */
    @ApiModelProperty(value = "总翻修次数", name = "zfanxcs", dataType = "String")
    private Integer zfanxcs;

    /**
     * 翻修次数
     */
    @ApiModelProperty(value = "翻修次数", name = "fanxcs", dataType = "Integer")
    private Integer fanxcs;

    /**
     * 修复日期
     */
    @ApiModelProperty(value = "修复日期", name = "xfrq", dataType = "Date")
    private Date xfrq;

    /**
     * 首翻期寿命
     */
    @ApiModelProperty(value = "首翻期寿命", name = "sfqsm", dataType = "Integer")
    private Integer sfqsm;

    /**
     * 首翻期剩余寿命
     */
    @ApiModelProperty(value = "首翻期剩余寿命", name = "sfqsysm", dataType = "Integer")
    private Integer sfqsysm;

    /**
     * 油封单位
     */
    @ApiModelProperty(value = "油封单位", name = "yfdw", dataType = "String")
    private String yfdw;

    /**
     * 使用油料
     */
    @ApiModelProperty(value = "使用油料", name = "syyl", dataType = "String")
    private String syyl;

    /**
     * 封存方法
     */
    @ApiModelProperty(value = "封存方法", name = "fcff", dataType = "Integer")
    private Integer fcff;

    /**
     * 出库日期
     */
    @ApiModelProperty(value = "出库日期", name = "ckrq", dataType = "Date")
    private Date ckrq;
    /**
     * 发付人
     */
    @ApiModelProperty(value = "发付人", name = "ffr", dataType = "String")
    private String ffr;
    /**
     * 接收人
     */
    @ApiModelProperty(value = "接收人", name = "jsr", dataType = "String")
    private String jsr;
    /**
     * null
     */
    @ApiModelProperty(value = "yfje", name = "yfje", dataType = "String")
    private BigDecimal yfje;

    @ApiModelProperty(value = "交付单位", name = "ffdw", dataType = "String")
    private String ffdw;

}
