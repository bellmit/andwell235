package com.andawell.purchase.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
* @ClassName: THtFk
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月01日 下午04:30:05
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("机关合同下发旅团")
public class THtXfDTO {
    /**
     * 合同号
     */
    @NotBlank(message = "合同号不能为空")
    @ApiModelProperty(value = "合同号",required = true)
    private String hth;

    /**
     * 计划编号
     */
    @NotBlank(message = "计划编号不能为空")
    @ApiModelProperty(value = "计划编号",required = true)
    private String jhbh;







}