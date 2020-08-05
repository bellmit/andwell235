package com.andawell.material.mapper;

import com.andawell.material.entity.TJhImage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TJhImageMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月07日 下午03:28:07
*/
@Mapper
public interface TJhImageMapper {
    /**
     *
     * @mbg.generated 2020-05-07
     */


    /**
     *
     * @mbg.generated 2020-05-07
     */


    /**
     *
     * @mbg.generated 2020-05-07
     */
    int deleteByPrimaryKey(String jh);

    /**
     *
     * @mbg.generated 2020-05-07
     */
    int insert(TJhImage record);

    /**
     *
     * @mbg.generated 2020-05-07
     */
    int insertSelective(TJhImage record);



    /**
     *
     * @mbg.generated 2020-05-07
     */
    TJhImage selectByPrimaryKey(String jh);

    /**
     *
     * @mbg.generated 2020-05-07
     */


    /**
     *
     * @mbg.generated 2020-05-07
     */
    int updateByPrimaryKeySelective(TJhImage record);

    /**
     *
     * @mbg.generated 2020-05-07
     */
    int updateByPrimaryKeyWithBLOBs(TJhImage record);
}