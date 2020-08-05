package com.andawell.purchase.mapper;

import com.andawell.purchase.entity.THt;
import com.andawell.purchase.query.THtQuery;
import com.andawell.purchase.vo.THtVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: THtMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月04日 下午01:26:31
*/
public interface THtMapper {
    /**
     *
     * @mbg.generated 2020-06-04
     */
    int deleteByPrimaryKey(@Param("hth") String hth, @Param("jhbh") String jhbh);

    /**
     *
     * @mbg.generated 2020-06-04
     */
    int insert(THt record);

    /**
     *
     * @mbg.generated 2020-06-04
     */
    int insertSelective(THt record);

    /**
     *
     * @mbg.generated 2020-06-04
     */
    THt selectByPrimaryKey(@Param("hth") String hth, @Param("jhbh") String jhbh);

    /**
     *
     * @mbg.generated 2020-06-04
     */
    int updateByPrimaryKeySelective(THt record);

    /**
     *
     * @mbg.generated 2020-06-04
     */
    int updateByPrimaryKey(THt record);

    List<THtVO> listBefore(@Param("query") THtQuery query);

    List<THtVO> listAfter(@Param("query") THtQuery query);

    int deleteByJhbh(@Param("jhbh") String jhbh);


}