package com.andawell.material.service.impl;

import com.andawell.common.util.BusinessException;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.entity.TDbzt;
import com.andawell.material.mapper.TDbztMapper;
import com.andawell.material.service.TDbztService;
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
public class TDbztServiceImpl implements TDbztService {

    @Autowired
    private TDbztMapper tDbztMapper;

    @Override
    public void delete(String id) {
        int i = tDbztMapper.deleteByPrimaryKey(Integer.valueOf(id));
        if (i < 1) {
            throw new BusinessException(NoticeConstant.RESPONSE_NOTFOUND_MESSAGE);
        }
    }

    @Override
    public void update(TDbzt tDbzt) {
        TDbzt tDbzt1=tDbztMapper.getByMc(tDbzt.getMc());
        if (tDbzt1!=null && !tDbzt.getId().equals(tDbzt1.getId())) {
            throw new BusinessException(NoticeConstant.RESPONSE_NAME_EXIST_MESSAGE);
        }
        int i = tDbztMapper.updateByPrimaryKeySelective(tDbzt);
        if (i < 1) {
            throw new BusinessException(NoticeConstant.RESPONSE_NOTFOUND_MESSAGE);
        }
    }

    @Override
    public void insert(TDbzt tDbzt) {
        TDbzt tDbzt1=tDbztMapper.getByMc(tDbzt.getMc());
        if (tDbzt1!=null) {
            throw new BusinessException(NoticeConstant.RESPONSE_NAME_EXIST_MESSAGE);
        }
        String maxId=tDbztMapper.getMaxId();
        if (StringUtils.isEmpty(maxId)) {
            tDbzt.setId(1);
        } else {
            tDbzt.setId(Integer.valueOf(maxId)+1);
        }
        tDbztMapper.insertSelective(tDbzt);
    }
}
