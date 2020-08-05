package com.andawell.material.mapper;

import com.andawell.material.entity.TCfLb;
import com.andawell.material.entity.TCkCrklb;

import java.util.List;

import com.andawell.material.query.TCkCrklbQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TCkCrklbMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年04月30日 上午09:23:24
*/
@Mapper
public interface TCkCrklbMapper {


    /**
     *
     * @mbg.generated 2020-04-30
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2020-04-30
     */
    int insert(TCkCrklb record);

    /**
     *
     * @mbg.generated 2020-04-30
     */
    int insertSelective(TCkCrklb record);


    /**
     *
     * @mbg.generated 2020-04-30
     */
    TCkCrklb selectByPrimaryKey(String id);


    /**
     *
     * @mbg.generated 2020-04-30
     */
    int updateByPrimaryKeySelective(TCkCrklb record);

    /**
     *
     * @mbg.generated 2020-04-30
     */
    int updateByPrimaryKey(TCkCrklb record);


    /**
     * 根据条件查询
     * @param query
     * @return
     */
    List<TCkCrklb> list(@Param("query") TCkCrklbQuery query);

    List<String> get2LengthId();

    String getMaxID(@Param("pid") String pid);

    List<TCkCrklb> getSqlLiteList();

    void deleteSqlLiteList();

    TCkCrklb getByMc(@Param("mc")String mc);

    String getJmById(@Param("id") String id);

    List<TCkCrklb> wjcrklbList();
}