package com.andawell.common.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class EnumData {
    private Map<String, String> map;
    private List<EnumItem> list;

    public EnumData(Map<String, String> map, List<EnumItem> list) {
        this.map = map;
        this.list = list;
    }
}