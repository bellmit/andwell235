package com.andawell.common.entity.template;

public interface EnumTemplate<T extends Enum<T>> {
    public String name();

    public String getName();
}