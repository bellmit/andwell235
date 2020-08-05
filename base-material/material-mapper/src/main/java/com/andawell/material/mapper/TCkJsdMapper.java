package com.andawell.material.mapper;

import com.andawell.material.entity.TCkJsd;
import org.apache.ibatis.annotations.Param;

/**
* @ClassName: TCkJsdMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月02日 上午11:29:35
*/
public interface TCkJsdMapper {



    /**
     *
     * @mbg.generated 2020-06-02
     */
    int deleteByPrimaryKey(@Param("bh") String bh, @Param("dwid") String dwid);

    /**
     *
     * @mbg.generated 2020-06-02
     */
    int insert(TCkJsd record);

    /**
     *
     * @mbg.generated 2020-06-02
     */
    int insertSelective(TCkJsd record);



    /**
     *
     * @mbg.generated 2020-06-02
     */
    TCkJsd selectByPrimaryKey(@Param("bh") String bh, @Param("dwid") String dwid);



    /**
     *
     * @mbg.generated 2020-06-02
     */
    int updateByPrimaryKeySelective(TCkJsd record);

    /**
     *
     * @mbg.generated 2020-06-02
     */
    int updateByPrimaryKey(TCkJsd record);
    /**
     *
     * 根据tCkJsd表的主键查询出该条主键对应的所有信息
     */
    TCkJsd selectTCkJsd(@Param("bh") String bh, @Param("dwid") String dwid);
    /**
     *
     * 查询编号
     */
    String maxBh(@Param("deptId")String deptId);
}