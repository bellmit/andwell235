package com.andawell.material.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
* @ClassName: TCkAqkc
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月02日 下午05:15:18
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCkAqkcDTO {
    @NotBlank(message = "机型不能为空")
    @ApiModelProperty(name = "jx", value = "机型不能为空", required = true)
    private String jx;

    @NotBlank(message = "件号不能为空")
    @ApiModelProperty(name = "jh", value = "件号不能为空", required = true)
    private String jh;

    /**
     * 安全库存
     */
    @ApiModelProperty(value = "安全库存")
    private Integer aqkc;

    /**
     * 过剩点
     */
    @ApiModelProperty(value = "过剩点")
    private Integer gsd;

    /**
     * 低储点
     */
    @ApiModelProperty(value = "低储点")
    private Integer dcd;


}