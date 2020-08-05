package com.andawell.common.util;

import java.util.*;

/**
 * List集合工具类
 *
 * @author: wangsh
 */
public class ListUtil {

    /**
     * 两个集合的交集
     * @param a:集合a
     * @param b:集合b
     * @return 两个列表的交集
     */
    @SuppressWarnings("unchecked")
    public static <E> List<E> intersectList(List<E> a, List<E> b) {
        List<E> list = new ArrayList<E>((Collection<? extends E>) Arrays.asList(new Object[a.size()]));
        Collections.copy(list, a);
        list.retainAll(b);
        return list;
    }

    /**
     * 对两个列表进行求差，即a中有b中没有
     * @param a:列表a
     * @param b:列表b
     * @return 两个集合的差集
     */
    @SuppressWarnings("unchecked")
    public static <E> List<E> diffList(List<E> a, List<E> b) {
        List<E> list = new ArrayList<E>((Collection<? extends E>) Arrays.asList(new Object[a.size()]));
        Collections.copy(list, a);
        list.removeAll(b);
        return list;
    }

    /**
     * 两个集合的交集
     * @param a:集合a
     * @param b:集合b
     * @return 两个列表的并集
     */
    @SuppressWarnings("unchecked")
    public static <E> List<E> unionList(List<E> a, List<E> b) {
        List<E> list = new ArrayList<E>((Collection<? extends E>) Arrays.asList(new Object[a.size()]));
        Collections.copy(list, a);// 将ls的值拷贝一份到list中
        list.removeAll(b);
        list.addAll(b);
        return list;
    }

    /**
     *
     * @param list  待去重list
     * @return   去重后的list
     */
    public static  <E> List<E> removeDuplicateList(List list) {
        List noRepeatList = new ArrayList<>();
        // 去重
        list.stream().forEach(
                p -> {
                    if (!noRepeatList.contains(p)) {
                        noRepeatList.add(p);
                    }
                }
        );
        return noRepeatList;
    }
}
