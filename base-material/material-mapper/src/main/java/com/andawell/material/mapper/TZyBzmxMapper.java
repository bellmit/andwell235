package com.andawell.material.mapper;

import com.andawell.material.entity.TZyBzmx;
import org.apache.ibatis.annotations.Param;

/**
* @ClassName: TZyBzmxMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月20日 下午05:00:17
*/
public interface TZyBzmxMapper {




    /**
     *
     * @mbg.generated 2020-05-20
     */
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("jh") Object jh);

    /**
     *
     * @mbg.generated 2020-05-20
     */
    int insert(TZyBzmx record);

    /**
     *
     * @mbg.generated 2020-05-20
     */
    int insertSelective(TZyBzmx record);


    /**
     *
     * @mbg.generated 2020-05-20
     */
    TZyBzmx selectByPrimaryKey(@Param("id") Integer id, @Param("jh") Object jh);

    /**
     *
     * @mbg.generated 2020-05-20
     */
    int updateByPrimaryKeySelective(TZyBzmx record);

    /**
     *
     * @mbg.generated 2020-05-20
     */
    int updateByPrimaryKey(TZyBzmx record);
}