package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.dto.*;
import com.andawell.material.entity.TCyDw;
import com.andawell.material.query.KFInOutQuery;
import com.andawell.material.service.KFMessageService;
import com.andawell.material.utils.ValidableList;
import com.andawell.material.vo.HistoryMessageCountVO;
import com.andawell.material.vo.KFInOutMessageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/***
 * @author hwd
 * @Date: 2020-05-15 18:13
 * @Description:库房信息修改
 * @version : V1.0
 */
@Api(value = "库房管理-库房信息修改", tags = "库房管理-库房信息修改")
@RestController
@RequestMapping(value = "sys/KFMessageUpdate")
public class KFMessageUpController {


    @Autowired
    private KFMessageService kfMessageService;


    /**
     * 查询货运单位
     */
    @ApiOperation(value = "查询货运单位")
    @GetMapping(value = "get/carrigeList")
    public RestResultVo<List<TCyDw>> getcarrigeList(){

        List<TCyDw> carrigeList = kfMessageService.getCarrigeList();
        return new RestResultVo<List<TCyDw>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,carrigeList);
    }


    /**
     * 修改根据文号
     * @param KFMessageDTO
     * @return
     */
    @ApiOperation(value = "库房信息修改-修改根据文号")
    @PutMapping(value = "update/KFMessage")
    @SysLog(value = "库房信息修改-修改根据文号", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo<Object> updateKFWH(@RequestBody @Valid KFMessageDTO KFMessageDTO){

        kfMessageService.updateKFMessage(KFMessageDTO);
        return new RestResultVo<Object>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
    }


    @ApiOperation(value = "库房信息修改-库存信息修改")
    @PutMapping(value = "update/KCMessage")
    @SysLog(value = "库房信息修改-库存信息修改", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo<Object> updateKCMessage(@RequestBody @Valid ValidableList<KCMessageDTO> kcMessageDTOS){

        kfMessageService.updateKCMessage(kcMessageDTOS);
        return new RestResultVo<Object>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
    }


    @ApiOperation(value = "库房信息修改-货运单号修改")
    @PutMapping(value = "update/HYBillNumber")
    @SysLog(value = "库房信息修改-货运单号修改", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo<Object> updateHYBillNumber(@RequestBody @Valid KFMessageDTO KFMessageDTO){

        kfMessageService.updateKFMessage(KFMessageDTO);
        return new RestResultVo<Object>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
    }




    @ApiOperation(value = "库房信息修改-入库价格修改")
    @PutMapping(value = "update/tariffRevise")
    @SysLog(value = "库房信息修改-入库价格修改", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo<Object> tariffRevise(@RequestBody @Valid ValidableList<TariffReviseDTO> TariffReviseDTOs){

        kfMessageService.tariffRevise(TariffReviseDTOs);
        return new RestResultVo<Object>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
    }


    @ApiOperation(value = "库房信息修改-油封信息修改")
    @PutMapping(value = "update/reviseYFMessage")
    @SysLog(value = "库房信息修改-油封信息修改", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo<Object> reviseYFMessage(@RequestBody @Valid ValidableList<ReviseYFMessageDTO> reviseYFMessageDTOs){

        kfMessageService.reviseYFMessage(reviseYFMessageDTOs);
        return new RestResultVo<Object>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
    }

    @ApiOperation(value = "库房信息修改-修理合同信息修改")
    @PutMapping(value = "update/repairAgreement")
    @SysLog(value = "库房信息修改-修理合同信息修改", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo<Object> repairAgreement(@RequestBody @Valid RepairAgreementDTO repairAgreementDTOS){

        kfMessageService.repairAgreement(repairAgreementDTOS);
        return new RestResultVo<Object>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
    }


    @ApiOperation(value = "库房信息修改-修理合同记录拆分")
    @PutMapping(value = "update/RecordSplit")
    @SysLog(value = "库房信息修改-修理合同记录拆分", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo<Object> repairRecordSplit(@RequestBody @Valid RecordSplitDTO repairAgreementDTOS){

        kfMessageService.repairRecordSplit(repairAgreementDTOS);
        return new RestResultVo<Object>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
    }


    @ApiOperation(value = "库房信息修改-送修记录拆分")
    @PutMapping(value = "update/deliveryRecordSplit")
    @SysLog(value = "库房信息修改-送修记录拆分", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo<Object> deliveryRecordSplit(@RequestBody @Valid RecordSplitDTO repairAgreementDTOS){

        kfMessageService.deliveryRecordSplit(repairAgreementDTOS);
        return new RestResultVo<Object>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
    }

    @ApiOperation(value = "库房信息-历史库存信息统计")
    @GetMapping(value = "get/historyList")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dcrq", value = "导出日期", dataType = "String", required = true),
            @ApiImplicitParam(name = "jx", value = "机型", dataType = "String", required = true)})
    public RestResultVo<List<HistoryMessageCountVO>> gethistoryList(String dcrq, String jx){
        return new RestResultVo<List<HistoryMessageCountVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE,
                kfMessageService.gethistoryList(dcrq, jx));
    }

    @ApiOperation(value = "库房信息-出入库查询")
    @GetMapping(value = "get/getInOutList")
    public RestResultVo<List<KFInOutMessageVO>> getInOutList(@Valid KFInOutQuery kfInOutDTO){
        return new RestResultVo<List<KFInOutMessageVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                kfMessageService.getInOutList(kfInOutDTO));
    }
}
