package com.andawell.material.mapper;

import com.andawell.material.entity.TXtHclb;
import com.andawell.material.query.TXtHclbQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: TXtHclbMapper
 * @Description:
 * @author: Mybatis Generator
 * @date 2020年04月27日 下午02:06:26
 */
public interface TXtHclbMapper {


    int deleteByPrimaryKey(String id);

    int insert(TXtHclb record);

    int insertSelective(TXtHclb record);


    TXtHclb selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TXtHclb record);

    int updateByPrimaryKey(TXtHclb record);

    List<TXtHclb> list(@Param("query")TXtHclbQuery query);
}