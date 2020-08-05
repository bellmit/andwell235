package com.andawell.upms.service.impl;

import com.andawell.upms.entity.TCfLb;
import com.andawell.upms.mapper.TCfLbMapper;
import com.andawell.upms.query.TCfLbQuery;
import com.andawell.upms.query.TCfQuery;
import com.andawell.upms.service.TCfLbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:PCJ
 * @Date:2020/5/11
 * @Version:V1.0.0
 */
@Service

public class TCfLbServiceImpl implements TCfLbService {

    @Autowired
    private TCfLbMapper tCfLbMapper;
    @Override
    public List<TCfLb> listCzlb(TCfLbQuery query) {
        return tCfLbMapper.listCzlb(query);
    }

    @Override
    public List<TCfLb> listCxlb(TCfLbQuery query) {
        return tCfLbMapper.listCxlb(query);
    }
}
