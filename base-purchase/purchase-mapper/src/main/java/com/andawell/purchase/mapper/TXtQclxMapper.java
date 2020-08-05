package com.andawell.purchase.mapper;

import com.andawell.purchase.entity.TXtQclx;
import com.andawell.purchase.query.TXtQcLxQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TXtQclxMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月29日 下午02:51:25
*/
public interface TXtQclxMapper {
    /**
     *
     * @mbg.generated 2020-05-29
     */
    int insert(TXtQclx record);

    /**
     *
     * @mbg.generated 2020-05-29
     */
    int insertSelective(TXtQclx record);

    /**
     * 根据名称查询
     * @param qcLx
     * @return
     */
     String selectIdByQcMc(String qcLx);

    /**
     * 器材类型查询
     * @param query
     * @return
     */
    List<TXtQclx> list(@Param("query") Object query);

}