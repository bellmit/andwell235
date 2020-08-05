package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.common.util.SysUserUtils;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.dto.*;
import com.andawell.material.dto.groups.First;
import com.andawell.material.entity.response.TCkCkBO;
import com.andawell.material.query.*;
import com.andawell.material.service.*;
import com.andawell.material.service.impl.*;
import com.andawell.material.util.BeanUtils;
import com.andawell.material.util.Utils;
import com.andawell.material.vo.TCkCrkVO;
import com.andawell.material.vo.TCkPglyVo;
import com.andawell.material.vo.TCkPglyqdVO;
import com.andawell.material.vo.TCkWsyfVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Date： 2020/5/8 16:42
 */
@Api(value = "出库管理", tags = "出库管理")
@RestController
@RequestMapping(value = "sys/out/stock")
public class OutOfStockController {


    @Autowired
    RepairedLibraryService repairedLibraryService;

    @Autowired
    IContractLibraryService contractLibraryService;

    @Autowired
    ScrapLibraryService scrapLibraryService;

    @Autowired
    CallOilSeaService callOilSeaService;

    @Autowired
    ISendRepairLibraryService sendRepairLibraryService;

    @Autowired
    BaseLibraryService baseLibraryService;

    @Autowired
    ReturnToFactoryLibraryService returnToFactoryLibraryService;

    @Autowired
    TransFormationLibraryService transFormationLibraryService;

    @Autowired
    IRotateService rotateService;

    @Autowired
    ITCkFcsjService tCkFcsjService;

    @Autowired
    ITCkWsYfService tCkWsYfService;


    @Autowired
    private IOutOfStockService iOutOfStockService;

    @Autowired
    TroubleShootService troubleShootService;


    /**
     * @Author: liuys
     * @Data: 2020/5/9 10:44
     * @Description: 全新可用出库/发付出库列表/查询
     */
    @ApiOperation(value = "全新可用出库/发付出库列表(新品可用转待修，领用出库)/查询", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "library/list")
    public RestResultVo<List<TCkCkBO>> libraryList(TCkSxLikeQuery tCkSxLikeQuery) {
        return new RestResultVo<List<TCkCkBO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                iOutOfStockService.libraryList(tCkSxLikeQuery));
    }




    @ApiOperation(value = "全新可用出库/发付出库列表(新品可用转待修，领用出库)/查询", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "library/listPage")
    public RestResultVo<ListPageVo<TCkSxLikeQuery, TCkCkBO>> libraryListPage(TCkSxLikeQuery tCkSxLikeQuery) {
        return new RestResultVo<ListPageVo<TCkSxLikeQuery, TCkCkBO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                iOutOfStockService.libraryListPage(tCkSxLikeQuery));
    }

    /**
     * @Author: liuys
     * @Data: 2020/5/9 10:45
     * @Description: 全新可用出库/发付出库列表/替换查询
     */
    @ApiOperation(value = "全新可用出库/发付出库列表/替换查询", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "library/matching/list")
    public RestResultVo<List<TCkCkBO>> libraryMatchingList(TCkSxLikeQuery tCkSxLikeQuery) {
        return new RestResultVo<List<TCkCkBO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                BeanUtils.copyList(iOutOfStockService.libraryMatchingList(tCkSxLikeQuery), TCkCkBO.class));
    }

    @ApiOperation(value = "全新可用出库/全新发付出库")
    @PostMapping(value = "add/newIssueOut")
    @SysLog(value = "全新可用出库/全新发付出库", operationType = LogTypeConstant.LOG_PUT_OUT_LIBRARY)
    public RestResultVo<Boolean> newIssueOut(@RequestBody @Valid OutLibraryInfoDTO outLibraryInfoDTO) {
        Boolean aBoolean = baseLibraryService.saveOutLibraryInfo(outLibraryInfoDTO);
        return Utils.getAddResult(aBoolean);
    }

    @ApiOperation(value = "返厂升级出库")
    @PostMapping(value = "add/returnFactoryOut")
    @SysLog(value = "返厂升级出库", operationType = LogTypeConstant.LOG_PUT_OUT_LIBRARY)
    public RestResultVo<Boolean> returnFactoryOut(@RequestBody @Valid OutLibraryInfoDTO outLibraryInfoDTO) {
        Boolean aBoolean = returnToFactoryLibraryService.saveOutLibraryInfo(outLibraryInfoDTO);
        return Utils.getAddResult(aBoolean);
    }


    @ApiOperation(value = "外送油封出库")
    @PostMapping(value = "add/oilSeaInOut")
    @SysLog(value = "外送油封出库", operationType = LogTypeConstant.LOG_PUT_OUT_LIBRARY)
    public RestResultVo<Boolean> oilSeaInOut(@RequestBody @Valid OutLibraryInfoDTO outLibraryInfoDTO) {
        Boolean aBoolean = callOilSeaService.saveOutLibraryInfo(outLibraryInfoDTO);
        return Utils.getAddResult(aBoolean);
    }

    @ApiOperation(value = "待修发付出库")
    @PostMapping(value = "add/paymentToRepairOut")
    @SysLog(value = "待修发付出库", operationType = LogTypeConstant.LOG_PUT_OUT_LIBRARY)
    public RestResultVo<Boolean> paymentToRepairOut(@RequestBody @Valid OutLibraryInfoDTO outLibraryInfoDTO) {
        Boolean aBoolean = repairedLibraryService.saveOutLibraryInfo(outLibraryInfoDTO);
        return Utils.getAddResult(aBoolean);
    }

    @ApiOperation(value = "送修出库")
    @PostMapping(value = "add/repairOut")
    @SysLog(value = "送修出库", operationType = LogTypeConstant.LOG_PUT_OUT_LIBRARY)
    public RestResultVo<Boolean> repairOut(@RequestBody @Valid LibraryInfoDTO libraryInfoDTO) {
        Boolean aBoolean = sendRepairLibraryService.saveOutLibraryInfo(libraryInfoDTO);
        return Utils.getAddResult(aBoolean);
    }


    /**
     * @Author: liuys
     * @Data: 2020/5/11
     * @Description: 全新可用出库/全新转待修/转报废
     */
    @ApiOperation(value = "全新-可用-全新转待修21（报废）24")
    @PostMapping(value = "save/new/repair")
    @SysLog(value = "全新-可用-全新转待修21（报废）24", operationType = LogTypeConstant.LOG_PUT_OUT_LIBRARY)
    public RestResultVo<Boolean> newRepair(@RequestBody @Valid  NewRepairedDTO newRepairedDTO) {
        return Utils.getAddResult(transFormationLibraryService.newRepair(newRepairedDTO));
    }

    /**
     * @Author: liuys
     * @Data: 2020/5/11
     * @Description: 全新可用出库/全新转待修
     */
    @ApiOperation(value = "全新可用出库/全新轮换出库")
    @PostMapping(value = "save/rotate/out")
    @SysLog(value = "全新可用出库/全新轮换出库", operationType = LogTypeConstant.LOG_PUT_OUT_LIBRARY)
    public RestResultVo<Boolean> rotateOut(@RequestBody @Valid OutLibraryInfoDTO outLibraryInfoDTO) {
        return Utils.getAddResult(transFormationLibraryService.rotateOut(outLibraryInfoDTO));
    }

    /**
     * @Author: liuys
     * @Data: 2020/5/13
     * @Description: 报废出库
     */
    @ApiOperation(value = "报废出库")
    @PostMapping(value = "save/scrap/outnound")
    @SysLog(value = "报废出库", operationType = LogTypeConstant.LOG_PUT_OUT_LIBRARY)
    public RestResultVo<Boolean> scrapOutnound(@RequestBody @Valid OutLibraryInfoDTO outLibraryInfoDTO) {
        return Utils.getAddResult(scrapLibraryService.saveOutLibraryInfo(outLibraryInfoDTO));
    }

    /**
     * @Author: liuys
     * @Data: 2020/5/15
     * @Description: 领用出库
     */
    @ApiOperation(value = "领用出库")
    @PostMapping(value = "save/collectiong")
    @SysLog(value = "领用出库", operationType = LogTypeConstant.LOG_PUT_OUT_LIBRARY)
    public RestResultVo<Boolean> collectiong(@RequestBody @Validated({First.class}) OutLibraryInfoDTO outLibraryInfoDTO) {
        Boolean aBoolean = baseLibraryService.saveOutLibraryInfo(outLibraryInfoDTO);
        return Utils.getAddResult(aBoolean);
    }

    /**
     *@Author: liuys
     *@Data: 2020/5/15
     *@Description: 文号类别
     */
    @ApiOperation(value = "文号类别")
    @GetMapping(value = "get/whlb")
    public RestResultVo<List<String>> getWhlb() {
        return new RestResultVo<List<String>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                iOutOfStockService.getWhlb());
    }

    /**
     * @Author: liuys
     * @Data: 2020/5/15
     * @Description: 排故领用出库
     */
    @ApiOperation(value = "排故领用出库")
    @PostMapping(value = "save/trouble/shooting")
    @SysLog(value = "排故领用出库", operationType = LogTypeConstant.LOG_PUT_OUT_LIBRARY)
    public RestResultVo<ListPageVo<TCkWsyfQuery, TCkWsyfVO>> troubleShooting(@RequestBody @Valid TroubleShootingDTO troubleShootingDTO) {
        Boolean aBoolean = troubleShootService.troubleShooting(troubleShootingDTO);
        return Utils.getAddResult(aBoolean);
    }

 /**
     *@Author: liuys
     *@Data: 2020/5/18
     *@Description: 排故领用归还查询
     */
    @ApiOperation(value = "排故领用归还查询")
    @GetMapping(value = "get/collecting/return")
    public RestResultVo<ListPageVo<TCkPglyQuery, TCkPglyVo>> getCollectingReturn(@Valid TCkPglyQuery tCkPglyQuery) {
        return new RestResultVo<ListPageVo<TCkPglyQuery, TCkPglyVo>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                troubleShootService.getCollectingReturn(tCkPglyQuery));
    }

    /**
     *@Author: liuys
     *@Data: 2020/5/18
     *@Description: 排故领用归还查询明细
     */

    @ApiOperation(value = "排故领用归还查询明细")
    @GetMapping(value = "get/collecting/return/detailed")
    public RestResultVo<List<TCkPglyqdVO>> getCollectingReturnDetailed(@Valid TCkPglyqdQuery tCkPglyqdQuery) {
        return new RestResultVo<List<TCkPglyqdVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                troubleShootService.getCollectingReturnDetailed(tCkPglyqdQuery));
    }

    /**
     *@Author: liuys
     *@Data: 2020/5/18
     *@Description: 排故领用归还保存
     */
    @ApiOperation(value = "排故领用归还保存")
    @PostMapping(value = "save/collecting/return")
    @SysLog(value = "排故领用归还保存", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<Boolean> saveCollectingReturn(@RequestBody @Valid ReturnShootingDTO returnShootingDTO) {
        return Utils.getAddResult(troubleShootService.saveCollectingReturn(returnShootingDTO));
    }

    /**
     *@Author: liuys
     *@Data: 2020/5/18
     *@Description: 出库文号
     */
    @ApiOperation(value = "排故出库文号")
    @GetMapping(value = "get/out/number")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "state", value = "文号选择", dataType = "String", required = true)
    }
    )
    public RestResultVo<String> outNumber(String state) {
        return new RestResultVo<String>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                troubleShootService.outNumber(state));
    }


    /**
     *@Author: liuys
     *@Data: 2020/5/18
     *@Description: 排故领用领出保存
     */
    @ApiOperation(value = "排故领用领出保存")
    @PostMapping(value = "save/take/out")
    @SysLog(value = "排故领用领出保存", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<Boolean> takeOut(@RequestBody @Validated({First.class}) TroubleShootingDTO takeOutDTO) {
        return Utils.getAddResult(troubleShootService.takeOut(takeOutDTO));
    }


    /**
     *@Author: liuys
     *@Data: 2020/5/18
     *@Description: 排故领用查询
     */

    @ApiOperation(value = "排故领用查询")
    @GetMapping(value = "get/collecting/time/pageList")
    public RestResultVo<ListPageVo<TCkPglyqdQuery, TCkPglyqdVO>> getCollectingTimeList(@Valid TCkPglyqdQuery tCkPglyqdQuery) {
        return new RestResultVo<ListPageVo<TCkPglyqdQuery, TCkPglyqdVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                troubleShootService.getCollectingTimeList(tCkPglyqdQuery));
    }

    @ApiOperation(value = "出库预览-返回编号")
    @PostMapping(value = "get/preview")
    @SysLog(value = "出库预览-返回编号", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<String> getPreview(@RequestBody OutAccessPreviewQuery outAccessPreviewQuery) {
        //用户id
        String userId = SysUserUtils.getUserId();
        //先删除
        baseLibraryService.delPreview(userId);
        //再添加
        return new RestResultVo<String>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE,
                baseLibraryService.getOutPreview(outAccessPreviewQuery));
    }

}
