package com.andawell.material.service;

import com.andawell.material.entity.TSxLb;
import com.andawell.material.query.TSxLbQuery;

import java.util.List;

/**
 * @author: zje
 * @date: 2020/5/9
 * @description:
 */
public interface ITSxLbService {

    /**
     *@Auther:zje
     *@Date:2020/5/8
     *@Description:查询送修类别列表
     *@Param:
     *@return:
     */
    List<TSxLb> list(TSxLbQuery query);
}
