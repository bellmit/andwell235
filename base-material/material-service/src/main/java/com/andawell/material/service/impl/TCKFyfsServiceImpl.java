package com.andawell.material.service.impl;

import com.andawell.common.entity.search.ListCommon;
import com.andawell.common.util.BusinessException;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.entity.TCkFyfs;
import com.andawell.material.mapper.TCkFyfsMapper;
import com.andawell.material.query.TCKFyfsQuery;
import com.andawell.material.service.ITCkFyfsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/***
 * @author lhb
 * @Date: 2020/4/26 17:29
 * @Description:
 * @version : V1.0
 */
@Service
public class TCKFyfsServiceImpl implements ITCkFyfsService {


    @Autowired
    TCkFyfsMapper tckFyfsMapper;


    public List<TCkFyfs> list(TCKFyfsQuery tckFyfsQuery) {
        return new ListCommon<TCKFyfsQuery, TCkFyfs>(tckFyfsQuery,
                (q) -> tckFyfsMapper.list(q)).get();
    }

    @Override
    public void update(TCkFyfs tCkFyfs) {
        TCkFyfs tCkFyfs1=tckFyfsMapper.getByMc(tCkFyfs.getMc());
        if (tCkFyfs1!=null && !tCkFyfs.getId().equals(tCkFyfs1.getId())) {
            throw new BusinessException(NoticeConstant.RESPONSE_NAME_EXIST_MESSAGE);
        }
        int i = tckFyfsMapper.updateByPrimaryKeySelective(tCkFyfs);
        if (i < 1) {
            throw new BusinessException(NoticeConstant.RESPONSE_NOTFOUND_MESSAGE);
        }
    }

    @Override
    public void delete(String id) {
        int i = tckFyfsMapper.deleteByPrimaryKey(id);
        if (i < 1) {
            throw new BusinessException(NoticeConstant.RESPONSE_NOTFOUND_MESSAGE);
        }
    }

    @Override
    public void insert(TCkFyfs tCkFyfs) {
        TCkFyfs tCkFyfs1=tckFyfsMapper.getByMc(tCkFyfs.getMc());
        if (tCkFyfs1!=null) {
            throw new BusinessException(NoticeConstant.RESPONSE_NAME_EXIST_MESSAGE);
        }
        String maxId=tckFyfsMapper.getMaxId();
        if (StringUtils.isEmpty(maxId)) {
            tCkFyfs.setId("1");
        } else {
            tCkFyfs.setId(String.valueOf(Integer.valueOf(maxId)+1));
        }
        tckFyfsMapper.insertSelective(tCkFyfs);
    }
}
