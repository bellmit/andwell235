package com.andawell.material.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
* @ClassName: TCkDx
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月06日 下午04:28:25
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCkDxSendForRepairVO {
    /**
     * 编号
     */
    @ApiModelProperty(value = "待修编号")
    private String bh;

    /**
     * 件号
     */
    @ApiModelProperty(value = "件号名称")
    private String jhmc;

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
     * 机型
     */
    @ApiModelProperty(value = "机型")
    private String jx;

    /**
     * 单位Id
     */
    @ApiModelProperty(value = "单位Id")
    private String dwid;

    /**
     * 数量
     */
    @ApiModelProperty(value = "数量")
    private Integer sl;

    /**
     * 计量单位
     */
    @ApiModelProperty(value = "计量单位")
    private String jldw;


    /**
     * 航材类别名称
     */
    @ApiModelProperty(value = "航材类别名称")
    private String hclbmc;



    /**
     * 入库日期
     */
    @ApiModelProperty(value = "入库日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date rkrq;

    /**
     * 油封日期
     */
    @ApiModelProperty(value = "油封日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date yfrq;


    /**
     * 油封期限
     */
    @ApiModelProperty(value = "油封期限")
    private Integer yfqx;

    /**
     * 返修日期
     */
    @ApiModelProperty(value = "翻修日期")
    private Date fxrq;

    /**
     * 飞行寿命:年
     */
    @ApiModelProperty(value = "翻修年限")
    private Integer fxsmn;


    /**
     * 出厂日期
     */
    @ApiModelProperty(value = "出厂日期")
    private Date ccrq;

    /**
     * 故障信息卡
     */
    @ApiModelProperty(value = "故障信息卡")
    private String yj;


    /**
     * 飞机号
     */
    @ApiModelProperty(value = "飞机号")
    private String fjh;

    /**
     * 故障现象
     */
    @ApiModelProperty(value = "故障原因")
    private String gzxx;

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
     * 生产厂家
     */
    @ApiModelProperty(value = "生产厂家")
    private String sccj;


    /**
     * 使用时间
     */
    @ApiModelProperty(value = "使用时间")
    private String sysj;


/**
 *@Author: liuys
 *@Data: 2020/5/14
 *@Description:
 */
    /**
     * 使用时间
     */
    @ApiModelProperty(value = "币种")
    private String bbz="1";

    /**
     * 使用时间
     */
    @ApiModelProperty(value = "币种名称")
    private String bzmc="人民币";

    /**
     * 使用时间
     */
    @ApiModelProperty(value = "汇率")
    private String hl="1.00000";


    /**
     * 质量
     */
    @ApiModelProperty(value = "质量")
    private String zl;


    /**
     * 计量单位
     */
    @ApiModelProperty(value = "计量单位")
    private String dw;

    /**
     * 航材类别
     */
    @ApiModelProperty(value = "航材类别")
    private String hclb;


    /**
     * 仓库代码
     */
    @ApiModelProperty(value = "仓库代码")
    private String ckdm;
}