package com.andawell.search.mapper;

import com.andawell.search.query.SearchInfoQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SearchInfoMapper {
    List<Map<String, Object>> list(SearchInfoQuery query);
}
