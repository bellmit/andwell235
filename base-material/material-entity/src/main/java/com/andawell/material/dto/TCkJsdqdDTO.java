package com.andawell.material.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
* @ClassName: TCkJsdqd
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月03日 上午09:33:53
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCkJsdqdDTO {

    /**
     * 结算单编号
     */
    @NotBlank(message = "结算单编号不能为空")
    @ApiModelProperty(value ="结算单编号",required = true)
    private String bh;

    /**
     * 机型
     */
    @NotBlank(message = "机型不能为空")
    @ApiModelProperty(value = "机型", required = true)
    private String jx;

    /**
     * 件号
     */
    @NotBlank(message = "件号不能为空")
    @ApiModelProperty(value = "件号", required = true)
    private String jh;

    /**
     * 序号(批次号)
     */
    @NotBlank(message = "序号(批次号)不能为空")
    @ApiModelProperty(value = "序号(批次号)", required = true)
    private String xh;

    /**
     * 红冲标示
     */
    @NotBlank(message = "红冲标示不能为空")
    @ApiModelProperty(value = "红冲标示", required = true)
    private String cxsgin;

    /**
     * 单位ID
     */
    @NotBlank(message = "单位ID不能为空")
    @ApiModelProperty(value = "单位ID", required = true)
    private String dwid;

    /**
     * 选择
     */
    @NotBlank(message = "选择不能为空")
    @ApiModelProperty(value = "选择", required = true)
    private String xz;


    /**
     * 单价
     */
    @NotNull(message = "单价不能为空")
    @ApiModelProperty(value = "单价", required = true)
    private BigDecimal dj;


}