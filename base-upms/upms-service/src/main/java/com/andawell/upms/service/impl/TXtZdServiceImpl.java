package com.andawell.upms.service.impl;

import com.andawell.common.entity.search.CountCommon;
import com.andawell.common.util.BusinessException;
import com.andawell.upms.constant.NoticeConstant;
import com.andawell.upms.entity.TXtZd;
import com.andawell.upms.entity.TXtZdfj;
import com.andawell.upms.mapper.TXtZdMapper;
import com.andawell.upms.mapper.TXtZdfjMapper;
import com.andawell.upms.query.TXtZdQuery;
import com.andawell.upms.query.TXtZdfjQuery;
import com.andawell.upms.service.TXtZdService;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 中对业务实现
 */
@Service
public class TXtZdServiceImpl implements TXtZdService {

    @Autowired
    private TXtZdMapper tXtZdMapper;

    @Autowired
    private TXtZdfjMapper tXtZdfjMapper;

    /**
     * 中队修改
     * @param tXtZd
     */
    @Override
    public void update(TXtZd tXtZd) {
        int i = tXtZdMapper.updateByPrimaryKeySelective(tXtZd);
        if (i<1) {
            throw new BusinessException(NoticeConstant.RESPONSE_NOTFOUND_MESSAGE+":"+tXtZd.toString());
        }
    }

    /**
     * 中队新增
     * @param tXtZd
     */
    @Override
    public void insert(TXtZd tXtZd) {
        String zdid = tXtZd.getZdid();
        String dwid = tXtZd.getDwid();

        tXtZd.setZdid(zdid);
        tXtZdMapper.insertSelective(tXtZd);
    }

    /**
     * 中队查询
     * @param query
     * @return
     */
    @Override
    public List<TXtZd> list(TXtZdQuery query) {
        return tXtZdMapper.list(query);
    }

    /**
     * 中队删除
     * @param query
     * @return
     */
    @Override
    public void delete(TXtZdQuery query) {
        String dwid = query.getDwid();
        String zdid = query.getZdid();
        TXtZdfjQuery tXtZdfjQuery = new TXtZdfjQuery();
        tXtZdfjQuery.setDwid(dwid);
        tXtZdfjQuery.setZdid(zdid);
        List<TXtZdfj> list = tXtZdfjMapper.list(tXtZdfjQuery);
        if (!list.isEmpty()) {
            throw new BusinessException(NoticeConstant.RESPONSE_ZDFJ_NOTNULL_MESSAGE);
        }
        int i = tXtZdMapper.deleteByPrimaryKey(dwid, zdid);
        if (i < 1) {
            throw new BusinessException(NoticeConstant.RESPONSE_NOTFOUND_MESSAGE+":"+query.toString());
        }
    }

    @Override
    public String getMaxZdid(String dwid) {
        return tXtZdMapper.getMaxZdid(dwid);
    }

}
