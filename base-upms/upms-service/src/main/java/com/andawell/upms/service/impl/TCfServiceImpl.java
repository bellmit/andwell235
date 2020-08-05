package com.andawell.upms.service.impl;

import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.common.util.BusinessException;
import com.andawell.upms.constant.NoticeConstant;
import com.andawell.upms.entity.TCf;
import com.andawell.upms.mapper.TCfMapper;
import com.andawell.upms.query.TCfQuery;
import com.andawell.upms.service.TCfService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 厂方服务实现类
 * @Author:PCJ
 * @Date:2020/5/11
 * @Version:V1.0.0
 */
@Service
public class TCfServiceImpl implements TCfService {

    @Autowired
    private TCfMapper tCfMapper;

    @Override
    public void delete(String id) {
        int i = tCfMapper.deleteByPrimaryKey(id);
        if (i != 1) {
            throw new BusinessException(NoticeConstant.RESPONSE_NOTFOUND_MESSAGE+":"+id);
        }
    }

    @Override
    public void insertCx(TCf tCf) {
        String id=tCfMapper.getCxMaxId();
        if (StringUtils.isEmpty(id)) {
            tCf.setId("R0001");
        } else {
            tCf.setId("R" + (String.valueOf(10000 + Integer.valueOf(id) + 1)).substring(1));
        }
        tCfMapper.insertSelective(tCf);
    }

    @Override
    public void update(TCf tCf) {
        int i = tCfMapper.updateByPrimaryKeySelective(tCf);
        if (i < 1) {
            throw new BusinessException(NoticeConstant.RESPONSE_NOTFOUND_MESSAGE+":"+tCf.toString());
        }
    }

    @Override
    public List<TCf> listCx(TCfQuery query) {
        return tCfMapper.list(query.setLb("20"));
    }

    @Override
    public List<TCf> listCz(TCfQuery query) {
        return tCfMapper.list(query.setLb("10"));
    }

    @Override
    public void insertCz(TCf tCf) {
        String id=tCfMapper.getCzMaxId();
        if (StringUtils.isEmpty(id)) {
            tCf.setId("M0001");
        } else {
            tCf.setId("M" + (String.valueOf(10000 + Integer.valueOf(id) + 1)).substring(1));
        }
        tCfMapper.insertSelective(tCf);
    }

    @Override
    public void upload(List<String[]> list) {
        List<TCf> tCfList=new ArrayList<>();
        Integer id=10000;
        String maxId=tCfMapper.getCzMaxId();
        if (StringUtils.isNotEmpty(maxId)) {
            id =10000 + Integer.valueOf(maxId);
        }
        for (String[] rowData : list) {
            if (rowData[0]==null) {
                continue;
            }
            TCf tCf = new TCf();
            tCf.setJm(rowData[0]);
            tCf.setMc(rowData[1]);
            tCf.setDz(rowData[2]);
            tCf.setDh(rowData[3]);
            tCf.setZhmc(rowData[4]);
            tCf.setKhyh(rowData[5]);
            tCf.setZh(rowData[6]);
            id+=1;
            tCf.setId("M" + (String.valueOf(id)).substring(1));
            tCf.setLb("1002");
            tCfList.add(tCf);
        }
        tCfMapper.insertAll(tCfList);
    }


}
