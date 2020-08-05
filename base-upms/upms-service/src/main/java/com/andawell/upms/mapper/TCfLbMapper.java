package com.andawell.upms.mapper;

import com.andawell.upms.entity.TCfLb;
import com.andawell.upms.query.TCfLbQuery;
import com.andawell.upms.query.TCfQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TCfLbMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月11日 上午09:45:23
*/
public interface TCfLbMapper {

    /**
     *
     * @mbg.generated 2020-05-11
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2020-05-11
     */
    int insert(TCfLb record);

    /**
     *
     * @mbg.generated 2020-05-11
     */
    int insertSelective(TCfLb record);

    /**
     *
     * @mbg.generated 2020-05-11
     */
    TCfLb selectByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2020-05-11
     */
    int updateByPrimaryKeySelective(TCfLb record);



    List<TCfLb> listCzlb(@Param("query") TCfLbQuery query);

    List<TCfLb> listCxlb(@Param("query") TCfLbQuery query);
}