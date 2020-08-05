package com.andawell.material.util;


public class StringTabaleName {

    public static String ChangeName(String name) {
        String[] s = name.split("_");
        StringBuilder builder = new StringBuilder();
        for (String ss : s) {
            builder.append(ss.substring(0, 1).toUpperCase()).append(ss.substring(1).toLowerCase());
        }
        return builder.toString()+"Mapper";
    }
    public static String BeanName(String name) {
        String[] s = name.split("_");
        StringBuilder builder = new StringBuilder();
        for (String ss : s) {
            builder.append(ss.substring(0, 1).toUpperCase()).append(ss.substring(1).toLowerCase());
        }
        return builder.toString();
    }

}
