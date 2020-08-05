package com.andawell.material.mapper;

import com.andawell.material.entity.TDbLtsqqd;
import com.andawell.material.entity.TDbLtsqqdTemp;
import com.andawell.material.query.TDbLtsqQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TDbLtsqqdTempMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月09日 下午02:46:05
*/
public interface TDbLtsqqdTempMapper {


    List<TDbLtsqqdTemp> getList(@Param("query") TDbLtsqQuery tDbLtsqQuery);

    /**
     *
     * @mbg.generated 2020-06-09
     */
    int insert(TDbLtsqqdTemp record);

    /**
     *
     * @mbg.generated 2020-06-09
     */
    int insertSelective(TDbLtsqqdTemp record);

    int updateByPrimaryKeySelective(TDbLtsqqdTemp record);

    int deleteByPrimaryKey(String ltsqdh);
    int deleteAll();


    }