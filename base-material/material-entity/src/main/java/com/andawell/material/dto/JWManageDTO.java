package com.andawell.material.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/***
 * @author hwd
 * @Date: 2020-05-15 10:30
 * @Description:
 * @version : V1.0
 */
@Data
@ApiModel("架位管理")
public class JWManageDTO
{
    /**
     * 件号
     */
    @NotBlank(message = "件号不能为空")
    @ApiModelProperty(value = "件号",required = true)
    private String jh;


    /**
     * 机型
     */
    @NotBlank(message = "机型不能为空")
    @ApiModelProperty(value = "机型",required = true)
    private String jx;


    /**
     * 质量
     */
    @NotBlank(message = "质量不能为空")
    @ApiModelProperty(value = "质量",required = true)
    private String zl;


    /**
     * 价位号
     */
    @NotBlank(message = "架位号不能为空")
    @ApiModelProperty(value = "价位号",required = true)
    private String jwh;


    /**
     * 仓库代码
     */
    @ApiModelProperty(value = "仓库号",required = true)
    private String ckdm;


    @ApiModelProperty(value = "单位id")
    private String dwid;


    @ApiModelProperty(value = "选择")
    private String xz;

    @ApiModelProperty(value = "编号")
    private String bh;

    @ApiModelProperty(value = "序号")
    private String xh;

}
