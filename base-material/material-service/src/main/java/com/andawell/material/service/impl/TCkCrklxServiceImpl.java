package com.andawell.material.service.impl;/**
 * @Date： 2020/5/11 15:02
 */

import com.andawell.common.entity.search.ListCommon;
import com.andawell.material.entity.TCkCrklb;
import com.andawell.material.entity.TCkCrklx;
import com.andawell.material.mapper.TCkCrklxMapper;
import com.andawell.material.query.TCkCrklbQuery;
import com.andawell.material.query.TCkCrklxQuery;
import com.andawell.material.service.ITCkCrklxService;
import com.andawell.material.util.TCkCrklxTreeUtil;
import com.andawell.material.vo.TCkCrklxVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *@Auther:liuys
 *@Date:2020/5/11 15:02
 *@Description:
 */
@Service
public class TCkCrklxServiceImpl implements ITCkCrklxService {
    @Autowired
    private TCkCrklxMapper tCkCrklxMapper;

    @Override
    public List<TCkCrklxVO> treelist(TCkCrklxQuery query) {
        return TCkCrklxTreeUtil.buildTree(tCkCrklxMapper.list(query));
    }

    @Override
    public List<TCkCrklx> list(TCkCrklxQuery query) {
        return new ListCommon<TCkCrklxQuery, TCkCrklx>(query,(q)->tCkCrklxMapper.list(q)).get();
    }
}
