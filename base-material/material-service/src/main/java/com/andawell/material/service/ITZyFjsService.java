package com.andawell.material.service;

import com.andawell.material.entity.TZyFjs;

/**
 * @author: zje
 * @date: 2020/5/20
 * @description:
 */
public interface ITZyFjsService {

    void insert(TZyFjs zyFjs);

    void update(TZyFjs zyFjs);

    void delete(Integer id);

    TZyFjs selectByMc(String mc);
}
