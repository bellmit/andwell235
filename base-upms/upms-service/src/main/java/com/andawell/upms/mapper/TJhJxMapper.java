package com.andawell.upms.mapper;


import com.andawell.upms.entity.TJhJx;

import java.util.List;

/**
* @ClassName: TJhJxMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年07月01日 上午11:06:59
*/
public interface TJhJxMapper {



    /**
     *
     * @mbg.generated 2020-07-01
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2020-07-01
     */
    int insert(TJhJx record);

    /**
     *
     * @mbg.generated 2020-07-01
     */
    int insertSelective(TJhJx record);


    /**
     *
     * @mbg.generated 2020-07-01
     */
    TJhJx selectByPrimaryKey(String id);



    /**
     *
     * @mbg.generated 2020-07-01
     */
    int updateByPrimaryKeySelective(TJhJx record);

    /**
     *
     * @mbg.generated 2020-07-01
     */
    int updateByPrimaryKey(TJhJx record);

    List<TJhJx> selectByPid(String id);
}