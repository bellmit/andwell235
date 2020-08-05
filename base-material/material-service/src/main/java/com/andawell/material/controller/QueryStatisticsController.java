package com.andawell.material.controller;

import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.search.ListPageCommon;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.common.util.SysUserUtils;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.entity.TJhDj;
import com.andawell.material.query.*;
import com.andawell.material.service.IQueryStatisticsService;
import com.andawell.material.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/***
 * @author lhb
 * @Date: 2020/7/6 16:32
 * @Description:
 * @version : V1.0
 */
@Api(value = "查询统计", tags = "查询统计API")
@RestController
@RequestMapping(value = "/query/statistics")
public class QueryStatisticsController {

    @Autowired
    private IQueryStatisticsService queryStatistics;

    /***
     * @author shs
     * @Date: 2020/7/6 16:18
     * @Description:
     * @return
     */
    @ApiOperation(value = "航材全新，待修，在修，报废的项数目、件数统计")
    @GetMapping(value = "getCout")
    public RestResultVo<List<TCkSyVO>> getCout() {
        try {
            List<TCkSyVO> tCkSyVO=queryStatistics.getCout();
            return new RestResultVo<List<TCkSyVO>>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,tCkSyVO);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<List<TCkSyVO>>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE);
        }
    }




    /***
     * @author gzh
     * @Date: 2020/7/6 16:18
     * @Description:
     * @return
     */
    @ApiOperation(value = "全新可用发付明细")
    @GetMapping(value = "getNewPrpertoryCountMxQuery")
    public RestResultVo<ListPageVo<NewPrpertoryCountQuery, NewRepertoryCountMxVO>> getNewPrpertoryCountMxQuery(NewPrpertoryCountQuery query) {
        try {
            // 机关Id
            String parentId = SysUserUtils.getUser().getDeptId().substring(0, 2);
            ListPageVo<NewPrpertoryCountQuery, NewRepertoryCountMxVO> list = queryStatistics.getNewPrpertoryCountMxQuery(query, parentId);
            return new RestResultVo<ListPageVo<NewPrpertoryCountQuery, NewRepertoryCountMxVO>>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                    list);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<ListPageVo<NewPrpertoryCountQuery, NewRepertoryCountMxVO>>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE);
        }
    }
    /***
     * @author shs
     * @Date: 2020/7/8 16:18
     * @Description:
     * @return
     */
    @ApiOperation(value = "航材收货明细")
    @GetMapping(value = "shmxlist")
    public RestResultVo<ListPageVo<HcSfCxMxQuery, HcShMxVO>> shmxlist(HcSfCxMxQuery hcSfCxMxQuery) {
        try {
            // 机关Id
            String parentId = SysUserUtils.getUser().getDeptId().substring(0, 2);
            ListPageVo<HcSfCxMxQuery, HcShMxVO> hcShTjVOS=queryStatistics.shmxlist(hcSfCxMxQuery,parentId);
            return new RestResultVo<ListPageVo<HcSfCxMxQuery, HcShMxVO>>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,hcShTjVOS);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<ListPageVo<HcSfCxMxQuery, HcShMxVO>>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE);
        }

    }
    /***
     * @author shs
     * @Date: 2020/7/8 16:18
     * @Description:
     * @return
     */
    @ApiOperation(value = "航材发货明细")
    @GetMapping(value = "fhmxlist")
    public RestResultVo<ListPageVo<HcSfCxMxQuery, HcFhMxVO>> fhmxlist(HcSfCxMxQuery hcSfCxMxQuery) {
        try {
            // 机关Id
            String parentId = SysUserUtils.getUser().getDeptId().substring(0, 2);
            ListPageVo<HcSfCxMxQuery, HcFhMxVO> hcShTjVOS=queryStatistics.fhmxlist(hcSfCxMxQuery,parentId);
            return new RestResultVo<ListPageVo<HcSfCxMxQuery, HcFhMxVO>>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,hcShTjVOS);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<ListPageVo<HcSfCxMxQuery, HcFhMxVO>>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE);
        }

    }

    
    /***
     * @author gzh
     * @Date: 2020/7/6 16:18
     * @Description:
     * @return
     */
    @ApiOperation(value = "待修库存明细")
    @GetMapping(value = "getRepairKcMxQuery")
    public RestResultVo<ListPageVo<NewPrpertoryCountQuery, RepairKcMxVO>> getDaiXiuKcMxQuery(NewPrpertoryCountQuery query) {
        try {
            // 机关Id
            String parentId = SysUserUtils.getUser().getDeptId().substring(0, 2);
            ListPageVo<NewPrpertoryCountQuery, RepairKcMxVO> list = queryStatistics.getDaiXiuKcMxQuery(query, parentId);
            return new RestResultVo<ListPageVo<NewPrpertoryCountQuery, RepairKcMxVO>>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                    list);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<ListPageVo<NewPrpertoryCountQuery, RepairKcMxVO>>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE);
        }
    }


    @ApiOperation(value = "查询统计 dome T_CK_CK")
    @GetMapping(value = "get/statistics/dome")
    public RestResultVo<List<Map>> getTCkCkDome(SummaryQuery query) {
        // 机关Id
        String parentId = SysUserUtils.getUser().getDeptId().substring(0,2);
        List<Map> listDome=queryStatistics.getListDome(parentId,query);
        return new RestResultVo<List<Map>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,listDome);
    }

    /***
     * @author gzh
     * @Date: 2020/7/6 16:18
     * @Description:
     * @return
     */
    @ApiOperation(value = "库存查询待修库存统计")
    @GetMapping(value = "getRepairKcQuery")
    public RestResultVo< ListPageVo<NewPrpertoryCountQuery, Map>> getRepairKcQuery(NewPrpertoryCountQuery query) {
        try {
            // 机关Id
            String parentId = SysUserUtils.getUser().getDeptId().substring(0, 2);
            ListPageVo<NewPrpertoryCountQuery, Map> list =  queryStatistics.getRepairKcQuery(query,parentId);
            return new RestResultVo< ListPageVo<NewPrpertoryCountQuery, Map>>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,list);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo< ListPageVo<NewPrpertoryCountQuery, Map>>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE);
        }
    }


    /***
     * @author gzh
     * @Date: 2020/7/6 16:18
     * @Description:
     * @return
     */
    @ApiOperation(value = "全新可用发付统计")
    @GetMapping(value = "getNewPrpertoryCountQuery")
    public RestResultVo< ListPageVo<NewPrpertoryCountQuery, Map>> getNewPrpertoryCountQuery(NewPrpertoryCountQuery query) {
        try {
            // 机关Id
            String parentId = SysUserUtils.getUser().getDeptId().substring(0, 2);
            ListPageVo<NewPrpertoryCountQuery, Map> list =  queryStatistics.getNewPrpertoryCountQuery(query,parentId);
            return new RestResultVo< ListPageVo<NewPrpertoryCountQuery, Map>>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,list);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo< ListPageVo<NewPrpertoryCountQuery, Map>>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE);
        }
    }


    /***
     * @author shs
     * @Date: 2020/7/16 16:18
     * @Description:
     * @return
     */
    @ApiOperation(value = "报废库存统计")
    @GetMapping(value = "bfkctjlist")
    public RestResultVo<ListPageVo<HcSfCxTjQuery, Map>> bfkctjlist(HcSfCxTjQuery hcSfCxTjQuery) {
        try {
            // 机关Id
            String parentId = SysUserUtils.getUser().getDeptId().substring(0, 2);
            ListPageVo<HcSfCxTjQuery, Map> bfkctjlist=queryStatistics.bfkctjlist(hcSfCxTjQuery,parentId);
            return new RestResultVo<ListPageVo<HcSfCxTjQuery, Map>>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,bfkctjlist);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<ListPageVo<HcSfCxTjQuery, Map>>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE);
        }

    }

    @ApiOperation(value = "在个人关注件统计")
    @GetMapping(value = "get/personalConcern")
    public RestResultVo<ListPageVo<SummaryQuery, Map>> getPersonalConcernsStatistics(SummaryQuery query) {
        // 机关Id
        String parentId = SysUserUtils.getUser().getDeptId().substring(0,2);
        query.setDwid(parentId);
        ListPageVo<SummaryQuery, Map> listPageVo =
                queryStatistics.getPersonalConcernsStatistics(query);
        return new RestResultVo<ListPageVo<SummaryQuery, Map>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,listPageVo);
    }
    @ApiOperation(value = "所属战区下列表")
    @GetMapping(value = "get/sszq")
    public RestResultVo<List<SszqVO>> getSszq(TJhDjQuery query) {
        // 机关Id
        String parentId = SysUserUtils.getUser().getDeptId().substring(0,2);
        List<SszqVO> sszq=queryStatistics.getSszq(parentId);
        return new RestResultVo<List<SszqVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,sszq);
    }

    @ApiOperation(value = "修理能力查询")
    @GetMapping(value = "get/statistics/sxList")
    public RestResultVo<ListPageVo<TCkSxXLNLQuery,List<Map>>> getTCkSxDome(TCkSxXLNLQuery query) {
//        List<Map> xlnlListData = queryStatistics.getXLNLListData(query);
        ListPageVo listPageVo = new ListPageCommon<TCkSxXLNLQuery, Map>(
                query,(q) ->queryStatistics.getXLNLListData(q)
        ).getVo();
        return new RestResultVo<ListPageVo<TCkSxXLNLQuery,List<Map>>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,listPageVo);
    }
    /***
     * @author shs
     * @Date: 2020/7/9 16:18
     * @Description: 航材收发-收查询
     * @return
     */
    @ApiOperation(value = "航材收发-发货统计查询")
    @GetMapping(value = "fhtjlist")
    public RestResultVo<ListPageVo<HcSfCxTjQuery,Map>> fhtjlist(HcSfCxTjQuery query) {
        // 机关Id
        String parentId = SysUserUtils.getUser().getDeptId().substring(0,2);
        ListPageVo<HcSfCxTjQuery, Map> listDome=queryStatistics.fhtjlist(parentId,query);
        return new RestResultVo<ListPageVo<HcSfCxTjQuery,Map>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,listDome);
    }
    /***
     * @author shs
     * @Date: 2020/7/9 16:18
     * @Description: 航材收发-收查询
     * @return
     */
    @ApiOperation(value = "航材收发-收货统计查询")
    @GetMapping(value = "shtjlist")
    public RestResultVo< ListPageVo<HcSfCxTjQuery, Map>> shtjlist(HcSfCxTjQuery query) {
        // 机关Id
        String parentId = SysUserUtils.getUser().getDeptId().substring(0,2);
        ListPageVo<HcSfCxTjQuery, Map> listDome=queryStatistics.shtjlist(parentId,query);
        return new RestResultVo<ListPageVo<HcSfCxTjQuery, Map>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,listDome);
    }


    @ApiOperation(value = "库存预警航材")
    @GetMapping(value = "get/warning")
    public RestResultVo<ListPageVo<SummaryQuery, Map>> warningStatistics(SummaryQuery query) {
        // 机关Id
        String parentId = SysUserUtils.getUser().getDeptId().substring(0,2);
        query.setDwid(parentId);
        ListPageVo<SummaryQuery, Map> listPageVo =
                queryStatistics.getWarningStatistics(query);
        return new RestResultVo<ListPageVo<SummaryQuery, Map>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,listPageVo);
    }


    @ApiOperation(value = "送修查询 -在修查统计")
    @GetMapping(value = "get/underRepair")
    public RestResultVo<ListPageVo<SummaryQuery, Map>> getStatisticsUnderRepair(SummaryQuery query) {
        // 机关Id
        String parentId = SysUserUtils.getUser().getDeptId().substring(0,2);
        query.setDwid(parentId);
        ListPageVo<SummaryQuery, Map> listPageVo =
                queryStatistics.getStatisticsUnderRepair(query);
        return new RestResultVo<ListPageVo<SummaryQuery, Map>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,listPageVo);
    }



    @ApiOperation(value = "查询首页柱状图")
    @GetMapping(value = "/getEchats")
    public RestResultVo<List<IndexEcharsVO>> getIndexEchats(TCkCrkqdIndexQuery tCkCrkqdIndexQuery) {
        List<IndexEcharsVO> indexEchats = queryStatistics.getIndexEchats(tCkCrkqdIndexQuery);
        RestResultVo<List<IndexEcharsVO>> listRestResultVo =null;
        try {
            listRestResultVo = new RestResultVo<>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE, indexEchats);
        }catch (Exception e){
            e.printStackTrace();
            listRestResultVo = new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE, indexEchats);
        }

        return listRestResultVo;
    }


    /***
     * @author gzh
     * @Date: 2020/7/6 16:18
     * @Description:
     * @return
     */
    @ApiOperation(value = "报废库存明细")
    @GetMapping(value = "getScrapKcMxQuery")
    public RestResultVo<ListPageVo<NewPrpertoryCountQuery, ScrapKcMxVO>> getScrapKcMxQuery(NewPrpertoryCountQuery query) {
        try {
            // 机关Id
            String parentId = SysUserUtils.getUser().getDeptId().substring(0, 2);
            ListPageVo<NewPrpertoryCountQuery, ScrapKcMxVO> list = queryStatistics.getScrapKcMxQuery(query, parentId);
            return new RestResultVo<ListPageVo<NewPrpertoryCountQuery, ScrapKcMxVO>>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                    list);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<ListPageVo<NewPrpertoryCountQuery, ScrapKcMxVO>>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE);
        }
    }


    @ApiOperation(value = "待修查询-统计")
    @GetMapping(value = "get/repaired/statistics")
    public RestResultVo<List<Map>> getRepairedCount(SummaryQuery query) {
        List<Map> list =queryStatistics.getRepairedStatistics(query);
        return new RestResultVo<List<Map>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,list);
    }

    @ApiOperation(value = "报废查询-统计")
    @GetMapping(value = "get/scrap/statistics")
    public RestResultVo<List<Map>> getScrapStatistics(SummaryQuery query) {
        List<Map> list =queryStatistics.getScrapStatistics(query);
        return new RestResultVo<List<Map>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,list);
    }


    /*@ApiOperation(value = "修理能力明细查询")
    @GetMapping(value = "/getXlnlMx")
    public RestResultVo<List<TcksxXLNLMXVO>> selectXLNLMX(TCkSxXLNLQuery tCkSxXLNLQuery) {
        List<TcksxXLNLMXVO> tcksxXLNLMXVOS = queryStatistics.selectXLNLMX(tCkSxXLNLQuery);
        RestResultVo<List<TcksxXLNLMXVO>> listRestResultVo =null;
        try {
            listRestResultVo = new RestResultVo<>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE, tcksxXLNLMXVOS);
        }catch (Exception e){
            e.printStackTrace();
            listRestResultVo = new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE, tcksxXLNLMXVOS);
        }
        return listRestResultVo;
    }*/
}
