package com.andawell.material.mapper;

import com.andawell.material.entity.TTzzCrkqd;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TTzzCrkqdMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月15日 上午10:54:23
*/
public interface TTzzCrkqdMapper {


    /**
     *
     * @mbg.generated 2020-05-15
     */
    int deleteByPrimaryKey(@Param("bh") String bh, @Param("jh") String jh, @Param("xh") String xh);

    /**
     *
     * @mbg.generated 2020-05-15
     */
    int insertSelective(TTzzCrkqd record);

    /**
     *
     * @mbg.generated 2020-05-15
     */
    TTzzCrkqd selectByPrimaryKey(@Param("bh") String bh, @Param("jh") String jh, @Param("xh") String xh);

    /**
     *
     * @mbg.generated 2020-05-15
     */
    int updateByPrimaryKeySelective(TTzzCrkqd record);

    List<String> listBhAndJhAndXh();

    String getMaxBh(String bh);


}