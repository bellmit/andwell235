package com.andawell.material.service;


import com.andawell.material.entity.TRyZw;
import com.andawell.material.query.listzwQuery;

import java.util.List;

/**
 * 职务下拉列表查询
 */
public interface ITRyZwService {

    /**
     * 职务查询接口
     */
    List<TRyZw> list(listzwQuery query);

    void insertOne(TRyZw ryZw);

    void update(TRyZw ryZw);

    void delete(String id);

    void insertTwo(TRyZw ryZw);

    TRyZw selectByMc(String mc);

    List<TRyZw> listTwoZw(String id);
}
