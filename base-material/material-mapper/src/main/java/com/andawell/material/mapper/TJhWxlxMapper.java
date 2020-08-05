package com.andawell.material.mapper;

import com.andawell.material.entity.TJhWxlx;
import java.util.List;

import com.andawell.material.entity.TXtJldw;
import org.apache.ibatis.annotations.Param;

/**
* @ClassName: TJhWxlxMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月21日 上午09:43:02
*/
public interface TJhWxlxMapper {

    void deleteSqlLiteList();

    List<TJhWxlx> getSqlLiteList();
    /**
     *
     * @mbg.generated 2020-05-21
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2020-05-21
     */
    int insert(TJhWxlx record);

    /**
     *
     * @mbg.generated 2020-05-21
     */
    int insertSelective(TJhWxlx record);

    /**
     *
     * @mbg.generated 2020-05-21
     */
    TJhWxlx selectByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2020-05-21
     */
    int updateByPrimaryKeySelective(TJhWxlx record);

    /**
     *
     * @mbg.generated 2020-05-21
     */
    int updateByPrimaryKey(TJhWxlx record);

    String getMaxId();

    TJhWxlx getByMc(String mc);
}