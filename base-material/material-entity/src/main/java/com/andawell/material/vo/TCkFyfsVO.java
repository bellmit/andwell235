package com.andawell.material.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @ClassName: TCkFyfs
* @Description: 
* @author: Mybatis Generator
* @date 2020年04月27日 下午03:20:26
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCkFyfsVO {

    /**
     * id
     */
    @ApiModelProperty(value = "id", name = "id", dataType = "String")
    private String id;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称", name = "mc", dataType = "String")
    private String mc;

    /**
     * 简写
     */

    /**
     * 名称
     */
    @ApiModelProperty(value = "简写", name = "jm", dataType = "String")
    private String jm;
}