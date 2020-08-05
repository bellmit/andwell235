package com.andawell.purchase.mapper;


import com.andawell.purchase.entity.TCkCrkqd;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TCkCrkqdMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月12日 上午10:10:37
*/
public interface TCkCrkqdMapper {


    /**
     *
     * @mbg.generated 2020-06-12
     */
    int deleteByPrimaryKey(@Param("bh") String bh, @Param("jx") String jx, @Param("jh") String jh, @Param("xh") String xh, @Param("cxsgin") String cxsgin, @Param("dwid") String dwid, @Param("xz") String xz);

    /**
     *
     * @mbg.generated 2020-06-12
     */
    int insert(TCkCrkqd record);

    /**
     *
     * @mbg.generated 2020-06-12
     */
    int insertSelective(TCkCrkqd record);



    /**
     *
     * @mbg.generated 2020-06-12
     */
    TCkCrkqd selectByPrimaryKey(@Param("bh") String bh, @Param("jx") String jx, @Param("jh") String jh, @Param("xh") String xh, @Param("cxsgin") String cxsgin, @Param("dwid") String dwid, @Param("xz") String xz);





    /**
     *
     * @mbg.generated 2020-06-12
     */
    int updateByPrimaryKeySelective(TCkCrkqd record);

    /**
     *
     * @mbg.generated 2020-06-12
     */
    int updateByPrimaryKey(TCkCrkqd record);
    /**
     *根据编号查询
     * @mbg.generated 2020-06-12
     */
    List<TCkCrkqd> selectByBh(@Param("bh") String bh);
}