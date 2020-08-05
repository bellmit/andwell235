package com.andawell.common.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * JSON工具类
 */
public class JsonUtil {
    private static Gson gson = new Gson();

    /**
     * 对象转json字符串
     *
     * @param object
     * @return
     */
    public static String toJson(Object object) {
        return gson.toJson(object);
    }

    /**
     * json字符串转对象
     *
     * @param json
     * @param clazz
     * @return
     */
    public static <T> T parse(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

    /**
     * json字符串转对象List
     *
     * @param json
     * @param clazz
     * @return
     */
    public static <T> List<T> parseList(String json, Class<T> clazz) {
        return gson.fromJson(json, new TypeToken<List<T>>() {
        }.getType());
    }
}
