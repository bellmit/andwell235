package com.andawell.material.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
* @ClassName: TJhJx
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月06日 下午04:28:25
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TXtCgfDTO {

    /**
     * 流水号,编码规则：CG+3位流水号
     */
    @NotBlank(message = "编号不能为空")
    @ApiModelProperty(name = "id", value = "编号",required = true)
    private String id;

    /**
     * 单位名称
     */
    @NotBlank(message = "单位名称不能为空")
    @ApiModelProperty(name = "dwmc", value = "单位名称",required = true)
    private String dwmc;

    /**
     * 地址
     */
    @NotBlank(message = "地址不能为空")
    @ApiModelProperty(name = "dz", value = "地址",required = true)
    private String dz;

    /**
     * 电话
     */
    @NotBlank(message = "电话不能为空")
    @ApiModelProperty(name = "dh", value = "电话",required = true)
    private String dh;

    /**
     * 开户名称
     */
    @NotBlank(message = "开户名称不能为空")
    @ApiModelProperty(name = "khmc", value = "开户名称",required = true)
    private String khmc;

    /**
     * 开户银行
     */
    @NotBlank(message = "开户银行不能为空")
    @ApiModelProperty(name = "khyh", value = "开户银行",required = true)
    private String khyh;

    /**
     * 银行账户
     */
    @NotBlank(message = "银行账户不能为空")
    @ApiModelProperty(name = "yhzh", value = "银行账户",required = true)
    private String yhzh;

}