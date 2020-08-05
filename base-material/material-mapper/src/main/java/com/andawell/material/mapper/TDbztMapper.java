package com.andawell.material.mapper;

import com.andawell.material.entity.TDbzt;
import java.util.List;

import com.andawell.material.entity.TXtJldw;
import org.apache.ibatis.annotations.Param;

/**
* @ClassName: TDbztMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月21日 上午08:46:48
*/
public interface TDbztMapper {

    void deleteSqlLiteList();

    List<TDbzt> getSqlLiteList();
    /**
     *
     * @mbg.generated 2020-05-21
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2020-05-21
     */
    int insert(TDbzt record);

    /**
     *
     * @mbg.generated 2020-05-21
     */
    int insertSelective(TDbzt record);

    /**
     *
     * @mbg.generated 2020-05-21
     */
    TDbzt selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2020-05-21
     */
    int updateByPrimaryKeySelective(TDbzt record);

    /**
     *
     * @mbg.generated 2020-05-21
     */
    int updateByPrimaryKey(TDbzt record);

    String getMaxId();

    TDbzt getByMc(String mc);

}