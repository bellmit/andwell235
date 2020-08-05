package com.andawell.material.mapper;

import com.andawell.material.entity.TTzzWzlb;
import com.andawell.material.query.TTzzWzlbQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TTzzWzlbMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月15日 上午10:15:13
*/
public interface TTzzWzlbMapper {

    /**
     *
     * @mbg.generated 2020-05-15
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2020-05-15
     */
    int insert(TTzzWzlb record);

    /**
     *
     * @mbg.generated 2020-05-15
     */
    int insertSelective(TTzzWzlb record);


    /**
     *
     * @mbg.generated 2020-05-15
     */
    TTzzWzlb selectByPrimaryKey(String id);


    /**
     *
     * @mbg.generated 2020-05-15
     */
    int updateByPrimaryKeySelective(TTzzWzlb record);

    /**
     *
     * @mbg.generated 2020-05-15
     */
    int updateByPrimaryKey(TTzzWzlb record);

    List<TTzzWzlb> list(@Param("query") TTzzWzlbQuery query);
}