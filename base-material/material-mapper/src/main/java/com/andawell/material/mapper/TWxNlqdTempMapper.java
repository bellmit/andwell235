package com.andawell.material.mapper;

import com.andawell.material.entity.TWxNlqd;
import com.andawell.material.entity.TWxNlqdTemp;
import com.andawell.material.query.TWxNlqdQuery;
import com.andawell.material.query.TWxNlqdTempQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TWxNlqdTempMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月09日 下午03:43:10
*/
public interface TWxNlqdTempMapper {
    /**
     *
     * @mbg.generated 2020-06-09
     */
    int deleteByPrimaryKey(@Param("pid") Integer pid, @Param("cfid") String cfid);

    /**
     *
     * @mbg.generated 2020-06-09
     */
    int insert(TWxNlqdTemp record);

    /**
     *
     * @mbg.generated 2020-06-09
     */
    int insertSelective(TWxNlqdTemp record);

    /**
     *
     * @mbg.generated 2020-06-09
     */
    TWxNlqdTemp selectByPrimaryKey(@Param("pid") Integer pid, @Param("cfid") String cfid);

    /**
     *
     * @mbg.generated 2020-06-09
     */
    int updateByPrimaryKeySelective(TWxNlqdTemp record);

    /**
     *
     * @mbg.generated 2020-06-09
     */
    int updateByPrimaryKey(TWxNlqdTemp record);

    List<TWxNlqdTemp> selectByQuery(@Param("query") TWxNlqdTempQuery tWxNlqdTempQuery);
}