package com.andawell.purchase.mapper;

import com.andawell.purchase.entity.THtQdTemp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: THtQdTempMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月11日 下午03:21:02
*/
public interface THtQdTempMapper {
    /**
     *
     * @mbg.generated 2020-06-11
     */
    int deleteByPrimaryKey(THtQdTemp record);

    /**
     *
     * @mbg.generated 2020-06-11
     */
    int insert(THtQdTemp record);

    /**
     *
     * @mbg.generated 2020-06-11
     */
    int insertSelective(THtQdTemp record);

    /**
     *
     * @mbg.generated 2020-06-11
     */
    THtQdTemp selectByPrimaryKey(@Param("hth") String hth,
                                 @Param("jhbh") String jhbh,
                                 @Param("jx") String jx,
                                 @Param("jh") String jh);

    /**
     *
     * @mbg.generated 2020-06-11
     */
    int updateByPrimaryKeySelective(THtQdTemp record);

    /**
     *
     * @mbg.generated 2020-06-11
     */
    int updateByPrimaryKey(THtQdTemp record);

    /**
     * 批量获取
     * @param hth
     * @param jhbh
     * @return
     */
    List<THtQdTemp> getList(@Param("hth") String hth, @Param("jhbh") String jhbh);
}