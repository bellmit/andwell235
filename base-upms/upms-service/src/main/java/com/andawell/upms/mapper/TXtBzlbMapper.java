package com.andawell.upms.mapper;

import com.andawell.upms.entity.TXtBzlb;
import com.andawell.upms.query.TXtBzlbQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TXtBzlbMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月11日 上午09:35:53
*/
public interface TXtBzlbMapper {

    /**
     *
     * @mbg.generated 2020-05-11
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2020-05-11
     */
    int insert(TXtBzlb record);

    /**
     *
     * @mbg.generated 2020-05-11
     */
    int insertSelective(TXtBzlb record);

    /**
     *
     * @mbg.generated 2020-05-11
     */
    TXtBzlb selectByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2020-05-11
     */
    int updateByPrimaryKeySelective(TXtBzlb record);

    /**
     *
     * @mbg.generated 2020-05-11
     */
    int updateByPrimaryKey(TXtBzlb record);

    List<TXtBzlb> list(@Param("query") TXtBzlbQuery query);
}