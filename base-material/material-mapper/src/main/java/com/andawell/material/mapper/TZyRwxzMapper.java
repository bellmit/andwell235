package com.andawell.material.mapper;

import com.andawell.material.entity.TXtJldw;
import com.andawell.material.entity.TZyDy;
import com.andawell.material.entity.TZyRwxz;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TZyRwxzMapper
* @Description:
* @author: Mybatis Generator
* @date 2020年05月20日 下午03:00:14
*/
public interface TZyRwxzMapper {


    List<TZyRwxz> getSqlLiteList();


    List<TZyRwxz> list(@Param("query") Object query);

    /**
     *
     * @mbg.generated 2020-05-20
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2020-05-20
     */
    int insert(TZyRwxz record);

    /**
     *
     * @mbg.generated 2020-05-20
     */
    int insertSelective(TZyRwxz record);


    /**
     *
     * @mbg.generated 2020-05-20
     */
    TZyRwxz selectByPrimaryKey(Integer id);


    /**
     *
     * @mbg.generated 2020-05-20
     */
    int updateByPrimaryKeySelective(TZyRwxz record);

    /**
     *
     * @mbg.generated 2020-05-20
     */
    int updateByPrimaryKey(TZyRwxz record);

    int getMaxId();

    void deleteSqlLiteList();

    TZyRwxz selectByMc(String mc);
}