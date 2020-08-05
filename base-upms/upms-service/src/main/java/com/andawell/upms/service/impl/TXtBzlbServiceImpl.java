package com.andawell.upms.service.impl;

import com.andawell.upms.entity.TXtBzlb;
import com.andawell.upms.mapper.TXtBzlbMapper;
import com.andawell.upms.query.TXtBzlbQuery;
import com.andawell.upms.service.TXtBzlbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author:PCJ
 * @Date:2020/5/11
 * @Version:V1.0.0
 */
@Service
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class TXtBzlbServiceImpl implements TXtBzlbService {

    @Autowired
    private TXtBzlbMapper tXtBzlbMapper;

    @Override
    public List<TXtBzlb> list(TXtBzlbQuery query) {
        return tXtBzlbMapper.list(query);
    }
}
