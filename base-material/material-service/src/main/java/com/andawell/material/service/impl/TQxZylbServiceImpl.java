package com.andawell.material.service.impl;

import com.andawell.common.util.BusinessException;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.entity.TJhJxlx;
import com.andawell.material.entity.TQxZylb;
import com.andawell.material.mapper.TQxZylbMapper;
import com.andawell.material.service.TQxZylbService;
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
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class TQxZylbServiceImpl implements TQxZylbService {

    @Autowired
    private TQxZylbMapper tQxZylbMapper;

    @Override
    public void update(TQxZylb tQxZylb) {

        TQxZylb tQxZylb1=tQxZylbMapper.getByMc(tQxZylb.getMc());
        if (tQxZylb1!=null && !tQxZylb.getId().equals(tQxZylb1.getId())) {
            throw new BusinessException(NoticeConstant.RESPONSE_NAME_EXIST_MESSAGE);
        }
        int i = tQxZylbMapper.updateByPrimaryKeySelective(tQxZylb);
        if (i < 1) {
            throw new BusinessException(NoticeConstant.RESPONSE_NOTFOUND_MESSAGE+":"+tQxZylb.toString());
        }
    }

    @Override
    public void delete(String id) {
        int i = tQxZylbMapper.deleteByPrimaryKey(id);
        if (i < 1) {
            throw new BusinessException(NoticeConstant.RESPONSE_NOTFOUND_MESSAGE+":"+id);
        }
    }

    @Override
    public void insert(TQxZylb tQxZylb) {
        TQxZylb tQxZylb1=tQxZylbMapper.getByMc(tQxZylb.getMc());
        if (tQxZylb1!=null) {
            throw new BusinessException(NoticeConstant.RESPONSE_NAME_EXIST_MESSAGE);
        }
        String maxId=tQxZylbMapper.getMaxId();
        if (StringUtils.isEmpty(maxId)) {
            tQxZylb.setId("1");
        } else {
            tQxZylb.setId(String.valueOf(Integer.valueOf(maxId)+1));
        }
        tQxZylbMapper.insertSelective(tQxZylb);
    }
}
