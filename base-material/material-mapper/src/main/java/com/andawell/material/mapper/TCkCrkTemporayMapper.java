package com.andawell.material.mapper;

import com.andawell.material.entity.TCkCrkTemporay;
import org.apache.ibatis.annotations.Param;

/**
* @ClassName: TCkCrkTemporayMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月18日 下午02:12:05
*/
public interface TCkCrkTemporayMapper {
    /**
     *
     * @mbg.generated 2020-06-18
     */
    int deleteByPrimaryKey(@Param("bh") String bh, @Param("dwid") String dwid, @Param("dlr") String dlr);

    /**
     *
     * @mbg.generated 2020-06-18
     */
    int insert(TCkCrkTemporay record);

    /**
     *
     * @mbg.generated 2020-06-18
     */
    int insertSelective(TCkCrkTemporay record);

    /**
     *
     * @mbg.generated 2020-06-18
     */
    TCkCrkTemporay selectByPrimaryKey(@Param("bh") String bh, @Param("dwid") String dwid, @Param("dlr") String dlr);

    /**
     *
     * @mbg.generated 2020-06-18
     */
    int updateByPrimaryKeySelective(TCkCrkTemporay record);

    /**
     *
     * @mbg.generated 2020-06-18
     */
    int updateByPrimaryKey(TCkCrkTemporay record);

    int deleteByDlr(@Param("dlr") String dlr);

    TCkCrkTemporay selectByNew(@Param("number") String number,@Param("wh") String wh);
}