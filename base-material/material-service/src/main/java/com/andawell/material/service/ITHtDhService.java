package com.andawell.material.service;

import com.andawell.material.entity.response.THtDhBO;
import com.andawell.material.entity.THtDh;
import com.andawell.material.query.THtDhQuery;

import java.util.List;

/**
 * @Date： 2020/4/28 11:36
 */
public interface ITHtDhService {
    //根据机型查询结果
    List<THtDh> list(THtDhQuery query);

    List<THtDhBO> getListAndCfmc(THtDhQuery query);
}
