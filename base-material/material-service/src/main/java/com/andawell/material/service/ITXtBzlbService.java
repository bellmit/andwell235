package com.andawell.material.service;

import com.andawell.material.entity.TXtBzlb;

/**
 * @author: zje
 * @date: 2020/5/20
 * @description:
 */
public interface ITXtBzlbService {

    void insert(TXtBzlb xtBzlb);

    void update(TXtBzlb xtBzlb);

    void delete(String id);

    TXtBzlb selectByMc(String mc);
}
