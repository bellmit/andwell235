package com.andawell.material.service.impl;

import com.andawell.common.entity.search.ListCommon;
import com.andawell.common.entity.search.ListPageCommon;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.material.entity.TCkFyfs;
import com.andawell.material.mapper.TCkFcsjMapper;
import com.andawell.material.query.TCKFyfsQuery;
import com.andawell.material.query.TCkFcsjQuery;
import com.andawell.material.service.ITCkFcsjService;
import com.andawell.material.vo.TCkFcsjVO;
import com.andawell.upms.entity.SysRoleInfo;
import com.andawell.upms.query.SysRoleInfoQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * @author lhb
 * @Date: 2020/5/8 18:26
 * @Description:
 * @version : V1.0
 */
@Service
public class TCkFcsjServiceImpl implements ITCkFcsjService {


    @Autowired
    TCkFcsjMapper tCkFcsjMapper;

    @Override
    public ListPageVo<TCkFcsjQuery, TCkFcsjVO> getTCkFcsjList(TCkFcsjQuery tCkFcsjQuery) {
        return new ListPageCommon<TCkFcsjQuery, TCkFcsjVO>
                (tCkFcsjQuery, (q) -> tCkFcsjMapper.list(q)).getVo();

    }
}
