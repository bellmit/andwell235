package com.andawell.material.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

/**
* @ClassName: TCkJsd
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月02日 上午11:29:35
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCkJsdDTO {

    /**
     * 结算单编号
     */
    @NotBlank(message = "结算单编号不能为空")
    @ApiModelProperty(value ="结算单编号",required = true)
    private String bh;

    /**
     * 单位ID
     */
    @NotBlank(message = "单位ID不能为空")
    @ApiModelProperty(value = "件号",required = true)
    private String dwid;






}