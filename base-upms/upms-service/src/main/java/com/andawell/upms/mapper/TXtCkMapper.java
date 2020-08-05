package com.andawell.upms.mapper;

import com.andawell.upms.entity.TXtCk;

import java.util.List;

import com.andawell.upms.query.TXtCkQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @ClassName: TXtCkMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月07日 下午02:34:58
*/

public interface TXtCkMapper {

    /**
     *
     * @mbg.generated 2020-05-07
     */
    int deleteByPrimaryKey(@Param("dwid") String dwid, @Param("ckid") String ckid);

    /**
     *
     * @mbg.generated 2020-05-07
     */
    int insert(TXtCk record);

    /**
     *
     * @mbg.generated 2020-05-07
     */
    int insertSelective(TXtCk record);

    /**
     *
     * @mbg.generated 2020-05-07
     */
    TXtCk selectByPrimaryKey(@Param("dwid") String dwid, @Param("ckid") String ckid);

    /**
     *
     * @mbg.generated 2020-05-07
     */
    int updateByPrimaryKeySelective(TXtCk record);

    /**
     *
     * @mbg.generated 2020-05-07
     */
    int updateByPrimaryKey(TXtCk record);

    List<TXtCk> list(@Param("query") TXtCkQuery query);

    Integer getMaxCkid(String dwid);

}