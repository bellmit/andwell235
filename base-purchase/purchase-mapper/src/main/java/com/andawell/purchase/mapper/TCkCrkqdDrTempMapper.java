package com.andawell.purchase.mapper;

import com.andawell.purchase.entity.TCkCrkqdDrTemp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TCkCrkqdDrTempMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月12日 上午10:30:13
*/
public interface TCkCrkqdDrTempMapper {
    /**
     *
     * @mbg.generated 2020-06-12
     */
    int deleteByPrimaryKey(TCkCrkqdDrTemp record);

    /**
     *
     * @mbg.generated 2020-06-12
     */
    int insert(TCkCrkqdDrTemp record);

    /**
     *
     * @mbg.generated 2020-06-12
     */
    int insertSelective(TCkCrkqdDrTemp record);

    /**
     *
     * @mbg.generated 2020-06-12
     */
    TCkCrkqdDrTemp selectByPrimaryKey(@Param("bh") String bh,
                                      @Param("jh") String jh,
                                      @Param("jx") String jx,
                                      @Param("xh") String xh,
                                      @Param("cxsgin") String cxsgin,
                                      @Param("dwid") String dwid,
                                      @Param("xz") String xz);

    /**
     *
     * @mbg.generated 2020-06-12
     */
    int updateByPrimaryKeySelective(TCkCrkqdDrTemp record);

    /**
     *
     * @mbg.generated 2020-06-12
     */
    int updateByPrimaryKey(TCkCrkqdDrTemp record);

    /**
     * 根据条件查询
     * @param record
     * @return
     */
    List<TCkCrkqdDrTemp> getList(TCkCrkqdDrTemp record);
}