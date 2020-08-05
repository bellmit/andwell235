package com.andawell.material.mapper;

import com.andawell.material.entity.TZbBz;
import org.apache.ibatis.annotations.Param;

/**
* @ClassName: TZbBzMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月21日 上午10:34:42
*/
public interface TZbBzMapper {

    /**
     *
     * @mbg.generated 2020-05-21
     */
    int deleteByPrimaryKey(@Param("dwid") String dwid, @Param("jx") String jx, @Param("jh") String jh);

    /**
     *
     * @mbg.generated 2020-05-21
     */
    int insert(TZbBz record);

    /**
     *
     * @mbg.generated 2020-05-21
     */
    int insertSelective(TZbBz record);



    /**
     *
     * @mbg.generated 2020-05-21
     */
    TZbBz selectByPrimaryKey(@Param("dwid") String dwid, @Param("jx") String jx, @Param("jh") String jh);



    /**
     *
     * @mbg.generated 2020-05-21
     */
    int updateByPrimaryKeySelective(TZbBz record);

    /**
     *
     * @mbg.generated 2020-05-21
     */
    int updateByPrimaryKey(TZbBz record);
}