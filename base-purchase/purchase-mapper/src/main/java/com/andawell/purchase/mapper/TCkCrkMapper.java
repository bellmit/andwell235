package com.andawell.purchase.mapper;


import com.andawell.purchase.entity.TCkCrk;
import org.apache.ibatis.annotations.Param;

/**
* @ClassName: TCkCrkMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月12日 上午10:07:29
*/
public interface TCkCrkMapper {


    /**
     *
     * @mbg.generated 2020-06-12
     */
    int deleteByPrimaryKey(@Param("bh") String bh, @Param("dwid") String dwid);

    /**
     *
     * @mbg.generated 2020-06-12
     */
    int insert(TCkCrk record);

    /**
     *
     * @mbg.generated 2020-06-12
     */
    int insertSelective(TCkCrk record);



    /**
     *
     * @mbg.generated 2020-06-12
     */
    TCkCrk selectByPrimaryKey(@Param("bh") String bh, @Param("dwid") String dwid);


    /**
     *
     * @mbg.generated 2020-06-12
     */
    int updateByPrimaryKeySelective(TCkCrk record);

    /**
     *
     * @mbg.generated 2020-06-12
     */
    int updateByPrimaryKey(TCkCrk record);
}