package com.andawell.material.mapper;

import com.andawell.material.entity.TTzzCrk;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TTzzCrkMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月15日 上午10:53:28
*/
public interface TTzzCrkMapper {

    /**
     *
     * @mbg.generated 2020-05-15
     */
    int deleteByPrimaryKey(String bh);

    /**
     *
     * @mbg.generated 2020-05-15
     */
    int insert(TTzzCrk record);

    /**
     *
     * @mbg.generated 2020-05-15
     */
    int insertSelective(TTzzCrk record);

    /**
     *
     * @mbg.generated 2020-05-15
     */
    TTzzCrk selectByPrimaryKey(String bh);


    /**
     *
     * @mbg.generated 2020-05-15
     */
    int updateByPrimaryKeySelective(TTzzCrk record);

    /**
     *
     * @mbg.generated 2020-05-15
     */
    int updateByPrimaryKey(TTzzCrk record);

    List<String> listBh();

    String getMaxWh(@Param("wh") String wh);
}