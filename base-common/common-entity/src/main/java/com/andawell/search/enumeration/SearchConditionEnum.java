package com.andawell.search.enumeration;


import com.andawell.common.entity.annotation.Enum;
import com.andawell.common.entity.template.EnumTemplate;


/**
 * 角色状态
 */
@Enum("searchCondition")
public enum SearchConditionEnum implements EnumTemplate<SearchConditionEnum> {
    equal("等于"),
    notEqual("不等于"),
    greater("大于"),
    less("小于"),
    lessAndEqual("小于等于"),
    greaterAndEqual("大于等于"),
    leftLike("左匹配"),
    rightLike("右匹配"),
    like("搜索");

    private SearchConditionEnum(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String getName() {
        return name;
    }
}
