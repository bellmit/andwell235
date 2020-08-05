package com.andawell.material.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/***
 * @author lhb
 * @Date: 2020/5/6 11:04
 * @Description:
 * @version : V1.0
 */
@Data
@Accessors(chain = true)
@ApiModel("待修入库详细明细")
@AllArgsConstructor
@NoArgsConstructor
public class RepairedLibraryDetailDTO {

    /**
     * 编号
     */

    @ApiModelProperty(name = "bh", value = "编号",required = true)
    private String bh;

    /**
     * 件号
     */
    @NotBlank(message = "件号不能为空")
    @ApiModelProperty(name = "jh", value = "件号",required = true)
    private String jh;

    /**
     * 序号
     */
    @NotBlank(message = "序号不能为空")
    @ApiModelProperty(name = "xh", value = "序号",required = true)
    private String xh;

    /**
     * 选择;0为未送修 1为已送修 默认未送修
     */
    @NotBlank(message = "选择;0为未送修 1为已送修 默认未送修 不能为NULL")
    @ApiModelProperty(name = "xz", value = "择;0为未送修 1为已送修 默认未送修")
    private String xz = "0";

    /**
     * 机型
     */
    @NotBlank(message = "机型不能为空")
    @ApiModelProperty(name = "jx", value = "机型",required = true)
    private String jx;


    /**
     * 仓库代码
     */
    @NotBlank(message = "仓库代码不为NULL")
    @ApiModelProperty(name = "ckdm", value = "仓库代码",required = true)
    private String ckdm;

    /**
     * 飞机号
     */
    @ApiModelProperty(name = "fjh", value = "飞机号")
    private String fjh;

    /**
     * 质量 21:待修 24:待报废
     */
    @NotBlank(message = "质量不能为空")
    @ApiModelProperty(name = "fjh", value = "质量 21:待修 24:待报废")
    private String zl;


    /**
     * 使用单位
     */
    @ApiModelProperty( value = "使用单位")
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
     * 航材类别
     */
    @NotNull(message = "航材类别不能为空")
    @ApiModelProperty(name = "zqlcs", value = "总起落次数")
    private Integer hclb;


    /**
     * 架位号
     */
    @ApiModelProperty(name = "jwh", value = "总起落次数")
    private String jwh;


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

    /**
     * 数量
     */
    @ApiModelProperty(name = "数量", value = "数量")
    private Integer sl;

    /**
     * 修复、退修
     */
    private String cljg;

}
