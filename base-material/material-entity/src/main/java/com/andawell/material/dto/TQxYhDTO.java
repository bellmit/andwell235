package com.andawell.material.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @Date： 2020/5/8 18:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TQxYhDTO {
    /**
     * 单位名称
     */
    @NotNull(message = "单位名称不能为空")
    @ApiModelProperty(name = "dw;", value = "单位名称")
    String dw;
    /**
     * 人员名称
     */
    @NotNull(message = "人员名称不能为空")
    @ApiModelProperty(name = "yhm;", value = "人员名称")
    String  yhm;
    /**
     * 登陆名称   判重
     */
    @NotNull(message = "登陆名称不能为空")
    @ApiModelProperty(name = "dlm;", value = "登陆名称")
    String  dlm;
    /**
     * 登陆密码  需要加密存储
     */
    @NotNull(message = "登陆密码不能为空")
    @ApiModelProperty(name = "dlmm", value = "登陆密码")
    String  dlmm;
    /**
     * 职务
     */
    @ApiModelProperty(name = "zw;", value = "职务")
    String zw;
}
