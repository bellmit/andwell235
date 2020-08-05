package com.andawell.material.mapper;

import com.andawell.material.entity.TCkDxzbf;
import com.andawell.material.query.TCkBfkQuery;
import com.andawell.material.vo.TCkDxzbfVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TCkDxzbfMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月14日 下午05:45:46
*/
public interface TCkDxzbfMapper {
    /**
     *
     * @mbg.generated 2020-05-14
     */
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("dwid") String dwid);

    /**
     *
     * @mbg.generated 2020-05-14
     */
    int insert(TCkDxzbf record);

    /**
     *
     * @mbg.generated 2020-05-14
     */
    int insertSelective(TCkDxzbf record);

    /**
     *
     * @mbg.generated 2020-05-14
     */
    TCkDxzbf selectByPrimaryKey(@Param("id") Integer id, @Param("dwid") String dwid);

    /**
     *
     * @mbg.generated 2020-05-14
     */
    int updateByPrimaryKeySelective(TCkDxzbf record);

    /**
     *
     * @mbg.generated 2020-05-14
     */
    int updateByPrimaryKey(TCkDxzbf record);

    List<TCkDxzbfVO> warehousingList(@Param("query") TCkBfkQuery query);
}