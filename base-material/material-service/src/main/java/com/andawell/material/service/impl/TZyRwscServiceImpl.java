package com.andawell.material.service.impl;

import com.andawell.common.util.BusinessException;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.entity.TZyRwsc;
import com.andawell.material.mapper.TZyRwscMapper;
import com.andawell.material.service.ITZyRwscService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: zje
 * @date: 2020/5/20
 * @description:
 */

@Service
public class TZyRwscServiceImpl implements ITZyRwscService {

    @Autowired
    private TZyRwscMapper zyRwscMapper;

    @Override
    public void insert(TZyRwsc zyRwsc) {
        int maxId = 0;
        try {
            maxId = zyRwscMapper.getMaxId();
        } catch (Exception e) {
            e.printStackTrace();
            maxId = 0;
        }
        zyRwsc.setId(maxId+1);
        zyRwscMapper.insertSelective(zyRwsc);
    }

    @Override
    public void update(TZyRwsc zyRwsc) {
        zyRwscMapper.updateByPrimaryKeySelective(zyRwsc);
    }

    @Override
    public void delete(Integer id) {
        zyRwscMapper.deleteByPrimaryKey(id);
    }

    @Override
    public TZyRwsc selectByMc(String mc) {
        TZyRwsc tZyRwsc = zyRwscMapper.selectByMc(mc);
        return tZyRwsc;
    }
}
