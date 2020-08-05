package com.andawell.material.service.impl;

import com.andawell.common.entity.search.ListPageCommon;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.material.entity.PKCX;
import com.andawell.material.mapper.PKCXMapper;
import com.andawell.material.query.PKCXQuery;
import com.andawell.material.query.TCkWjkQuery;
import com.andawell.material.service.IPKCXService;
import com.andawell.material.vo.TCkWjkVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yzy
 * @Description:
 * @Date: created in 2020/5/25 11:05
 */
@Service
public class PKCXServiceImpl implements IPKCXService {

    @Autowired
    PKCXMapper pkcxMapper;

    @Override
    public List<PKCX> list(PKCXQuery pkcxQuery) {
        return pkcxMapper.list(pkcxQuery);
    }

    @Override
    public ListPageVo<PKCXQuery, PKCX> getPageList(PKCXQuery pkcxQuery) {
        return  new ListPageCommon<PKCXQuery, PKCX>
                (pkcxQuery, (q) -> pkcxMapper.list(q)).getVo();
    }
}
