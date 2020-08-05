package com.andawell.material.service.impl;

import com.andawell.common.util.BusinessException;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.entity.TDbDblx;
import com.andawell.material.mapper.TDbDblxMapper;
import com.andawell.material.service.ITDbDblxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: zje
 * @date: 2020/5/20
 * @description:调拨类型管理
 */

@Service
public class TDbDblxServiceImpl implements ITDbDblxService {

    @Autowired
    private TDbDblxMapper tDbDblxMapper;

    @Override
    public void insert(TDbDblx tDbDblx) {
        int id = 0;
        try {
            String maxId = tDbDblxMapper.getMaxId();
            id = Integer.parseInt(maxId)+1;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            id = 1;
        }
        tDbDblx.setId(String.valueOf(id));
        tDbDblxMapper.insertSelective(tDbDblx);
    }

    @Override
    public void update(TDbDblx tDbDblx) {
        tDbDblxMapper.updateByPrimaryKeySelective(tDbDblx);
    }

    @Override
    public void delete(String id) {
        tDbDblxMapper.deleteByPrimaryKey(id);
    }

    @Override
    public TDbDblx selectByMc(String mc) {
        return tDbDblxMapper.selectByMc(mc);
    }
}
