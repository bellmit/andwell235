package com.andawell.material.mapper;

import com.andawell.material.entity.TZyBz;

/**
* @ClassName: TZyBzMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月20日 下午04:51:45
*/
public interface TZyBzMapper {


    /**
     * 过去最大id
     */
    int getMaxID();

    /**
     *
     * @mbg.generated 2020-05-20
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2020-05-20
     */
    int insert(TZyBz record);

    /**
     *
     * @mbg.generated 2020-05-20
     */
    int insertSelective(TZyBz record);



    /**
     *
     * @mbg.generated 2020-05-20
     */
    TZyBz selectByPrimaryKey(Integer id);



    /**
     *
     * @mbg.generated 2020-05-20
     */
    int updateByPrimaryKeySelective(TZyBz record);

    /**
     *
     * @mbg.generated 2020-05-20
     */
    int updateByPrimaryKey(TZyBz record);
}