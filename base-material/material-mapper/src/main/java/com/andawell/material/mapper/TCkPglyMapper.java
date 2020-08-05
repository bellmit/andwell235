package com.andawell.material.mapper;

import com.andawell.material.entity.TCkPgly;
import com.andawell.material.query.TCkPglyQuery;
import com.andawell.material.vo.TCkPglyVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TCkPglyMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月15日 下午05:09:48
*/
public interface TCkPglyMapper {
    /**
     *
     * @mbg.generated 2020-05-15
     */
    int deleteByPrimaryKey(@Param("bh") String bh, @Param("dwid") String dwid);

    /**
     *
     * @mbg.generated 2020-05-15
     */
    int insert(TCkPgly record);

    /**
     *
     * @mbg.generated 2020-05-15
     */
    int insertSelective(TCkPgly record);

    /**
     *
     * @mbg.generated 2020-05-15
     */
    TCkPgly selectByPrimaryKey(@Param("bh") String bh, @Param("dwid") String dwid);

    /**
     *
     * @mbg.generated 2020-05-15
     */
    int updateByPrimaryKeySelective(TCkPgly record);

    /**
     *
     * @mbg.generated 2020-05-15
     */
    int updateByPrimaryKey(TCkPgly record);

    List<TCkPglyVo> selectByJx(@Param("query") TCkPglyQuery tCkPglyQuery);

    /**
     *@Author: liuys
     *@Data: 2020/5/18
     *@Description: 查询最新的一条
     */
    TCkPgly selectByYjrqOne();

}