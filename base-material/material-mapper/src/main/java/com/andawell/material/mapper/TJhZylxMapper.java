package com.andawell.material.mapper;

import com.andawell.material.entity.TJhZylx;
import com.andawell.material.query.TJhZylxQuery;
import com.andawell.material.query.TXtXljbQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TJhZylxMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月11日 下午02:44:19
*/
public interface TJhZylxMapper {
    /**
     *
     * @mbg.generated 2020-05-11
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2020-05-11
     */
    int insert(TJhZylx record);

    /**
     *
     * @mbg.generated 2020-05-11
     */
    int insertSelective(TJhZylx record);

    /**
     *
     * @mbg.generated 2020-05-11
     */
    TJhZylx selectByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2020-05-11
     */
    int updateByPrimaryKeySelective(TJhZylx record);

    /**
     *
     * @mbg.generated 2020-05-11
     */
    int updateByPrimaryKey(TJhZylx record);

    List<TJhZylx> list(@Param("query") TJhZylxQuery query);
}