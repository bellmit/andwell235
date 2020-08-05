package com.andawell.material.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @Date： 2020/4/29 10:59
 */
@Data
@ApiModel("合同入库信息")
public class ContractInfoDTO {
    /**
     * 合同编号不能为空
     */
    @NotBlank(message = "合同编号不能为空")
    @ApiModelProperty(name = "htbh;", value = "合同编号")
    private String htbh;

    @Valid
    private LibraryInfoDTO libraryInfoDTO;
}
