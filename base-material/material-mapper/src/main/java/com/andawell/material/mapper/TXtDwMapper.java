package com.andawell.material.mapper;

import com.andawell.material.entity.TXtDw;
import com.andawell.material.entity.TXtJldw;
import com.andawell.material.query.TXtDwQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: TXtDwMapper
 * @Description:
 * @author: Mybatis Generator
 * @date 2020年06月08日 下午01:24:04
 */
public interface TXtDwMapper {

    List<TXtDw> getSqlLiteList();

    String selectMc(String s);

    void deleteSqlLiteList();

    int insertSelective(TXtDw record);

    List<TXtDw> getList(@Param("query") TXtDwQuery query);

    TXtDw selectByid(String id);

    List<TXtDw> selectByPid(String pid);
}