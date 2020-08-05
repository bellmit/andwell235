package com.andawell.purchase.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @ClassName: TDhLtxqTemp
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月03日 下午02:33:10
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TDhLtxqTempQuery {
    /**
     * 自增Id
     */
    @ApiModelProperty(value = "自增Id")
    private Long id;

    /**
     * 计划编号
     */
    @ApiModelProperty(value = "编号")
    private String bh;
}