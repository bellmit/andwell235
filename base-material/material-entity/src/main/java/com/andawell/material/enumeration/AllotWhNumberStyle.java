package com.andawell.material.enumeration;

import com.andawell.common.entity.annotation.Enum;
import com.andawell.common.entity.template.EnumTemplate;

/***
 * @author hwd
 * @Date: 2020-05-29 16:19
 * @Description:
 * @version : V1.0
 */
@Enum("AllotWhNumber")
public enum AllotWhNumberStyle implements EnumTemplate<AllotWhNumberStyle> {
    JGDBWH("JGDB");//机关调拨文号

    private AllotWhNumberStyle(String name)
    {
        this.name = name;
    }
    private String name;

    @Override
    public String getName() {
        return name;
    }
}
