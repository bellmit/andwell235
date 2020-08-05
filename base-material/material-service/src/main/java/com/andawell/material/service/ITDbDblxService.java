package com.andawell.material.service;

import com.andawell.material.entity.TDbDblx;

/**
 * @author: zje
 * @date: 2020/5/20
 * @description:
 */
public interface ITDbDblxService {

    void insert(TDbDblx tDbDblx);

    void update(TDbDblx tDbDblx);

    void delete(String id);

    TDbDblx selectByMc(String mc);
}
