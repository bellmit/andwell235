package com.andawell.material.mapper;

import com.andawell.material.entity.response.THtDhBO;
import com.andawell.material.entity.THtDh;
import com.andawell.material.query.THtDhQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: THtDhMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年04月28日 下午01:16:11
*/
@Mapper
public interface THtDhMapper {

    /**
     *
     * @mbg.generated 2020-04-28
     */
    int deleteByPrimaryKey(String htbh);

    /**
     *
     * @mbg.generated 2020-04-28
     */
    int insert(THtDh record);

    /**
     *
     * @mbg.generated 2020-04-28
     */
    int insertSelective(THtDh record);



    /**
     *
     * @mbg.generated 2020-04-28
     */
    THtDh selectByPrimaryKey(String htbh);

    /**
     *
     * @mbg.generated 2020-04-28
     */
    int updateByPrimaryKeySelective(THtDh record);

    /**
     *
     * @mbg.generated 2020-04-28
     */
    int updateByPrimaryKey(THtDh record);

    /**
     * 条件查询合同列表
     * @param query
     * @return
     */
    List<THtDh> list(@Param("query")THtDhQuery query);

    List<THtDhBO> getListAndCfmc(@Param("jx")String jx);
}