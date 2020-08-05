package com.andawell.material.service.impl;

import com.andawell.common.util.BusinessException;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.entity.TXtBzlb;
import com.andawell.material.mapper.TXtBzlbMapper;
import com.andawell.material.service.ITXtBzlbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: zje
 * @date: 2020/5/20
 * @description:
 */

@Service
public class TXtBzlbServiceImpl implements ITXtBzlbService {

    @Autowired
    private TXtBzlbMapper bzlbMapper;

    @Override
    public void insert(TXtBzlb xtBzlb) {
        int id = 0;
        try {
            String maxId = bzlbMapper.getMaxId();
            id = Integer.parseInt(maxId)+1;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            id = 1;
        }
        xtBzlb.setId(String.valueOf(id));
        bzlbMapper.insertSelective(xtBzlb);
    }

    @Override
    public void update(TXtBzlb xtBzlb) {
        bzlbMapper.updateByPrimaryKeySelective(xtBzlb);
    }

    @Override
    public void delete(String id) {
        bzlbMapper.deleteByPrimaryKey(id);
    }

    @Override
    public TXtBzlb selectByMc(String mc) {
        return bzlbMapper.selectByMc(mc);
    }
}
