package com.andawell.material.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/***
 * @author hwd
 * @Date: 2020-06-05 14:00
 * @Description:下发
 * @version : V1.0
 */
@ApiModel("战区下发")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeliverDTO {

    /**
     * 申请单号
     */
    @NotBlank(message = "申请单号不能为空")
    @ApiModelProperty(value = "申请单号",required = true)
    private String ltsqdh;


}
