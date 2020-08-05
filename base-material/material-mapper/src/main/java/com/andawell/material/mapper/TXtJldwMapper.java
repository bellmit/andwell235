package com.andawell.material.mapper;

import com.andawell.material.entity.TXtBzlb;
import com.andawell.material.entity.TXtJldw;
import com.andawell.material.query.TXtJldwQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TXtJldwMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月09日 上午09:42:04
*/
public interface TXtJldwMapper {

    /**
     *
     * @mbg.generated 2020-05-09
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2020-05-09
     */
    int insert(TXtJldw record);

    /**
     *
     * @mbg.generated 2020-05-09
     */
    int insertSelective(TXtJldw record);


    /**
     *
     * @mbg.generated 2020-05-09
     */
    TXtJldw selectByPrimaryKey(String id);


    /**
     *
     * @mbg.generated 2020-05-09
     */
    int updateByPrimaryKeySelective(TXtJldw record);

    /**
     *
     * @mbg.generated 2020-05-09
     */
    int updateByPrimaryKey(TXtJldw record);


    List<TXtJldw> getList(@Param("query")TXtJldwQuery query);

    String getMaxId();

    List<TXtJldw> getSqlLiteList();

    void deleteSqlLiteList();

    TXtJldw selectByMc(String mc);
}