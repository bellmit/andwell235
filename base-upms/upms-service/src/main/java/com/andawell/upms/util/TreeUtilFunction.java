package com.andawell.upms.util;

/***
 * @ClassName: TreeUtilFunction
 * @Description:
 * @Auther: PC
 * @Date: 2020/4/9 10:39
 * @version : V1.0
 */
@FunctionalInterface
public interface TreeUtilFunction<T> {
    public T buildTree(T t);
}
