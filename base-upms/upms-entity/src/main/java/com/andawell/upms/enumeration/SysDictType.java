package com.andawell.upms.enumeration;


import com.andawell.common.entity.annotation.Enum;
import com.andawell.common.entity.template.EnumTemplate;

@Enum("sysDictType")
public enum SysDictType implements EnumTemplate<SysDictType> {
    business("系统业务类"),
    base("系统基础类");

    private SysDictType(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String getName() {
        return name;
    }
}
