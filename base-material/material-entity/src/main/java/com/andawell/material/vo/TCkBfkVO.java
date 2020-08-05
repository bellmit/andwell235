package com.andawell.material.vo;/**
 * @Date： 2020/5/13 13:59
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Auther:liuys
 * @Date:2020/5/13 13:59
 * @Description:
 */
@Data
@ApiModel("报废信息")
public class TCkBfkVO {

    /**
     * 报废入库编号
     */
    @ApiModelProperty(value = "报废入库编号", name = "bh", dataType = "String")
    private String bh;

    /**
     * 件号
     */
    @ApiModelProperty(value = "件号", name = "jh", dataType = "String")
    private String jh;

    /**
     * 序号
     */
    @ApiModelProperty(value = "序号", name = "xh", dataType = "String")
    private String xh;

    /**
     * 机型
     */
    @ApiModelProperty(value = "机型", name = "jx", dataType = "String")
    private String jx;

    /**
     * 单位ID
     */
    @ApiModelProperty(value = "单位ID", name = "dwid", dataType = "String")
    private String dwid;

    /**
     * 报废单位
     */
    @ApiModelProperty(value = "报废单位", name = "bfdw", dataType = "String")
    private String bfdw;

    /**
     * 报废日期
     */
    @ApiModelProperty(value = "报废日期", name = "bfrq", dataType = "String")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date bfrq;

    /**
     * 报废依据
     */
    @ApiModelProperty(value = "报废依据", name = "bfyj", dataType = "String")
    private String bfyj;

    /**
     * 报废原因
     */
    @ApiModelProperty(value = "报废原因", name = "bfyy", dataType = "String")
    private String bfyy;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注", name = "bz", dataType = "String")
    private String bz;

    /**
     * 架位号
     */
    @ApiModelProperty(value = "架位号", name = "jwh", dataType = "String")
    private String jwh;

    /**
     * 入库日期
     */
    @ApiModelProperty(value = "入库日期", name = "rkrq", dataType = "Date")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date rkrq;

    /**
     * 审批人
     */
    @ApiModelProperty(value = "报废入库编号", name = "bh", dataType = "String")
    private String spr;

    /**
     * 通知数
     */
    @ApiModelProperty(value = "通知数", name = "tzs", dataType = "Long")
    private Long tzs;

    /**
     * 仓库代码
     */
    @ApiModelProperty(value = "仓库代码", name = "ckdm", dataType = "String")
    private String ckdm;

    /**
     * 质量
     */
    @ApiModelProperty(value = "质量", name = "zl", dataType = "String")
    private String zl;

    /**
     * 待修编号
     */
    @ApiModelProperty(value = "待修编号", name = "dxbh", dataType = "String")
    private String dxbh;

    /**
     * 报废数量
     */
    @ApiModelProperty(value = "报废数量", name = "sl", dataType = "String")
    private Long sl;

    /**
     * 选择
     */
    @ApiModelProperty(value = "选择", name = "xz", dataType = "String")
    private String xz;

    /**
     * HCLB
     */
    @ApiModelProperty(value = "HCLB", name = "hclb", dataType = "Long")
    private Long hclb;

    /**
     * 批准单位
     */
    @ApiModelProperty(value = "批准单位", name = "pzdw", dataType = "String")
    private String pzdw;

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
    @ApiModelProperty(value = "null", name = "rfid", dataType = "String")
    private String rfid;
    /**
     * 以下是业务字段
     */
    @ApiModelProperty(value = "件号名称", name = "jhmc", dataType = "String")
    private String jhmc;

    @ApiModelProperty(value = "计量单位名称", name = "jldwmc", dataType = "String")
    private String jldwmc;

    @ApiModelProperty(value = "机型名称", name = "jxmc", dataType = "String")
    private String jxmc;

    @ApiModelProperty(value = "序号名称", name = "xhmc", dataType = "String")
    private String xhmc;
}

