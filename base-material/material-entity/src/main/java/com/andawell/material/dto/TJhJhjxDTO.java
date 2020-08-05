package com.andawell.material.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * @Date： 2020/5/22 18:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TJhJhjxDTO {
    /**
     * 机型
     */
    @NotNull(message = "机型代码不能为空")
    @ApiModelProperty(name = "jx;", value = "机型代码",required = true)
    private List<String> jx;

    /**
     * 件号
     */
    @NotBlank(message = "件号代码不能为空")
    @ApiModelProperty(name = "jh;", value = "机型代码",required = true)
    private String jh;



}
