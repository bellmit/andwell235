package com.andawell.search.service.impl;

import com.andawell.common.entity.search.ListCommon;
import com.andawell.common.entity.search.ListPageCommon;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.search.mapper.SearchInfoMapper;
import com.andawell.search.query.SearchInfoQuery;
import com.andawell.search.service.SearchInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SearchInfoServiceImpl implements SearchInfoService {

    @Autowired
    private SearchInfoMapper searchInfoMapper;

    @Override
    public ListPageVo<SearchInfoQuery, Map<String, Object>> listPage(SearchInfoQuery query) {

        return new ListPageCommon<SearchInfoQuery, Map<String, Object>>(query, (q) -> searchInfoMapper.list(q)).getVo();
    }

    @Override
    public List<Map<String, Object>> list(SearchInfoQuery query) {

        return new ListCommon<SearchInfoQuery, Map<String, Object>>(query, (q) -> searchInfoMapper.list(q)).get();
    }

}
