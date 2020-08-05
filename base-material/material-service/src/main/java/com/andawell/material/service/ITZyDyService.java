package com.andawell.material.service;

import com.andawell.material.entity.TZyDy;

/**
 * @author: zje
 * @date: 2020/5/20
 * @description:
 */
public interface ITZyDyService {

    void insert(TZyDy zyDy);

    void update(TZyDy zyDy);

    void delete(Integer id);

    TZyDy selectByMc(String mc);
}
