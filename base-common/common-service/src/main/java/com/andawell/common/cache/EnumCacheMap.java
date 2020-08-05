package com.andawell.common.cache;

import com.andawell.common.entity.EnumData;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EnumCacheMap {
    private static Map<String, EnumData> cache = new ConcurrentHashMap<String, EnumData>();

    public static void put(String key, EnumData value) {
        cache.put(key, value);
    }

    public static EnumData get(String key) {
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        return null;
    }

    public static boolean containsKey(String key) {
        return cache.containsKey(key);
    }

    public static void clear() {
        cache.clear();
    }
}