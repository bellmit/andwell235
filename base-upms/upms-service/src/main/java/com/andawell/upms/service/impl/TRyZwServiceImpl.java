package com.andawell.upms.service.impl;


import com.andawell.common.entity.search.ListCommon;
import com.andawell.upms.entity.TRyZw;
import com.andawell.upms.mapper.TRyZwMapper;
import com.andawell.upms.query.TRyZwQuery;
import com.andawell.upms.service.TRyZwService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 职务下拉列表查询
 *
 * @Date： 2020/5/8 14:12
 */
@Service
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class TRyZwServiceImpl implements TRyZwService {

    @Autowired
    private TRyZwMapper tRyZwMapper;

    /**
     * 职务查询
     */
    @Override
    public List<TRyZw> list(TRyZwQuery query) {
        return new ListCommon<TRyZwQuery, TRyZw>(query,
                (q) -> tRyZwMapper.list(q)).get();
    }



}
