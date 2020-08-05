package com.andawell.material.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @ClassName: TCkCrkqd
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月06日 下午04:28:25
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCkCrkqdIndexQuery {

    @ApiModelProperty(value = "开始时间",required = true)
    private String startDate;

    @ApiModelProperty(value = "结束时间",required = true)
    private String endDate;

    @ApiModelProperty(value = "机型id")
    private String jx;
}