package com.andawell.material.service;

import com.andawell.material.entity.TXtXljb;
import com.andawell.material.query.TXtXljbQuery;

import java.util.List;

/**
 * @Date： 2020/5/3 15:55
 */
public interface ITXtXljbService {
    //查询所有的维修类别
    List<TXtXljb> list(TXtXljbQuery query);

}
