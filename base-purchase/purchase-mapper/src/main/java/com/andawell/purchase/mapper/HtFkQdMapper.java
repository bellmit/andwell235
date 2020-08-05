package com.andawell.purchase.mapper;

import com.andawell.purchase.entity.HtFkQd;
import org.apache.ibatis.annotations.Param;

/**
* @ClassName: HtFkQdMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月08日 下午04:37:10
*/
public interface HtFkQdMapper {
    /**
     *
     * @mbg.generated 2020-06-08
     */
    int deleteByPrimaryKey(@Param("rkb") String rkb, @Param("jx") String jx, @Param("jh") String jh, @Param("xh") String xh);

    /**
     *
     * @mbg.generated 2020-06-08
     */
    int insert(HtFkQd record);

    /**
     *
     * @mbg.generated 2020-06-08
     */
    int insertSelective(HtFkQd record);

    /**
     *
     * @mbg.generated 2020-06-08
     */
    HtFkQd selectByPrimaryKey(@Param("rkb") String rkb, @Param("jx") String jx, @Param("jh") String jh, @Param("xh") String xh);

    /**
     *
     * @mbg.generated 2020-06-08
     */
    int updateByPrimaryKeySelective(HtFkQd record);

    /**
     *
     * @mbg.generated 2020-06-08
     */
    int updateByPrimaryKey(HtFkQd record);
    /**
     *查询合同入库单明细
     * @mbg.generated 2020-06-08
     */
    HtFkQd selectHtfkqdByCrkqd(String Rkdh);
}