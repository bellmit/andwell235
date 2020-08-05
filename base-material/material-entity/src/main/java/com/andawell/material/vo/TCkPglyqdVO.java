package com.andawell.material.vo;/**
 * @Date： 2020/5/19 14:29
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 *@Auther:liuys
 *@Date:2020/5/19 14:29
 *@Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCkPglyqdVO {

    /**
     * 编号
     */
    @ApiModelProperty(value = "编号", name = "bh", dataType = "String")
    private String bh;

    /**
     * 机型
     */
    @ApiModelProperty(value = "机型", name = "jx", dataType = "String")
    private String jx;

    /**
     * 件号
     */
    @ApiModelProperty(value = "件号", name = "jh", dataType = "String")
    private String jh;

    /**
     * 序号(批次号)
     */
    @ApiModelProperty(value = "序号", name = "xh", dataType = "String")
    private String xh;

    /**
     * 红冲标示
     */
    @ApiModelProperty(value = "红冲标示", name = "cxsgin", dataType = "String")
    private String cxsgin;

    /**
     * 单位ID
     */
    @ApiModelProperty(value = "单位ID", name = "dwid", dataType = "String")
    private String dwid;

    /**
     * 0:借用状态(初始状态);1:已归还;2:已转领用
     */
    @ApiModelProperty(value = "选择", name = "xz", dataType = "String")
    private String xz;

    /**
     * 仓库代码
     */
    @ApiModelProperty(value = "仓库代码", name = "ckdm", dataType = "String")
    private String ckdm;

    /**
     * 架位号
     */
    @ApiModelProperty(value = "架位号", name = "jwh", dataType = "String")
    private String jwh;

    /**
     * 飞机号
     */
    @ApiModelProperty(value = "飞机号", name = "fjh", dataType = "String")
    private String fjh;

    /**
     * 通知数
     */
    @ApiModelProperty(value = "通知数", name = "tzs", dataType = "Long")
    private Long tzs;

    /**
     * 数量(入库 实收数;出库 实发数)
     */
    @ApiModelProperty(value = "数量", name = "sl", dataType = "Long")
    private Long sl;

    /**
     * 质量
     */
    @ApiModelProperty(value = "质量", name = "zl", dataType = "String")
    private String zl;

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
     * 寿命状态
     */
    @ApiModelProperty(value = "寿命状态", name = "smzt", dataType = "String")
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
     * 总寿命：小时
     */
    @ApiModelProperty(value = "总寿命：小时", name = "zsmxs", dataType = "Integer")
    private Integer zsmxs;

    /**
     * 总寿命：循环次数
     */
    @ApiModelProperty(value = "总寿命：循环次数", name = "zsmxh", dataType = "Integer")
    private Integer zsmxh;

    /**
     * 总寿命 ：起落次数
     */
    @ApiModelProperty(value = "总寿命 ：起落次数", name = "zsmql", dataType = "Integer")
    private Integer zsmql;

    /**
     * 总翻修次数
     */
    @ApiModelProperty(value = "总翻修次数", name = "zfxcs", dataType = "Integer")
    private Integer zfxcs;

    /**
     * 油封日期
     */
    @ApiModelProperty(value = "油封日期", name = "yfrq", dataType = "Date")
    private Date yfrq;

    /**
     * 翻修日期
     */
    @ApiModelProperty(value = "翻修日期", name = "fxrq", dataType = "Date")
    private Date fxrq;

    /**
     * 翻修年限
     */
    @ApiModelProperty(value = "验收日期", name = "ysrq", dataType = "Integer")
    private Integer fxsmn;

    /**
     * 翻修寿命小时
     */
    @ApiModelProperty(value = "翻修寿命小时", name = "fxsmxs", dataType = "Integer")
    private Integer fxsmxs;

    /**
     * 翻修次数
     */
    @ApiModelProperty(value = "翻修次数", name = "fxcs", dataType = "Integer")
    private Integer fxcs;

    /**
     * 商保期年
     */
    @ApiModelProperty(value = "商保期年", name = "sbqxn", dataType = "Integer")
    private Integer sbqxn;

    /**
     * 商保期飞行小时
     */
    @ApiModelProperty(value = "商保期飞行小时", name = "sbqxxs", dataType = "Integer")
    private Integer sbqxxs;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注", name = "bz", dataType = "String")
    private String bz;

    /**
     * 总飞行小时(总使用时间)
     */
    @ApiModelProperty(value = "总飞行小时", name = "zfxxs", dataType = "Integer")
    private Integer zfxxs;

    /**
     * 本次总飞行小时(使用时间)
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
     * 循环次数
     */
    @ApiModelProperty(value = "循环次数", name = "bcxhcs", dataType = "Integer")
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
     * 起落次数
     */
    @ApiModelProperty(value = "起落次数", name = "bcqlcs", dataType = "Integer")
    private Integer bcqlcs;

    /**
     * 调拨选择标志 外借选择标志
     */
    @ApiModelProperty(value = "调拨选择标志", name = "dbbz", dataType = "String")
    private String dbbz;

    /**
     * 创建日期
     */
    @ApiModelProperty(value = "创建日期", name = "cjrq", dataType = "Date")
    private Date cjrq;

    /**
     * 油封次数
     */
    @ApiModelProperty(value = "油封次数", name = "yfcs", dataType = "Integer")
    private Integer yfcs;

    /**
     * 总油封次数
     */
    @ApiModelProperty(value = "总油封次数", name = "zyfcs", dataType = "Integer")
    private Integer zyfcs;

    /**
     * 新品是否选择标志
     */
    @ApiModelProperty(value = "新品是否选择标志", name = "xsbz", dataType = "String")
    private String xsbz;

    /**
     * 汇率
     */
    @ApiModelProperty(value = "汇率", name = "hl", dataType = "BigDecimal")
    private BigDecimal hl;

    /**
     * 出入库类别
     */
    @ApiModelProperty(value = "出入库类别", name = "lb", dataType = "String")
    private String lb;

    /**
     * 出入库日期
     */
    @ApiModelProperty(value = "出入库日期", name = "rq", dataType = "Date")
    private Date rq;

    /**
     * 计价
     */
    @ApiModelProperty(value = "计价", name = "jj", dataType = "BigDecimal")
    private BigDecimal jj;

    /**
     * 航材类别
     */
    @ApiModelProperty(value = "航材类别", name = "hclb", dataType = "Integer")
    private Integer hclb;

    /**
     * 币种
     */
    @ApiModelProperty(value = "币种", name = "bbz", dataType = "Integer")
    private Integer bbz;

    /**
     * 专业类别
     */
    @ApiModelProperty(value = "专业类别", name = "zylb", dataType = "Integer")
    private Integer zylb;

    /**
     * 原序号(原批次号)
     */
    @ApiModelProperty(value = "原序号(原批次号)", name = "yxh", dataType = "String")
    private String yxh;

    /**
     * 总供气次数
     */
    @ApiModelProperty(value = "总供气次数", name = "zgqcs", dataType = "Integer")
    private Integer zgqcs;

    /**
     * 供气次数
     */
    @ApiModelProperty(value = "供气次数", name = "gqcs", dataType = "Integer")
    private Integer gqcs;

    /**
     * 油封期限
     */
    @ApiModelProperty(value = "油封期限", name = "yfqx", dataType = "BigDecimal")
    private BigDecimal yfqx;

    /**
     * 付款类别
     */
    @ApiModelProperty(value = "付款类别", name = "fklb", dataType = "Short")
    private Short fklb;

    /**
     * 缴旧数
     */
    @ApiModelProperty(value = "缴旧数", name = "jjs", dataType = "Long")
    private Long jjs;

    /**
     * 中队代码
     */
    @ApiModelProperty(value = "中队代码", name = "zddm", dataType = "String")
    private String zddm;

    /**
     * 收旧数
     */
    @ApiModelProperty(value = "收旧数", name = "sjs", dataType = "Long")
    private Long sjs;

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
     * null
     */
    @ApiModelProperty(value = "验收日期", name = "rfid", dataType = "Date")
    private String rfid;

    /**
     * null
     */
    @ApiModelProperty(value = "验收日期", name = "ysid", dataType = "String")
    private String ysid;

    /**
     * 归还日期
     */
    @ApiModelProperty(value = "归还日期", name = "ghrq", dataType = "Date")
    private Date ghrq;

    /**
     * 机型简码
     */
    @ApiModelProperty(value = "机型简码", name = "jxjm", dataType = "String")
    private String jxjm;
    /**
     *业务字段
     */
    /**
     * 选择名称
     */
    @ApiModelProperty(value = "选择名称", name = "zt", dataType = "String")
    private String zt;

    /**
     * 单价*汇率
     */
    @ApiModelProperty(value = "单价*汇率", name = "yhldj", dataType = "String")
    private String yhldj;

    /**
     * 单价*汇率*数量
     */
    @ApiModelProperty(value = "单价*汇率*数量", name = "yhlzj", dataType = "String")
    private String yhlzj;

    /**
     * 单价*汇率
     */
    @ApiModelProperty(value = "单价*汇率", name = "xhldj", dataType = "String")
    private String xhldj;

    /**
     * 单价*汇率*数量
     */
    @ApiModelProperty(value = "单价*汇率*数量", name = "xhlzj", dataType = "String")
    private String xhlzj;


    /**
     * 件号名称
     */
    @ApiModelProperty(value = "件号名称", name = "jhmc", dataType = "String")
    private String jhmc;

    /**
     * 发付单位名称
     */
    @ApiModelProperty(value = "发付单位名称", name = "ffmc", dataType = "String")
    private String ffmc;

    /**
     * 文号
     */
    @ApiModelProperty(value = "文号", name = "ffmc", dataType = "String")
    private String wh;

    /**
     * 依据
     */
    @ApiModelProperty(value = "依据", name = "ffmc", dataType = "String")
    private String yj;

    /**
     * 计量单位
     */
    @ApiModelProperty(value = "计量单位", name = "jldw", dataType = "String")
    private String jldw;

    /**
     * 质量名称
     */
    @ApiModelProperty(value = "质量名称", name = "zlmc", dataType = "String")
    private String zlmc;
}
