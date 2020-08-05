package com.andawell.material.mapper;

import com.andawell.material.entity.TDbDb;
import org.apache.ibatis.annotations.Param;

/**
* @ClassName: TDbDbMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月21日 下午03:34:57
*/
public interface TDbDbMapper {


    TDbDb selectByNew(@Param("number") String number,@Param("type") String type);

    /**
     *
     * @mbg.generated 2020-05-21
     */
    int deleteByPrimaryKey(String dbdh);

    /**
     *
     * @mbg.generated 2020-05-21
     */
    int insert(TDbDb record);

    /**
     *
     * @mbg.generated 2020-05-21
     */
    int insertSelective(TDbDb record);



    /**
     *
     * @mbg.generated 2020-05-21
     */
    TDbDb selectByPrimaryKey(String dbdh);


    /**
     *
     * @mbg.generated 2020-05-21
     */
    int updateByPrimaryKeySelective(TDbDb record);

    /**
     *
     * @mbg.generated 2020-05-21
     */
    int updateByPrimaryKey(TDbDb record);
}