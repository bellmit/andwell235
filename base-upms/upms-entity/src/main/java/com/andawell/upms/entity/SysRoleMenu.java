package com.andawell.upms.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
@ApiModel("角色菜单列表")
public class SysRoleMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(name = "roleId", value = "角色ID", dataType = "String")
    /**
     * 角色ID
     */
    private String roleId;
    /**
     * 菜单ID
     */
    @ApiModelProperty(name = "menuId", value = "菜单ID", dataType = "String")
    private String menuId;

    @ApiModelProperty(name = "checkedAttr", value = "选择状态", dataType = "String")
    private String checkedAttr;
}
