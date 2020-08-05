package com.andawell.material.mapper;

import com.andawell.material.entity.TDbDblx;
import com.andawell.material.entity.TXtJldw;

import java.util.List;

/**
* @ClassName: TDbDblxMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月20日 下午04:31:38
*/
public interface TDbDblxMapper {

    void deleteSqlLiteList();

    List<TDbDblx> getSqlLiteList();

    /**
     *
     * @mbg.generated 2020-05-20
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2020-05-20
     */
    int insert(TDbDblx record);

    /**
     *
     * @mbg.generated 2020-05-20
     */
    int insertSelective(TDbDblx record);


    /**
     *
     * @mbg.generated 2020-05-20
     */
    TDbDblx selectByPrimaryKey(String id);


    /**
     *
     * @mbg.generated 2020-05-20
     */
    int updateByPrimaryKeySelective(TDbDblx record);

    /**
     *
     * @mbg.generated 2020-05-20
     */
    int updateByPrimaryKey(TDbDblx record);

    String getMaxId();

    TDbDblx selectByMc(String mc);


}