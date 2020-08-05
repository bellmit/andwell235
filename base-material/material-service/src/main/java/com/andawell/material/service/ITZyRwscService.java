package com.andawell.material.service;

import com.andawell.material.entity.TZyRwsc;

/**
 * @author: zje
 * @date: 2020/5/20
 * @description:
 */
public interface ITZyRwscService {

    void insert(TZyRwsc zyRwsc);

    void update(TZyRwsc zyRwsc);

    void delete(Integer id);

    TZyRwsc selectByMc(String mc);
}
