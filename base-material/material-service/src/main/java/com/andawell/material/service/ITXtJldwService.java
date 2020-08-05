package com.andawell.material.service;

import com.andawell.material.entity.TXtJldw;
import com.andawell.material.query.TXtJldwQuery;

import java.util.List;

public interface ITXtJldwService {

    /**
     *@Auther:zje
     *@Date:2020/5/8
     *@Description:查询计量单位列表
     *@Param:
     *@return:
     */
    List<TXtJldw> list(TXtJldwQuery query);

    void insert(TXtJldw xtJldw);

    void update(TXtJldw xtJldw);

    void delete(String id);

    TXtJldw selectByMc(String mc);
}
