package com.andawell.material.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @ClassName: TJhZl
* @Description: 
* @author: Mybatis Generator
* @date 2020年04月27日 下午03:31:13
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TJhZlVO {
    /**
     * 代码
     */
    @ApiModelProperty(value = "id", name = "id", dataType = "String")
    private String id;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称", name = "mc", dataType = "String")
    private String mc;

    /**
     * 简码
     */

    @ApiModelProperty(value = "简码", name = "jm", dataType = "String")
    private String jm;

    /**
     * 等级名称
     */

    @ApiModelProperty(value = "等级名称", name = "djmc", dataType = "String")
    private String djmc;

}