package com.andawell.material.mapper;

import com.andawell.material.entity.TXtFcff;
import com.andawell.material.entity.VDw;
import com.andawell.material.query.TXtFcffQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TXtFcffMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月08日 下午03:40:30
*/
public interface TXtFcffMapper {

    /**
     * 查询封装方法
     * @param query
     * @return
     */
    List<TXtFcff> list(@Param("query") TXtFcffQuery query);

    /**
     *
     * @mbg.generated 2020-05-08
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2020-05-08
     */
    int insert(TXtFcff record);

    /**
     *
     * @mbg.generated 2020-05-08
     */
    int insertSelective(TXtFcff record);


    /**
     *
     * @mbg.generated 2020-05-08
     */
    TXtFcff selectByPrimaryKey(Integer id);



    /**
     *
     * @mbg.generated 2020-05-08
     */
    int updateByPrimaryKeySelective(TXtFcff record);

    /**
     *
     * @mbg.generated 2020-05-08
     */
    int updateByPrimaryKey(TXtFcff record);
}