package com.andawell.upms.enumeration;


import com.andawell.common.entity.annotation.Enum;
import com.andawell.common.entity.template.EnumTemplate;

@Enum("sysDoor")
public enum SysDoor implements EnumTemplate<SysDoor> {
    admin("管理员门户");

    private SysDoor(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String getName() {
        return name;
    }
}
