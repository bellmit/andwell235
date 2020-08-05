package com.andawell.material.service;


import com.andawell.material.entity.TXtHclb;
import com.andawell.material.query.TXtHclbQuery;

import java.util.List;

/**
 * 统计类别的增删改查
 * @Date： 2020/4/26 18:31
 */
public interface ITXtHclbService {
    List<TXtHclb> list(TXtHclbQuery query);
}
