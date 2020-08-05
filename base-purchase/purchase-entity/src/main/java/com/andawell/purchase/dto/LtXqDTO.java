package com.andawell.purchase.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/***
 * @author lhb
 * @Date: 2020/6/3 15:08
 * @Description:
 * @version : V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LtXqDTO {

    /**
     * 计划编号(JH-BH-06011457256)
     */
    @NotBlank(message = "计划编号不为NULL")
    @ApiModelProperty(value = "计划编号",required = true)
    private String bh;

    /**
     * 单位Id
     */
    // @NotBlank(message = "单位Id不为NULL")
    @ApiModelProperty(value = "单位Id",required = true)
    private String dwid;

    /**
     * 机型
     */
    @NotBlank(message = "机型不为NULL")
    @ApiModelProperty(value = "机型",required = true)
    private String jx;

    /**
     * 器材类型名称
     */
    @NotBlank(message = "器材类型名称")
    @ApiModelProperty(value = "器材类型名称",required = true)
    private String qclxmc;

    /**
     * 件号
     */
    @NotBlank(message = "件号不为NULL")
    @ApiModelProperty(value = "机型",required = true)
    private String jh;

    /**
     * 申请数量
     */
    @NotNull(message = "申请数量不为NULL")
    @ApiModelProperty(value = "申请数量",required = true)
    private Long sqsl;

}
