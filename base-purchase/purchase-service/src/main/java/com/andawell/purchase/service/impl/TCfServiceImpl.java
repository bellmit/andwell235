package com.andawell.purchase.service.impl;

import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.purchase.mapper.TCfMapper;
import com.andawell.purchase.query.TCfQuery;
import com.andawell.purchase.service.ITCfService;
import com.andawell.purchase.vo.TCfVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:PCJ
 * @Date:2020/6/5
 * @Version:V1.0.0
 */
@Service
public class TCfServiceImpl implements ITCfService {

    @Autowired
    private TCfMapper tCfMapper;

    @Override
    public List<TCfVO> list(TCfQuery query) {
        return tCfMapper.list(query);
    }
}
