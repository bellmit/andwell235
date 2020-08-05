package com.andawell.material.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

/***
 * @author hwd
 * @Date: 2020-05-27 16:51
 * @Description:上级申请
 * @version : V1.0
 */
@Data
@ApiModel("战区调拨-上级申请")
public class SuperiorApplicationDTO {

    /**
     * 机型
     */
    @NotBlank(message = "机型不能为空")
    @ApiModelProperty(value = "机型不能为空",required = true)
    private String jx;

    /**
     * 件号
     */
    @NotBlank(message = "件号不能为空")
    @ApiModelProperty(value = "件号不能为空",required = true)
    private String jh;

    /**
     * 申请单号
     */
    @NotBlank(message = "申请不能为空")
    @ApiModelProperty(value = "申请不能为空",required = true)
    private String sqdh;

    /**
     * 申请数量
     */
    @NotBlank(message = "申请数量不能为空")
    @ApiModelProperty(value = "申请数量不能为空",required = true)
    private Integer sl;




    /**
     * 接收单位/申请单位
     */
    @NotBlank(message = "接收不能为空")
    @ApiModelProperty(value = "接收单位不能为空",required = true)
    private String jsdw;


    /**
     * 申请人
     */
    @NotBlank(message = "申请人不能为空")
    @ApiModelProperty(value = "申请人不能为空",required = true)
    private String sqr;

    /**
     * 总价
     */
    @NotBlank(message = "总价不能为空")
    @ApiModelProperty(value = "总价不能为空",required = true)
    private BigDecimal zj;


    /**
     * 单位id
     */
    @ApiModelProperty(value = "单位id",required = true)
    private String dwid;

    private String sqyy;

}
