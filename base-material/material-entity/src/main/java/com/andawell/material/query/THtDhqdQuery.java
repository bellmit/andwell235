package com.andawell.material.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * @Date： 2020/5/8 10:42
 */
@Data
@Accessors(chain = true)
@ApiModel("合同清单")
@NoArgsConstructor
public class THtDhqdQuery {

    /**
     * 合同编号
     */
    @NotBlank(message = "合同编号不能为空")
    @NonNull
    @ApiModelProperty(name = "htbh", value = "合同编号", dataType = "String")
    private String htbh;

    @ApiModelProperty(name = "htbh", value = "合同编号", dataType = "String")
    private String jx;

    @ApiModelProperty(name = "htbh", value = "合同编号", dataType = "String")
    private String jh;
}
