package com.andawell.material.mapper;

import com.andawell.material.entity.TJhPtjh;
import org.apache.ibatis.annotations.Param;

/**
* @ClassName: TJhPtjhMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月20日 下午02:32:20
*/
public interface TJhPtjhMapper {


    /**
     *
     * @mbg.generated 2020-05-20
     */
    int deleteByPrimaryKey(@Param("jh") String jh, @Param("ptjh") String ptjh, @Param("jx") String jx);

    /**
     *
     * @mbg.generated 2020-05-20
     */
    int insert(TJhPtjh record);

    /**
     *
     * @mbg.generated 2020-05-20
     */
    int insertSelective(TJhPtjh record);


    /**
     *
     * @mbg.generated 2020-05-20
     */
    TJhPtjh selectByPrimaryKey(@Param("jh") String jh, @Param("ptjh") String ptjh, @Param("jx") String jx);



    /**
     *
     * @mbg.generated 2020-05-20
     */
    int updateByPrimaryKeySelective(TJhPtjh record);

    /**
     *
     * @mbg.generated 2020-05-20
     */
    int updateByPrimaryKey(TJhPtjh record);
}