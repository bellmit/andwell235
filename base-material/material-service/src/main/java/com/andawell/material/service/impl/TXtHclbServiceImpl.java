package com.andawell.material.service.impl;

import com.andawell.common.entity.search.ListCommon;
import com.andawell.material.entity.TXtHclb;
import com.andawell.material.entity.TXtZd;
import com.andawell.material.mapper.TXtHclbMapper;
import com.andawell.material.query.TXtHclbQuery;
import com.andawell.material.query.TXtZdQuery;
import com.andawell.material.service.ITXtHclbService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Date： 2020/4/26 18:36
 */
@Service
public class TXtHclbServiceImpl implements ITXtHclbService {

    @Autowired
    private TXtHclbMapper tXtHclbMapper;

    @Override
    public List<TXtHclb> list(TXtHclbQuery query) {
        return new ListCommon<TXtHclbQuery, TXtHclb>(query,
                (q) -> tXtHclbMapper.list(q)).get();
    }
}
