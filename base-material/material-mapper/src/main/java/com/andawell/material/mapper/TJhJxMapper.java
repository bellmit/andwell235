package com.andawell.material.mapper;

import com.andawell.material.entity.TJhJx;

import com.andawell.material.entity.TXtJldw;
import com.andawell.material.query.TJhJxQuery;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TJhJxMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年04月27日 上午11:43:19
*/
@Mapper
public interface TJhJxMapper {

    void deleteSqlLiteList();

    List<TJhJx> getSqlLiteList();
    /**
     * 机型删除
     */
    int deleteByPrimaryKey(String id);

    /**
     * 机型添加
     */
    int insert(TJhJx record);

    int insertSelective(TJhJx record);

    TJhJx selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TJhJx record);

    /**
     * 机型修改
     * */
    int updateByPrimaryKey(TJhJx record);

    List<TJhJx> list(@Param("query") TJhJxQuery query);
    /**
     * 查询最大父级id+1
     * */
    String selectMaxPid();
    /**
     * 查询最大子级id+1
     *
     * @param pid*/
    String selectZid(@Param("pid")String pid);
}