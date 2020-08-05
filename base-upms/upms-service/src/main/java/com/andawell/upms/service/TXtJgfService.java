package com.andawell.upms.service;

import com.andawell.upms.entity.TXtJgf;

import java.util.List;

public interface TXtJgfService {

    /**
     * 新增监管方
     * @param tXtJgf
     */
    void insert(TXtJgf tXtJgf);

    /**
     * 监管方名称查询
     * @param mc
     * @return
     */
    List<String> listMc(String mc);

    /**
     * 监管方编辑
     * @param tXtJgf
     */
    void update(TXtJgf tXtJgf);

    /**
     * 监管方删除
     * @param id
     */
    void delete(String id);

    /**
     * 下拉列表
     * @return
     */
    List<TXtJgf> list();

}
