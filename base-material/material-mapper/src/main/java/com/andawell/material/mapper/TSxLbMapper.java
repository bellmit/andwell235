package com.andawell.material.mapper;

import com.andawell.material.entity.TSxLb;
import com.andawell.material.query.TSxLbQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TSxLbMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月09日 下午05:45:15
*/
public interface TSxLbMapper {


    /**
     *
     * @mbg.generated 2020-05-09
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2020-05-09
     */
    int insert(TSxLb record);

    /**
     *
     * @mbg.generated 2020-05-09
     */
    int insertSelective(TSxLb record);



    /**
     *
     * @mbg.generated 2020-05-09
     */
    TSxLb selectByPrimaryKey(String id);



    /**
     *
     * @mbg.generated 2020-05-09
     */
    int updateByPrimaryKeySelective(TSxLb record);

    /**
     *
     * @mbg.generated 2020-05-09
     */
    int updateByPrimaryKey(TSxLb record);


    List<TSxLb> getList(@Param("query")TSxLbQuery query);
}