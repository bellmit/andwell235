package com.andawell.common.util;

import java.util.Arrays;
import java.util.List;

/**
 *
 * ArrayUtil.java
 *
 * @desc 数组操作工具
 * @author XieWei
 *
 */
public class ArrayUtil {


    /**
     * 对数组进行去重
     * @param a:已排好序的数组a
     * @return 去重后的数组
     */
    private static <T>T[] removeDuplicateListArray(T[] a){

        List<T> list= ListUtil.removeDuplicateList(Arrays.asList(a));
        return list.toArray(Arrays.copyOf(a,list.size()));
    }

    /**
     * 对两个有序数组进行求差，即a中有b中没有
     * @param a:已排好序的数组a
     * @param b:已排好序的数组b
     * @return 两个数组的差集
     */
    public static <T>T[] diffArray(T[] a,T[] b){
        List<T> list= ListUtil.diffList(Arrays.asList(a),Arrays.asList(b));
        return list.toArray(Arrays.copyOf(a,list.size()));
    }

    /**
     * 对两个有序数组求交集
     * @param a:已排好序的数组a
     * @param b:已排好序的数组b
     * @return 两个数组的差集
     */
    public static <T>T[] intersectArray(T[] a,T[] b){
        List<T> list= ListUtil.intersectList(Arrays.asList(a),Arrays.asList(b));
        return list.toArray(Arrays.copyOf(a,list.size()));
    }
    /**
     * 对两个有序数组求并集
     * @param a:已排好序的数组a
     * @param b:已排好序的数组b
     * @return 两个数组的并集
     */
    public static <T>T[] intersectionArray(T[] a,T[] b){
        List<T> list= ListUtil.unionList(Arrays.asList(a),Arrays.asList(b));
        return list.toArray(Arrays.copyOf(a,list.size()));
    }
}
