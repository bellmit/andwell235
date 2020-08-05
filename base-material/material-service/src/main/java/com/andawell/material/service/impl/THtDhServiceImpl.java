package com.andawell.material.service.impl;

import com.andawell.common.entity.search.ListCommon;
import com.andawell.material.entity.response.THtDhBO;
import com.andawell.material.entity.THtDh;
import com.andawell.material.mapper.THtDhMapper;
import com.andawell.material.query.THtDhQuery;
import com.andawell.material.service.ITHtDhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Date： 2020/4/28 11:36
 */
@Service
public class THtDhServiceImpl implements ITHtDhService {

    @Autowired
    private THtDhMapper tHtDhMapper;

    @Override
    public List<THtDh> list(THtDhQuery query) {
        return new ListCommon<THtDhQuery, THtDh>(query,
                (q) -> tHtDhMapper.list(q)).get();
    }

    @Override
    public List<THtDhBO> getListAndCfmc(THtDhQuery query) {
        List<THtDhBO> list = tHtDhMapper.getListAndCfmc(query.getJx());
        return list;
    }
}
