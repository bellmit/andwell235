package com.andawell.material.mapper;


import com.andawell.material.entity.TJhJhhh;
import org.apache.ibatis.annotations.Param;

/**
* @ClassName: TJhJhhhMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月20日 下午04:18:06
*/
public interface TJhJhhhMapper {

    /**
     *
     * @mbg.generated 2020-05-20
     */
    int deleteByPrimaryKey(@Param("jh") String jh, @Param("thjh") String thjh);

    /**
     *
     * @mbg.generated 2020-05-20
     */
    int insert(TJhJhhh record);

    /**
     *
     * @mbg.generated 2020-05-20
     */
    int insertSelective(TJhJhhh record);



    /**
     *
     * @mbg.generated 2020-05-20
     */
    TJhJhhh selectByPrimaryKey(@Param("jh") String jh, @Param("thjh") String thjh);



    /**
     *
     * @mbg.generated 2020-05-20
     */
    int updateByPrimaryKeySelective(TJhJhhh record);

    /**
     *
     * @mbg.generated 2020-05-20
     */
    int updateByPrimaryKey(TJhJhhh record);
}