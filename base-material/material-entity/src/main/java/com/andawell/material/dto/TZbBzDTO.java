package com.andawell.material.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TZbBzDTO {

    private String dwid;

    @NotBlank(message = "机型不能为空")
    @ApiModelProperty(name = "jx",value = "机型",required = true)
    private String jx;

    @NotBlank(message = "件号不能为空")
    @ApiModelProperty(name = "jh",value = "件号",required = true)
    private String jh;

    private Long sl;


}
