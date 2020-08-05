package com.andawell.upms.service.impl;

import com.andawell.common.util.BusinessException;
import com.andawell.upms.constant.NoticeConstant;
import com.andawell.upms.entity.TXtJgf;
import com.andawell.upms.mapper.TXtJgfMapper;
import com.andawell.upms.service.TXtJgfService;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author:PCJ
 * @Date:2020/5/27
 * @Version:V1.0.0
 */
@Service
public class TXtJgfServiceImpl implements TXtJgfService {

    @Autowired
    private TXtJgfMapper tXtJgfMapper;

    @Override
    public void insert(TXtJgf tXtJgf) {

        String maxId=tXtJgfMapper.getMaxId();
        String id=null;
        id= StringUtils.isEmpty(maxId) ? "JG001" : "JG"+String.valueOf(Integer.valueOf(maxId)+1000+1).substring(1);
        tXtJgf.setId(id);
        tXtJgfMapper.insertSelective(tXtJgf);
    }

    @Override
    public List<String> listMc(String mc) {

        return tXtJgfMapper.listMc(mc);
    }

    @Override
    public void update(TXtJgf tXtJgf) {
        int i = tXtJgfMapper.updateByPrimaryKeySelective(tXtJgf);
        if (i < 1) {
            throw new BusinessException(NoticeConstant.RESPONSE_NOTFOUND_MESSAGE+":"+tXtJgf.toString());
        }
    }

    @Override
    public void delete(@Param("id") String id) {
        int i = tXtJgfMapper.deleteByPrimaryKey(id);
        if (i < 1) {
            throw new BusinessException(NoticeConstant.RESPONSE_NOTFOUND_MESSAGE+":"+id);
        }
    }

    @Override
    public List<TXtJgf> list() {
        return tXtJgfMapper.list();
    }
}
