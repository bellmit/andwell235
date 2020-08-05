package com.andawell.material.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *@Auther:shs
 *@Date:2020/7/7 17:19
 *@Description:
 */
@Data
@ApiModel("报废库存统计")
public class BfKcVO {
    /**
     * 机型
     */
    @ApiModelProperty(name = "jx", value = "机型", dataType = "String")
    private String jx;

    /**
     * 机型名称
     */
    @ApiModelProperty(name = "jxmc", value = "机型名称", dataType = "String")
    private String jxmc;

    /**
     * 器材名称
     */
    @ApiModelProperty(name = "jhmc", value = "器材名称", dataType = "String")
    private String jhmc;

    /**
     * 器材型号
     */
    @ApiModelProperty(name = "jh", value = "器材型号", dataType = "String")
    private String jh;

    /**
     * 质量（全新可用）
     */
    @ApiModelProperty(name = "zl", value = "质量（全新可用）", dataType = "String")
    private String zl;


    /**
     * 总数
     */
    @ApiModelProperty(name = "zs", value = "总数", dataType = "String")
    private String zs;

    /**
     * 所属战区
     */
    @ApiModelProperty(name = "sszq", value = "所属战区", dataType = "String")
    private String sszq;

    /**
     * 数量
     */
    @ApiModelProperty(name = "sl", value = "数量", dataType = "String")
    private Integer sl;
    /**
     * 战区dwid
     * */
    private String dwid;

}
