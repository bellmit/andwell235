package com.andawell.material.mapper;

import com.andawell.material.entity.TCfLb;
import com.andawell.material.entity.TCkFyfs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TCkFyfsMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年04月27日 下午03:20:26
*/
@Mapper
public interface TCkFyfsMapper {
    int deleteByPrimaryKey(String id);

    int insert(TCkFyfs record);

    int insertSelective(TCkFyfs record);

    TCkFyfs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TCkFyfs record);

    int updateByPrimaryKey(TCkFyfs record);

    /**
     * 条件查询仓库类别列表
     *
     * @author lhb
     * @Date: 2020/4/26 17:21
     * @Description:
     * @version : V1.0
     * @param query
     */
    List<TCkFyfs> list(@Param("query") Object query);

    String getMaxId();

    List<TCkFyfs> getSqlLiteList();

    void deleteSqlLiteList();

    TCkFyfs getByMc(String mc);

}