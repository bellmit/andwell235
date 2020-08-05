package com.andawell.material.mapper;

import com.andawell.material.entity.TQxYh;
import com.andawell.material.entity.TQxYhExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TQxYhMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月08日 下午01:32:17
*/
public interface TQxYhMapper {




    /**
     *
     * @mbg.generated 2020-05-08
     */
    long countByExample(TQxYhExample example);

    /**
     *
     * @mbg.generated 2020-05-08
     */
    int deleteByExample(TQxYhExample example);

    /**
     *
     * @mbg.generated 2020-05-08
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2020-05-08
     */
    int insert(TQxYh record);

    /**
     *
     * @mbg.generated 2020-05-08
     */
    int insertSelective(TQxYh record);

    /**
     *
     * @mbg.generated 2020-05-08
     */
    List<TQxYh> selectByExample(TQxYhExample example);

    /**
     *
     * @mbg.generated 2020-05-08
     */
    TQxYh selectByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2020-05-08
     */
    int updateByExampleSelective(@Param("record") TQxYh record, @Param("example") TQxYhExample example);

    /**
     *
     * @mbg.generated 2020-05-08
     */
    int updateByExample(@Param("record") TQxYh record, @Param("example") TQxYhExample example);

    /**
     *
     * @mbg.generated 2020-05-08
     */
    int updateByPrimaryKeySelective(TQxYh record);

    /**
     *
     * @mbg.generated 2020-05-08
     */
    int updateByPrimaryKey(TQxYh record);
}