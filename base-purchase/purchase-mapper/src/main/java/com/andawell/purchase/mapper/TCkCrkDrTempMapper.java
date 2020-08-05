package com.andawell.purchase.mapper;

import com.andawell.purchase.entity.TCkCrkDrTemp;
import org.apache.ibatis.annotations.Param;

/**
* @ClassName: TCkCrkDrTempMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月12日 上午10:30:29
*/
public interface TCkCrkDrTempMapper {
    /**
     *
     * @mbg.generated 2020-06-12
     */
    int deleteByPrimaryKey(@Param("bh") String bh, @Param("dwid") String dwid);

    /**
     *
     * @mbg.generated 2020-06-12
     */
    int insert(TCkCrkDrTemp record);

    /**
     *
     * @mbg.generated 2020-06-12
     */
    int insertSelective(TCkCrkDrTemp record);

    /**
     *
     * @mbg.generated 2020-06-12
     */
    TCkCrkDrTemp selectByPrimaryKey(@Param("bh") String bh, @Param("dwid") String dwid);

    /**
     *
     * @mbg.generated 2020-06-12
     */
    int updateByPrimaryKeySelective(TCkCrkDrTemp record);

    /**
     *
     * @mbg.generated 2020-06-12
     */
    int updateByPrimaryKey(TCkCrkDrTemp record);
}