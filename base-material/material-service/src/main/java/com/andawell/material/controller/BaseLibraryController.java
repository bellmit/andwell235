package com.andawell.material.controller;


import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.common.util.SysUserUtils;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.dto.*;
import com.andawell.material.entity.TCkCrklb;
import com.andawell.material.entity.TCkCrkqd;
import com.andawell.material.query.*;
import com.andawell.material.service.*;

import com.andawell.material.service.impl.BaseLibraryService;
import com.andawell.material.service.impl.BaseLibraryService;
import com.andawell.material.service.impl.CallOilSeaService;
import com.andawell.material.service.impl.ReturnToFactoryLibraryService;
import com.andawell.material.util.Utils;
import com.andawell.material.vo.TCkCrkVO;
import com.andawell.material.vo.TCkCrkqdVO;
import com.andawell.material.vo.TCkFcsjVO;
import com.andawell.material.vo.TCkWsyfVO;
import com.andawell.upms.entity.SysAccountInfo;
import com.andawell.upms.query.SysAccountInfoQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/***
 * @author lhb
 * @Date: 2020/4/27 14:59
 * @Description:
 * @version : V1.0
 */
@Api(value = "入库管理", tags = "入库管理")
@RestController
@RequestMapping(value = "sys/putInStorage")
public class BaseLibraryController {

    @Autowired
    IRepairedLibraryService repairedLibraryService;

    @Autowired
    IContractLibraryService contractLibraryService;

    @Autowired
    IScrapLibraryService scrapLibraryService;

    @Autowired
    CallOilSeaService callOilSeaService;

    @Autowired
    ISendRepairLibraryService sendRepairLibraryService;

    @Autowired
    IBaseLibraryService baseLibraryService;

    @Autowired
    ReturnToFactoryLibraryService returnToFactoryLibraryService;

    @Autowired
    IRotateService rotateService;

    @Autowired
    ITCkFcsjService tCkFcsjService;

    @Autowired
    ITCkWsYfService tCkWsYfService;

    @ApiOperation(value = "全新/可用/发付/其他/入库")
    @PostMapping(value = "save/newOtherIn")
    @SysLog(value = "全新/可用/发付/其他/入库", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<Boolean> newOtherIn(@RequestBody @Valid LibraryInfoDTO libraryInfoDTO) {
        Boolean isSuccess = baseLibraryService.saveInLibraryInfo(libraryInfoDTO);
        return Utils.getAddResult(isSuccess);
    }

    @ApiOperation(value = "全新/可用/轮换入库")
    @PostMapping(value = "save/rotateIn")
    @SysLog(value = "全新/可用/轮换入库", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<Boolean> rotateIn(@RequestBody @Valid LibraryInfoDTO libraryInfoDTO) throws Exception {
        Boolean isSuccess = rotateService.rotateTypeSaveStockInfo(libraryInfoDTO);
        return Utils.getAddResult(isSuccess);
    }

    @ApiOperation(value = "待修/发付/入库")
    @PostMapping(value = "save/repairedIn")
    @SysLog(value = "待修/发付/入库", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<Boolean> repairedIn(@RequestBody @Valid RepairedLibraryDTO repairedLibraryDTO) {
        Boolean isSuccess = repairedLibraryService.saveRepairedStockInfo(repairedLibraryDTO);
        return Utils.getAddResult(isSuccess);
    }

    @ApiOperation(value = "待修退修入库")
    @PostMapping(value = "save/repairedReturnIn")
    @SysLog(value = "待修退修入库", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<Boolean> repairedReturnIn(@RequestBody @Valid RepairedLibraryDTO repairedLibraryDTO) {
        Boolean isSuccess = repairedLibraryService.repairReturnStatus(repairedLibraryDTO);
        return Utils.getAddResult(isSuccess);
    }

    @ApiOperation(value = "订货合同入库")
    @PostMapping(value = "save/contract")
    @SysLog(value = "订货合同入库", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<String> addContract(@RequestBody @Valid ContractInfoDTO contractInfoDTO) {
        return Utils.getAddResult(contractLibraryService.addContract(contractInfoDTO));
    }

    @ApiOperation(value = "可用入库-送修返回入库")
    @PostMapping(value = "save/repair/return")
    @SysLog(value = "可用入库-送修返回入库", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<String> repairReturn(@RequestBody @Valid RepairReturnInfoDTO repairReturnInfoDTO) {
        return Utils.getAddResult(sendRepairLibraryService.saveInLibraryInfo(repairReturnInfoDTO));
    }

    @ApiOperation(value = "合同多到入库")
    @PostMapping(value = "save/multipe/contract")
    @SysLog(value = "可用入库-送修返回入库", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<String> multipeContract(@RequestBody @Valid ContractInfoDTO contractInfoDTO) {
        Boolean state = contractLibraryService.addMultipeContract(contractInfoDTO);
        return Utils.getAddResult(state);
    }


    @ApiOperation(value = "返厂升级入库")
    @PostMapping(value = "save/returnFactoryIn")
    @SysLog(value = "返厂升级入库", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<String> returnFactoryIn(@RequestBody @Valid LibraryInfoDTO libraryInfoDTO) {
        Boolean isSuccess = returnToFactoryLibraryService.saveInLibraryInfo(libraryInfoDTO);
        return Utils.getAddResult(isSuccess);
    }

    @ApiOperation(value = "外送油封入库")
    @PostMapping(value = "save/oilSeaIn")
    @SysLog(value = "外送油封入库", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<String> oilSeaIn(@RequestBody @Valid LibraryInfoDTO libraryInfoDTO) {
        Boolean isSuccess = callOilSeaService.saveInLibraryInfo(libraryInfoDTO);
        return Utils.getAddResult(isSuccess);
    }

    @ApiOperation(value = "报废入库")
    @PostMapping(value = "save/scrap/contract")
    @SysLog(value = "报废入库", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<String> saveScrapContract(@RequestBody @Valid ScrapInforDTO scrapInforDTO) {
        Boolean state = scrapLibraryService.saveScrapContract(scrapInforDTO);
        return Utils.getAddResult(state);
    }

    @ApiOperation(value = "报废入库/外来器材报废")
    @PostMapping(value = "save/scrap/foreign")
    @SysLog(value = "报废入库/外来器材报废", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<String> saveScrapForeign(@RequestBody @Valid ScrapInforDTO scrapInforDTO) {
        Boolean aBoolean = scrapLibraryService.saveScrapForeign(scrapInforDTO);
        return Utils.getAddResult(aBoolean);
    }

    @ApiOperation(value = "入库类别列表")
    @GetMapping(value = "receipt/category/list")
    public RestResultVo<ListPageVo<TCkCrklbQuery, TCkCrklb>> receiptCategoryList(TCkCrklbQuery tCkCrklbQuery) throws Exception {
        return new RestResultVo<ListPageVo<TCkCrklbQuery, TCkCrklb>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                baseLibraryService.getReceiptCategoryList(tCkCrklbQuery));
    }

    @ApiOperation(value = "获取系统编码")
    @GetMapping(value = "get/systemNumberByRule")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "lbjm", value = "出入库类别简码", dataType = "String", required = true),
            @ApiImplicitParam(name = "dwid", value = "dwid", dataType = "String", required = true)
    })
    public RestResultVo<String> getSystemNumberByRule(String lbjm, String dwid) {

        SystemNoDetailDTO systemNoDetailDTO = new SystemNoDetailDTO(lbjm, dwid);
        String systemNumber = baseLibraryService.getSystemNumber(systemNoDetailDTO);
        return new RestResultVo<String>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                systemNumber);
    }

    @ApiOperation(value = "冲销主列表")
    @GetMapping(value = "get/writeOff/list")
    public RestResultVo<ListPageVo<TCkCrkQuery, TCkCrkVO>> receiptCategoryList(TCkCrkQuery tCkCrkQuery) throws Exception {
        return new RestResultVo<ListPageVo<TCkCrkQuery, TCkCrkVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                baseLibraryService.getTCkCrkVOList(tCkCrkQuery));
    }

    @ApiOperation(value = "出入库清单列表查询")
    @GetMapping(value = "get/tckCrkList")
    public RestResultVo<List<TCkCrkqdVO>> getTckCrkList(TCkCrkqdQuery tCkCrkqdQuery) throws Exception {
        return new RestResultVo<List<TCkCrkqdVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                baseLibraryService.getTckCrkQdList(tCkCrkqdQuery));
    }

    @ApiOperation(value = "获取入库文号")
    @GetMapping(value = "get/documentNo")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "jxid", value = "机型id", dataType = "String", required = true),
            @ApiImplicitParam(name = "zllb", value = "质量类别", dataType = "String", required = true),
            @ApiImplicitParam(name = "jm", value = "机型简码", dataType = "String", required = true)
    }
    )
    public RestResultVo<String> getDocumentNo(String jxid, String zllb, String jm) {

        SystemNoDetailDTO systemNoDetailDTO = new SystemNoDetailDTO(jxid, zllb, jm);
        String documentNo = baseLibraryService.getDocumentNo(systemNoDetailDTO);
        return new RestResultVo<String>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                documentNo);
    }


    @ApiOperation(value = "文号验证")
    @GetMapping(value = "get/documentNoIsExit")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "wh", value = "机型简码", dataType = "String", required = true)
    }
    )
    public RestResultVo<Boolean> documentNoIsExit(String wh) {
        Boolean aBoolean = baseLibraryService.isExit(wh);
        return new RestResultVo<Boolean>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                aBoolean);
    }

    @ApiOperation(value = "获取返厂升级列表")
    @GetMapping(value = "get/getTCkFcsjList")
    public RestResultVo<ListPageVo<TCkFcsjQuery, TCkFcsjVO>> getTCkFcsjList(TCkFcsjQuery tCkFcsjQuery) {
        return new RestResultVo<ListPageVo<TCkFcsjQuery, TCkFcsjVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                tCkFcsjService.getTCkFcsjList(tCkFcsjQuery));
    }

    @ApiOperation(value = "获取油封入库列表")
    @GetMapping(value = "get/getTCkWsYfList")
    public RestResultVo<ListPageVo<TCkWsyfQuery, TCkWsyfVO>> getTCkWsYfList(TCkWsyfQuery tCkWsyfQuery) {
        return new RestResultVo<ListPageVo<TCkWsyfQuery, TCkWsyfVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                tCkWsYfService.getTCkWsYfList(tCkWsyfQuery));
    }

    @ApiOperation(value = "入库预览-返回编号")
    @PostMapping(value = "get/preview")
    @SysLog(value = "入库预览-返回编号", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<String> getPreview(@RequestBody AccessPreviewQuery accessPreviewQuery) {
        //用户id
        String userId = SysUserUtils.getUserId();
        //先删除
        baseLibraryService.delPreview(userId);
        //再添加
        return new RestResultVo<String>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE,
                baseLibraryService.getPreview(accessPreviewQuery));
    }

}
