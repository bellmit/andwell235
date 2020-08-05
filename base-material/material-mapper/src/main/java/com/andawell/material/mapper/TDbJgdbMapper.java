package com.andawell.material.mapper;

import com.andawell.material.entity.TDbJgdb;
import com.andawell.material.entity.TDbZqdb;
import com.andawell.material.query.TDbJgdbQuery;
import com.andawell.material.query.TDbLtsqQuery;
import com.andawell.material.vo.TDbSjsqVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TDbJgdbMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月29日 上午08:37:59
*/
public interface TDbJgdbMapper {


    /**
     *
     * @mbg.generated 2020-05-30
     */
    int deleteByPrimaryKey(String sqdh);

    /**
     *
     * @mbg.generated 2020-05-30
     */
    int insert(TDbJgdb record);

    /**
     *
     * @mbg.generated 2020-05-30
     */
    int insertSelective(TDbJgdb record);


    /**
     *
     * @mbg.generated 2020-05-30
     */
    TDbJgdb selectByPrimaryKey(String sqdh);


    /**
     *
     * @mbg.generated 2020-05-30
     */
    int updateByPrimaryKeySelective(TDbJgdb record);

    /**
     *
     * @mbg.generated 2020-05-30
     */
    int updateByPrimaryKey(TDbJgdb record);

    List<TDbSjsqVO> getJGDBList(@Param("query") TDbJgdbQuery query);

    TDbJgdb selectByNew(@Param("number") String number);

    List<TDbJgdb> selectByQuery(@Param("query") TDbJgdbQuery query);



}