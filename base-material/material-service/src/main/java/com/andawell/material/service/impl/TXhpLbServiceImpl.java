package com.andawell.material.service.impl;

import com.andawell.common.entity.search.ListCommon;
import com.andawell.material.entity.TXhpCrk;
import com.andawell.material.entity.TXhpLb;
import com.andawell.material.mapper.TXhpLbMapper;
import com.andawell.material.query.TXhpCrkQuery;
import com.andawell.material.query.TXhpLbQuery;
import com.andawell.material.service.ITXhpLbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class TXhpLbServiceImpl implements ITXhpLbService {

    @Autowired
    private TXhpLbMapper tXhpLbMapper;

    @Override
    public List<TXhpLb> list(TXhpLbQuery query) {

        return new ListCommon<TXhpLbQuery, TXhpLb>(query,(q)->tXhpLbMapper.list(q)).get();

    }
}
