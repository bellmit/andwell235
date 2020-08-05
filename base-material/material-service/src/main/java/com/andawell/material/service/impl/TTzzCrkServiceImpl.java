package com.andawell.material.service.impl;

import com.andawell.material.entity.TTzzCrk;
import com.andawell.material.mapper.TTzzCrkMapper;
import com.andawell.material.service.TTzzCrkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:PCJ
 * @Date:2020/5/15
 * @Version:V1.0.0
 */
@Service
public class TTzzCrkServiceImpl implements TTzzCrkService {

    @Autowired
    private TTzzCrkMapper tTzzCrkMapper;

    @Override
    public void insert(TTzzCrk tTzzCrk) {
        tTzzCrkMapper.insertSelective(tTzzCrk);
    }

    @Override
    public List<String> listBh() {
        return tTzzCrkMapper.listBh();
    }

    @Override
    public String getMaxWh(String wh) {
        return tTzzCrkMapper.getMaxWh(wh);
    }
}
