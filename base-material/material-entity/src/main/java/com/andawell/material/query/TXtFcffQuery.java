package com.andawell.material.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/***
 * @author hwd
 * @Date: 2020-05-12 14:28
 * @Description:
 * @version : V1.0
 */
@Data
@Accessors(chain = true)
@ApiModel("封存方法视图")
@NoArgsConstructor
@AllArgsConstructor
public class TXtFcffQuery {
    @NotBlank(message = "类别不能为空")
    @ApiParam(value = "类别", name = "lb")
    private Integer lb;
}
