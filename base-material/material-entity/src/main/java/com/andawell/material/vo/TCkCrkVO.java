package com.andawell.material.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
* @ClassName: TCkCrk
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月06日 下午04:28:25
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCkCrkVO {

    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    private String bh;

    /**
     * 单位ID
     */
    @ApiModelProperty(value = "单位ID")
    private String dwid;

    /**
     * 依据
     */
    @ApiModelProperty(value = "依据")
    private String yj;

    /**
     * 文号
     */
    @ApiModelProperty(value = "文号")
    private String wh;


    /**
     * 飞机类型
     */
    @ApiModelProperty(value = "机型")
    private String fjlx;

    /**
     * 飞机机号
     */
    @ApiModelProperty(value = "飞机号")
    private String fjjh;

    /**
     * 发票号
     */
    @ApiModelProperty(value = "发票号")
    private String fph;

    /**
     * 发付单位
     */
    @ApiModelProperty("发付单位")
    private String ffmc;

    /**
     * 入库单位
     */
    @ApiModelProperty("入库单位")
    private String jsmc;
}