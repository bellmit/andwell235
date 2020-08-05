package com.andawell.material.service.impl;

import com.andawell.common.entity.search.ListCommon;
import com.andawell.material.entity.TJhZl;
import com.andawell.material.mapper.TJhZlMapper;
import com.andawell.material.query.TJhZlQuery;
import com.andawell.material.service.ITJhZlService;
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
public class TJhZlServiceImpl implements ITJhZlService {


    @Autowired
    TJhZlMapper tJhZlMapper;

    @Override
    public List<TJhZl> list(TJhZlQuery tJhZlQuery) {
        return new ListCommon<TJhZlQuery, TJhZl>(tJhZlQuery,
                (q) -> tJhZlMapper.list(q)).get();
    }
}
