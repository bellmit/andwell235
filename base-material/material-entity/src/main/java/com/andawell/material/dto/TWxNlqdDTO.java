package com.andawell.material.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author: zje
 * @date: 2020/5/9
 * @description:
 */
@Data
@ApiModel("维修能力信息")
public class TWxNlqdDTO {

    @NotBlank(message = "机型id不能为空")
    @ApiModelProperty(name = "jxId",value = "机型id")
    private String jxId;

    @NotBlank(message = "件号id不能为空")
    @ApiModelProperty(name = "jhId",value = "机型id")
    private String jhId;

    @ApiModelProperty(name = "sbmc",value = "设备名称")
    private String sbmc;

    @ApiModelProperty(name = "sbxh",value = "设备型号")
    private String sbxh;

    @ApiModelProperty(name = "sbzk",value = "设备状况")
    private String sbzk;

    @ApiModelProperty(name = "zccj",value = "制造厂家")
    private String zccj;

    @ApiModelProperty(name = "jlzq",value = "计量周期")
    private String jlzq;

    @ApiModelProperty(name = "zlmc",value = "资料名称")
    private String zlmc;

    @ApiModelProperty(name = "zlbc",value = "资料版次")
    private String zlbc;

    @ApiModelProperty(name = "zjh",value = "章节号")
    private String zjh;

    @ApiModelProperty(name = "nbbh",value = "内部编号")
    private String nbbh;

    @ApiModelProperty(name = "zlly",value = "资料来源")
    private String zlly;

    @ApiModelProperty(name = "skzt",value = "受控状态")
    private String skzt;

    @ApiModelProperty(name = "cfid",value = "厂房id")
    private String cfid;

    @ApiModelProperty(name = "wxlb",value = "维修类别")
    private String wxlb;

    @ApiModelProperty(name = "gzhj",value = "工作环境")
    private String gzhj;

    @ApiModelProperty(name = "bjly",value = "备件来源")
    private String bjly;

    @ApiModelProperty(name = "bz",value = "备注")
    private String bz;

    @ApiModelProperty(name = "sxbl",value = "送修比例")
    @NotNull(message = "送修比例不能为空")
    private BigDecimal sxbl;

}
