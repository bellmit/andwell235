package com.andawell.material.service.impl;

import com.andawell.common.entity.search.ListPageCommon;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.material.entity.TDbSjsq;
import com.andawell.material.mapper.TDbJgdbMapper;
import com.andawell.material.mapper.TDbSjsqMapper;
import com.andawell.material.query.TDbJgdbQuery;
import com.andawell.material.service.ITDbSjsqService;
import com.andawell.material.vo.TDbSjsqVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author: zje
 * @date: 2020/6/1
 * @description:
 */

@Service
public class TDbSjsqServiceImpl implements ITDbSjsqService {

    @Autowired
    private TDbJgdbMapper tDbJgdbMapper;

    @Autowired
    private TDbSjsqMapper tDbSjsqMapper;

    @Override
    public ListPageVo<TDbJgdbQuery,TDbSjsqVO> list(TDbJgdbQuery query) {
        DateFormat bf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        List<TDbSjsqVO> jgdbList = tDbJgdbMapper.getJGDBList(query);
        jgdbList.stream().forEach(jgdb -> {
            TDbSjsq tDbSjsq = tDbSjsqMapper.selectByPrimaryKey(jgdb.getSqdh());
            jgdb.setRq((bf.format(tDbSjsq.getRq())));
        });
        return new ListPageCommon<TDbJgdbQuery, TDbSjsqVO>(query,
                (q) -> jgdbList).getVo();
    }

    @Override
    public void update(String sqdh) {
        TDbSjsq tDbSjsq = tDbSjsqMapper.selectByPrimaryKey(sqdh);
        tDbSjsq.setClzt("1");
        tDbSjsqMapper.updateByPrimaryKeySelective(tDbSjsq);
    }

}
