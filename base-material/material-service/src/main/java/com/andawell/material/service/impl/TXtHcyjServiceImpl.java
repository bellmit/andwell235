package com.andawell.material.service.impl;

import com.andawell.material.entity.TXtHcyj;
import com.andawell.material.mapper.TXtHcyjMapper;
import com.andawell.material.service.ITXtHcyjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TXtHcyjServiceImpl implements ITXtHcyjService {

    @Autowired
    private TXtHcyjMapper tXtHcyjMapper;


    @Override
    public TXtHcyj select() {
        return  tXtHcyjMapper.select();
    }
    /***
     * @author shs
     * @Date: 2020/6/30 15:42
     * @Description:
     *  1.获得具体参数
     *  2.根据传入参数进行修改
     */
    @Override
    public void update(TXtHcyj tXtHcyj) {
        tXtHcyjMapper.update(tXtHcyj);
    }
}
