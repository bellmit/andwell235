package com.andawell.material.service.impl;

import com.andawell.common.entity.search.ListCommon;
import com.andawell.common.entity.search.ListPageCommon;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.material.entity.response.TCkCkBO;
import com.andawell.material.enumeration.WhleStyle;
import com.andawell.material.mapper.TCkCkMapper;
import com.andawell.material.query.TCkSxLikeQuery;
import com.andawell.material.service.IOutOfStockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @Date： 2020/5/8 16:49
 */
@Service
@Slf4j
public class OutOfStockServiceImpl implements IOutOfStockService {


    @Autowired
    private TCkCkMapper tCkCkMapper;


    @Override
    public List<TCkCkBO> libraryList(TCkSxLikeQuery query) {
        return new ListCommon<TCkSxLikeQuery, TCkCkBO>(query,
                (q) -> tCkCkMapper.libraryList(q)).get();
    }

    @Override
    public ListPageVo<TCkSxLikeQuery, TCkCkBO> libraryListPage(TCkSxLikeQuery tCkSxLikeQuery) {
        return new ListPageCommon<TCkSxLikeQuery, TCkCkBO>(tCkSxLikeQuery,
                (q) -> tCkCkMapper.libraryList(q)).getVo();

    }


    @Override
    public List<TCkCkBO> libraryMatchingList(TCkSxLikeQuery tCkSxLikeQuery) {
        tCkSxLikeQuery.setJx(tCkSxLikeQuery.getJx().substring(2));
        List<TCkCkBO> list = tCkCkMapper.libraryMatchingList(tCkSxLikeQuery);
        return list;
    }

    @Override
    public List<String> getWhlb() {
        ArrayList<String> list = new ArrayList<String>();
        list.add(WhleStyle.ff.getName());
        list.add(WhleStyle.ts.getName());
        list.add(WhleStyle.zb.getName());
        return list;
    }


}
