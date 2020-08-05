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
@ApiModel("航材收货明细")
public class HcShMxVO {
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
     * 序号
     */
    @ApiModelProperty(name = "zl", value = "序号", dataType = "String")
    private String xh;

    /**
     * 质量
     */
    @ApiModelProperty(name = "zl", value = "质量", dataType = "String")
    private String zl;


    /**
     * 计量单位
     */
    @ApiModelProperty(name = "jldw", value = "计量单位", dataType = "String")
    private String jldw;

    /**
     * 厂家
     */
    @ApiModelProperty(name = "cj", value = "厂家", dataType = "String")
    private String cj;

    /**
     * 监管单位
     */
    @ApiModelProperty(name = "jgdw", value = "监管单位", dataType = "String")
    private String jgdw;

    /**
     * 价格依据
     */
    @ApiModelProperty(name = "jgyj", value = "价格依据", dataType = "String")
    private String jgyj;

    /**
     * 价格类型
     */
    @ApiModelProperty(name = "jglx", value = "价格类型", dataType = "String")
    private String jglx;

    /**
     * 到寿日期
     */
    @ApiModelProperty(name = "dsrq", value = "到寿日期", dataType = "String")
    private String dsrq;

    /**
     * 所属战区
     */
    @ApiModelProperty(name = "sszq", value = "所属战区", dataType = "String")
    private String sszq;
    /**
     * 所属战区dwid
     * */
    private String dwid;

    /**
     * 入库日期
     */
    @ApiModelProperty(name = "rkrq", value = "入库日期", dataType = "String")
    private String rkrq;




}
