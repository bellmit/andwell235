package com.andawell.material.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/***
 * @author lhb
 * @Date: 2020/4/30 13:24
 * @Description:
 * @version : V1.0
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
public class SystemNumberQuery {

    @ApiModelProperty(name = "lb", value = "出入库类别简码")
    @NotBlank(message = "出入库类别简码不能为NULL")
    private String lb;

    @ApiModelProperty(name = "dwid", value = "单位Id")
    @NotBlank(message = "单位Id不能为空自己的单位Id")
    private String dwid;

}
