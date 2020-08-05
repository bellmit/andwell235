package com.andawell.material.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

/***
 * @author hwd
 * @Date: 2020-05-12 14:47
 * @Description:油封数据确认DTO
 * @version : V1.0
 */
@Data
@ApiModel("油封数据确认")
public class YFDataAffirmDTO
{
    @NotBlank(message = "编号不能为空")
    @ApiModelProperty(value = "编号不能为空",required = true)
    private String bh;

    @NotBlank(message = "单位id不能为空")
    @ApiModelProperty(value = "编号不能为空",required = true)
    private String dwid;

    @NotBlank(message = "机型不能为空")
    @ApiModelProperty(value = "编号不能为空",required = true)
    private String jx;

    @NotBlank(message = "机号不能为空")
    @ApiModelProperty(value = "编号不能为空",required = true)
    private String jh;

    @NotBlank(message = "序号不能为空")
    @ApiModelProperty(value = "编号不能为空",required = true)
    private String xh;

    @NotBlank(message = "质量不能为空")
    @ApiModelProperty(value = "编号不能为空",required = true)
    private String zl;

    private String xz ="0";

    private String bz;



}
