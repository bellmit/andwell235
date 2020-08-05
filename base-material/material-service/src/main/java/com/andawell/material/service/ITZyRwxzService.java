package com.andawell.material.service;

import com.andawell.material.entity.TZyRwxz;

/**
 * @author: zje
 * @date: 2020/5/20
 * @description:
 */
public interface ITZyRwxzService {

    void insert(TZyRwxz zyRwxz);

    void update(TZyRwxz zyRwxz);

    void delete(Integer id);

    TZyRwxz selectByMc(String mc);
}
