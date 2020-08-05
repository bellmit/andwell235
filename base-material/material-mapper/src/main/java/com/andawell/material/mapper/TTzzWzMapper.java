package com.andawell.material.mapper;

import com.andawell.material.entity.TTzzWz;
import com.andawell.material.query.TTzzWzQuery;
import com.andawell.material.vo.TTzzWzVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TTzzWzMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月13日 上午11:16:54
*/
public interface TTzzWzMapper {

    /**
     *
     * @mbg.generated 2020-05-13
     */
    int deleteByPrimaryKey(String jh);

    /**
     *
     * @mbg.generated 2020-05-13
     */
    int insert(TTzzWz record);

    /**
     *
     * @mbg.generated 2020-05-13
     */
    int insertSelective(TTzzWz record);


    /**
     *
     * @mbg.generated 2020-05-13
     */
    TTzzWz selectByPrimaryKey(String jh);

    /**
     *
     * @mbg.generated 2020-05-13
     */
    int updateByPrimaryKeySelective(TTzzWz record);

    /**
     *
     * @mbg.generated 2020-05-13
     */
    int updateByPrimaryKey(TTzzWz record);

    List<TTzzWzVO> list(@Param("query") TTzzWzQuery query);
}