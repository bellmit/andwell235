package com.andawell.material.mapper;

import com.andawell.material.entity.TXtBzlb;
import com.andawell.material.entity.TZyDy;

import java.util.List;

/**
* @ClassName: TXtBzlbMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年04月28日 下午04:11:10
*/
public interface TXtBzlbMapper {

    /**
     *
     * @mbg.generated 2020-04-28
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2020-04-28
     */
    int insert(TXtBzlb record);

    /**
     *
     * @mbg.generated 2020-04-28
     */
    int insertSelective(TXtBzlb record);


    /**
     *
     * @mbg.generated 2020-04-28
     */
    TXtBzlb selectByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2020-04-28
     */
    int updateByPrimaryKeySelective(TXtBzlb record);

    /**
     *
     * @mbg.generated 2020-04-28
     */
    int updateByPrimaryKey(TXtBzlb record);

    String getMaxId();

    void deleteSqlLiteList();

    List<TXtBzlb> getSqlLiteList();

    TXtBzlb selectByMc(String mc);
}