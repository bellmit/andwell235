package com.andawell.upms.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Date： 2020/5/8 18:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TQxYhDto {

    /**
     * 用户身份id
     */
    @ApiModelProperty(name = "id;", value = "用户身份id")
    String id;

    /**
     * 单位id
     */
    @NotBlank(message = "单位名称不能为空")
    @ApiModelProperty(name = "dw;", value = "单位id",required = true)
    String dw;
    /**
     * 人员名称
     */
    @NotBlank(message = "人员名称不能为空")
    @ApiModelProperty(name = "yhm;", value = "人员名称",required = true)
    String  yhm;
    /**
     * 登陆名称   判重
     */
    @NotBlank(message = "登陆名称不能为空")
    @ApiModelProperty(name = "dlm;", value = "登陆名称",required = true)
    String  dlm;
    /**
     * 登陆密码  需要加密存储
     */
    @ApiModelProperty(name = "dlmm", value = "登陆密码",required = true)
    String  dlmm;
    /**
     * 职务
     */
    @ApiModelProperty(name = "zw;", value = "职务")
    String zw;

    /**
     * 审批权限标记，一旦被标记，表示有航材请领出库的审批权限。
     */
    @ApiModelProperty(name = "spqx;", value = "审批权限")
    String spqx;
}
