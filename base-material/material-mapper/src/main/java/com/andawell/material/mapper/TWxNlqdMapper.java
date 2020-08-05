package com.andawell.material.mapper;

import com.andawell.material.entity.TWxNlqd;
import com.andawell.material.query.TWxNlqdQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TWxNlqdMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月09日 下午01:40:27
*/
public interface TWxNlqdMapper {


    /**
     *
     * @mbg.generated 2020-05-09
     */
    int deleteByPrimaryKey(@Param("pid") Integer pid, @Param("cfid") String cfid);

    /**
     *
     * @mbg.generated 2020-05-09
     */
    int insert(TWxNlqd record);

    /**
     *
     * @mbg.generated 2020-05-09
     */
    int insertSelective(TWxNlqd record);


    /**
     *
     * @mbg.generated 2020-05-09
     */
    TWxNlqd selectByPrimaryKey(@Param("pid") Integer pid, @Param("cfid") String cfid);


    /**
     *
     * @mbg.generated 2020-05-09
     */
    int updateByPrimaryKeySelective(TWxNlqd record);

    /**
     *
     * @mbg.generated 2020-05-09
     */
    int updateByPrimaryKey(TWxNlqd record);

    List<TWxNlqd> selectByPId(Integer pid);

    List<TWxNlqd> selectByQuery(@Param("query") TWxNlqdQuery tWxNlqdQuery);
}