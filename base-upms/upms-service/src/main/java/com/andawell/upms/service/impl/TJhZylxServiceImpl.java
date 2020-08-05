package com.andawell.upms.service.impl;

import com.andawell.upms.entity.TJhZylx;
import com.andawell.upms.mapper.TJhZylxMapper;
import com.andawell.upms.query.TJhZylxQuery;
import com.andawell.upms.service.TJhZylxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:PCJ
 * @Date:2020/5/11
 * @Version:V1.0.0
 */
@Service
public class TJhZylxServiceImpl implements TJhZylxService {

    @Autowired
    private TJhZylxMapper tJhZylxMapper;
    @Override
    public List<TJhZylx> list(TJhZylxQuery query) {
        return tJhZylxMapper.list(query);
    }
}
