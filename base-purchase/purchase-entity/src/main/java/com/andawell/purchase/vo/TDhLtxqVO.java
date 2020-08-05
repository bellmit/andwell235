package com.andawell.purchase.vo;

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
public class TDhLtxqVO {

    /**
     * 单位名称
     */
    @ApiModelProperty(value = "单位名称")
    private String dwmc;

    /**
     * 件号
     */
    @ApiModelProperty(value = "件号")
    private String jh;

    /**
     * 件号
     */
    @ApiModelProperty(value = "件号名称")
    private String jhmc;

    /**
     * 器材类型
     */
    @ApiModelProperty(value = "器材类型")
    private String qclx;

    /**
     * 器材类型
     */
    @ApiModelProperty(value = "计量单位")
    private String jldw;

    /**
     * 厂家
     */
    @ApiModelProperty(value = "厂家")
    private String cj;

    /**
     * 单价
     */
    @ApiModelProperty(value = "单价")
    private String dj;

    /**
     * 价格类型
     */
    @ApiModelProperty(value = "价格类型")
    private String jglx;

    /**
     * 价格依据
     */
    @ApiModelProperty(value = "价格依据")
    private String jgyj;

    /**
     * 申请数量
     */
    @ApiModelProperty(value = "申请数量")
    private Long sqsl;
}