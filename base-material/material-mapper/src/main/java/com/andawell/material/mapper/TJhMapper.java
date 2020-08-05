package com.andawell.material.mapper;

import com.andawell.material.entity.TJh;
import com.andawell.material.query.JhQuery;
import com.andawell.material.vo.TJhJhVO;
import com.andawell.material.vo.TJhVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TJhMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年04月28日 下午04:11:10
*/
public interface TJhMapper {


    List<TJhVO> getListByjx(@Param("query") JhQuery jhQuery);


    /**
     *
     * @mbg.generated 2020-04-28
     */
    int insert(TJh record);

    /**
     *
     * @mbg.generated 2020-04-28
     */
    int insertSelective(TJh record);


}