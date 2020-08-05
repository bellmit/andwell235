package com.andawell.material.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Date： 2020/5/8 13:54
 */
@Data
@ApiModel("报废入库主信息")
public class ScrapInAndOutLibraryDetailDTO {
    /**
     * 以下是T_Ck_Bfk
     */

    /**
     * 报废入库编号
     */
    @ApiModelProperty(name = "bh", value = "编号")
    private String bh;

    /**
     * 件号
     */
    @NotBlank(message = "件号不能为空")
    @ApiModelProperty(name = "jh", value = "件号")
    private String jh;

    /**
     * 序号
     */
    @NotBlank(message = "序号不能为空")
    @ApiModelProperty(name = "xh", value = "序号")
    private String xh;


    /**
     * 报废单位
     */
    @ApiModelProperty(name = "bfdw", value = "报废单位")
    private String bfdw;

    /**
     * 报废日期
     */
    @ApiModelProperty(name = "bfrq", value = "报废日期")
    private Date bfrq;

    /**
     * 报废依据
     */
    @ApiModelProperty(name = "bfyj", value = "报废依据")
    private String bfyj;

    /**
     * 报废原因
     */
    @ApiModelProperty(name = "bfyy", value = "报废原因")
    private String bfyy;

    /**
     * 备注
     */
    @ApiModelProperty(name = "bz", value = "备注")
    private String bz;

    /**
     * 架位号
     */
    @ApiModelProperty(name = "jwh", value = "架位号")
    private String jwh;

    /**
     * 入库日期
     */
    @ApiModelProperty(name = "rkrq", value = "入库日期")
    private Date rkrq;

    /**
     * 审批人
     */
    @ApiModelProperty(name = "spr", value = "审批人")
    private String spr;

    /**
     * 通知数
     */
    @ApiModelProperty(name = "tzs", value = "通知数")
    private Long tzs;

    /**
     * 仓库代码
     */
    @ApiModelProperty(name = "ckdm", value = "仓库代码")
    private String ckdm;

    /**
     * 质量
     */
    @ApiModelProperty(name = "zl", value = "质量")
    private String zl;

    /**
     * 待修编号
     */
    @ApiModelProperty(name = "dxbh", value = "待修编号")
    private String dxbh;

    /**
     * 报废数量
     */
    @ApiModelProperty(name = "sl", value = "报废数量")
    private Long sl;

    /**
     * 选择;0为未送修 1为已送修 默认未送修
     */
    @NotBlank(message = "选择;0为未送修 1为已送修 默认未送修 不能为NULL")
    @ApiModelProperty(name = "xz", value = "择;0为未送修 1为已送修 默认未送修")
    private String xz = "0";

    /**
     * HCLB
     */
    @ApiModelProperty(name = "hclb", value = "HCLB")
    private Long hclb;

    /**
     * 批准单位
     */
    @ApiModelProperty(name = "pzdw", value = "批准单位")
    private String pzdw;

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
    @ApiModelProperty(name = "rfid", value = "")
    private String rfid;

    /**
     *以下是T_CK_CRKQD
     */

    /**
     * 机型
     */
    @NotBlank(message = "机型不能为空")
    @ApiModelProperty(name = "jx", value = "机型")
    private String jx;

    /**
     * 单位编号
     */
    @NotBlank(message = "单位编号不能为空")
    @ApiModelProperty(name = "dwid", value = "单位编号")
    private String dwid;


    /**
     * 飞机号
     */
    @ApiModelProperty(name = "fjh", value = "飞机号")
    private String fjh;



    /**
     * 使用单位
     */
    @ApiModelProperty(name = "sydw", value = "使用单位")
    private String sydw;

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
     * 出厂日期
     */
    @ApiModelProperty(name = "ccrq", value = "出厂日期")
    private Date ccrq;


    /**
     * 油封日期
     */
    @ApiModelProperty(name = "yfrq", value = "油封日期")
    private Date yfrq;


    /**
     * 总寿命:年
     */
    @ApiModelProperty(name = "zsmn", value = "总寿命:年")
    private String zsmn;

    /**
     * 总飞行小时
     */
    @ApiModelProperty(name = "zfxxs", value = "总飞行小时")
    private Integer zfxxs;

    /**
     * 总循环次数
     */
    @ApiModelProperty(name = "zxhcs", value = "总循环次数")
    private Integer zxhcs;

    /**
     * 总起落次数
     */
    @ApiModelProperty(name = "zqlcs", value = "总起落次数")
    private Integer zqlcs;



    /**
     * 上报编号
     */
    @ApiModelProperty(name = "sbbh", value = "上报编号")
    private String sbbh;


    /**
     * 生产厂家
     */
    @ApiModelProperty(name = "sccj", value = "生产厂家")
    private String sccj;


    /**
     * 处理编号，即对应的出入库编号
     */
    @ApiModelProperty(name = "clbh", value = "处理编号，即对应的出入库编号")
    private String clbh;


}
