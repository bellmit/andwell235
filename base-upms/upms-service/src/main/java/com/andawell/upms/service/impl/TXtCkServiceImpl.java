package com.andawell.upms.service.impl;

import com.andawell.common.util.BusinessException;
import com.andawell.upms.constant.NoticeConstant;
import com.andawell.upms.dto.TXtCkDto;
import com.andawell.upms.entity.TXtCk;
import com.andawell.upms.mapper.TXtCkMapper;
import com.andawell.upms.query.TXtCkQuery;
import com.andawell.upms.service.TXtCkService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TXtCkServiceImpl implements TXtCkService {

    @Autowired
    private TXtCkMapper tXtCkMapper;

    @Override
    public void insert(TXtCkDto tXtCkDto) {
        TXtCk tXtCk = new TXtCk();
        tXtCk.setDwid(tXtCkDto.getDwid());
        tXtCk.setCkid(tXtCkDto.getCkid());
        tXtCk.setMc(tXtCkDto.getMc());
        tXtCk.setLx(tXtCkDto.getLx());
        Integer ckid = tXtCkMapper.getMaxCkid(tXtCk.getDwid());
        if (ckid == null || ckid <= 0) {
            tXtCk.setCkid("1");
        } else {
            String ickid = String.valueOf(ckid + 1);
            tXtCk.setCkid(ickid);
        }

        tXtCkMapper.insertSelective(tXtCk);
    }

    @Override
    public void update(TXtCkDto tXtCkDto) {
        TXtCk tXtCk = new TXtCk();
        tXtCk.setDwid(tXtCkDto.getDwid());
        tXtCk.setCkid(tXtCkDto.getCkid());
        tXtCk.setMc(tXtCkDto.getMc());
        tXtCk.setLx(tXtCkDto.getLx());
        int i = tXtCkMapper.updateByPrimaryKeySelective(tXtCk);
        if (i != 1) {
            throw new BusinessException(NoticeConstant.RESPONSE_NOTFOUND_MESSAGE+":"+tXtCkDto.toString());
        }
    }

    @Override
    public List<TXtCk> list(TXtCkQuery query) {
        return tXtCkMapper.list(query);
    }

    @Override
    public void delete(TXtCkDto tXtCkDto) {
        int i = tXtCkMapper.deleteByPrimaryKey(tXtCkDto.getDwid(), tXtCkDto.getCkid());
        if (i != 1) {
            throw new BusinessException(NoticeConstant.RESPONSE_NOTFOUND_MESSAGE+":"+tXtCkDto.toString());
        }
    }

}
