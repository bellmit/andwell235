package com.andawell.material.service;

import com.andawell.material.entity.TJhZylx;
import com.andawell.material.entity.response.TCkCkBO;
import com.andawell.material.query.TJhZylxQuery;

import java.util.List;

/**
 * @Date： 2020/5/11 14:51
 */
public interface ITJhZylxService {
    List<TJhZylx> list(TJhZylxQuery query);
}
