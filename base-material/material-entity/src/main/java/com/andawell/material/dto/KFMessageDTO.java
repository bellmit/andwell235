package com.andawell.material.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/***
 * @author hwd
 * @Date: 2020-05-15 18:17
 * @Description:
 * @version : V1.0
 */
@Data
@ApiModel("库房信息修改")
public class KFMessageDTO {

    /**
     * 文号
     */
    @ApiModelProperty(value = "文号")
    private String wh;

    /**
     * 根据文号
     */
    @ApiModelProperty(value = "根据文号")
    private String yj;

    /**
     * 编号
     */
    @NotBlank(message = "编号不能为空")
    @ApiModelProperty(value = "编号",required = true)
    private String bh;

    /**
     * 单位id
     */
    @NotBlank(message = "单位id不能为空")
    @ApiModelProperty(value = "单位id",required = true)
    private String dwid;

    /**
     * 承运单位
     */
    @ApiModelProperty(value = "承运单位")
    private String cydw;

    /**
     * 货运单号
     */
    @ApiModelProperty(value = "货运单号")
    private String hydh;

    /**
     * 装备编号
     */
    @ApiModelProperty(value = "装备编号")
    private String zbbh;


}
