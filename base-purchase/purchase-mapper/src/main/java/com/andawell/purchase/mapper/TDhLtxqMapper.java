package com.andawell.purchase.mapper;

import com.andawell.purchase.entity.TDhLtxq;
import com.andawell.purchase.query.TDhLtxqQuery;
import com.andawell.purchase.vo.TDhLtxqVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TDhLtxqMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月01日 下午04:31:43
*/
public interface TDhLtxqMapper {

    /**
     *
     * @mbg.generated 2020-06-01
     */
    int deleteByPrimaryKey(@Param("bh") String bh,
                           @Param("dwid") String dwid,
                           @Param("jx") String jx,
                           @Param("jh") String jh);

    /**
     *
     * @mbg.generated 2020-06-01
     */
    int insert(TDhLtxq record);

    /**
     *
     * @mbg.generated 2020-06-01
     */
    int insertSelective(TDhLtxq record);

    /**
     *
     * @mbg.generated 2020-06-01
     */
    TDhLtxq selectByPrimaryKey(@Param("bh") String bh,
                               @Param("dwid") String dwid,
                               @Param("jx") String jx,
                               @Param("jh") String jh);

    /**
     *
     * 根据条件获取
     */
    List<TDhLtxqVO> getList(TDhLtxqQuery tDhLtxqQuery);

    /**
     *
     * @mbg.generated 2020-06-01
     */
    int updateByPrimaryKeySelective(TDhLtxq record);

    /**
     *
     * @mbg.generated 2020-06-01
     */
    int updateByPrimaryKey(TDhLtxq record);

    int deleteByBh(@Param("bh") String bh);

}