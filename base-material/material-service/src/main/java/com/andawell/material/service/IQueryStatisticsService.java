package com.andawell.material.service;

import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.material.query.*;
import com.andawell.material.vo.*;

import java.util.List;
import java.util.Map;

/***
 * @author shs
 * @Date: 2020/7/6 16:26
 * @Description:
 * @version : V1.0
 */
public interface IQueryStatisticsService {
    /**
     * 航材全新，待修，在修，报废的项数目、件数统计
     *
     * @param
     * @return
     */
    List<TCkSyVO> getCout();

    /**
     * 首页柱状图
     * @param tCkCrkqdIndexQuery
     * @return
     */
    List<IndexEcharsVO> getIndexEchats(TCkCrkqdIndexQuery tCkCrkqdIndexQuery);


    /**
     * 全新可用库存统计
     *gzh
     * @param
     * @return
     */
    ListPageVo<NewPrpertoryCountQuery, Map> getNewPrpertoryCountQuery(NewPrpertoryCountQuery query,String parentId);

    /**
     * 获取dome  list
     * @param dwid
     * @return
     */
    List<Map> getListDome(String dwid,SummaryQuery summaryQuery);

    /**
     * 根据机型件号查询修理能力列表
     * @param tCkSxXLNLQuery
     * @return
     */
    List<Map> getXLNLListData(TCkSxXLNLQuery tCkSxXLNLQuery);

    /**
     * 查询在修统计
     * @param summaryQuery
     * @return
     */
    ListPageVo<SummaryQuery, Map> getStatisticsUnderRepair(SummaryQuery summaryQuery);

    /**
     * 查询在关注件儿
     * @param summaryQuery
     * @return
     */
    ListPageVo<SummaryQuery, Map> getPersonalConcernsStatistics(SummaryQuery summaryQuery);

    /**
     * 航材预警统计
     * @param summaryQuery
     * @return
     */
    ListPageVo<SummaryQuery, Map> getWarningStatistics(SummaryQuery summaryQuery);

    /**
     * 修理能力明细查询
     * @param tCkSxXLNLQuery
     * @return
     */
//    List<TcksxXLNLMXVO> selectXLNLMX(TCkSxXLNLQuery tCkSxXLNLQuery);
    /**
     * 全新可用库存明细
     *gzh
     * @param
     * @return
     */
    ListPageVo<NewPrpertoryCountQuery, NewRepertoryCountMxVO> getNewPrpertoryCountMxQuery(NewPrpertoryCountQuery query, String parentId);
    /**
     * 待修库存明细
     *gzh
     * @param
     * @return
     */
    ListPageVo<NewPrpertoryCountQuery, RepairKcMxVO> getDaiXiuKcMxQuery(NewPrpertoryCountQuery query, String parentId);
    /**
     * 收货明细
     * shs
     * @param
     * @return
     */
    ListPageVo<HcSfCxMxQuery, HcShMxVO> shmxlist(HcSfCxMxQuery hcSfCxMxQuery,String parentId);
    /**
     * 报废库存明细
     *gzh
     * @param
     * @return
     */
    ListPageVo<NewPrpertoryCountQuery, ScrapKcMxVO> getScrapKcMxQuery(NewPrpertoryCountQuery query, String parentId);
    /**
     * 航材发货明细
     * shs
     * @param
     * @return
     */
    ListPageVo<HcSfCxMxQuery, HcFhMxVO> fhmxlist(HcSfCxMxQuery hcSfCxMxQuery, String parentId);
    /**
     * 航材收货统计
     * shs
     * @param
     * @return
     */
    ListPageVo<HcSfCxTjQuery, Map> shtjlist(String parentId, HcSfCxTjQuery query);
    /**
     * 航材发货统计
     * shs
     * @param
     * @return
     */
    /**
     *@Author: liuys
     *@Data: 2020/7/10
     *@Description: 待修查询统计
     */
    List<Map> getRepairedStatistics(SummaryQuery query);

    /**
     *@Author: shs
     *@Data: 2020/7/10
     *@Description:航材发货统计
     */
    ListPageVo<HcSfCxTjQuery, Map>  fhtjlist(String parentId, HcSfCxTjQuery query);

    /**
     *@Author: liuys
     *@Data: 2020/7/10
     *@Description: 报废查询-统计
     */
    List<Map> getScrapStatistics(SummaryQuery query);
    /**
     *@Author: gzh
     *@Data: 2020/7/10
     *@Description: 库存查询-待修库存统计
     */
    ListPageVo<NewPrpertoryCountQuery, Map> getRepairKcQuery(NewPrpertoryCountQuery query, String parentId);
    /**
     *@Author: shs
     *@Data: 2020/7/10
     *@Description:当前用户所属战区
     */
    List<SszqVO> getSszq(String parentId);
    /**
     *@Author: shs
     *@Data: 2020/7/13
     *@Description:报废查询统计
     */
    ListPageVo<HcSfCxTjQuery, Map> bfkctjlist(HcSfCxTjQuery hcSfCxTjQuery, String parentId);
}
