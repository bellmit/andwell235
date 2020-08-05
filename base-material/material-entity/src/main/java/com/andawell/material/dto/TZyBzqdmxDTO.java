package com.andawell.material.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/***
 * @author hwd
 * @Date: 2020-05-20 15:43
 * @Description:
 * @version : V1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TZyBzqdmxDTO
{
    /**
     * 编号
     */
    @NotNull(message = "编号不能为空")
    @ApiModelProperty(value = "编号",required = true)
    private Integer id;

    /**
     * 件号
     */
    @NotNull(message = "件号不能为空")
    @ApiModelProperty(value = "件号",required = true)
    private String jh;

    /**
     * 质量
     */
    private Integer zl;

    /**
     * 数量
     */
    private Integer sl;

    /**
     * 备注
     */
    private String bz;

}
