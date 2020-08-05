package com.andawell.material.mapper;

import com.andawell.material.entity.TTzzCkTemp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TTzzCkTempMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月14日 上午11:47:59
*/
public interface TTzzCkTempMapper {

    /**
     *
     * @mbg.generated 2020-05-14
     */
    int insertSelective(TTzzCkTemp record);

    List<String> getJhAndXh();

    void insertAll(List<TTzzCkTemp> tTzzCkTempList);

    void deleteAll();

}