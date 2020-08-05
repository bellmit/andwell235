package com.andawell.purchase.mapper;

import com.andawell.purchase.entity.TDhJh;
import com.andawell.purchase.query.TDhJhQuery;
import com.andawell.purchase.vo.TDhJhVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TDhJhMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月01日 下午04:30:05
*/
public interface TDhJhMapper {
    /**
     *
     * @mbg.generated 2020-06-01
     */
    int deleteByPrimaryKey(String bh);

    /**
     *
     * @mbg.generated 2020-06-01
     */
    int insert(TDhJh record);

    /**
     *
     * @mbg.generated 2020-06-01
     */
    int insertSelective(TDhJh record);

    /**
     *
     * 获取最新业务，的编号来生成下一个计划编号
     */
    TDhJh selectByBusinessNew(@Param("number")  String number);


    /**
     *
     * @mbg.generated 2020-06-01
     */
    TDhJh selectByPrimaryKey(String bh);

    /**
     *
     * @mbg.generated 2020-06-01
     */
    int updateByPrimaryKeySelective(TDhJh record);

    /**
     *
     * @mbg.generated 2020-06-01
     */
    int updateByPrimaryKey(TDhJh record);

    List<TDhJhVO> listJhbh(@Param("query") TDhJhQuery query);

}