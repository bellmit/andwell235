package com.andawell.common.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EnumItem {
    private String name;
    private String displayName;

    public EnumItem(String name, String displayName) {
        this.name = name;
        this.displayName = displayName;
    }
}