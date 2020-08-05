package com.andawell.material.mapper;

import com.andawell.material.entity.TCkC;
import com.andawell.material.entity.TCkCk;
import com.andawell.material.entity.response.TCkCkBO;
import com.andawell.material.query.*;
import com.andawell.material.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
* @ClassName: TCkCkMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年04月28日 上午09:36:38
*/
@Mapper
public interface TCkCkMapper {


    List<KFInOutMessageVO> getInOutList(KFInOutQuery kfInOutQuery);

    List<TCkCkPlanVO> getPlanList(YFPlanQuery yfPlanQuery);

    List<TCkCk> getListByjhjxzl(@Param("jx") String jx, @Param("jh") String jh, @Param("zl") String zl);

    /**
     *
     * @mbg.generated 2020-04-28
     */
    int deleteByPrimaryKey(@Param("dwid") String dwid, @Param("jx") String jx, @Param("jh") String jh, @Param("xh") String xh, @Param("zl") String zl, @Param("xz") String xz);

    /**
     *
     * @mbg.generated 2020-04-28
     */
    int insert(TCkCk record);

    /**
     *
     * @mbg.generated 2020-04-28
     */
    int insertSelective(TCkCk record);

    /**
     *
     * @mbg.generated 2020-04-28
     */
    void inserttckck(TCkC record);


    /**
     *
     * @mbg.generated 2020-04-28
     */
    TCkCk selectByPrimaryKey(@Param("dwid") String dwid,
                             @Param("jx") String jx,
                             @Param("jh") String jh,
                             @Param("xh") String xh,
                             @Param("zl") String zl,
                             @Param("xz") String xz);


    /**
     *
     * @mbg.generated 2020-04-28
     */
    int updateByPrimaryKeySelective(TCkCk record);

    /**
     *
     * @mbg.generated 2020-04-28
     */
    int updateByPrimaryKey(TCkCk record);

    List<TCkCkBO> libraryList(@Param("query") TCkSxLikeQuery tCkSxLikeQuery);

    List<TCkCkBO> libraryMatchingList(@Param("query") TCkSxLikeQuery tCkSxLikeQuery);


    TCkCk selectByDwidAndJxAndJhAndXhAndZl(@Param("dwid") String dwid, @Param("jx") String jx, @Param("jh") String jh, @Param("xh") String xh, @Param("zl") String zl);

    int updateByDwidAndJxAndJhAndXhAndZl(TCkCk record);

    void updateZB(TCkCkUpdateQuery ckCkUpdateQuery);

    void updateZZ(TCkCkUpdateQuery ckCkUpdateQuery);

    List<HistoryMessageCountVO> getHistoryMessageCountList(@Param("dcrq") String dcrq,@Param("jx") String jx);

    //数量的查询
    int selectByCount(TCkCkQuery tCkCkQuery);


    List<TCkC> select();


    void deleteCkck(String dwid);

    List<TCkCkVO> listAllGz(@Param("query") TCkCkQuery query);

    List<TCkCkVO> listUserGz(@Param("query") TCkCkQuery query);

    TCkSyVO getCout();

    TCkSyVO qxkyCount();

    TCkSyVO dxCount();

    TCkSyVO zxCount();

    TCkSyVO hcdbf();

    /**
     * dome
     * @param dwid
     * @return
     */
    List<StatisticsDomeVO> getStatisticDome(@Param("dwid") String dwid,
                                            @Param("jx") String jx,
                                            @Param("jh") String jh);

    /**
     * 获取个人关注件儿统计
     * @param summaryQuery
     * @return
     */
    List<Map> getPersonalConcernsStatistics(SummaryQuery summaryQuery);

    /**
     * 预警航材统计
     * @param summaryQuery
     * @return
     */
    List<Map> getWarningStatistics(SummaryQuery summaryQuery);

    List<NewRepertoryCountMxVO> listMx(@Param("query") NewPrpertoryCountQuery query);

    List<NewRepertoryCountVO> listTJ(@Param("query")NewPrpertoryCountQuery query);

    String selectBySumZs(@Param("query")NewPrpertoryCountQuery query);

    String selectBySumZj(@Param("query")NewPrpertoryCountQuery query);

    List<HcShMxVO> ShMx(@Param("query") HcSfCxMxQuery query);

    List<HcFhMxVO> FhMx(@Param("query")HcSfCxMxQuery query);

    List<HcShTjVO> listShTJ(@Param("query")HcSfCxTjQuery query);

    String selectsHZs(@Param("query")HcSfCxTjQuery query);

    List<HcShTjVO> listfhTJ(@Param("query")HcSfCxTjQuery query);

    List<SszqVO> getSszq(String id);

    List<BfKcVO> listBfTJ(@Param("query")HcSfCxTjQuery query);

    String selectbFZs(HcSfCxTjQuery q);
}