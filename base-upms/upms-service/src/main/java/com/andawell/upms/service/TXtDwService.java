package com.andawell.upms.service;

import com.andawell.common.entity.vo.ListPageVo;

import com.andawell.upms.entity.TXtDw;
import com.andawell.upms.query.TXtDwQuery;


import java.util.List;


public interface TXtDwService {

    /**
     * 新增单位
     * @param tXtDw
     */
    void insert(TXtDw tXtDw);

    /**
     * 编辑单位
     * @param tXtDw
     */
    void update(TXtDw tXtDw);

    /**
     * 不分页查询
     * @param query
     * @return
     */
    List<TXtDw> list(TXtDwQuery query);

    /**
     * 单位详情查询
     * @param id
     * @return
     */
    TXtDw getDetail(String id);

    /**
     * 分页查询
     * @param query
     * @return
     */
    ListPageVo<TXtDwQuery, TXtDw> listPage(TXtDwQuery query);

    /**
     * 获取pid下最大id值
     * @param id
     * @return
     */
    String getMaxByPid(String id);

    /**
     * 删除单位
     * @param id
     */
    void deleteById(String id);

    /**
     * 获取长度为2的最大id
     * @return
     */
    String getMax2LengthId();

}
