package com.andawell.purchase.mapper;

import com.andawell.purchase.entity.THtDh;

/**
* @ClassName: THtDhMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月10日 下午02:10:03
*/
public interface THtDhMapper {




    /**
     *
     * @mbg.generated 2020-06-10
     */
    int deleteByPrimaryKey(String htbh);

    /**
     *
     * @mbg.generated 2020-06-10
     */
    int insert(THtDh record);

    /**
     *
     * @mbg.generated 2020-06-10
     */
    int insertSelective(THtDh record);



    /**
     *
     * @mbg.generated 2020-06-10
     */
    THtDh selectByPrimaryKey(String htbh);


    /**
     *
     * @mbg.generated 2020-06-10
     */
    int updateByPrimaryKeySelective(THtDh record);

    /**
     *
     * @mbg.generated 2020-06-10
     */
    int updateByPrimaryKey(THtDh record);
}