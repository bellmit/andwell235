package com.andawell.material.mapper;

import com.andawell.material.entity.TXtJldw;
import com.andawell.material.entity.TZyFjs;
import com.andawell.material.entity.TZyRwxz;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TZyFjsMapper
* @Description:
* @author: Mybatis Generator
* @date 2020年05月20日 上午11:36:56
*/
public interface TZyFjsMapper {

    List<TZyFjs> getSqlLiteList();

    void deleteSqlLiteList();

    List<TZyFjs> list(@Param("query") Object query);
    /**
     *
     * @mbg.generated 2020-05-20
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2020-05-20
     */
    int insert(TZyFjs record);

    /**
     *
     * @mbg.generated 2020-05-20
     */
    int insertSelective(TZyFjs record);


    /**
     *
     * @mbg.generated 2020-05-20
     */
    TZyFjs selectByPrimaryKey(Integer id);

    int getMaxId();

    /**
     *
     * @mbg.generated 2020-05-20
     */
    int updateByPrimaryKeySelective(TZyFjs record);

    /**
     *
     * @mbg.generated 2020-05-20
     */
    int updateByPrimaryKey(TZyFjs record);

    TZyFjs selectByMc(String mc);
}