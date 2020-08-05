package com.andawell.upms.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
* @ClassName: TQxCk
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月14日 上午11:10:44
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TQxCk {
    /**
     * null
     */
    @NotBlank(message = "角色id不能为空")
    @ApiModelProperty( value = "角色id",required = true)
    private String js;

    /**
     * null
     */
    @NotBlank(message = "单位id不能为空")
    @ApiModelProperty(value = "单位id",required = true)
    private String dwid;

    /**
     * null
     */
    @NotBlank(message = "仓库id不能为空")
    @ApiModelProperty(value = "仓库id",required = true)
    private String ckid;
}