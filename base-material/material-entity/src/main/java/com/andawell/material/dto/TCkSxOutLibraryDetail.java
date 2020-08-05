package com.andawell.material.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
* @ClassName: TCkSx
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月06日 下午04:28:25
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCkSxOutLibraryDetail {

    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    private String bh;

    /**
     * 件号
     */
    @ApiModelProperty(value = "件号")
    private String jh;

    /**
     * 序号
     */
    @ApiModelProperty(value = "序号")
    private String xh;

    /**
     * 单位ID
     */
    @ApiModelProperty(value = "单位ID")
    private String dwid;

    /**
     * 机型
     */
    @ApiModelProperty(value = "机型")
    private String jx;


    /**
     * 飞机号
     */
    @ApiModelProperty(value = "飞机号")
    private String fjh;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String bz;

    /**
     * 架位号
     */
    @ApiModelProperty(value = "架位号")
    private String jwh;

    /**
     * 返回地
     */
    @ApiModelProperty(value = "返回地")
    private String fhd;

    /**
     * 承修单位
     */
    @ApiModelProperty(value = "承修单位")
    private String cxdw;

    /**
     * 承修单位
     */
    @ApiModelProperty(value = "送修日期")
    private Date sxrq;

    /**
     * 送修类别
     */
    @ApiModelProperty(value = "送修类别")
    private Date sxlb;

    /**
     * 合同编号
     */
    @ApiModelProperty(value = "合同编号")
    private String htbh;

    /**
     * 送修数量
     */
    @ApiModelProperty(value = "送修数量")
    private String sxsl;


    /**
     * 待修编号
     */
    @ApiModelProperty(value = "待修编号")
    private String dxbh;

    /**
     * 数量
     */
    @ApiModelProperty(value = "数量")
    private Integer sl;

    /**
     * 单价
     */
    @ApiModelProperty(value = "单价")
    private String dj;

    /**
     * 总价
     */
    @ApiModelProperty(value = "总价")
    private String zj;

    /**
     * 执行数量
     */
    @ApiModelProperty(value = "通知数")
    private Integer tzs;

    /**
     * 仓库代码
     */
    @ApiModelProperty(value = "仓库代码")
    private String ckdm;

    /**
     * 间修期年
     */
    @ApiModelProperty(value = "间修期年")
    private Integer jxqn;

    /**
     * 间修期小时
     */
    @ApiModelProperty(value = "间修期小时")
    private Integer jxqxs;

    /**
     * 出厂日期
     */
    @ApiModelProperty(value = "出厂日期")
    private Date ccrq;

    /**
     * 验收日期
     */
    @ApiModelProperty(value = "验收日期")
    private Date ysrq;

    /**
     * 寿命状态
     */
    @ApiModelProperty(value = "寿命状态")
    private Integer smzt;

    /**
     * 入库日期
     */
    @ApiModelProperty(value = "入库日期")
    private String rkrq;

    /**
     * null
     */
    @ApiModelProperty(value = "总寿命:年")
    private String zsmn;

    /**
     * 上报编号
     */
    @ApiModelProperty(value = "总寿命:小时")
    private String zsmxs;

    /**
     * 总寿命:循环次数
     */
    @ApiModelProperty(value = "总寿命:循环次数")
    private String zsmxh;


    /**
     * 总寿命:起落次数
     */
    @ApiModelProperty(value = "总寿命:起落次数")
    private Date zsmql;

    /**
     * 总翻修次数
     */
    @ApiModelProperty(value = "总翻修次数")
    private Date zfxcs;

    /**
     * 批复状态
     */
    @ApiModelProperty(value = "油封日期")
    private String yfrq;

    /**
     * 批复状态
     */
    @ApiModelProperty(value = "油封期限")
    private String yfqx;

    /**
     * 翻修日期
     */
    @ApiModelProperty(value = "翻修日期")
    private String fxrq;

    /**
     * 翻修日期
     */
    @ApiModelProperty(value = "翻修年限")
    private String fxsmn;



    /**
     * 翻修日期
     */
    @ApiModelProperty(value = "翻修寿命小时")
    private String fxsmxs;

    /**
     * 翻修次数
     */
    @ApiModelProperty(value = "翻修次数")
    private String fxcs;

    /**
     * 商保期年
     */
    @ApiModelProperty(value = "商保期年")
    private String sbqxn;

    /**
     * 处理时间，即出入库时间
     */
    @ApiModelProperty(value = "商保期飞行小时")
    private String sbqxxs;

    /**
     * 故障原因
     */
    @ApiModelProperty(value = "故障原因")
    private String gzyy;


    /**
     * 总飞行小时
     */
    @ApiModelProperty(value = "总飞行小时")
    private String zfxxs;



    /**
     * 本次飞行小时
     */
    @ApiModelProperty(value = "本次飞行小时")
    private String bcfxxs;

    /**
     * 翻修次数
     */
    @ApiModelProperty(value = "总循环次数")
    private String zxhcs;

    /**
     * 商保期年
     */
    @ApiModelProperty(value = "本次总循环次数")
    private String bczxhcs;

    /**
     * 循环次数
     */
    @ApiModelProperty(value = "循环次数")
    private String bcxhcs;

    /**
     * 总起落次数
     */
    @ApiModelProperty(value = "总起落次数")
    private String zqlcs;

    /**
     * 总起落次数
     */
    @ApiModelProperty(value = "本次总起落次数")
    private String bczqlcs;

    /**
     * 油封次数
     */
    @ApiModelProperty(value = "油封次数")
    private String yfcs;

    /**
     * 油封总次数
     */
    @ApiModelProperty(value = "油封总次数")
    private String zyfcs;

    /**
     * 出入库类别
     */
    @ApiModelProperty(value = "出入库类别")
    private String lb;

    /**
     * 商保期年
     */
    @ApiModelProperty(value = "本次起落次数")
    private String bcqlcs;

    /**
     * 航材类别
     */
    @ApiModelProperty(value = "航材类别HCLB")
    private String hclb;

    /**
     * 生产厂家
     */
    @ApiModelProperty(value = "生产厂家")
    private String sccj;

    /**
     * 出入库类别
     */
    @ApiModelProperty(value = "使用时间")
    private Date sysj;
}