package com.andawell.material.service.impl;

import com.andawell.common.entity.search.ListPageCommon;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.material.mapper.TCkFcsjMapper;
import com.andawell.material.mapper.TCkWsyfMapper;
import com.andawell.material.query.TCkFcsjQuery;
import com.andawell.material.query.TCkWsyfQuery;
import com.andawell.material.service.ITCkFcsjService;
import com.andawell.material.service.ITCkWsYfService;
import com.andawell.material.vo.TCkFcsjVO;
import com.andawell.material.vo.TCkWsyfVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * @author lhb
 * @Date: 2020/5/8 18:26
 * @Description:
 * @version : V1.0
 */
@Service
public class TCkWsYfServiceImpl implements ITCkWsYfService {


    @Autowired
    TCkWsyfMapper tCkWsyfMapper;

    @Override
    public ListPageVo<TCkWsyfQuery, TCkWsyfVO> getTCkWsYfList(TCkWsyfQuery tCkWsyfQuery) {
        return new ListPageCommon<TCkWsyfQuery, TCkWsyfVO>
                (tCkWsyfQuery, (q) -> tCkWsyfMapper.list(q)).getVo();

    }
}
