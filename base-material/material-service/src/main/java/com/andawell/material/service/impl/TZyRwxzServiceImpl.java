package com.andawell.material.service.impl;

import com.andawell.common.util.BusinessException;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.entity.TZyRwxz;
import com.andawell.material.mapper.TZyRwxzMapper;
import com.andawell.material.service.ITZyRwxzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: zje
 * @date: 2020/5/20
 * @description:
 */

@Service
public class TZyRwxzServiceImpl implements ITZyRwxzService {

    @Autowired
    private TZyRwxzMapper zyRwxzMapper;

    @Override
    public void insert(TZyRwxz zyRwxz) {
        int maxId = 0;
        try {
            maxId = zyRwxzMapper.getMaxId();
        } catch (Exception e) {
            e.printStackTrace();
            maxId = 0;
        }
        zyRwxz.setId(maxId+1);
        zyRwxzMapper.insertSelective(zyRwxz);
    }

    @Override
    public void update(TZyRwxz zyRwxz) {
        zyRwxzMapper.updateByPrimaryKeySelective(zyRwxz);
    }

    @Override
    public void delete(Integer id) {
        zyRwxzMapper.deleteByPrimaryKey(id);
    }

    @Override
    public TZyRwxz selectByMc(String mc) {
        TZyRwxz tZyRwxz = zyRwxzMapper.selectByMc(mc);
        return tZyRwxz;
    }
}
