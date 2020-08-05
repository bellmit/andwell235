package com.andawell.material.mapper;

import com.andawell.material.entity.TQxYh;
import com.andawell.material.entity.VDw;
import com.andawell.material.query.VDwQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
* @ClassName: VDwMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年04月30日 下午02:01:35
*/
public interface VDwMapper {


    List<VDw> getUserBranchDW(@Param("dw") String dw);

    /**
     *
     * @mbg.generated 2020-04-30
     */
    int insert(VDw record);

    /**
     *
     * @mbg.generated 2020-04-30
     */
    int insertSelective(VDw record);

    List<VDw> list(@Param("query") VDwQuery query);
}