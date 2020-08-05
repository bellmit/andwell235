package com.andawell.purchase.service.impl;

import com.andawell.common.entity.search.ListCommon;
import com.andawell.purchase.entity.TXtQclx;
import com.andawell.purchase.mapper.TXtQclxMapper;
import com.andawell.purchase.query.TXtQcLxQuery;
import com.andawell.purchase.service.ITXtQclxService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Author:gzh
 * @Date:2020/5/29
 * @Version:V1.0.0
 */
@Service
public class TXtQclxServiceImpl implements ITXtQclxService {


    @Autowired
    private TXtQclxMapper tXtQclxMapper;

    /**
     * 器材类型查询
     */
    @Override
    public List<TXtQclx> qclxList(TXtQcLxQuery query) {
        return new ListCommon<TXtQcLxQuery, TXtQclx>(query, (q) -> tXtQclxMapper.list(q)).get();
    }
}
