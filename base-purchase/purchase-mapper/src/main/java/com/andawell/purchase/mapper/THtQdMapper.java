package com.andawell.purchase.mapper;

import com.andawell.purchase.entity.THtQd;
import com.andawell.purchase.query.THtFkQuery;
import com.andawell.purchase.vo.THtFkVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: THtQdMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月04日 下午01:27:50
*/
public interface THtQdMapper {
    /**
     *
     * @mbg.generated 2020-06-04
     */
    int deleteByPrimaryKey(@Param("hth") String hth,
                           @Param("jhbh") String jhbh,
                           @Param("jx") String jx,
                           @Param("jh") String jh);

    /**
     *
     * @mbg.generated 2020-06-04
     */
    int insert(THtQd record);

    /**
     *
     * @mbg.generated 2020-06-04
     */
    int insertSelective(THtQd record);

    /**
     *
     * @mbg.generated 2020-06-04
     */
    THtQd selectByPrimaryKey(@Param("hth") String hth,
                             @Param("jhbh") String jhbh,
                             @Param("jx") String jx,
                             @Param("jh") String jh);


    /**
     *
     * @mbg.generated 2020-06-04
     */
    List<THtQd> selectListByPrimaryKey(@Param("hth") String hth,
                             @Param("jhbh") String jhbh,
                             @Param("jx") String jx,
                             @Param("jh") String jh);

    /**
     *
     * 获取合同入库清单
     */
    List<THtQd> getThtQdList(@Param("hth") String hth,
                                   @Param("jhbh") String jhbh);



    /**
     *
     * @mbg.generated 2020-06-04
     */
    int updateByPrimaryKeySelective(THtQd record);

    /**
     *
     * @mbg.generated 2020-06-04
     */
    int updateByPrimaryKey(THtQd record);

    void deleteByJhbh( @Param("jhbh") String jhbh);
    /**
     *根据合同号计划编号来查询
     * @mbg.generated 2020-06-04
     */
    List<THtQd> selectListByPrimaryHthJhbh(@Param("hth") String hth,
                                           @Param("jhbh") String jhbh);
}