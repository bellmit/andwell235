package com.andawell.material.service.impl;

import com.andawell.common.entity.search.ListCommon;
import com.andawell.common.util.BusinessException;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.entity.TCkCrklb;
import com.andawell.material.entity.TXhpCrk;
import com.andawell.material.mapper.TCkCrklbMapper;
import com.andawell.material.query.TCkCrklbQuery;
import com.andawell.material.query.TXhpCrkQuery;
import com.andawell.material.service.ITCkCrklbService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TCkCrklbServiceImpl implements ITCkCrklbService {

    @Autowired
    TCkCrklbMapper tCkCrklbMapper;

    @Override
    public List<TCkCrklb> rklbList(TCkCrklbQuery query) {
        return new ListCommon<TCkCrklbQuery, TCkCrklb>(query, (q) -> tCkCrklbMapper.list(q)).get();
    }

    @Override
    public void insertBj(TCkCrklb tCkCrklb) {
        TCkCrklb tCkCrklb1=tCkCrklbMapper.getByMc(tCkCrklb.getMc());
        if (tCkCrklb1!=null) {
            throw new BusinessException(NoticeConstant.RESPONSE_NAME_EXIST_MESSAGE);
        }
        List<String> list = tCkCrklbMapper.get2LengthId();
        if (list.isEmpty()) {
            tCkCrklb.setId("10");
        } else {
            if (list.size() >= 9) {
                throw new BusinessException(NoticeConstant.RESPONSE_FULL_ID_MESSAGE);
            }
            for (int i = 1; i <= 9; i++) {
                String id = i * 10 + "";
                if (!list.contains(id)) {
                    tCkCrklb.setId(id);
                    break;
                }
            }
        }
        tCkCrklbMapper.insertSelective(tCkCrklb);
    }

    @Override
    public void update(TCkCrklb tCkCrklb) {
        TCkCrklb tCkCrklb1=tCkCrklbMapper.getByMc(tCkCrklb.getMc());
        if (tCkCrklb1!=null && !tCkCrklb.getId().equals(tCkCrklb1.getId())) {
            throw new BusinessException(NoticeConstant.RESPONSE_NAME_EXIST_MESSAGE);
        }
        int i = tCkCrklbMapper.updateByPrimaryKeySelective(tCkCrklb);
        if ( i < 1) {
            throw new BusinessException(NoticeConstant.RESPONSE_NOTFOUND_MESSAGE);
        }
    }

    @Override
    public void insertZj(TCkCrklb tCkCrklb) {
        TCkCrklb tCkCrklb1=tCkCrklbMapper.getByMc(tCkCrklb.getMc());
        if (tCkCrklb1!=null) {
            throw new BusinessException(NoticeConstant.RESPONSE_NAME_EXIST_MESSAGE);
        }
        String pid = tCkCrklb.getPid();
        String maxId = tCkCrklbMapper.getMaxID(pid);
        if (StringUtils.isEmpty(maxId)) {
            tCkCrklb.setId(String.valueOf(Integer.valueOf(pid) * 100 + 1));
        } else {
            tCkCrklb.setId(String.valueOf(Integer.valueOf(maxId) + 1));
        }
        tCkCrklbMapper.insertSelective(tCkCrklb);
    }

    @Override
    public void delete(String id) {
        String maxId = tCkCrklbMapper.getMaxID(id);
        if (!StringUtils.isEmpty(maxId)) {
            throw new BusinessException(NoticeConstant.RESPONSE_CHILDREN_NOTNULL_MESSAGE);
        }
        int i = tCkCrklbMapper.deleteByPrimaryKey(id);
        if ( i < 1) {
            throw new BusinessException(NoticeConstant.RESPONSE_NOTFOUND_MESSAGE);
        }
    }

    @Override
    public String getJmById(String id) {
        return tCkCrklbMapper.getJmById(id);
    }

    /***
     * @author gzh
     * @Date: 2020/4/28 14:36
     * @Description: 五金出入库类别接口
     */
    @Override
    public List<TCkCrklb> wjcrklbList() {
        return tCkCrklbMapper.wjcrklbList();
    }


}
