package com.andawell.material.service;

import com.andawell.material.entity.TCfLb;

import java.util.List;

public interface TCfLbService {

    void delete(String id);

    /**
     * 编辑厂方类别
     * @param tCfLb
     */
    void update(TCfLb tCfLb);

    /**
     * 新增本级
     * @param tCfLb
     */
    void insertBj(TCfLb tCfLb);

    /**
     * 新增子级
     * @param tCfLb
     */
    void insertZj(TCfLb tCfLb);

    /**
     * 下拉列表
     * @return
     */
    List<TCfLb> list();
}
