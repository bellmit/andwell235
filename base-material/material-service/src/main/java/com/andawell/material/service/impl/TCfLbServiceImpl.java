package com.andawell.material.service.impl;

import com.andawell.common.util.BusinessException;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.entity.TCfLb;
import com.andawell.material.mapper.TCfLbMapper;
import com.andawell.material.service.TCfLbService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author:PCJ
 * @Date:2020/5/20
 * @Version:V1.0.0
 */
@Service
public class TCfLbServiceImpl implements TCfLbService {

    @Autowired
    private TCfLbMapper tCfLbMapper;

    @Override
    public void delete(String id) {
        String maxId = tCfLbMapper.getMaxID(id);
        if (!StringUtils.isEmpty(maxId)) {
            throw new BusinessException(NoticeConstant.RESPONSE_CHILDREN_NOTNULL_MESSAGE);
        }
        int i = tCfLbMapper.deleteByPrimaryKey(id);
        if (i < 1) {
            throw new BusinessException(NoticeConstant.RESPONSE_NOTFOUND_MESSAGE);
        }
    }

    @Override
    public void update(TCfLb tCfLb) {
        TCfLb tCfLb1 =  tCfLbMapper.getByMc(tCfLb.getMc());
        if (tCfLb1!=null && !tCfLb.getId().equals(tCfLb1.getId())) {
            throw new BusinessException(NoticeConstant.RESPONSE_NAME_EXIST_MESSAGE);
        }
        int i = tCfLbMapper.updateByPrimaryKeySelective(tCfLb);
        if (i < 1) {
            throw new BusinessException(NoticeConstant.RESPONSE_NOTFOUND_MESSAGE);
        }
    }

    @Override
    public void insertBj(TCfLb tCfLb) {
        TCfLb tCfLb1 =  tCfLbMapper.getByMc(tCfLb.getMc());
        if (tCfLb1!=null) {
            throw new BusinessException(NoticeConstant.RESPONSE_NAME_EXIST_MESSAGE);
        }
        List<String> list = tCfLbMapper.get2LengthId();
        if (list.isEmpty()) {
            tCfLb.setId("10");
        } else {
            if (list.size() >= 9) {
                throw new BusinessException(NoticeConstant.RESPONSE_FULL_ID_MESSAGE);
            }
            for (int i = 1; i <= 9; i++) {
                String id = i * 10 + "";
                if (!list.contains(id)) {
                    tCfLb.setId(id);
                    break;
                }
            }
        }
        tCfLbMapper.insertSelective(tCfLb);

    }

    @Override
    public void insertZj(TCfLb tCfLb) {
        TCfLb tCfLb1 =  tCfLbMapper.getByMc(tCfLb.getMc());
        if (tCfLb1!=null) {
            throw new BusinessException(NoticeConstant.RESPONSE_NAME_EXIST_MESSAGE);
        }
        String pid = tCfLb.getPid();
        String maxId = tCfLbMapper.getMaxID(pid);
        if (StringUtils.isEmpty(maxId)) {
            tCfLb.setId(String.valueOf(Integer.valueOf(pid) * 100 + 1));
        } else {
            tCfLb.setId(String.valueOf(Integer.valueOf(maxId) + 1));
        }
        tCfLbMapper.insertSelective(tCfLb);
    }

    @Override
    public List<TCfLb> list() {
        return tCfLbMapper.list();
    }
}
