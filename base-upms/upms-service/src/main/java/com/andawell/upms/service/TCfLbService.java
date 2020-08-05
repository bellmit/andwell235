package com.andawell.upms.service;

import com.andawell.upms.entity.TCfLb;
import com.andawell.upms.query.TCfLbQuery;

import java.util.List;

public interface TCfLbService {
    /**
     * 承制方类别查询
     * @param query
     * @return
     */
    List<TCfLb> listCzlb(TCfLbQuery query);

    /**
     * 承修方类别
     * @param query
     * @return
     */
    List<TCfLb> listCxlb(TCfLbQuery query);
}
