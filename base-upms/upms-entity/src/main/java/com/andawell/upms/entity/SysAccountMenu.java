package com.andawell.upms.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author DCY
 */
@Data
@ApiModel("账户菜单列表")
public class SysAccountMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(name = "accountId", value = "账户ID", dataType = "String")
    /**
     * 账户ID
     */
    private String accountId;
    /**
     * 菜单ID
     */
    @ApiModelProperty(name = "menuId", value = "菜单ID", dataType = "String")
    private String menuId;

    @ApiModelProperty(name = "checkedAttr", value = "选择状态", dataType = "String")
    private String checkedAttr;
}
