package com.andawell.material.dto;/**
 * @Date： 2020/5/11 20:10
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 *@Auther:liuys
 *@Date:2020/5/11 20:10
 *@Description:
 */
@Data
@ApiModel("待修出库信息")
public class TJhGzDTO {
    /**
     * 编号
     */
    @ApiModelProperty(name = "bh", value = "编号")
    private String bh;


    /**
     * 出库件号
     */
    @NotBlank(message = "出库件号不能为空")
    @ApiModelProperty("出库件号")
    private String jh;

    /**
     * 机型
     */
    @NotBlank(message = "机型不能为空")
    @ApiModelProperty("机型")
    private String jx;


    /**
     * 出库件号
     */
    @NotBlank(message = "出库单位Id不能为空")
    @ApiModelProperty("出库单位Id")
    private String dwid;


    /**
     * 序号
     */
    @NotBlank(message = "序号不能为空")
    @ApiModelProperty(name = "xh", value = "序号")
    private String xh;

    /**
     * 选择;0为未送修 1为已送修
     */
    @NotBlank(message = "序号不能为空")
    @ApiModelProperty(name = "xz", value = "选择")
    private String xz;


    /**
     * 仓库代码
     */
    @ApiModelProperty(name = "ckdm", value = "仓库代码")
    private String ckdm;

    /**
     * 飞机号
     */
    @ApiModelProperty(name = "fjh", value = "飞机号")
    private String fjh;

    /**
     * 质量 21:待修 24:待报废
     */
    @ApiModelProperty(name = "zl", value = "质量")
    private String zl;

    /**
     * 入库日期
     */
    @ApiModelProperty(name = "rkrq", value = "入库日期")
    private Date rkrq;

    /**
     * 使用单位
     */
    @ApiModelProperty(name = "sydw", value = "使用单位")
    private String sydw;

    /**
     * 专业
     */
    @ApiModelProperty(name = "zy", value = "专业")
    private String zy;

    /**
     * 故障日期
     */
    @ApiModelProperty(name = "gzrq", value = "故障日期")
    private Date gzrq;

    /**
     * 发现人
     */
    @ApiModelProperty(name = "fxr", value = "发现人")
    private String fxr;

    /**
     * 排故人
     */
    @ApiModelProperty(name = "pgr", value = "排故人")
    private String pgr;

    /**
     * 故障现象
     */
    @ApiModelProperty(name = "gzxx", value = "故障现象")
    private String gzxx;

    /**
     * 装机时间
     */
    @ApiModelProperty(name = "zjsj", value = "装机时间")
    private Date zjsj;

    /**
     * 装机单位
     */
    @ApiModelProperty(name = "zjdw", value = "装机单位")
    private String zjdw;

    /**
     * 装机人
     */
    @ApiModelProperty(name = "zjr", value = "装机人")
    private String zjr;

    /**
     * 拆机单位
     */
    @ApiModelProperty(name = "cjdw", value = "拆机单位")
    private String cjdw;

    /**
     * 拆机时间
     */
    @ApiModelProperty(name = "cjsj", value = "拆机时间")
    private Date cjsj;

    /**
     * 拆机人
     */
    @ApiModelProperty(name = "cjr", value = "拆机人")
    private String cjr;

    /**
     * 备注
     */
    @ApiModelProperty(name = "bz", value = "备注")
    private String bz;

    /**
     * 本次循环次数
     */
    @ApiModelProperty(name = "bcxhcs", value = "本次循环次数")
    private Integer bcxhcs;

    /**
     * 本次起落次数
     */
    @ApiModelProperty(name = "bcqlcs", value = "本次起落次数")
    private Integer bcqlcs;

    /**
     * 本次飞行次数
     */
    @ApiModelProperty(name = "bcfxxs", value = "本次飞行次数")
    private Integer bcfxxs;

    /**
     * 数量
     */
    @ApiModelProperty(name = "sl", value = "数量")
    private Integer sl;

    /**
     * 承修单位
     */
    @ApiModelProperty(name = "cxdw", value = "承修单位")
    private String cxdw;

    /**
     * 故障信息卡
     */
    @ApiModelProperty(name = "yj", value = "故障信息卡")
    private String yj;

    /**
     * 用于保存送修表中的合同编号 （返修时使用）
     */
    @ApiModelProperty(name = "htbh", value = "用于保存送修表中的合同编号")
    private String htbh;

    /**
     * 送修数量
     */
    @ApiModelProperty(name = "zxsl", value = "送修数量")
    private Integer zxsl;

    /**
     * 出厂日期
     */
    @ApiModelProperty(name = "ccrq", value = "出厂日期")
    private Date ccrq;

    /**
     * 验收日期
     */
    @ApiModelProperty(name = "ysrq", value = "验收日期")
    private Date ysrq;

    /**
     * 寿命状态(保留)暂无意义
     */
    @ApiModelProperty(name = "smzt", value = "寿命状态")
    private String smzt;

    /**
     * 总寿命:年
     */
    @ApiModelProperty(name = "zsmn", value = "总寿命:年")
    private String zsmn;

    /**
     * 总寿命:小时
     */
    @ApiModelProperty(name = "zsmxs", value = "总寿命:小时")
    private String zsmxs;

    /**
     * 总寿命:循环
     */
    @ApiModelProperty(name = "zsmxh", value = "总寿命:循环")
    private String zsmxh;

    /**
     * 总寿命:起落
     */
    @ApiModelProperty(name = "zsmql", value = "总寿命:起落")
    private String zsmql;

    /**
     * 总飞行次数
     */
    @ApiModelProperty(name = "zfxcs", value = "总飞行次数")
    private String zfxcs;

    /**
     * 油封日期
     */
    @ApiModelProperty(name = "yfrq", value = "油封日期")
    private Date yfrq;

    /**
     * 油封权限
     */
    @ApiModelProperty(name = "yfqx", value = "油封权限")
    private Integer yfqx;

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
     * 飞行日期
     */
    @ApiModelProperty(name = "fxrq", value = "飞行日期")
    private Date fxrq;

    /**
     * 飞行寿命:年
     */
    @ApiModelProperty(name = "fxsmn", value = "飞行寿命:年")
    private Integer fxsmn;

    /**
     * 飞行寿命:小时
     */
    @ApiModelProperty(name = "fxsmxs", value = "飞行寿命:小时")
    private Integer fxsmxs;

    /**
     * 飞行次数
     */
    @ApiModelProperty(name = "fxcs", value = "飞行次数")
    private Integer fxcs;

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
     * null
     */
    @ApiModelProperty(name = "zt", value = "null")
    private String zt;

    /**
     * 航材类别
     */
    @ApiModelProperty(name = "hclb", value = "航材类别")
    private Integer hclb;

    /**
     * 修理级别
     */
    @ApiModelProperty(name = "xljb", value = "修理级别")
    private Integer xljb;

    /**
     * 专业类别
     */
    @ApiModelProperty(name = "zylb", value = "专业类别")
    private Integer zylb;

    /**
     * 架位号
     */
    @ApiModelProperty(name = "jwh", value = "架位号")
    private String jwh;

    /**
     * null
     */
    @ApiModelProperty(name = "zddm", value = "null")
    private String zddm;

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
     * 上报编号
     */
    @ApiModelProperty(name = "sbbh", value = "上报编号")
    private String sbbh;

    /**
     * 上报开始日期
     */
    @ApiModelProperty(name = "sbrq", value = "上报开始日期")
    private Date sbrq;

    /**
     * 上报截止日期
     */
    @ApiModelProperty(name = "jzrq", value = "上报截止日期")
    private Date jzrq;

    /**
     * 批复状态
     */
    @ApiModelProperty(name = "pfzt", value = "批复状态")
    private String pfzt;

    /**
     * 生产厂家
     */
    @ApiModelProperty(name = "sccj", value = "生产厂家")
    private String sccj;

    /**
     * 使用时间
     */
    @ApiModelProperty(name = "sysj", value = "使用时间")
    private String sysj;

    /**
     * 报废、送修
     */
    @ApiModelProperty(name = "cljg", value = "报废、送修")
    private String cljg;

    /**
     * 处理时间，即出入库时间
     */
    @ApiModelProperty(name = "clsj", value = "处理时间，即出入库时间")
    private Date clsj;

    /**
     * 处理编号，即对应的出入库编号
     */
    @ApiModelProperty(name = "clbh", value = "处理编号，即对应的出入库编号")
    private String clbh;

    /**
     * 状态互转说明
     */
    @ApiModelProperty(name = "zhsm", value = "状态互转说明")
    private String zhsm;

    /**
     * 状态转换日期
     */
    @ApiModelProperty(name = "zhrq", value = "状态转换日期")
    private Date zhrq;


}
