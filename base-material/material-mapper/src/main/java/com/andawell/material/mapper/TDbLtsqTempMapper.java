package com.andawell.material.mapper;

import com.andawell.material.entity.TDbLtsqTemp;
import com.andawell.material.query.TDbLtsqQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TDbLtsqTempMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月09日 下午02:39:34
*/
public interface TDbLtsqTempMapper {


    List<TDbLtsqTemp> getList(@Param("query") TDbLtsqQuery tDbLtsqQuery);

    /**
     *
     * @mbg.generated 2020-06-09
     */
    int deleteByPrimaryKey(String ltsqdh);
    int deleteAll();

    /**
     *
     * @mbg.generated 2020-06-09
     */
    int insert(TDbLtsqTemp record);

    /**
     *
     * @mbg.generated 2020-06-09
     */
    int insertSelective(TDbLtsqTemp record);


    /**
     *
     * @mbg.generated 2020-06-09
     */
    TDbLtsqTemp selectByPrimaryKey(String ltsqdh);





    /**
     *
     * @mbg.generated 2020-06-09
     */
    int updateByPrimaryKeySelective(TDbLtsqTemp record);

    /**
     *
     * @mbg.generated 2020-06-09
     */
    int updateByPrimaryKey(TDbLtsqTemp record);
}