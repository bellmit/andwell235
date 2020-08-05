package com.andawell.common.util;

import java.util.UUID;

/**
 * UUID工具类
 */
public class UUIDUtil {
    /**
     * 生成UUID字符串
     */
    public static String create() {
        return UUID.randomUUID().toString();
    }

    /**
     * 生成随机6为数字
     * @return
     */
    public static int randomCode() {
        return (int) ((Math.random() * 9 + 1) * 100000);
    }
}
