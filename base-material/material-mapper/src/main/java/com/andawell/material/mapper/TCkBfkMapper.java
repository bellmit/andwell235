package com.andawell.material.mapper;

import com.andawell.material.entity.TCkBfk;
import com.andawell.material.query.NewPrpertoryCountQuery;
import com.andawell.material.query.SummaryQuery;
import com.andawell.material.query.TCkBfkQuery;
import com.andawell.material.vo.ScrapKcMxVO;
import com.andawell.material.vo.TCkBfkVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TCkBfkMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月08日 上午11:03:26
*/
public interface TCkBfkMapper {
    /**
     *
     * @mbg.generated 2020-05-08
     */
    int deleteByPrimaryKey(@Param("bh") String bh, @Param("jh") String jh, @Param("xh") String xh, @Param("jx") String jx, @Param("dwid") String dwid);

    /**
     *
     * @mbg.generated 2020-05-08
     */
    int insert(TCkBfk record);

    /**
     *
     * @mbg.generated 2020-05-08
     */
    int insertSelective(TCkBfk record);

    /**
     *
     * @mbg.generated 2020-05-08
     */
    TCkBfk selectByPrimaryKey(@Param("bh") String bh,
                              @Param("jh") String jh,
                              @Param("xh") String xh,
                              @Param("jx") String jx,
                              @Param("dwid") String dwid);

    /**
     *
     * @param jh
     * @param xh
     * @param jx
     * @param dwid
     * @return
     */
    List<TCkBfk> selectByCondition(@Param("jh") String jh,
                             @Param("xh") String xh,
                             @Param("jx") String jx,
                             @Param("dwid") String dwid);

    /**
     *
     * @mbg.generated 2020-05-08
     */
    int updateByPrimaryKeySelective(TCkBfk record);

    /**
     *
     * @mbg.generated 2020-05-08
     */
    int updateByPrimaryKey(TCkBfk record);

    List<TCkBfkVO> outnoundList(@Param("query") TCkBfkQuery tCkBfkQuery);

    List<ScrapKcMxVO> listMx(@Param("query")NewPrpertoryCountQuery query);

    List<TCkBfkVO> getStatistics(@Param("query")SummaryQuery query);

    Integer getRepairedStatistics(@Param("query")SummaryQuery query);
}