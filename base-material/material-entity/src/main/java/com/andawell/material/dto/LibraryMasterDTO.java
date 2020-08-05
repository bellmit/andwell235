package com.andawell.material.dto;

import com.andawell.material.dto.groups.First;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/***
 * @author lhb
 * @Date: 2020/4/28 13:32
 * @Description:
 * @version : V1.0
 */
@Data
@ApiModel("出入库主信息")
public class LibraryMasterDTO {


    @NotBlank(message = "机型不能为空")
    @ApiModelProperty(name = "jx", value = "机型")
    private String jx;

    @NotBlank(message = "单位Id不能为空自己的单位Id")
    @ApiModelProperty(name = "dwid", value = "单位Id",required = true)
    private String dwid;

    @NotBlank(message = "发付单位Id不能为空")
    @ApiModelProperty(value = "发付单位Id",required = true)
    private String ffdw;

    @NotBlank(message = "接收单位Id不能为空")
    @ApiModelProperty(value = "接收单位Id",required = true)
    private String jsdw;

    @NotBlank(message = "类别Id不能为空")
    @ApiModelProperty(name = "lb", value = "类别",required = true)
    private String lb;

    @NotBlank(message = "类别简明")
    @ApiModelProperty(name = "lbjm", value = "类别Id不能为空",required = true)
    private String lbjm;

    @NotBlank(message = "文号")
    @ApiModelProperty(name = "wh", value = "入库文号",required = true)
    private String wh;

    @NotBlank(message = "依据不能为空，即根据文号",groups = {First.class})
    @ApiModelProperty(name = "yj", value = "依据")
    private String yj;

    @NotBlank(message = "运输方式不能为空")
    @ApiModelProperty(name = "ysfs", value = "运输方式",required = true)
    private String ysfs;

    @ApiModelProperty(name = "ysr", value = "验收人",required = true)
    private String ysr;

    @NotBlank(message = "创建人不能为空")
    @ApiModelProperty(name = "cjr", value = "创建人",required = true)
    private String cjr;

    @NotBlank(message = "系统编号不能为空")
    @ApiModelProperty(name = "bh", value = "系统编号",required = true)
    private String bh;

    @ApiModelProperty(name = "fph", value = "发票号")
    private String fph;

    @NotNull(message = "出入库日期不能为空")
    @ApiModelProperty(name = "rkrq", value = "入库日期",required = true)
    private Date rkrq;

  /*  @NotNull(message = "交付日期不能为空")*/
    @ApiModelProperty(name = "jfrq", value = "交付日期")
    private Date jfrq;

    @ApiModelProperty(name = "lcbh", value = "轮换出库编号")
    private Integer lcbh;

    @ApiModelProperty(name = "crklx", value = "出入库类型")
    private Integer crklx;

    /**
     *@Author: liuys
     *@Data: 2020/5/14
     *@Description: 以上是主信息


    /**
     * 依据日期
     */
    @ApiModelProperty(name = "yjrq", value = "依据日期",dataType="Date")
    private Date yjrq;


    /**
     * 日期
     */
    @ApiModelProperty(name = "rq", value = "日期",dataType="Date")
    private Date rq;

    /**
     * 飞机类型
     */
    @ApiModelProperty(name = "fjlx", value = "飞机类型",dataType="String")
    private String fjlx;

    /**
     * 飞机机号
     */
    @ApiModelProperty(name = "fjjh", value = "飞机机号",dataType="String")
    private String fjjh;

    /**
     * 发付人
     */
    @ApiModelProperty(name = "fcr", value = "发付人",dataType="String")
    private String fcr;

    /**
     * 收入人
     */
    @NotBlank(groups = {First.class},message = "收入人(领用人)")
    @ApiModelProperty(name = "srr", value = "收入人",dataType="String")
    private String srr;


    /**
     * 运输单号
     */
    @ApiModelProperty(name = "ysdh", value = "运输单号",dataType="String")
    private String ysdh;

    /**
     * 批准人
     */
    @NotBlank(groups = {First.class},message = "批准人不能为空")
    @ApiModelProperty(name = "pzr", value = "批准人",dataType="String")
    private String pzr;

    /**
     * 保管员
     */
    @NotBlank(groups = {First.class},message = "保管人不能为空")
    @ApiModelProperty(name = "bgy", value = "保管员",dataType="String")
    private String bgy;


    /**
     * null
     */
    @ApiModelProperty(name = "cydw", value = "null",dataType="String")
    private String cydw;

    /**
     * null
     */
    @ApiModelProperty(name = "hydh", value = "null",dataType="String")
    private String hydh;

    /**
     * 装备编号
     */
    @ApiModelProperty(name = "zbbh", value = "装备编号",dataType="String")
    private String zbbh;

    /**
     * null
     */
    @ApiModelProperty(name = "rfid", value = "null",dataType="String")
    private String rfid;

    /**
     * null
     */
    @ApiModelProperty(name = "ysid", value = "null",dataType="String")
    private String ysid;

    /**
     * 回执接收时间
     */
    @ApiModelProperty(name = "hzsj", value = "回执接收时间",dataType="Date")
    private Date hzsj;

    /**
     * 回执接收人
     */
    @ApiModelProperty(name = "hzjsr", value = "回执接收人",dataType="String")
    private String hzjsr;


    /**
     * 器材类别
     */
    @ApiModelProperty(name = "qclb", value = "器材类别",dataType="String")
    private String qclb;

    /**
     * 件号
     */
    @ApiModelProperty(name = "jh", value = "件号",dataType="String")
    private String jh;

    /**
     * 处理编号，即对应的出入库编号
     */
    @ApiModelProperty(name = "clbh", value = "处理编号",dataType="String")
    private String clbh;
}
