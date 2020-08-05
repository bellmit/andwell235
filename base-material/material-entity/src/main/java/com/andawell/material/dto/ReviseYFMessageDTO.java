package com.andawell.material.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

/***
 * @author hwd
 * @Date: 2020-05-18 18:15
 * @Description:修改油封信息
 * @version : V1.0
 */
@Data
@ApiModel("库存-油封信息修改")
public class ReviseYFMessageDTO {

    /**
     * 单位ID
     */
    @NotBlank(message = "单位Id不能为空")
    @ApiModelProperty(value = "单位id",required = true)
    private String dwid;

    /**
     * 机型
     */
    @NotBlank(message = "机型不能为空")
    @ApiModelProperty(value = "机型",required = true)
    private String jx;

    /**
     * 件号
     */
    @NotBlank(message = "件号不能为空")
    @ApiModelProperty(value = "件号",required = true)
    private String jh;

    /**
     * 序号
     */
    @NotBlank(message = "序号不能为空")
    @ApiModelProperty(value = "序号",required = true)
    private String xh;

    /**
     * 质量
     */
    @NotBlank(message = "质量不能为空")
    @ApiModelProperty(value = "质量",required = true)
    private String zl;

    @ApiModelProperty(value = "油封期限",required = true)
    private Date  yfrq;


    @ApiModelProperty(value = "油封期限",required = true)
    private BigDecimal yfqx;
}
