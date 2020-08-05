package com.andawell.material.mapper;

import com.andawell.material.entity.TDbDblb;
import com.andawell.material.query.TDbDblbQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TDbDblbMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月05日 上午09:12:59
*/
public interface TDbDblbMapper {

    /**
     *
     * @mbg.generated 2020-06-05
     */
    int insert(TDbDblb record);

    /**
     *
     * @mbg.generated 2020-06-05
     */
    int insertSelective(TDbDblb record);

    List<TDbDblb> list(@Param("query")TDbDblbQuery query);


}