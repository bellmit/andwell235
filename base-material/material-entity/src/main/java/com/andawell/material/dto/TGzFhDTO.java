package com.andawell.material.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TGzFhDTO {
    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    private String id;

    /**
     * 机型
     */
    @ApiModelProperty(value = "机型")
    private String jx;

    /**
     * 重量
     */
    @ApiModelProperty(value = "重量")
    private String zl;


    /**
     * 收货单位
     */
    @ApiModelProperty(value = "收货单位")
    private String shdw;

    /**
     * 发货人
     */
    @ApiModelProperty(value = "发货人")
    private String fhr;


    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String bz;

    /**
     * 运输方式
     */
    @ApiModelProperty(value = "运输方式")
    private Integer ysfs;


    /**
     * 发货日期
     */
    @ApiModelProperty(value = "发货日期")
    private Date fhrq;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private Integer zt;

    /**
     * 箱数
     */
    @ApiModelProperty(value = "箱数")
    private Integer xs;

    /**
     * 出库文号
     */
    @ApiModelProperty(value = "出库文号")
    private String ckwh;

    /**
     * 出库编号
     */
    @ApiModelProperty(value = "出库编号")
    private String bh;

    /**
     * 编号集合
     */
    @ApiModelProperty(value = "编号集合")
    private List<String> rulelds;
}
