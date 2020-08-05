package com.andawell.search.enumeration;


import com.andawell.common.entity.annotation.Enum;
import com.andawell.common.entity.template.EnumTemplate;


/**
 * 角色状态
 */
@Enum("fieldTypeEnum")
public enum FieldTypeEnum implements EnumTemplate<FieldTypeEnum> {
    date("日期"),
    string("字符串"),
    integer("数字"),
    dateString("日期字符串");

    private FieldTypeEnum(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String getName() {
        return name;
    }
}
