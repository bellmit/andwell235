package com.andawell.upms.service.impl;

import com.andawell.common.entity.search.ListPageCommon;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.common.util.BusinessException;
import com.andawell.upms.constant.NoticeConstant;
import com.andawell.upms.dto.TXtDwDto;
import com.andawell.upms.entity.TXtDw;
import com.andawell.upms.mapper.TXtDwMapper;
import com.andawell.upms.query.TXtDwQuery;
import com.andawell.upms.service.TXtDwService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class TXtDwServiceImpl implements TXtDwService {

    @Autowired
    private TXtDwMapper tXtDwMapper;

    /**
     * 分页查询
     *
     * @param query
     * @return
     */
    @Override
    public ListPageVo<TXtDwQuery, TXtDw> listPage(TXtDwQuery query) {
        return new ListPageCommon<TXtDwQuery, TXtDw>(query, (q) -> tXtDwMapper.list(q)).getVo();
    }

    @Override
    public String getMaxByPid(String id) {
        return tXtDwMapper.getMaxByPid(id);
    }

    @Override
    public void deleteById(String id) {
        int i = tXtDwMapper.deleteByPrimaryKey(id);
        if (i < 1) {
            throw new BusinessException(NoticeConstant.RESPONSE_NOTFOUND_MESSAGE+":"+id);
        }
    }

    @Override
    public String getMax2LengthId() {
        return tXtDwMapper.getMax2LengthId();
    }

    /**
     * 新增单位
     *
     * @param tXtDw
     */
    @Override
    public void insert(TXtDw tXtDw) {
        tXtDwMapper.insertSelective(tXtDw);
    }

    /**
     * 单位编辑
     *
     * @param tXtDw
     */
    @Override
    public void update(TXtDw tXtDw) {
        int i = tXtDwMapper.updateByPrimaryKeySelective(tXtDw);
        if (i < 1) {
            throw new BusinessException(NoticeConstant.RESPONSE_NOTFOUND_MESSAGE+":"+tXtDw.toString());
        }
    }


    /**
     * 单位全量查询
     *
     * @param query
     * @return
     */
    @Override
    public List<TXtDw> list(TXtDwQuery query) {
        return tXtDwMapper.list(query);
    }

    /**
     * 单位详情查询
     * @param id
     * @return
     */
    @Override
    public TXtDw getDetail(String id) {
        return tXtDwMapper.selectByPrimaryKey(id);
    }

}
