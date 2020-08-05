package com.andawell.material.service.impl;

import com.andawell.common.util.BusinessException;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.entity.TTzzCk;
import com.andawell.material.entity.TTzzCkTemp;
import com.andawell.material.mapper.TTzzCkMapper;
import com.andawell.material.mapper.TTzzCkTempMapper;
import com.andawell.material.service.TTzzCkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author:PCJ
 * @Date:2020/5/15
 * @Version:V1.0.0
 */
@Service
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class TTzzCkServiceImpl implements TTzzCkService {

    @Autowired
    private TTzzCkMapper tTzzCkMapper;

    @Autowired
    private TTzzCkTempMapper tTzzCkTempMapper;

    @Override
    public void insert(TTzzCk tTzzCk) {
        tTzzCkMapper.insertSelective(tTzzCk);
    }

    @Override
    public List<String> listJhAndXh() {
        return tTzzCkMapper.listJhAndXh();
    }

    @Override
    public void update(TTzzCk tTzzCk) {
        tTzzCkMapper.updateByPrimaryKeySelective(tTzzCk);
    }

    @Override
    public String getSl(String jh, String xh) {
        return tTzzCkMapper.getSl(jh,xh);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertAll(List<String[]> list) {
        List<String> jhAndXh = listJhAndXh();
        List<TTzzCk> tTzzCkList = new ArrayList<>();
        List<TTzzCkTemp> tTzzCkTempList = new ArrayList<>();
        for (String[] rowData : list) {
            if (rowData[0]==null) {
                continue;
            }
            TTzzCk tTzzCk = new TTzzCk();
            TTzzCkTemp tTzzCkTemp = new TTzzCkTemp();
            tTzzCk.setJh(rowData[0]);
            tTzzCk.setXh(rowData[4]);
            tTzzCk.setSl(Integer.valueOf(rowData[5]));
            tTzzCk.setDj(BigDecimal.valueOf(Double.valueOf(rowData[6])));
            tTzzCk.setZj(tTzzCk.getDj().multiply(new BigDecimal(tTzzCk.getSl())));
            tTzzCk.setCcrq(new Date(rowData[7]));
            tTzzCk.setCjh(rowData[8]);
            tTzzCk.setFdjh(rowData[9]);
            tTzzCk.setBz(rowData[10]);
            tTzzCkTemp.setJh(rowData[0]);
            tTzzCkTemp.setMc(rowData[1]);
            tTzzCkTemp.setDw(rowData[2]);
            tTzzCkTemp.setWzlb(rowData[3]);
            tTzzCkTemp.setXh(rowData[4]);
            tTzzCkTemp.setSl(Integer.valueOf(rowData[5]));
            tTzzCkTemp.setDj(BigDecimal.valueOf(Double.valueOf(rowData[6])));
            tTzzCkTemp.setCcrq(new Date(rowData[7]));
            tTzzCkTemp.setCjh(rowData[8]);
            tTzzCkTemp.setFdjh(rowData[9]);
            tTzzCkTemp.setBz(rowData[10]);
            tTzzCkTempList.add(tTzzCkTemp);
            String ckJhAndXh =rowData[0]+"+"+rowData[4];
            if (jhAndXh.contains(ckJhAndXh)) {
                throw new BusinessException(NoticeConstant.RESPONSE_EXIST_ALREADY_MESSAGE+":"+tTzzCk.toString());
            }
            jhAndXh.add(ckJhAndXh);
            tTzzCkList.add(tTzzCk);
        }
        tTzzCkTempMapper.deleteAll();
        tTzzCkTempMapper.insertAll(tTzzCkTempList);
        tTzzCkMapper.insertAll(tTzzCkList);
    }

}
