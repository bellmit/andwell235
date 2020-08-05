package com.andawell.material.mapper;

import com.andawell.material.entity.TCf;
import com.andawell.material.entity.TXtJldw;
import com.andawell.material.query.TCfQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TCfMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月09日 下午02:29:15
*/
public interface TCfMapper {

    void deleteSqlLiteList();


    List<TCf> getSqlLiteList();
    /**
     *
     * @mbg.generated 2020-05-09
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2020-05-09
     */
    int insert(TCf record);

    /**
     *
     * @mbg.generated 2020-05-09
     */
    int insertSelective(TCf record);

    /**
     *
     * @mbg.generated 2020-05-09
     */
    TCf selectByPrimaryKey(String id);


    /**
     *
     * @mbg.generated 2020-05-09
     */
    int updateByPrimaryKeySelective(TCf record);

    /**
     *
     * @mbg.generated 2020-05-09
     */
    int updateByPrimaryKey(TCf record);

    List<TCf> getList(@Param("query")TCfQuery query);
}