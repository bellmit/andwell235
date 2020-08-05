package com.andawell.material.service.impl;

import com.andawell.material.entity.TTzzCrkqd;
import com.andawell.material.mapper.TTzzCrkqdMapper;
import com.andawell.material.service.TTzzCrkqdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author:PCJ
 * @Date:2020/5/15
 * @Version:V1.0.0
 */
@Service
public class TTzzCrkqdServiceImpl implements TTzzCrkqdService {

    @Autowired
    private TTzzCrkqdMapper tTzzCrkqdMapper;

    @Override
    public void insert(TTzzCrkqd tTzzCrkqd) {
        tTzzCrkqdMapper.insertSelective(tTzzCrkqd);
    }

    @Override
    public List<String> listBhAndJhAndXh() {
        return tTzzCrkqdMapper.listBhAndJhAndXh();
    }

    @Override
    public String getMaxBh(String bh) {
        return tTzzCrkqdMapper.getMaxBh(bh);
    }

}
