package com.andawell.material.service.impl;

import com.andawell.common.util.BusinessException;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.entity.TJhJxlx;
import com.andawell.material.mapper.TJhJxlxMapper;
import com.andawell.material.service.TJhJxlxService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author:PCJ
 * @Date:2020/5/20
 * @Version:V1.0.0
 */
@Service
public class TJhJxlxServiceImpl implements TJhJxlxService {

    @Autowired
    private TJhJxlxMapper tJhJxlxMapper;

    @Override
    public void insert(TJhJxlx tJhJxlx) {
        TJhJxlx tJhJxlx1=tJhJxlxMapper.getByMc(tJhJxlx.getMc());
        if (tJhJxlx1!=null) {
            throw new BusinessException(NoticeConstant.RESPONSE_NAME_EXIST_MESSAGE);
        }
        String maxId=tJhJxlxMapper.getMaxId();
        if (StringUtils.isEmpty(maxId)) {
            tJhJxlx.setId("1");
        } else {
            tJhJxlx.setId(String.valueOf(Integer.valueOf(maxId)+1));
        }
        tJhJxlxMapper.insertSelective(tJhJxlx);
    }

    @Override
    public void update(TJhJxlx tJhJxlx) {
        TJhJxlx tJhJxlx1=tJhJxlxMapper.getByMc(tJhJxlx.getMc());
        if (tJhJxlx1!=null && !tJhJxlx.getId().equals(tJhJxlx1.getId())) {
            throw new BusinessException(NoticeConstant.RESPONSE_NAME_EXIST_MESSAGE);
        }
        int i = tJhJxlxMapper.updateByPrimaryKeySelective(tJhJxlx);
        if (i < 1) {
            throw new BusinessException(NoticeConstant.RESPONSE_NOTFOUND_MESSAGE);
        }
    }

    @Override
    public void delete(String id) {

        int i = tJhJxlxMapper.deleteByPrimaryKey(id);
        if (i < 1) {
            throw new BusinessException(NoticeConstant.RESPONSE_NOTFOUND_MESSAGE);
        }
    }
}
