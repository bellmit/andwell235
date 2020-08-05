package com.andawell.material.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

/***
 * @author hwd
 * @Date: 2020-05-18 16:44
 * @Description: 入库价格修改
 * @version : V1.0
 */
@Data
@ApiModel("入库价格修改")
public class TariffReviseDTO
{
    /**
     * 编号
     */
    @NotBlank(message = "编号不能为空")
    @ApiModelProperty(value = "编号",required = true)
    private String bh;

    /**
     * 机型
     */
    @NotBlank(message = "机型不能为空")
    @ApiModelProperty(value = "机型",required = true)
    private String jx;

    /**
     * 件号
     */
    @NotBlank(message = "件号不能为空")
    @ApiModelProperty(value = "件号",required = true)
    private String jh;

    /**
     * 序号
     */
    @NotBlank(message = "序号不能为空")
    @ApiModelProperty(value = "序号",required = true)
    private String xh;

    /**
     * 红冲标示
     */
    @NotBlank(message = "红冲标示不能为空")
    @ApiModelProperty(value = "红冲标示",required = true)
    private String cxsgin;

    /**
     * 单位id
     */
    @NotBlank(message = "单位id不能为空")
    @ApiModelProperty(value = "单位id",required = true)
    private String dwid;

    /**
     * 选择
     */
    @NotBlank(message = "选择不能为空")
    @ApiModelProperty(value = "选择",required = true)
    private String xz;

    /**
     * 质量
     */
    @NotBlank(message = "质量不能为空")
    @ApiModelProperty(value = "质量",required = true)
    private String zl;

    @ApiModelProperty(value = "单价")
    private BigDecimal dj;

    @ApiModelProperty(value = "总价")
    private BigDecimal zj;

    @ApiModelProperty(value = "备注")
    private String bz;
    
    @ApiModelProperty(value = "数量(入库 实收数;出库 实发数)")
    private  Integer sl;

}
