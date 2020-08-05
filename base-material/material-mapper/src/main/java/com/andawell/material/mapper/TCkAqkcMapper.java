package com.andawell.material.mapper;

import com.andawell.material.dto.TCkAqkcDTO;
import com.andawell.material.entity.TCkAqkc;
import com.andawell.material.entity.TCkAqkc;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TCkAqkcMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月02日 下午05:15:18
*/
public interface TCkAqkcMapper {
    /**
     *
     * @mbg.generated 2020-06-02
     */
    long countByExample(TCkAqkc example);

    /**
     *
     * @mbg.generated 2020-06-02
     */
    int deleteByExample(TCkAqkc example);

    /**
     *
     * @mbg.generated 2020-06-02
     * @param tCkAqkc
     */
    int deleteByPrimaryKey(TCkAqkc tCkAqkc);

    /**
     *
     * @mbg.generated 2020-06-02
     */
    int insert(TCkAqkc record);

    /**
     *
     * @mbg.generated 2020-06-02
     */
    int insertSelective(TCkAqkc record);

    /**
     *
     * @mbg.generated 2020-06-02
     */
    List<TCkAqkc> selectByExample(TCkAqkc example);

    /**
     *
     * @mbg.generated 2020-06-02
     */
    TCkAqkc selectByPrimaryKey(@Param("jx") String jx, @Param("jh") String jh);

    /**
     *
     * @mbg.generated 2020-06-02
     */
    int updateByExampleSelective();

    /**
     *
     * @mbg.generated 2020-06-02
     */
    int updateByExample(@Param("record") TCkAqkc record, @Param("example") TCkAqkc example);

    /**
     *
     * @mbg.generated 2020-06-02
     */
    int updateByPrimaryKeySelective(TCkAqkc record);

    /**
     *
     * @mbg.generated 2020-06-02
     */
    int updateByPrimaryKey(TCkAqkc record);
}