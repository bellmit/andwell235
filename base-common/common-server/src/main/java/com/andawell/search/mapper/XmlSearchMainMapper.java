package com.andawell.search.mapper;

import com.andawell.search.entity.XmlSearchMain;
import com.andawell.search.query.XmlSearchMainQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface XmlSearchMainMapper {
    /**
     * xml查询功能-主表查询
     * */
    List<XmlSearchMain> list(@Param("query") XmlSearchMainQuery query);
}
