package com.andawell.material.mapper;

import com.andawell.material.entity.TCfLb;
import com.andawell.material.entity.TZyDy;
import com.andawell.material.query.TXtFcffQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: TZyDyMapper
 * @Description:
 * @author: Mybatis Generator
 * @date 2020年05月20日 上午10:57:16
 */
public interface TZyDyMapper {


    List<TZyDy> list(@Param("query") Object query);

    /**
     *
     * @mbg.generated 2020-05-20
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2020-05-20
     */
    int insert(TZyDy record);

    /**
     *
     * @mbg.generated 2020-05-20
     */
    int insertSelective(TZyDy record);


    /**
     *
     * @mbg.generated 2020-05-20
     */
    TZyDy selectByPrimaryKey(Integer id);





    /**
     *
     * @mbg.generated 2020-05-20
     */
    int updateByPrimaryKeySelective(TZyDy record);

    /**
     *
     * @mbg.generated 2020-05-20
     */
    int updateByPrimaryKey(TZyDy record);


    int getMaxId();

    List<TZyDy> getSqlLiteList();

    void deleteSqlLiteList();

    TZyDy selectByMc(String mc);
}