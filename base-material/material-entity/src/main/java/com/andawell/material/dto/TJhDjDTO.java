package com.andawell.material.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
* @ClassName: TJhDj
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月15日 上午11:51:58
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TJhDjDTO {
    /**
     * 件号
     */
    @NotBlank(message = "实入序号不能为空")
    @ApiModelProperty(name = "jh;", value = "件号")
    private String jh;

    /**
     * 机型
     */
    @NotBlank(message = "机型不能为空")
    @ApiModelProperty(name = "jx", value = "机型")
    private String jx;

    /**
     * 单位
     */
    private String dw;

    /**
     * 名称
     */
    private String mc;

    /**
     * 资源名称
     */
    private String zylx;
}