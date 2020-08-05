package com.andawell.purchase.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
* @ClassName: TDhLtxq
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月01日 下午04:31:43
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TDhLtxqQuery {
    /**
     * 计划编号(JH-BH-06011457256)
     */
    @ApiModelProperty(value = "编号",required = true)
    private String bh;

    /**
     * 有效目录编号
     */
    private String mlbh;
    
    /**
     * 机型
     */
    @ApiModelProperty(value = "机型",required = true)
    private String jx;

    /**
     * 件号
     */
    @ApiModelProperty(value = "jh",required = true)
    private String jh;

}