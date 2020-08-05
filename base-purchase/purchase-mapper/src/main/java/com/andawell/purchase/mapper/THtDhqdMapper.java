package com.andawell.purchase.mapper;

import com.andawell.purchase.entity.THtDhqd;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: THtDhqdMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月22日 下午05:14:47
*/
public interface THtDhqdMapper {
    /**
     *
     * @mbg.generated 2020-06-22
     */
    int deleteByPrimaryKey(@Param("htbh") String htbh, @Param("jx") String jx, @Param("jh") String jh);

    /**
     *
     * @mbg.generated 2020-06-22
     */
    int insert(THtDhqd record);

    /**
     *
     * @mbg.generated 2020-06-22
     */
    int insertSelective(THtDhqd record);

    /**
     *
     * @mbg.generated 2020-06-22
     */
    THtDhqd selectByPrimaryKey(@Param("htbh") String htbh, @Param("jx") String jx, @Param("jh") String jh);

    /**
     *
     * @mbg.generated 2020-06-22
     */
    int updateByPrimaryKeySelective(THtDhqd record);

    /**
     *
     * @mbg.generated 2020-06-22
     */
    int updateByPrimaryKey(THtDhqd record);

    /**
     *根据合同编号查询
     * @mbg.generated 2020-06-10
     */
    List<THtDhqd> selectByHtbh(@Param("htbh") String htbh);
}