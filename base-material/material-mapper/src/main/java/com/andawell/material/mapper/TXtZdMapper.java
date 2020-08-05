package com.andawell.material.mapper;

import com.andawell.material.entity.TXtZd;
import com.andawell.material.query.SysTXtZdQuery;
import com.andawell.material.query.TXtZdQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: TXtZdMapper
 * @Description:
 * @author: Mybatis Generator
 * @date 2020年05月06日 上午11:45:13
 */
public interface TXtZdMapper {

    /**
     * @mbg.generated 2020-05-06
     */
    int deleteByPrimaryKey(@Param("dwid") Integer dwid, @Param("zdid") Integer zdid);

    /**
     * @mbg.generated 2020-05-06
     */
    int insert(TXtZd record);

    /**
     * @mbg.generated 2020-05-06
     */
    int insertSelective(TXtZd record);


    /**
     * @mbg.generated 2020-05-06
     */
    TXtZd selectByPrimaryKey(@Param("dwid") Integer dwid, @Param("zdid") Integer zdid);


    /**
     * @mbg.generated 2020-05-06
     */
    int updateByPrimaryKeySelective(TXtZd record);

    /**
     * @mbg.generated 2020-05-06
     */
    int updateByPrimaryKey(TXtZd record);

    /**
     * 账户列表信息查询Mapper
     * @param query
     * @return
     */
    public List<TXtZd> list(@Param("query") TXtZdQuery query);
}