package com.andawell.material.mapper;

import com.andawell.material.entity.TCyDw;

import java.util.List;

/**
* @ClassName: TCyDwMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月01日 下午02:12:51
*/
public interface TCyDwMapper {


    List<TCyDw> list();

    /**
     *
     * @mbg.generated 2020-06-01
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2020-06-01
     */
    int insert(TCyDw record);

    /**
     *
     * @mbg.generated 2020-06-01
     */
    int insertSelective(TCyDw record);



    /**
     *
     * @mbg.generated 2020-06-01
     */
    TCyDw selectByPrimaryKey(String id);


    /**
     *
     * @mbg.generated 2020-06-01
     */
    int updateByPrimaryKeySelective(TCyDw record);

    /**
     *
     * @mbg.generated 2020-06-01
     */
    int updateByPrimaryKey(TCyDw record);
}