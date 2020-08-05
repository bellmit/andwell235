package com.andawell.material.service.impl;

import com.andawell.material.entity.TTzzCkTemp;
import com.andawell.material.mapper.TTzzCkTempMapper;
import com.andawell.material.service.TTzzCkTempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author:PCJ
 * @Date:2020/5/14
 * @Version:V1.0.0
 */
@Service
public class TTzzCkTempServiceImpl implements TTzzCkTempService {

    @Autowired
    private TTzzCkTempMapper tTzzCkTempMapper;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertAll(List<TTzzCkTemp> tTzzCkTempList) {
        tTzzCkTempMapper.deleteAll();
        tTzzCkTempMapper.insertAll(tTzzCkTempList);
    }
}
