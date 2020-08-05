package com.andawell.material.mapper;

import com.andawell.material.entity.TWxNlTemp;
import com.andawell.material.query.TWxNlTempQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TWxNlTempMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月09日 下午03:43:10
*/
public interface TWxNlTempMapper {
    /**
     *
     * @mbg.generated 2020-06-09
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2020-06-09
     */
    int insert(TWxNlTemp record);

    /**
     *
     * @mbg.generated 2020-06-09
     */
    int insertSelective(TWxNlTemp record);

    /**
     *
     * @mbg.generated 2020-06-09
     */
    TWxNlTemp selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2020-06-09
     */
    int updateByPrimaryKeySelective(TWxNlTemp record);

    /**
     *
     * @mbg.generated 2020-06-09
     */
    int updateByPrimaryKey(TWxNlTemp record);

    List<TWxNlTemp> selectByQuery(@Param("query") TWxNlTempQuery tWxNlTempQuery);
}