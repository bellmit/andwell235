package com.andawell.purchase.vo;

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
public class TDhLtxqTempVO {
    /**
     * 自增Id
     */
    @ApiModelProperty(value = "自增Id")
    private Long id;

    /**
     * 部门
     */
    @ApiModelProperty(value = "部门")
    private String bm;

    /**
     * 机型名称
     */
    @ApiModelProperty(value = "机型名称")
    private String jxmc;

    /**
     * 机型名称
     */
    @ApiModelProperty(value = "机型")
    private String jx;

    /**
     * 器材名称
     */
    @ApiModelProperty(value = "器材名称")
    private String qcmc;

    /**
     * 器材型号
     */
    @ApiModelProperty(value = "器材型号")
    private String qcxh;

    /**
     * 器材类型名称
     */
    @ApiModelProperty(value = "器材类型名称")
    private String qclxmc;

    /**
     * 器材型号
     */
    @ApiModelProperty(value = "件号")
    private String jh;

    /**
     * 单位
     */
    @ApiModelProperty(value = "单位")
    private String dw;

    /**
     * 单位
     */
    @ApiModelProperty(value = "单位Id")
    private String dwid;

    /**
     * 申请数量
     */
    @ApiModelProperty(value = "申请数量")
    private Integer sqsl;

    /**
     * 计划编号
     */
    @ApiModelProperty(value = "计划编号")
    private String bh;
}