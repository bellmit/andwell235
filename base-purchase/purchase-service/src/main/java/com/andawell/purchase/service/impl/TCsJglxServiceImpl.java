package com.andawell.purchase.service.impl;

import com.andawell.common.entity.search.ListCommon;
import com.andawell.purchase.entity.TCsJglx;
import com.andawell.purchase.entity.TXtQclx;
import com.andawell.purchase.mapper.TCsJglxMapper;
import com.andawell.purchase.mapper.TXtQclxMapper;
import com.andawell.purchase.query.TCsJglxQuery;
import com.andawell.purchase.query.TXtQcLxQuery;
import com.andawell.purchase.service.ITCsJglxService;
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
public class TCsJglxServiceImpl implements ITCsJglxService {

    @Autowired
    TCsJglxMapper tCsJglxMapper;

    /**
     * 价格类型查询
     *
     * @param query
     */
    @Override
    public List<TCsJglx> jglxList(TCsJglxQuery query) {
        return new ListCommon<TCsJglxQuery, TCsJglx>(query, (q) -> tCsJglxMapper.list(q)).get();
    }


}
