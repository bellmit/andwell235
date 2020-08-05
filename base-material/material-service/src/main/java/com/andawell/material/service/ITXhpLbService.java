package com.andawell.material.service;

import com.andawell.material.entity.TXhpLb;
import com.andawell.material.query.TXhpLbQuery;

import java.util.List;

public interface ITXhpLbService {
    /**
     *@Auther:gzh
     *@Date:2020/5/15 15:20
     *@Description: 五金类别查询接口
     *@Param:
     *@return:
     */
    List<TXhpLb> list(TXhpLbQuery query);
}
