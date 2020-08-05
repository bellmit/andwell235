package com.andawell.material.service;

import com.andawell.material.entity.TXtZd;
import com.andawell.material.query.TXtZdQuery;

import java.util.List;

/**
 * @Date： 2020/5/6 13:05
 */
public interface ITXtZdService {
    List<TXtZd> list(TXtZdQuery tXtZdQuery);
}
