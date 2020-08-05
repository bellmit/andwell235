package com.andawell.material.vo;

/***
 * @author hwd
 * @Date: 2020-06-09 15:53
 * @Description:
 * @version : V1.0
 */

import com.andawell.material.entity.TDbLtsqqd;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

/**
 * @author: zje
 * @date: 2020/5/28
 * @description:
 */
@Data
@ApiModel("旅团申请和详情信息")
public class TDbLtsqAndQDVO
{
    /**
     * 申请单号
     */
    @NotBlank(message = "申请单号不能为空")
    @ApiModelProperty(name = "ltsqdh",value = "申请单号",required = true)
    private String ltsqdh;

    /**
     * 申请单位
     */
    @ApiModelProperty(name = "sqdw",value = "申请单位")
    private String sqdw;

    /**
     * 机型
     */
    @NotBlank(message = "机型不能为空")
    @ApiModelProperty(name = "jx",value = "机型")
    private String jx;

    /**
     * 申请类别
     */
    @ApiModelProperty(name = "sqlb",value = "申请类别")
    private Integer sqlb;

    /**
     * 项数
     */
    @ApiModelProperty(name = "xs",value = "项数")
    private Integer xs;

    /**
     * 年度
     */
    @ApiModelProperty(name = "nd",value = "年度")
    private Integer nd;

    /**
     * 季度
     */
    @ApiModelProperty(name = "jd",value = "季度")
    private Integer jd;

    /**
     * 日期
     */
    @ApiModelProperty(name = "rq",value = "日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date rq;

    /**
     * 申请人
     */
    @ApiModelProperty(name = "sqr",value = "申请人")
    private String sqr;

    /**
     * 数据处理
     */
    @ApiModelProperty(name = "datacl",value = "数据处理")
    private Integer datacl;

    /**
     * 接收单位
     */
    @ApiModelProperty(name = "jsdw",value = "接收单位")
    private String jsdw;

    /**
     * 接收人
     */
    @ApiModelProperty(name = "jsr",value = "接收人")
    private String jsr;

    /**
     * 联系电话
     */
    @ApiModelProperty(name = "lxdh",value = "联系电话")
    private String lxdh;

    /**
     * 上传状态
     */
    @ApiModelProperty(name = "sczt",value = "上传状态")
    private String sczt ;

    /**
     * 处理状态
     */
    @ApiModelProperty(name = "clzt",value = "处理状态")
    private String clzt;

    /**
     * 清单信息
     */
    @Valid
    List<TDbLtsqqd> tDbLtsqqds;

}
