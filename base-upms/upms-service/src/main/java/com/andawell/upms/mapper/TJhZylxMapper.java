package com.andawell.upms.mapper;

import com.andawell.upms.entity.TJhZylx;
import com.andawell.upms.query.TJhZylxQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TJhZylxMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月11日 下午01:26:51
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