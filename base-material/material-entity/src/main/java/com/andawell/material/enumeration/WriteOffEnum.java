package com.andawell.material.enumeration;

import com.andawell.common.entity.annotation.Enum;
import com.andawell.common.entity.template.EnumTemplate;

/***
 * @author lhb
 * @Date: 2020/5/19 16:26
 * @Description:
 * @version : V1.0
 */
@Enum("writeOffEnum")
public enum WriteOffEnum implements EnumTemplate<WriteOffEnum> {

    NOT_REVERSED("0"),
    REVERSED("1"),
    WRITE_OFF_RECORD("-1");

    private WriteOffEnum(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String getName() {
        return name;
    }
}
