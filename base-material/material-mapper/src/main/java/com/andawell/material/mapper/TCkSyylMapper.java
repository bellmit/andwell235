package com.andawell.material.mapper;

import com.andawell.material.entity.TCkSyyl;
import com.andawell.material.query.TCkSyylQuery;
import com.andawell.material.query.VDwQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TCkSyylMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月08日 下午04:28:53
*/
@Mapper
public interface TCkSyylMapper {

    List<TCkSyyl> list(@Param("query") TCkSyylQuery query);

    /**
     *
     * @mbg.generated 2020-05-08
     */
    int insert(TCkSyyl record);

    /**
     *
     * @mbg.generated 2020-05-08
     */
    int insertSelective(TCkSyyl record);


}