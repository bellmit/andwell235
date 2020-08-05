package com.andawell.material.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/***
 * @author lhb
 * @Date: 2020/5/20 11:32
 * @Description:
 * @version : V1.0
 */
@ApiModel("合同冲销")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContractWriteOffDto extends WriteOffDTO {

    /**
     * 合同编号不能为空
     */
    @NotBlank(message = "合同编号不能为空")
    @ApiModelProperty(value = "合同编号",required = true)
    private String htbh;

}
