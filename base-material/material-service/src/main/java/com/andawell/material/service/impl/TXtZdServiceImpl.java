package com.andawell.material.service.impl;

import com.andawell.common.entity.search.ListCommon;
import com.andawell.material.entity.TXtZd;
import com.andawell.material.mapper.TXtZdMapper;
import com.andawell.material.query.TXtZdQuery;
import com.andawell.material.service.ITXtZdService;
import com.andawell.upms.entity.SysAccountMenu;
import com.andawell.upms.query.SysAccountMenuQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Date： 2020/5/6 13:05
 */
@Service
public class TXtZdServiceImpl implements ITXtZdService {
    @Autowired
    private TXtZdMapper tXtZdMapper;

    @Override
    public List<TXtZd> list(TXtZdQuery query) {
        return new ListCommon<TXtZdQuery, TXtZd>(query,
                (q) -> tXtZdMapper.list(q)).get();
    }
}
