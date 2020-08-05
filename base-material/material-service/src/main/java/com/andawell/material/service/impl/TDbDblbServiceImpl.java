package com.andawell.material.service.impl;

import com.andawell.common.entity.search.ListCommon;
import com.andawell.material.entity.TDbDblb;
import com.andawell.material.mapper.TDbDblbMapper;
import com.andawell.material.query.TDbDblbQuery;
import com.andawell.material.service.ITDbDblbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: zje
 * @date: 2020/6/5
 * @description:
 */

@Service
public class TDbDblbServiceImpl implements ITDbDblbService {

    @Autowired
    private TDbDblbMapper tDbDblbMapper;

    @Override
    public List<TDbDblb> list(TDbDblbQuery query) {
        return new ListCommon<TDbDblbQuery, TDbDblb>(query,
                (q) -> tDbDblbMapper.list(q)).get();
    }
}
