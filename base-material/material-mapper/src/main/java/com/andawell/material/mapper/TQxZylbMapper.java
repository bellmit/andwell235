package com.andawell.material.mapper;

import com.andawell.material.entity.TQxZylb;
import java.util.List;

import com.andawell.material.entity.TXtJldw;
import org.apache.ibatis.annotations.Param;

/**
* @ClassName: TQxZylbMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月20日 下午01:14:09
*/
public interface TQxZylbMapper {

    void deleteSqlLiteList();

    List<TQxZylb> getSqlLiteList();
    /**
     *
     * @mbg.generated 2020-05-20
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2020-05-20
     */
    int insert(TQxZylb record);

    /**
     *
     * @mbg.generated 2020-05-20
     */
    int insertSelective(TQxZylb record);

    /**
     *
     * @mbg.generated 2020-05-20
     */
    TQxZylb selectByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2020-05-20
     */
    int updateByPrimaryKeySelective(TQxZylb record);


    String getMaxId();

    TQxZylb getByMc(String mc);

}