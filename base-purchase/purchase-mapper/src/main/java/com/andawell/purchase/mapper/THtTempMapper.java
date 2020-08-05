package com.andawell.purchase.mapper;

import com.andawell.purchase.entity.THtTemp;
import org.apache.ibatis.annotations.Param;

/**
* @ClassName: THtTempMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月11日 下午03:23:00
*/
public interface THtTempMapper {
    /**
     *
     * @mbg.generated 2020-06-11
     */
    int deleteByPrimaryKey(@Param("hth") String hth, @Param("jhbh") String jhbh);

    /**
     *
     * @mbg.generated 2020-06-11
     */
    int insert(THtTemp record);

    /**
     *
     * @mbg.generated 2020-06-11
     */
    int insertSelective(THtTemp record);

    /**
     *
     * @mbg.generated 2020-06-11
     */
    THtTemp selectByPrimaryKey(@Param("hth") String hth, @Param("jhbh") String jhbh);

    /**
     *
     * @mbg.generated 2020-06-11
     */
    int updateByPrimaryKeySelective(THtTemp record);

    /**
     *
     * @mbg.generated 2020-06-11
     */
    int updateByPrimaryKey(THtTemp record);
}