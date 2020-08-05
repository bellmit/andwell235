package com.andawell.material.mapper;

import com.andawell.material.entity.TRyZw;
import com.andawell.material.entity.TXtJldw;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TRyZwMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月21日 下午02:24:20
*/
public interface TRyZwMapper {


    /**
     *
     * @mbg.generated 2020-05-21
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2020-05-21
     */
    int insert(TRyZw record);

    /**
     *
     * @mbg.generated 2020-05-21
     */
    int insertSelective(TRyZw record);


    /**
     *
     * @mbg.generated 2020-05-21
     */
    TRyZw selectByPrimaryKey(String id);



    /**
     *
     * @mbg.generated 2020-05-21
     */
    int updateByPrimaryKeySelective(TRyZw record);

    /**
     *
     * @mbg.generated 2020-05-21
     */
    int updateByPrimaryKey(TRyZw record);

    /**
     * 职务查询
     */
    List<TRyZw> list(@Param("query") Object query);

    String getMaxId();

    String getTwoMaxId(@Param("id")String id);

    List<TRyZw> listTwoZw(@Param("id")String id);

    List<TRyZw> getSqlLiteList();

    void deleteSqlLiteList();

    TRyZw selectByMc(String mc);
}