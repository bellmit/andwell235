package com.andawell.material.service.impl;

import com.andawell.common.entity.search.ListCommon;
import com.andawell.material.entity.TSxLb;
import com.andawell.material.entity.TXtJldw;
import com.andawell.material.mapper.TSxLbMapper;
import com.andawell.material.query.TSxLbQuery;
import com.andawell.material.query.TXtJldwQuery;
import com.andawell.material.service.ITSxLbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: NXX012
 * @date: 2020/5/9
 * @description:
 */
@Service
public class TSxLbServiceImpl implements ITSxLbService {

    @Autowired
    private TSxLbMapper sxLbMapper;


    @Override
    public List<TSxLb> list(TSxLbQuery query) {
        return new ListCommon<TSxLbQuery, TSxLb>(query,
                (q) -> sxLbMapper.getList(q)).get();
    }
}
