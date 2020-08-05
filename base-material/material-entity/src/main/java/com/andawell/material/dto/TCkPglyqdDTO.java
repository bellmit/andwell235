package com.andawell.material.dto;/**
 * @Date： 2020/5/15 17:21
 */

import com.andawell.material.dto.groups.First;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 *@Auther:liuys
 *@Date:2020/5/15 17:21
 *@Description:
 */
@Data
@Accessors(chain = true)
@ApiModel("排故领用清单")
public class TCkPglyqdDTO {
    /**
     * 编号
     */
    @NotBlank(message = "编号不能为空",groups = {First.class})
    @ApiModelProperty(name = "bh", value = "编号")
    private String bh;

    /**
     * 机型
     */
    @NotBlank(message = "机型不能为空")
    @ApiModelProperty(name = "jx", value = "机型")
    private String jx;

    /**
     * 件号
     */
    @NotBlank(message = "件号不能为空")
    @ApiModelProperty(name = "jh", value = "件号")
    private String jh;

    /**
     * 序号(批次号)
     */
    @NotBlank(message = "序号不能为空")
    @ApiModelProperty(name = "xh", value = "序号")
    private String xh;

    /**
     * 红冲标示
     */
    @ApiModelProperty(name = "cxsgin", value = "红冲标示")
    private String cxsgin="0";

    /**
     * 单位ID
     */
    @NotBlank(message = "单位ID不能为空")
    @ApiModelProperty(name = "dwid", value = "单位ID")
    private String dwid;

    /**
     * 0:借用状态(初始状态);1:已归还;2:已转领用
     */
    @ApiModelProperty(name = "xz", value = "选择")
    private String xz="2";

    /**
     * 仓库代码
     */
    @ApiModelProperty(name = "ckdm", value = "仓库代码")
    private String ckdm;

    /**
     * 架位号
     */
    @ApiModelProperty(name = "jwh", value = "仓库代码")
    private String jwh;

    /**
     * 飞机号
     */
    @ApiModelProperty(name = "fjh", value = "飞机号")
    private String fjh;

    /**
     * 通知数
     */
    @ApiModelProperty(name = "tzs", value = "通知数")
    private Long tzs;

    /**
     * 数量(入库 实收数;出库 实发数)
     */
    @ApiModelProperty(name = "sl", value = "通知数")
    private Long sl;

    /**
     * 质量
     */
    @ApiModelProperty(name = "zl", value = "质量")
    private String zl;

    /**
     * 单价
     */
    @ApiModelProperty(name = "dj", value = "单价")
    private BigDecimal dj;

    /**
     * 总价
     */
    @ApiModelProperty(name = "zj", value = "总价")
    private BigDecimal zj;

    /**
     * 出厂日期
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    @ApiModelProperty(name = "ccrq", value = "出厂日期")
    private Date ccrq;

    /**
     * 验收日期
     */
    @ApiModelProperty(name = "ysrq", value = "验收日期")
    private Date ysrq;

    /**
     * 寿命状态
     */
    @ApiModelProperty(name = "smzt", value = "寿命状态")
    private String smzt;

    /**
     * 入库日期
     */
    @ApiModelProperty(name = "rkrq", value = "入库日期")
    private Date rkrq;

    /**
     * 总寿命：年
     */
    @ApiModelProperty(name = "zsmn", value = "总寿命：年")
    private Integer zsmn;

    /**
     * 总寿命：小时
     */
    @ApiModelProperty(name = "zsmxs", value = "总寿命：小时")
    private Integer zsmxs;

    /**
     * 总寿命：循环次数
     */
    @ApiModelProperty(name = "zsmxh", value = "总寿命：循环次数")
    private Integer zsmxh;

    /**
     * 总寿命 ：起落次数
     */
    @ApiModelProperty(name = "zsmql", value = "总寿命 ：起落次数")
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
     * 翻修日期
     */
    @ApiModelProperty(name = "fxrq", value = "翻修日期")
    private Date fxrq;

    /**
     * 翻修年限
     */
    @ApiModelProperty(name = "fxsmn", value = "翻修年限")
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
     * 商保期年
     */
    @ApiModelProperty(name = "sbqxn", value = "商保期年")
    private Integer sbqxn;

    /**
     * 商保期飞行小时
     */
    @ApiModelProperty(name = "sbqxxs", value = "商保期飞行小时")
    private Integer sbqxxs;

    /**
     * 备注
     */
    @ApiModelProperty(name = "bz", value = "备注")
    private String bz;

    /**
     * 总飞行小时(总使用时间)
     */
    @ApiModelProperty(name = "zfxxs", value = "总飞行小时(总使用时间)")
    private Integer zfxxs;

    /**
     * 本次总飞行小时(使用时间)
     */
    @ApiModelProperty(name = "bczfxxs", value = "本次总飞行小时(使用时间)")
    private Integer bczfxxs;

    /**
     * 本次飞行小时
     */
    @ApiModelProperty(name = "bcfxxs", value = "本次飞行小时")
    private Integer bcfxxs;

    /**
     * 总循环次数
     */
    @ApiModelProperty(name = "zxhcs", value = "总循环次数")
    private Integer zxhcs;

    /**
     * 本次总循环次数
     */
    @ApiModelProperty(name = "bczxhcs", value = "本次总循环次数")
    private Integer bczxhcs;

    /**
     * 循环次数
     */
    @ApiModelProperty(name = "bcxhcs", value = "循环次数")
    private Integer bcxhcs;

    /**
     * 总起落次数
     */
    @ApiModelProperty(name = "zqlcs", value = "总起落次数")
    private Integer zqlcs;

    /**
     * 本次总起落次数
     */
    @ApiModelProperty(name = "bczqlcs", value = "本次总起落次数")
    private Integer bczqlcs;

    /**
     * 起落次数
     */
    @ApiModelProperty(name = "bcqlcs", value = "起落次数")
    private Integer bcqlcs;

    /**
     * 调拨选择标志 外借选择标志
     */
    @ApiModelProperty(name = "dbbz", value = "拨选择标志 外借选择标志")
    private String dbbz;

    /**
     * 创建日期
     */
    @ApiModelProperty(name = "cjrq", value = "创建日期")
    private Date cjrq;

    /**
     * 油封次数
     */
    @ApiModelProperty(name = "yfcs", value = "油封次数")
    private Integer yfcs;

    /**
     * 总油封次数
     */
    @ApiModelProperty(name = "zyfcs", value = "总油封次数")
    private Integer zyfcs;

    /**
     * 新品是否选择标志
     */
    @ApiModelProperty(name = "xsbz", value = "新品是否选择标志")
    private String xsbz;

    /**
     * 汇率
     */
    @ApiModelProperty(name = "hl", value = "汇率")
    private BigDecimal hl;

    /**
     * 出入库类别
     */
    @ApiModelProperty(name = "lb", value = "出入库类别")
    private String lb;

    /**
     * 出入库日期
     */
    @ApiModelProperty(name = "rq", value = "出入库日期")
    private Date rq;

    /**
     * 计价
     */
    @ApiModelProperty(name = "rq", value = "出入库日期")
    private BigDecimal jj;

    /**
     * 航材类别
     */
    @ApiModelProperty(name = "hclb", value = "航材类别")
    private Integer hclb;

    /**
     * 币种
     */
    @ApiModelProperty(name = "bbz", value = "币种")
    private Integer bbz;

    /**
     * 专业类别
     */
    @ApiModelProperty(name = "zylb", value = "专业类别")
    private Integer zylb;

    /**
     * 原序号(原批次号)
     */
    @ApiModelProperty(name = "yxh", value = "原序号(原批次号)")
    private String yxh;

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
     * 油封期限
     */
    @ApiModelProperty(name = "yfqx", value = "油封期限")
    private BigDecimal yfqx;

    /**
     * 付款类别
     */
    @ApiModelProperty(name = "fklb", value = "付款类别")
    private Short fklb;

    /**
     * 缴旧数
     */
    @ApiModelProperty(name = "jjs", value = "缴旧数")
    private Long jjs;

    /**
     * 中队代码
     */

    @ApiModelProperty(name = "zddm", value = "中队代码")
    private String zddm;

    /**
     * 收旧数
     */
    @ApiModelProperty(name = "sjs", value = "收旧数")
    private Long sjs;

    /**
     * 间修期年
     */
    @ApiModelProperty(name = "jxqn", value = "间修期年")
    private Integer jxqn;

    /**
     * 间修期小时
     */
    @ApiModelProperty(name = "jxqxs", value = "间修期小时")
    private Integer jxqxs;

    /**
     * null
     */
    @ApiModelProperty(name = "rfid", value = "null")
    private String rfid;

    /**
     * null
     */
    @ApiModelProperty(name = "ysid", value = "null")
    private String ysid;

    /**
     * 归还日期
     */
    @ApiModelProperty(name = "ghrq", value = "归还日期")
    private Date ghrq;

    //ckck


    /**
     * 原因
     */
    @ApiModelProperty(value = "原因")
    private String reason;

}
