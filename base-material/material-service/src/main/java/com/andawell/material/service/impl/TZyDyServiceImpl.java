package com.andawell.material.service.impl;

import com.andawell.common.util.BusinessException;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.entity.TZyDy;
import com.andawell.material.mapper.TZyDyMapper;
import com.andawell.material.service.ITZyDyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: zje
 * @date: 2020/5/20
 * @description:
 */

@Service
public class TZyDyServiceImpl implements ITZyDyService {

    @Autowired
    private TZyDyMapper zyDyMapper;

    @Override
    public void insert(TZyDy zyDy) {
        int maxId = 0;
        try {
            maxId = zyDyMapper.getMaxId();
        } catch (Exception e) {
            e.printStackTrace();
            maxId = 0;
        }
        zyDy.setId(maxId+1);
        zyDyMapper.insertSelective(zyDy);
    }

    @Override
    public void update(TZyDy zyDy) {
        zyDyMapper.updateByPrimaryKeySelective(zyDy);
    }

    @Override
    public void delete(Integer id) {
        zyDyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public TZyDy selectByMc(String mc) {
        return zyDyMapper.selectByMc(mc);
    }
}
