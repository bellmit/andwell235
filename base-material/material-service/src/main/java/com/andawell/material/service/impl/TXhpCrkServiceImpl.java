package com.andawell.material.service.impl;

import com.andawell.common.entity.search.ListCommon;
import com.andawell.material.entity.TCkCrklb;
import com.andawell.material.entity.TXhpCrk;
import com.andawell.material.mapper.TXhpCrkMapper;
import com.andawell.material.mapper.TXhpCrkqdMapper;
import com.andawell.material.query.TXhpCrkQuery;
import com.andawell.material.service.ITXhpCrkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class TXhpCrkServiceImpl implements ITXhpCrkService {



    @Autowired
    TXhpCrkMapper tXhpCrkMapper;

    @Autowired
    TXhpCrkqdMapper tXhpCrkqdMapper;

    /***
     * @author gzh
     * @Date: 2020/4/28 14:36
     * @Description: 来源单位查询
     */
    @Override
    public List<TXhpCrk> lydwList(TXhpCrkQuery query) {
        List<TXhpCrk> tXhpCrks = new ListCommon<TXhpCrkQuery, TXhpCrk>(query, (q) -> tXhpCrkMapper.lydwList(q)).get();
        return new ListCommon<TXhpCrkQuery,TXhpCrk>(query,(q)->tXhpCrkMapper.lydwList(q)).get();
    }
    /**
     *@Auther:gzh
     *@Date:2020/5/25 14:16
     *@Description: 查询批次号
     */
    @Override
    public TXhpCrk pch() {
        TXhpCrk tXhpCrk = new TXhpCrk();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
       String date = df.format(new Date());
        try {
            Integer maxPch =  tXhpCrkMapper.selectPch(date)+1;
            tXhpCrk.setPch(String.valueOf(maxPch));
            return tXhpCrk;
        } catch (Exception e) {
            tXhpCrk.setPch(String.valueOf(date+"01"));
            return tXhpCrk;
        }


    }
    /**
     *@Auther:gzh
     *@Date:2020/5/26 8:33
     *@Description: 入库文号
     * 根据数据库最大文号切割最后四位+1
     */
    @Override
    public TXhpCrk wh(String jm) {
        DecimalFormat decimalFormat = new DecimalFormat("0000");
        //获取当前年度
        Calendar date = Calendar.getInstance();
        String year = String.valueOf(date.get(Calendar.YEAR));
        //获取最大文号并封装
        String Maxwh = tXhpCrkqdMapper.maxWh(jm);
        int maxWh = Integer.parseInt(Maxwh.substring(Maxwh.length() - 4, Maxwh.length()))+1;  //文号四位流水
        TXhpCrk tXhpCrk = new TXhpCrk();
        tXhpCrk.setWh(jm+year+decimalFormat.format(maxWh));
        return tXhpCrk;
    }
}
