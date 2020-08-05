package com.andawell.purchase.mapper;


import com.andawell.purchase.entity.TCsJglx;
import com.andawell.purchase.query.TCsJglxQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TCsJglxMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月06日 上午10:18:19
*/
public interface TCsJglxMapper {

    /**
     *
     * @mbg.generated 2020-06-06
     */
    int insert(TCsJglx record);

    /**
     *
     * @mbg.generated 2020-06-06
     */
    int insertSelective(TCsJglx record);

    /**
     * 价格类型查询
     * @param query
     * @return
     */
    List<TCsJglx> list(@Param("query") Object query);
}