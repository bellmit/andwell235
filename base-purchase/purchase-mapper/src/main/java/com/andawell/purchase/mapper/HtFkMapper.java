package com.andawell.purchase.mapper;

import com.andawell.purchase.entity.HtFk;
import com.andawell.purchase.query.THtFkQuery;
import com.andawell.purchase.vo.THtFkVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: HtFkMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月08日 下午04:37:24
*/
public interface HtFkMapper {
    /**
     *
     * @mbg.generated 2020-06-08
     */
    int deleteByPrimaryKey(@Param("hth") String hth, @Param("fkbh") String fkbh);

    /**
     *
     * @mbg.generated 2020-06-08
     */
    int insert(HtFk record);

    /**
     *
     * @mbg.generated 2020-06-08
     */
    int insertSelective(HtFk record);

    /**
     *
     * @mbg.generated 2020-06-08
     */
    HtFk selectByPrimaryKey(@Param("hth") String hth, @Param("fkbh") String fkbh);

    /**
     *
     * @mbg.generated 2020-06-08
     */
    int updateByPrimaryKeySelective(HtFk record);

    /**
     *
     * @mbg.generated 2020-06-08
     */
    int updateByPrimaryKey(HtFk record);
    /**
     *查询数据库最大付款编号
     * @mbg.generated 2020-06-08
     */
    String selectMaxFkbh();

    List<THtFkVO> listHtFk(@Param("query") THtFkQuery query);

    List<THtFkVO> listHtFkck(@Param("query") THtFkQuery query);
}