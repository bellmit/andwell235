package com.andawell.material.service.impl;/**
 * @Date： 2020/5/11 14:51
 */

import com.andawell.common.entity.search.ListCommon;
import com.andawell.material.entity.TJhZylx;
import com.andawell.material.entity.TXtXljb;
import com.andawell.material.entity.response.TCkCkBO;
import com.andawell.material.mapper.TJhZylxMapper;
import com.andawell.material.query.TJhZylxQuery;
import com.andawell.material.query.TXtXljbQuery;
import com.andawell.material.service.ITJhZylxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@Auther:liuys
 *@Date:2020/5/11 14:51
 *@Description:
 */
@Service
public class TJhZylxServiceImpl implements ITJhZylxService {
    @Autowired
    private TJhZylxMapper tJhZylxMapper;

    @Override
    public List<TJhZylx> list(TJhZylxQuery query) {
        return new ListCommon<TJhZylxQuery, TJhZylx>(query,
                (q) -> tJhZylxMapper.list(q)).get();
    }
}
