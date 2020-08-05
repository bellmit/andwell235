package com.andawell.material.mapper;

import com.andawell.material.entity.TCkJsdqd;
import org.apache.ibatis.annotations.Param;

/**
* @ClassName: TCkJsdqdMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月03日 上午09:33:53
*/
public interface TCkJsdqdMapper {

    /**
     *
     * @mbg.generated 2020-06-03
     */
    int deleteByPrimaryKey(@Param("bh") String bh, @Param("jx") String jx, @Param("jh") String jh, @Param("xh") String xh, @Param("cxsgin") String cxsgin, @Param("dwid") String dwid, @Param("xz") String xz);

    /**
     *
     * @mbg.generated 2020-06-03
     */
    int insert(TCkJsdqd record);

    /**
     *
     * @mbg.generated 2020-06-03
     */
    int insertSelective(TCkJsdqd record);

    /**
     *
     * @mbg.generated 2020-06-03
     */
    TCkJsdqd selectByPrimaryKey(@Param("bh") String bh, @Param("jx") String jx, @Param("jh") String jh, @Param("xh") String xh, @Param("cxsgin") String cxsgin, @Param("dwid") String dwid, @Param("xz") String xz);

    /**
     *
     * @mbg.generated 2020-06-03
     */
    int updateByPrimaryKeySelective(TCkJsdqd record);

    /**
     *
     * @mbg.generated 2020-06-03
     */
    int updateByPrimaryKey(TCkJsdqd record);
    /**
     *根据tCkJsd表的主键查询出该条主键对应的所有信息@mbg.generated 2020-06-03
     */
    TCkJsdqd selectTCkJsdqd(@Param("bh") String bh, @Param("jx") String jx, @Param("jh") String jh, @Param("xh") String xh, @Param("cxsgin") String cxsgin, @Param("dwid") String dwid, @Param("xz") String xz);
}