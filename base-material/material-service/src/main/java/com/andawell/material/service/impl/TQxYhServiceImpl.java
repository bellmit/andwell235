package com.andawell.material.service.impl;



import com.andawell.material.mapper.TQxYhMapper;
import com.andawell.material.service.ITQxYhService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * 用户管理的增删改查 职务下拉列表查询
 *
 * @Date： 2020/5/8 14:12
 */
@Service
public class TQxYhServiceImpl implements ITQxYhService {

    @Autowired
    private TQxYhMapper tQxYhMapper;


    @Override
    public void delete(String id) {
        tQxYhMapper.deleteByPrimaryKey(id);
    }
}
