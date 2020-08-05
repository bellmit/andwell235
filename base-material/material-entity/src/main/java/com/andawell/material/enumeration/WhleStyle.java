package com.andawell.material.enumeration;

import com.andawell.common.entity.annotation.Enum;
import com.andawell.common.entity.template.EnumTemplate;

/**
 * @Date： 2020/5/15 15:15
 */
@Enum("whleStyle")
public enum WhleStyle implements EnumTemplate<WhleStyle> {
    ff("FF"),
    ts("TS"),
    zb("ZB");

    private WhleStyle(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String getName() {
        return name;
    }
}
