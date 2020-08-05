package com.andawell.material.service.impl;

import com.andawell.common.entity.search.ListCommon;
import com.andawell.common.util.BusinessException;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.entity.TJhZylx;
import com.andawell.material.entity.TXtJldw;
import com.andawell.material.mapper.TXtJldwMapper;
import com.andawell.material.query.TJhZylxQuery;
import com.andawell.material.query.TXtJldwQuery;
import com.andawell.material.service.ITXtJldwService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class TXtJldwServiceImpl implements ITXtJldwService {

    @Autowired
    TXtJldwMapper tXtJldwMapper;
    /**
     *@Auther:zje
     *@Date:2020/5/8
     *@Description:查询计量单位列表
     *@Param:
     *@return:
     */
    @Override
    public List<TXtJldw> list(TXtJldwQuery query) {
        return new ListCommon<TXtJldwQuery, TXtJldw>(query,
                (q) -> tXtJldwMapper.getList(q)).get();
    }

    @Override
    public void insert(TXtJldw xtJldw) {
        int id = 0;
        try {
            String maxId = tXtJldwMapper.getMaxId();
            id = Integer.parseInt(maxId)+1;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            id = 1;
        }
        xtJldw.setId(String.valueOf(id));
        tXtJldwMapper.insertSelective(xtJldw);
    }

    @Override
    public void update(TXtJldw xtJldw) {
        tXtJldwMapper.updateByPrimaryKeySelective(xtJldw);
    }

    @Override
    public void delete(String id) {
        tXtJldwMapper.deleteByPrimaryKey(id);
    }

    @Override
    public TXtJldw selectByMc(String mc) {
        return tXtJldwMapper.selectByMc(mc);
    }
}
