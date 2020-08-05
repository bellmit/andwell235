package com.andawell.material.mapper;

import com.andawell.material.entity.TXtJldw;
import com.andawell.material.entity.TZyFjs;
import com.andawell.material.entity.TZyRwsc;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TZyRwscMapper
* @Description:
* @author: Mybatis Generator
* @date 2020年05月20日 下午03:29:10
*/
public interface TZyRwscMapper {



    List<TZyRwsc> list(@Param("query") Object query);
    /**
     *
     * @mbg.generated 2020-05-20
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2020-05-20
     */
    int insert(TZyRwsc record);

    /**
     *
     * @mbg.generated 2020-05-20
     */
    int insertSelective(TZyRwsc record);


    /**
     *
     * @mbg.generated 2020-05-20
     */
    TZyRwsc selectByPrimaryKey(Integer id);


    /**
     *
     * @mbg.generated 2020-05-20
     */
    int updateByPrimaryKeySelective(TZyRwsc record);

    /**
     *
     * @mbg.generated 2020-05-20
     */
    int updateByPrimaryKey(TZyRwsc record);

    int getMaxId();

    List<TZyRwsc> getSqlLiteList();

    void deleteSqlLiteList();

    TZyRwsc selectByMc(String mc);

}