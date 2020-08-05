package com.andawell.material.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/***
 * @author hwd
 * @Date: 2020-06-02 09:44
 * @Description:修改战区调拨
 * @version : V1.0
 */
@Data
@ApiModel("手动修改战区调拨状态")
public class ReviseZqdbDTO {
    /**
     * 调拨单号
     */
    @NotBlank(message = "调拨单号不能为空")
    @ApiModelProperty(value = "调拨单号",required = true)
    private String dbdh;


    /**
     * 处理状态
     */
    private String clzt ="1";


}
