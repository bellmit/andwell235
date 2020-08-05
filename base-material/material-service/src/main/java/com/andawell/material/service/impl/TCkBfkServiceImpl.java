package com.andawell.material.service.impl;

import com.andawell.common.entity.search.ListCommon;
import com.andawell.common.entity.search.ListPageCommon;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.material.entity.TCkBfk;
import com.andawell.material.entity.TCkCrklb;
import com.andawell.material.entity.TXtXljb;
import com.andawell.material.mapper.TCkBfkMapper;
import com.andawell.material.mapper.TCkDxzbfMapper;
import com.andawell.material.query.TCkBfkQuery;
import com.andawell.material.query.TCkCrklbQuery;
import com.andawell.material.query.TXtXljbQuery;
import com.andawell.material.service.ITCkBfkService;
import com.andawell.material.vo.TCkBfkVO;
import com.andawell.material.vo.TCkDxzbfVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Date： 2020/5/8 11:01
 */
@Service
public class TCkBfkServiceImpl implements ITCkBfkService {
    @Autowired
    private TCkBfkMapper tCkBfkMapper;

    @Autowired
    private TCkDxzbfMapper tCkDxzbfMapper;

    @Override
    public List<TCkBfk> list(TCkBfkQuery tCkBfkQuery) {
        return null;
    }

    @Override
    public ListPageVo<TCkBfkQuery,TCkBfkVO> outnoundList(TCkBfkQuery query) {
        return new ListPageCommon<TCkBfkQuery,TCkBfkVO>(query, (q) ->
                tCkBfkMapper.outnoundList(q)).getVo();
    }

    @Override
    public List<TCkDxzbfVO> warehousingList(TCkBfkQuery query) {
        return new ListCommon<TCkBfkQuery, TCkDxzbfVO>(query,
                (q) -> tCkDxzbfMapper.warehousingList(q)).get();
    }
}
