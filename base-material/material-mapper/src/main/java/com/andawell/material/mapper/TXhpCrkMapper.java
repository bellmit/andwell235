package com.andawell.material.mapper;

import com.andawell.material.entity.TXhpCrk;
import com.andawell.material.query.TXhpCrkQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TXhpCrkMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月07日 下午02:08:49
*/
public interface TXhpCrkMapper {

    /**
     *
     * @mbg.generated 2020-05-07
     */
    int deleteByPrimaryKey(String bh);

    /**
     *
     * @mbg.generated 2020-05-07
     */
    int insert(TXhpCrk record);

    /**
     *
     * @mbg.generated 2020-05-07
     */
    int insertSelective(TXhpCrk record);


    /**
     *
     * @mbg.generated 2020-05-07
     */
    TXhpCrk selectByPrimaryKey(String bh);



    /**
     *
     * @mbg.generated 2020-05-07
     */
    int updateByPrimaryKeySelective(TXhpCrk record);

    /**
     *
     * @mbg.generated 2020-05-07
     */
    int updateByPrimaryKey(TXhpCrk record);

    /***
     * @author gzh
     * @Date: 2020/4/28 14:36
     * @Description: 来源单位查询
     */
    List<TXhpCrk> lydwList(@Param("query")Object query);
    /**
     * @author gzh
     * @Date: 2020/4/28 14:36
     * 查询最大批次号
     * */
    Integer selectPch(@Param("date")String date);
}