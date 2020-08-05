package com.andawell.upms.mapper;

import com.andawell.upms.entity.TCf;
import com.andawell.upms.query.TCfQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TCfMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月09日 下午06:06:16
*/
public interface TCfMapper {

    /**
     *
     * @mbg.generated 2020-05-09
     */
    int deleteByPrimaryKey(String id);

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


    List<TCf> list(@Param("query") TCfQuery query);


    String getCzMaxId();

    String getCxMaxId();

    List<String> listId();


    void insertAll(List<TCf> tCfList);

}