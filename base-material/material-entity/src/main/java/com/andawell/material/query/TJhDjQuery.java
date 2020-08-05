package com.andawell.material.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

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
public class TJhDjQuery {
    /**
     * 件号
     */
    @ApiModelProperty(name = "jh", value = "件号", dataType = "String")
    private String jh;
    /**
     * 机型
     */
    @ApiModelProperty(name = "jx", value = "机型", dataType = "String")
    private String jx;


    /**
     * 件号名称
     */
    @ApiModelProperty(name = "mc", value = "件号名称", dataType = "String")
    private String mc;

}