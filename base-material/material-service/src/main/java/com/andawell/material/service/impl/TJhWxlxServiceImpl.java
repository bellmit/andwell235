package com.andawell.material.service.impl;

import com.andawell.common.util.BusinessException;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.entity.TJhWxlx;
import com.andawell.material.mapper.TJhWxlxMapper;
import com.andawell.material.service.TJhWxlxService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author:PCJ
 * @Date:2020/5/21
 * @Version:V1.0.0
 */
@Service
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class TJhWxlxServiceImpl implements TJhWxlxService {

    @Autowired
    private TJhWxlxMapper tJhWxlxMapper;

    @Override
    public void delete(String id) {
        int i = tJhWxlxMapper.deleteByPrimaryKey(id);
        if (i < 1) {
            throw new BusinessException(NoticeConstant.RESPONSE_NOTFOUND_MESSAGE);
        }
    }

    @Override
    public void update(TJhWxlx tJhWxlx) {
        TJhWxlx tJhWxlx1=tJhWxlxMapper.getByMc(tJhWxlx.getMc());
        if (tJhWxlx1!=null && !tJhWxlx.getId().equals(tJhWxlx1.getId())) {
            throw new BusinessException(NoticeConstant.RESPONSE_NAME_EXIST_MESSAGE);
        }
        int i = tJhWxlxMapper.updateByPrimaryKeySelective(tJhWxlx);
        if (i < 1) {
            throw new BusinessException(NoticeConstant.RESPONSE_NOTFOUND_MESSAGE);
        }
    }

    @Override
    public void insert(TJhWxlx tJhWxlx) {
        TJhWxlx tJhWxlx1=tJhWxlxMapper.getByMc(tJhWxlx.getMc());
        if (tJhWxlx1!=null) {
            throw new BusinessException(NoticeConstant.RESPONSE_NAME_EXIST_MESSAGE);
        }
        String maxId=tJhWxlxMapper.getMaxId();
        if (StringUtils.isEmpty(maxId)) {
            tJhWxlx.setId("1");
        } else {
            tJhWxlx.setId(String.valueOf(Integer.valueOf(maxId)+1));
        }
        tJhWxlxMapper.insertSelective(tJhWxlx);
    }
}
