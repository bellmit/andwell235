package com.andawell.upms.mapper;

import com.andawell.upms.entity.TXtDw;
import com.andawell.upms.query.TXtDwQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Property;

import java.util.List;

/**
 * @ClassName: TXtDwMapper
 * @Description:
 * @author: Mybatis Generator
 * @date 2020年05月07日 上午11:16:52
 */

public interface TXtDwMapper {

    /**
     * 查询
     * @param q
     * @return
     */
    List<TXtDw> list(@Param("query") TXtDwQuery q);

    /**
     *
     * @mbg.generated 2020-05-07
     */
    int deleteByPrimaryKey(@Param("id") String id);

    /**
     *
     * @mbg.generated 2020-05-07
     */
    int insert(TXtDw record);

    /**
     *
     * @mbg.generated 2020-05-07
     */
    int insertSelective(TXtDw record);

    /**
     *
     * @mbg.generated 2020-05-07
     */
    TXtDw selectByPrimaryKey(@Param("id") String id);


    /**
     *
     * @mbg.generated 2020-05-07
     */
    int updateByPrimaryKeySelective(TXtDw record);


    String getMaxByPid(String pid);


    String getMax2LengthId();

}