package com.andawell.material.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
* @ClassName: TJhDj
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月15日 上午11:51:58
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TJhDTO {
    /**
     * 件号
     */
    @ApiModelProperty(name = "id;", value = "件号")
    private String id;

    /**
     * 机型
     */
    @ApiModelProperty(name = "jx", value = "机型")
    private String jx;

    /**
     * 器材名称
     */
    private String mc;

}