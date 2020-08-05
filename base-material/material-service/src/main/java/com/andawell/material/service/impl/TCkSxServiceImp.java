package com.andawell.material.service.impl;

import com.andawell.material.dto.TCkSxXLNLDTO;
import com.andawell.material.entity.TXtBzlb;
import com.andawell.material.entity.response.TCkSxBO;
import com.andawell.material.mapper.TCkSxMapper;
import com.andawell.material.mapper.TXtBzlbMapper;
import com.andawell.material.query.TCkSxQuery;
import com.andawell.material.query.TCkSxXLNLQuery;
import com.andawell.material.service.ITCkSxService;
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
public class TCkSxServiceImp implements ITCkSxService {


    @Autowired
    TCkSxMapper ckSxMapper;

    @Autowired
    TXtBzlbMapper tXtBzlbMapper;

    @Override
    public List<TCkSxBO> repairReturn(TCkSxQuery tCkSxQuery) {
        return ckSxMapper.repairReturn(tCkSxQuery);
    }

    @Override
    public List<TCkSxBO> repairRetreat(TCkSxQuery tCkSxQuery) {
        return ckSxMapper.repairRetreat(tCkSxQuery);
    }

    @Override
    public List<TCkSxXLNLDTO> getList() {
        return ckSxMapper.getList();
    }


}
