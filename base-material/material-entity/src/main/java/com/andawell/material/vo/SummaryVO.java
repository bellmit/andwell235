package com.andawell.material.vo;/**
 * @Date： 2020/7/7 10:56
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *@Auther:liuys
 *@Date:2020/7/7 10:56
 *@Description:
 */
@Data
@ApiModel("综合查询")
public class SummaryVO {

    /**
     *机型
     */
    @ApiModelProperty(value = "机型", name = "jx", dataType = "String")
    private String jx;

    /**
     *件号
     */
    @ApiModelProperty(value = "件号", name = "jh", dataType = "String")
    private String jh;

    /**
     *件号名称
     */
    @ApiModelProperty(value = "件号名称", name = "jhmc", dataType = "String")
    private String jhmc;

    /**
     *质量
     */
    @ApiModelProperty(value = "质量", name = "zl", dataType = "String")
    private String zl;

    /**
     *总价
     */
    @ApiModelProperty(value = "总价", name = "zj", dataType = "String")
    private String zj;

    /**
     *所属战区
     */
    @ApiModelProperty(value = "所属战区", name = "dwmc", dataType = "String")
    private String dwmc;

    /**
     *数量
     */
    @ApiModelProperty(value = "数量", name = "sl", dataType = "String")
    private String sl;
}
