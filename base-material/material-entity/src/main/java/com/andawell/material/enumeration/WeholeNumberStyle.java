package com.andawell.material.enumeration;/**
 * @Date： 2020/5/25 19:02
 */

import com.andawell.common.entity.annotation.Enum;
import com.andawell.common.entity.template.EnumTemplate;
import lombok.Getter;

/**
 * @Auther:liuys
 * @Date:2020/5/25 19:02
 * @Description:
 */
@Enum("weholeNumber")
public enum WeholeNumberStyle implements EnumTemplate<WeholeNumberStyle> {
    ZERO("0"),//xz 选择 0 在库里
    ONE("1"),//xz 选择 1 不在库里
    TWO("2"),
    THREE("3"),

    ELEVEN("11"),//全新
    TWELVE("12"),//可用
    TEWENTY_ONE("21"),//待修
    TEWENTY_TWO("22");//在修


    private WeholeNumberStyle(String name) {
        this.name = name;
    }

    private String name;


    @Override
    public String getName() {
        return name;
    }

}
