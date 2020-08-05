package com.andawell.search.service;

import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.search.entity.XmlSearchMain;
import com.andawell.search.query.CommonListSqlQuery;
import com.andawell.search.query.SearchInfoQuery;
import com.andawell.search.query.XmlSearchMainQuery;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface SearchInfoService {
    ListPageVo<SearchInfoQuery, Map<String, Object>> listPage(SearchInfoQuery query);
    List<Map<String, Object>> list(SearchInfoQuery query);


}
