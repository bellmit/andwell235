package com.andawell.upms.enumeration;


import com.andawell.common.entity.annotation.Enum;
import com.andawell.common.entity.template.EnumTemplate;


/**
 * 角色状态
 */
@Enum("roleStatus")
public enum RoleStatus implements EnumTemplate<RoleStatus> {
    Y("是"),
    N("否");

    private RoleStatus(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String getName() {
        return name;
    }
}
