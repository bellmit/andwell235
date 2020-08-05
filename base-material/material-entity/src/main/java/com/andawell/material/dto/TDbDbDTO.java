package com.andawell.material.dto;

import com.andawell.material.dto.groups.First;
import com.andawell.material.dto.groups.Number;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/***
 * @author hwd
 * @Date: 2020-05-22 09:52
 * @Description:
 * @version : V1.0
 */
@Data
@ApiModel("战区和机关调拨主信息")
public class TDbDbDTO
{

    /**
     * 接收单位
     */
    @ApiModelProperty(name = "jsdw", value = "接收单位",required = true)
    private String jsdw;

    /**
     * 调拨单号
     */
    @ApiModelProperty(name = "dbdh", value = "调拨单号",required = true)
    private String dbdh;

    /**
     * 申请单号
     */
    @NotNull(message = "申请单号不能位空")
    @ApiModelProperty(name = "ltsqdh", value = "申请单号",required = true)
    private String ltsqdh;

    /**
     * 文号
     */
    @ApiModelProperty(name = "wh", value = "文号",required = true)
    private String wh;

    /**
     * 运输方式
     */
    @ApiModelProperty(name = "ysfs", value = "运输方式",required = true)
    @NotNull(message = "运输方式不能位空",groups = {First.class})
    private Integer ysfs;

    /**
     * 机型
     */
    @NotNull(message = "机型不能位空")
    @ApiModelProperty(name = "jx", value = "机型")
    private String jx;

    /**
     * 发付单位
     */

    @ApiModelProperty(name = "ffdw", value = "发付单位")
    private Integer ffdw;


    /**
     * dwid 发付单位 页面仓库id
     */
    private String dwid;

    /**
     * 接收单位
     */
    @ApiModelProperty(name = "sqdw", value = "接收单位")
    private Integer sqdw;

    /**
     * 状态
     */
    @ApiModelProperty(name = "zt", value = "状态")
    private Integer zt;

    /**
     * 编写日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(name = "rq", value = "编写日期")
    private Date rq;

    /**
     * 备注
     */
    @ApiModelProperty(name = "bz", value = "备注")
    private String bz;

    /**
     * null
     */
    private Short bzw;

    /**
     * 调拨类型
     */
    @NotNull(message = "调拨类型不能位空",groups = {First.class})
    private Integer dblx;

    /**
     * 打印标识
     */
    private Short print;

    /**
     * null
     */
    @ApiModelProperty(name = "dblb", value = "调拨类别")
    private Integer dblb;

    /**
     * 调拨编号
     */
    @NotNull(message = "调拨编号不能位空",groups = {First.class})
    @ApiModelProperty(name = "dbbh", value = "调拨编号")
    private String dbbh;

    /**
     * 下发状态0：未下发；1：以下发；
     */
    @ApiModelProperty(name = "xfzt", value = "下发状态")
    private String xfzt;

    /**
     * 处理状态0：未处理；1：以处理；
     */
    @ApiModelProperty(name = "clzt", value = "处理状态")
    private String clzt;

    /**
     * 上传状态0：未长传；1：未长传
     */
    @ApiModelProperty(name = "cszt", value = "上传状态")
    private String cszt;

    /**
     * 上级申请0：不需要上级申请；1：需要上级申请；
     */
    @ApiModelProperty(name = "sjsq", value = "上级申请")
    private String sjsq;
}
