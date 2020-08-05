package com.andawell.material.mapper;

import com.andawell.material.entity.TDbZqdb;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TDbZqdbMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月30日 上午10:33:08
*/
public interface TDbZqdbMapper {

    TDbZqdb selectByNew(@Param("number") String number, @Param("type") String type);


    /**
     *
     * @mbg.generated 2020-05-30
     */
    int deleteByPrimaryKey(String dbdh);

    /**
     *
     * @mbg.generated 2020-05-30
     */
    int insert(TDbZqdb record);

    /**
     *
     * @mbg.generated 2020-05-30
     */
    int insertSelective(TDbZqdb record);



    /**
     *
     * @mbg.generated 2020-05-30
     */
    TDbZqdb selectByPrimaryKey(String dbdh);



    /**
     *
     * @mbg.generated 2020-05-30
     */
    int updateByPrimaryKeySelective(TDbZqdb record);

    /**
     *
     * @mbg.generated 2020-05-30
     */
    int updateByPrimaryKey(TDbZqdb record);

    List<TDbZqdb> list();
}