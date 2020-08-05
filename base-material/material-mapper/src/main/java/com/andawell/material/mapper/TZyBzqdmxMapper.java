package com.andawell.material.mapper;

import com.andawell.material.entity.TZyBzqdmx;
import org.apache.ibatis.annotations.Param;

/**
* @ClassName: TZyBzqdmxMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月20日 上午11:28:39
*/
public interface TZyBzqdmxMapper {




    /**
     *
     * @mbg.generated 2020-05-20
     */
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("jh") Object jh);

    /**
     *
     * @mbg.generated 2020-05-20
     */
    int insert(TZyBzqdmx record);

    /**
     *
     * @mbg.generated 2020-05-20
     */
    int insertSelective(TZyBzqdmx record);



    /**
     *
     * @mbg.generated 2020-05-20
     */
    TZyBzqdmx selectByPrimaryKey(@Param("id") Integer id, @Param("jh") Object jh);




    /**
     *
     * @mbg.generated 2020-05-20
     */
    int updateByPrimaryKeySelective(TZyBzqdmx record);

    /**
     *
     * @mbg.generated 2020-05-20
     */
    int updateByPrimaryKey(TZyBzqdmx record);
}