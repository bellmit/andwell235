package com.andawell.upms.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
* @ClassName: TQxJx
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月14日 下午03:09:14
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TQxJx {
    /**
     * null
     */
    @NotBlank(message = "角色id不能为空")
    @ApiModelProperty( value = "角色id",required = true)
    private String js;

    /**
     * null
     */
    @NotBlank(message = "机型id不能为空")
    @ApiModelProperty( value = "机型id",required = true)
    private String jx;
}