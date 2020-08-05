package com.andawell.material.mapper;

import com.andawell.material.entity.TCkCrkqdTemporay;
import org.apache.ibatis.annotations.Param;

/**
* @ClassName: TCkCrkqdTemporayMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月18日 下午02:12:05
*/
public interface TCkCrkqdTemporayMapper {
    /**
     *
     * @mbg.generated 2020-06-18
     */
    int deleteByPrimaryKey(@Param("bh") String bh, @Param("jx") String jx, @Param("jh") String jh, @Param("xh") String xh, @Param("cxsgin") String cxsgin, @Param("dwid") String dwid, @Param("xz") String xz);

    /**
     *
     * @mbg.generated 2020-06-18
     */
    int insert(TCkCrkqdTemporay record);

    /**
     *
     * @mbg.generated 2020-06-18
     */
    int insertSelective(TCkCrkqdTemporay record);

    /**
     *
     * @mbg.generated 2020-06-18
     */
    TCkCrkqdTemporay selectByPrimaryKey(@Param("bh") String bh, @Param("jx") String jx, @Param("jh") String jh, @Param("xh") String xh, @Param("cxsgin") String cxsgin, @Param("dwid") String dwid, @Param("xz") String xz);

    /**
     *
     * @mbg.generated 2020-06-18
     */
    int updateByPrimaryKeySelective(TCkCrkqdTemporay record);

    /**
     *
     * @mbg.generated 2020-06-18
     */
    int updateByPrimaryKey(TCkCrkqdTemporay record);

    int deleteByDlr(@Param("dlr") String dlr);
}