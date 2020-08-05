package com.andawell.material.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/***
 * @author lhb
 * @Date: 2020/5/19 16:03
 * @Description:
 * @version : V1.0
 */
@ApiModel("冲销实体")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WriteOffDTO {

    @ApiModelProperty(value = "编号",required = true)
    @NotBlank(message = "编号不为空")
    private String bh;

    @NotBlank(message = "机型不为空")
    @ApiModelProperty(value = "机型",required = true)
    private String jx;

    @NotBlank(message = "件号不为空")
    @ApiModelProperty(value = "件号",required = true)
    private String jh;

    @NotBlank(message = "序号不为空")
    @ApiModelProperty(value = "序号",required = true)
    private String xh;

    @NotBlank(message = "红冲标识不为空")
    @ApiModelProperty(value = "红冲标识",required = true)
    private String cxsgin;

    @NotBlank(message = "单位Id不为空")
    @ApiModelProperty(value = "单位Id",required = true)
    private String dwid;

    @NotBlank(message = "选择不为空")
    @ApiModelProperty(value = "选择",required = true)
    private String xz;

    @NotBlank(message = "类别Id")
    @ApiModelProperty(value = "类别Id",required = true)
    private String lb;

    @NotBlank(message = "质量Id")
    @ApiModelProperty(value = "质量Id",required = true)
    private String zl;

    @NotNull(message = "数量")
    @ApiModelProperty(value = "数量",required = true)
    private Long sl;


    @ApiModelProperty(value = "接收单位")
    private String jsdw;

    @ApiModelProperty(value = "发付单位")
    private String ffdw;

    @NotNull(message = "出入库类别 true 出库 ，false 入库 不能为空")
    @ApiModelProperty(value = "出入库类别 true 出库 ，false 入库",required = true)
    private Boolean crk;
}
