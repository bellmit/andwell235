package com.andawell.material.service.impl;

import com.andawell.common.entity.search.ListCommon;
import com.andawell.material.entity.TXtXljb;
import com.andawell.material.entity.TXtZd;
import com.andawell.material.mapper.TXtXljbMapper;
import com.andawell.material.query.TXtXljbQuery;
import com.andawell.material.query.TXtZdQuery;
import com.andawell.material.service.ITXtXljbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Date： 2020/5/3 15:55
 */
@Service
public class TXtXljbServiceImpl implements ITXtXljbService {

    @Autowired
    private TXtXljbMapper tXtXljbMapper;


    @Override
    public List<TXtXljb> list(TXtXljbQuery query) {
        return new ListCommon<TXtXljbQuery, TXtXljb>(query,
                (q) -> tXtXljbMapper.list(q)).get();
    }
}
