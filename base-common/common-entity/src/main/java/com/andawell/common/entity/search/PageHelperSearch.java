package com.andawell.common.entity.search;

import java.util.List;

/**
 * 函数式接口
 * @param <Q>
 * @param <T>
 */
@FunctionalInterface
public interface PageHelperSearch<Q, T> {
    public List<T> search(Q query);
}
