package com.andawell.upms.mapper;

import com.andawell.upms.entity.TQxDwlx;
import com.andawell.upms.query.TQxDwlxQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TQxDwlxMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月07日 上午11:24:11
*/
public interface TQxDwlxMapper {
    /**
     *
     * @mbg.generated 2020-05-07
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2020-05-07
     */
    int insert(TQxDwlx record);

    /**
     *
     * @mbg.generated 2020-05-07
     */
    int insertSelective(TQxDwlx record);

    /**
     *
     * @mbg.generated 2020-05-07
     */
    TQxDwlx selectByPrimaryKey(String id);


    /**
     *
     * @mbg.generated 2020-05-07
     */
    int updateByPrimaryKeySelective(TQxDwlx record);

    /**
     *
     * @mbg.generated 2020-05-07
     */
    int updateByPrimaryKey(TQxDwlx record);

    List<TQxDwlx> list(@Param("query") TQxDwlxQuery query);
}