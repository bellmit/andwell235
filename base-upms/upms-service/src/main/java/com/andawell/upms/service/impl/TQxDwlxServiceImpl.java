package com.andawell.upms.service.impl;

import com.andawell.upms.entity.TQxDwlx;
import com.andawell.upms.mapper.TQxDwlxMapper;
import com.andawell.upms.query.TQxDwlxQuery;
import com.andawell.upms.service.TQxDwlxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TQxDwlxServiceImpl implements TQxDwlxService {

    @Autowired
    private TQxDwlxMapper tQxDwlxMapper;
    @Override
    public TQxDwlx getDetail(String id) {
        return tQxDwlxMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TQxDwlx> list(TQxDwlxQuery query) {
        return tQxDwlxMapper.list(query);
    }


}
