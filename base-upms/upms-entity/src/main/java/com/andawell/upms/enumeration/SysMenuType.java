package com.andawell.upms.enumeration;


import com.andawell.common.entity.annotation.Enum;
import com.andawell.common.entity.template.EnumTemplate;

@Enum("sysMenuType")
public enum SysMenuType implements EnumTemplate<SysMenuType> {
    menu("菜单"),
    button("按钮");

    private SysMenuType(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String getName() {
        return name;
    }
}
