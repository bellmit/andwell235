package com.andawell.material.mapper;

import com.andawell.material.dto.TXhpCkDTO;
import com.andawell.material.entity.TXhpCk;
import com.andawell.material.entity.TXhpCkCx;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
* @ClassName: TXhpCkMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月07日 下午03:58:17
*/
public interface TXhpCkMapper {

    /**
     *
     * @mbg.generated 2020-05-07
     */
    int deleteByPrimaryKey(@Param("pch") String pch, @Param("mc") String mc, @Param("gg") String gg);

    /**
     *
     * @mbg.generated 2020-05-07
     */
    int insert(TXhpCk record);

    /**
     *
     * @mbg.generated 2020-05-07
     */
    int insertSelective(TXhpCk record);


    /**
     *
     * @mbg.generated 2020-05-07
     */
    TXhpCk selectByPrimaryKey(@Param("pch") String pch, @Param("mc") String mc, @Param("gg") String gg);



    /**
     *
     * @mbg.generated 2020-05-07
     */
    int updateByPrimaryKeySelective(TXhpCk record);

    /**
     *
     * @mbg.generated 2020-05-07
     */
    int updateByPrimaryKey(TXhpCk record);

    List<TXhpCk> list();


    /**
     * 根据名称，规格，批次号，核减数量
     */
    int updateByMcAndGgAndPch(@Param("query") Object query);

}