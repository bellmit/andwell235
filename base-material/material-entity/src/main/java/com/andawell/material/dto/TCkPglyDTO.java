package com.andawell.material.dto;/**
 * @Date： 2020/5/15 17:11
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

/**
 *@Auther:liuys
 *@Date:2020/5/15 17:11
 *@Description:
 */
@Data
@Accessors(chain = true)
@ApiModel("排故领用主信息")
public class TCkPglyDTO {
    /**
     * 编号
     */

    @ApiModelProperty(name = "bh", value = "编号")
    private String bh;

    /**
     * 文号
     */
    @ApiModelProperty(name = "wh", value = "文号")
    private String wh;

    /**
     * 单位ID
     */
    @NotBlank(message = "单位ID不能为空")
    @ApiModelProperty(name = "zhsm", value = "单位ID")
    private String dwid;

    /**
     * 依据日期-领用日期
     */
    @ApiModelProperty(name = "yjrq", value = "依据日期-领用日期")
    private Date yjrq;


    /**
     * 飞机类型
     */
    @NotBlank(message = "机型不能为空")
    @ApiModelProperty(name = "jx", value = "飞机类型-机型")
    private String jx;

    /**
     * 飞机机号
     */
    @ApiModelProperty(name = "fjjh", value = "飞机机号")
    private String fjjh;

    /**
     * 类别
     */
    @ApiModelProperty(name = "lb", value = "类别")
    private String lb;

    /**
     * 日期
     */
    @ApiModelProperty(name = "rq", value = "日期")
    private Date rq;

    /**
     * 发付单位
     */
    @ApiModelProperty(name = "ffdw", value = "发付单位")
    private String ffdw;

    /**
     * 验收人
     */
    @NotBlank(message = "业务部门不能为空")
    @ApiModelProperty(name = "ysr", value = "验收人-业务部门")
    private String ysr;


    /**
     * 接收单位
     */
    @ApiModelProperty(name = "jsdw", value = "接收单位")
    private String jsdw;

    /**
     * 接收日期
     */
    @ApiModelProperty(name = "jsrq", value = "接收日期")
    private Date jsrq;

    /**
     * 运输单号
     */
    @ApiModelProperty(name = "ysdh", value = "运输单号")
    private String ysdh;

    /**
     * 运输方式
     */
    @ApiModelProperty(name = "ysfs", value = "运输方式")
    private String ysfs;

    /**
     * 批准人
     */
    @NotBlank(message = "批准人不能为空")
    @ApiModelProperty(name = "pzr", value = "批准人")
    private String pzr;

    /**
     * 保管员
     */
    @NotBlank(message = "保管员不能为空")
    @ApiModelProperty(name = "bgy", value = "保管员")
    private String bgy;


    /**
     * 装箱编号
     */
    @ApiModelProperty(name = "zxbh", value = "装箱编号")
    private String zxbh;

    /**
     * 股长
     */
    @NotBlank(message = "领用人不能为空")
    @ApiModelProperty(name = "gz", value = "股长-领用人")
    private String gz;

    /**
     * 依据
     */
    @ApiModelProperty(name = "yj", value = "依据")
    private String yj;

    /**
     * 发付人
     */
    @ApiModelProperty(name = "fcr", value = "发付人")
    private String fcr;

    /**
     * 总箱数
     */
    @ApiModelProperty(name = "zxs", value = "总箱数")
    private BigDecimal zxs;

    /**
     * 助理员
     */
    @ApiModelProperty(name = "zly", value = "助理员")
    private String zly;

    /**
     * 分库主任
     */
    @ApiModelProperty(name = "fkzr", value = "分库主任")
    private String fkzr;

    /**
     * 收入人
     */
    @ApiModelProperty(name = "srr", value = "收入人")
    private String srr;

    /**
     * 发票号
     */
    @ApiModelProperty(name = "fph", value = "发票号")
    private String fph;

    /**
     * 创建人
     */
    @ApiModelProperty(name = "cjr", value = "创建人")
    private String cjr;

    /**
     * 创建日期
     */
    @ApiModelProperty(name = "cjrq", value = "创建日期")
    private Date cjrq;

    /**
     * 修改人
     */
    @ApiModelProperty(name = "xgr", value = "修改人")
    private String xgr;

    /**
     * 修改日期
     */
    @ApiModelProperty(name = "xgrq", value = "修改日期")
    private Date xgrq;

    /**
     * 发付单位名称
     */
    @ApiModelProperty(name = "ffdwmc", value = "发付单位名称")
    private String ffdwmc;

    /**
     * 接受单位名称
     */
    @ApiModelProperty(name = "jsdwmc", value = "接受单位名称")
    private String jsdwmc;

    /**
     * null
     */
    @ApiModelProperty(name = "cydw", value = "null")
    private String cydw;

    /**
     * null
     */
    @ApiModelProperty(name = "hydh", value = "null")
    private String hydh;

    /**
     * 装备编号
     */
    @ApiModelProperty(name = "zbbh", value = "装备编号")
    private String zbbh;

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
     * 件号
     */
    @ApiModelProperty(name = "jh", value = "件号")
    private String jh;

    /**
     *@Author: liuys
     *@Data: 2020/7/9
     *@Description:
     */
    @NotBlank(message = "中队代码不能为空")
    @ApiModelProperty(name = "zddm", value = "中队代码")
    private String zddm;
}
