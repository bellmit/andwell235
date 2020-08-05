package com.andawell.gateway.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CaptchaCacheMap {
    private static Logger logger = LoggerFactory.getLogger(CaptchaCacheMap.class);
    private static Map<Object, Map<String,Object>> cache = new ConcurrentHashMap<Object, Map<String,Object>>();
    private CaptchaCacheMap() {
        super();
    }

    public static void put(Object key, Map<String,Object> value) {
        cache.put(key, value);
    }
    public static void removeOnly(String key) {
        cache.remove(key);
    }
    public synchronized static boolean hasCache(String key) {
        return cache.containsKey(key);
    }
    public synchronized static Map<String,Object> getSimpleCaptcha(String key) {
        return cache.get(key);
    }
}
