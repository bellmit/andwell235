package com.andawell.material.mapper;

import com.andawell.material.entity.TDbSjsqTemp;
import com.andawell.material.query.TDbLtsqQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TDbSjsqTempMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月09日 下午04:48:58
*/
public interface TDbSjsqTempMapper {

    /**
     *
     * @mbg.generated 2020-06-09
     */
    int deleteByPrimaryKey(String sqdh);

    /**
     *
     * @mbg.generated 2020-06-09
     */
    int insert(TDbSjsqTemp record);

    /**
     *
     * @mbg.generated 2020-06-09
     */
    int insertSelective(TDbSjsqTemp record);


    /**
     *
     * @mbg.generated 2020-06-09
     */
    TDbSjsqTemp selectByPrimaryKey(String sqdh);


    /**
     *
     * @mbg.generated 2020-06-09
     */
    int updateByPrimaryKeySelective(TDbSjsqTemp record);

    /**
     *
     * @mbg.generated 2020-06-09
     */
    int updateByPrimaryKey(TDbSjsqTemp record);

    void deleteAll();

    List<TDbSjsqTemp> getLiset(@Param("query") TDbLtsqQuery tDbLtsqQuery);
}