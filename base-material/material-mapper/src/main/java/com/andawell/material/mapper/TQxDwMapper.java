package com.andawell.material.mapper;

import com.andawell.material.entity.TQxDw;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TQxDwMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月26日 上午10:37:39
*/
public interface TQxDwMapper {


    List<TQxDw> getTQxdwByUserDw(@Param("dw") String dw);

    /**
     * @mbg.generated 2020-05-26
     */
    int insert(TQxDw record);

    /**
     * @mbg.generated 2020-05-26
     */
    int insertSelective(TQxDw record);


}