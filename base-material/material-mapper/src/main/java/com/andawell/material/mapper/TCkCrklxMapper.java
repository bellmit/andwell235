package com.andawell.material.mapper;

import com.andawell.material.entity.TCkCrklx;
import com.andawell.material.query.TCkCrklxQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TCkCrklxMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月03日 上午10:02:19
*/
@Mapper
public interface TCkCrklxMapper {


    /**
     *
     * @mbg.generated 2020-05-03
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2020-05-03
     */
    int insert(TCkCrklx record);

    /**
     *
     * @mbg.generated 2020-05-03
     */
    int insertSelective(TCkCrklx record);


    /**
     *
     * @mbg.generated 2020-05-03
     */
    TCkCrklx selectByPrimaryKey(String id);
    /**
     *
     * @mbg.generated 2020-05-03
     */
    int updateByPrimaryKeySelective(TCkCrklx record);

    /**
     *
     * @mbg.generated 2020-05-03
     */
    int updateByPrimaryKey(TCkCrklx record);

    List<TCkCrklx> list(@Param("query") TCkCrklxQuery query);
}