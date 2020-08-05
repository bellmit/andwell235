package com.andawell.upms.mapper;

import com.andawell.upms.entity.TRyZw;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TRyZwMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月08日 下午03:15:14
*/
public interface TRyZwMapper {


    /**
     * 职务查询
     */
    List<TRyZw> list(@Param("query") Object query);
}