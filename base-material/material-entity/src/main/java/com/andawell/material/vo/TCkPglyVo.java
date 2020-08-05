package com.andawell.material.vo;/**
 * @Date： 2020/5/18 10:23
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 *@Auther:liuys
 *@Date:2020/5/18 10:23
 *@Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCkPglyVo {
    /**
     * 编号
     */
    @ApiModelProperty(value = "bh", name = "编号", dataType = "String")
    private String bh;

    /**
     * 单位ID
     */
    @ApiModelProperty(value = "dwid", name = "单位ID", dataType = "String")
    private String dwid;

    /**
     * 依据
     */
    @ApiModelProperty(value = "yj", name = "依据", dataType = "String")
    private String yj;

    /**
     * 文号
     */
    @ApiModelProperty(value = "wh", name = "文号", dataType = "String")
    private String wh;

    /**
     * 依据日期
     */
    @ApiModelProperty(value = "yjrq", name = "依据日期", dataType = "String")
    private Date yjrq;

    /**
     * 类别
     */
    @ApiModelProperty(value = "lb", name = "类别", dataType = "String")
    private String lb;

    /**
     * 日期
     */
    @ApiModelProperty(value = "rq", name = "类别", dataType = "String")
    private Date rq;

    /**
     * 飞机类型
     */
    @ApiModelProperty(value = "jx", name = "飞机类型", dataType = "String")
    private String jx;

    /**
     * 飞机机号
     */
    @ApiModelProperty(value = "fjjh", name = "飞机机号", dataType = "String")
    private String fjjh;

    /**
     * 发票号
     */
    @ApiModelProperty(value = "fph", name = "发票号", dataType = "String")
    private String fph;

    /**
     * 运输方式
     */
    @ApiModelProperty(value = "ysfs", name = "运输方式", dataType = "String")
    private String ysfs;

    /**
     * 发付单位
     */
    @ApiModelProperty(value = "ffdw", name = "发付单位", dataType = "String")
    private String ffdw;

    /**
     * 发付人
     */
    @ApiModelProperty(value = "fcr", name = "发付人", dataType = "String")
    private String fcr;

    /**
     * 接收单位
     */
    @ApiModelProperty(value = "jsdw", name = "接收单位", dataType = "String")
    private String jsdw;

    /**
     * 收入人
     */
    @ApiModelProperty(value = "srr", name = "收入人", dataType = "String")
    private String srr;

    /**
     * 接收日期
     */
    @ApiModelProperty(value = "jsrq", name = "接收日期", dataType = "Date")
    private Date jsrq;

    /**
     * 运输单号
     */
    @ApiModelProperty(value = "ysdh", name = "运输单号", dataType = "Date")
    private String ysdh;

    /**
     * 总箱数
     */
    @ApiModelProperty(value = "zxs", name = "总箱数", dataType = "BigDecimal")
    private BigDecimal zxs;

    /**
     * 装箱编号
     */
    @ApiModelProperty(value = "zxbh", name = "装箱编号", dataType = "String")
    private String zxbh;

    /**
     * 股长
     */
    @ApiModelProperty(value = "gz", name = "股长", dataType = "String")
    private String gz;

    /**
     * 助理员
     */
    @ApiModelProperty(value = "zly", name = "助理员", dataType = "String")
    private String zly;

    /**
     * 分库主任
     */
    @ApiModelProperty(value = "fkzr", name = "分库主任", dataType = "String")
    private String fkzr;

    /**
     * 批准人
     */
    @ApiModelProperty(value = "pzr", name = "批准人", dataType = "String")
    private String pzr;

    /**
     * 保管员
     */
    @ApiModelProperty(value = "bgy", name = "保管员", dataType = "String")
    private String bgy;

    /**
     * 验收人
     */
    @ApiModelProperty(value = "ysr", name = "验收人", dataType = "String")
    private String ysr;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "cjr", name = "创建人", dataType = "String")
    private String cjr;

    /**
     * 创建日期
     */
    @ApiModelProperty(value = "cjrq", name = "创建日期", dataType = "Date")
    private Date cjrq;

    /**
     * 修改人
     */
    @ApiModelProperty(value = "xgr", name = "修改人", dataType = "String")
    private String xgr;

    /**
     * 修改日期
     */
    @ApiModelProperty(value = "xgrq", name = "修改日期", dataType = "Date")
    private Date xgrq;

    /**
     * 发付单位名称
     */
    @ApiModelProperty(value = "ffdwmc", name = "发付单位名称", dataType = "String")
    private String ffdwmc;

    /**
     * 接受单位名称
     */
    @ApiModelProperty(value = "jsdwmc", name = "接受单位名称", dataType = "String")
    private String jsdwmc;

    /**
     * null
     */
    @ApiModelProperty(value = "cydw", name = "null", dataType = "String")
    private String cydw;

    /**
     * null
     */
    @ApiModelProperty(value = "hydh", name = "null", dataType = "String")
    private String hydh;

    /**
     * 装备编号
     */
    @ApiModelProperty(value = "zbbh", name = "装备编号", dataType = "String")
    private String zbbh;

    /**
     * null
     */
    @ApiModelProperty(value = "rfid", name = "null", dataType = "String")
    private String rfid;

    /**
     * null
     */
    @ApiModelProperty(value = "ysid", name = "null", dataType = "String")
    private String ysid;
    /**
     *以下是业务字段
     */
    /**
     * 单位名称
     */
    @ApiModelProperty(value = "dwmc", name = "单位名称", dataType = "String")
    private String dwmc;

    /**
     * 机型名称
     */
    @ApiModelProperty(value = "jxmc", name = "机型名称", dataType = "String")
    private String jxmc;

    /**
     * 运输方式
     */
    @ApiModelProperty(value = "fyfsmc", name = "运输方式", dataType = "String")
    private String fyfsmc;

    /**
     * 件号
     */
    @ApiModelProperty(value = "jh", name = "件号", dataType = "String")
    private String jh;
}
