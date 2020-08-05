package com.andawell.search.service.impl;

import com.andawell.search.entity.XmlSearchMain;
import com.andawell.search.mapper.XmlSearchMainMapper;
import com.andawell.search.query.XmlSearchMainQuery;
import com.andawell.search.service.XmlSearchMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XmlSearchMainServiceImpl implements XmlSearchMainService {
    @Autowired
    private XmlSearchMainMapper xmlSearchMainMapper;

    @Override
    public List<XmlSearchMain> list(XmlSearchMainQuery query) {
        return xmlSearchMainMapper.list(query);
    }
}
