package com.andawell.upms.service;

import com.andawell.upms.entity.TRyZw;
import com.andawell.upms.query.TRyZwQuery;

import java.util.List;

/**
 * 职务下拉列表查询
 */
public interface TRyZwService {

    /**
     * 职务查询接口
     */
    List<TRyZw> list(TRyZwQuery query);
}
