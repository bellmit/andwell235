package com.andawell.material.service.impl;

import com.andawell.material.entity.TTzzWzlb;
import com.andawell.material.mapper.TTzzWzlbMapper;
import com.andawell.material.query.TTzzWzlbQuery;
import com.andawell.material.service.TTzzWzlbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:PCJ
 * @Date:2020/5/15
 * @Version:V1.0.0
 */
@Service
public class TTzzWzlbServiceImpl implements TTzzWzlbService {

    @Autowired
    private TTzzWzlbMapper tTzzWzlbMapper;

    @Override
    public List<TTzzWzlb> list(TTzzWzlbQuery query) {
        return tTzzWzlbMapper.list(query);
    }
}
