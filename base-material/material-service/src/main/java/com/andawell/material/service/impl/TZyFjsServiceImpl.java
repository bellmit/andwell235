package com.andawell.material.service.impl;

import com.andawell.common.util.BusinessException;
import com.andawell.common.util.SysUserUtils;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.entity.TZyFjs;
import com.andawell.material.mapper.TZyFjsMapper;
import com.andawell.material.service.ITZyFjsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: zje
 * @date: 2020/5/20
 * @description:
 */
@Service
public class TZyFjsServiceImpl implements ITZyFjsService {

    @Autowired
    private TZyFjsMapper zyFjsMapper;

    @Override
    public void insert(TZyFjs zyFjs) {
        int maxId = 0;
        try {
            maxId = zyFjsMapper.getMaxId();
        } catch (Exception e) {
            e.printStackTrace();
            maxId = 0;
        }
        zyFjs.setId(maxId+1);

        zyFjsMapper.insertSelective(zyFjs);
    }

    @Override
    public void update(TZyFjs zyFjs) {
        zyFjsMapper.updateByPrimaryKeySelective(zyFjs);
    }

    @Override
    public void delete(Integer id) {
        zyFjsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public TZyFjs selectByMc(String mc) {
        TZyFjs tZyFjs = zyFjsMapper.selectByMc(mc);
        return tZyFjs;
    }
}
