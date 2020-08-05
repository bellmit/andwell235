package com.andawell.purchase.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

/**
* @ClassName: TCkCrk
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月12日 上午10:07:29
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCkCrkXfDTO {
    /**
     * 编号
     */
    @NotBlank(message = "编号不能为空")
    @ApiModelProperty(value = "编号",required = true)
    private String bh;

    /**
     * 单位ID
     */
    @NotBlank(message = "单位ID不能为空")
    @ApiModelProperty(value = "单位ID",required = true)
    private String dwid;

    /**
     * 合同号
     */
    @NotBlank(message = "合同号不能为空")
    @ApiModelProperty(value = "合同号",required = true)
    private String yj;


}