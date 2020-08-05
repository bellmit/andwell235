package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.dto.*;
import com.andawell.material.query.YFPlanQuery;
import com.andawell.material.service.TCkCkSerivce;
import com.andawell.material.util.Utils;
import com.andawell.material.utils.ValidableList;
import com.andawell.material.vo.TCkCkPlanVO;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/***
 * @author hwd
 * @Date: 2020-05-09 17:38
 * @Description:
 * @version : V1.0
 */
@Api(value = "内部油封接口", tags = "内部油封接口")
@RestController
@RequestMapping(value = "sys/tckck")
public class TCkCkController {


    @Autowired
    private TCkCkSerivce tCkCkSerivce;

    /**
     * 获取内部油封信息
     */
    @ApiOperation(value = "获取内部油封信息")
    @GetMapping(value = "get/YFMessage")
    public RestResultVo<List<TCkCkPlanVO>> getList(@Valid YFPlanQuery yfPlanQuery)
    {
        return new RestResultVo<>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                tCkCkSerivce.getList(yfPlanQuery));
    }



    /**
     * 内部油封-拟定油封计划-保存计划信息
     */
    @ApiOperation(value = "保存拟定油封计划信息")
    @PostMapping(value = "save/YFMessage")
    @SysLog(value = "保存拟定油封计划信息", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<Object> saveFkMessage(@RequestBody @Valid ValidableList<TCkCkPlanDTO> tCkCkPlanDTO)
    {
        tCkCkSerivce.saveFkMessage(tCkCkPlanDTO);
        return new RestResultVo<Object>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
    }


    /**
     * 内部油封-油封完成数据提交
     */
    @ApiOperation(value = "油封完成数据提交")
    @PutMapping(value = "save/PutYFData")
    @SysLog(value = "油封完成数据提交", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo<Object> putYFData(@RequestBody @Valid ValidableList<PutYFDataDTO> putYFDataDTOs)
    {
        tCkCkSerivce.putYFData(putYFDataDTOs);
        return new RestResultVo<Object>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
    }




    /**
     * 保管队油封管理-油封数据确认
     */
    @ApiOperation(value = "保管队油封管理-油封数据确认")
    @PutMapping(value = "save/YFData")
    @SysLog(value = "保管队油封管理-油封数据确认", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo<Object> saveYFData(@RequestBody @Valid ValidableList<YFDataAffirmDTO> yfDataAffirmDTOs)
    {
        tCkCkSerivce.saveYFData(yfDataAffirmDTOs);
        return new RestResultVo<Object>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
    }

    /**
        * 保管队油封管理-油封完成接收确认
     * ConfirmYFReceive
     * 确认油封接收
     */
    @ApiOperation(value = "保管队油封管理-油封完成接收确认")
    @PutMapping(value = "save/ConfirmYFReceive")
    @SysLog(value = "保管队油封管理-油封完成接收确认", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo<Object> confirmYFReceive(@RequestBody @Valid ValidableList<ConfirmYFReceiveDTO> confirmYFReceiveDTOs)
    {
        tCkCkSerivce.confirmYFReceive(confirmYFReceiveDTOs);
        return new RestResultVo<Object>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
    }


    /**
     * 保管队油封管理-油封完成上架
     * YFCompletedShelves
     * 油封上架
     */
    @ApiOperation(value = "保管队油封管理-油封完成上架")
    @PutMapping(value = "save/YFCompletedShelves")
    @SysLog(value = "保管队油封管理-油封完成上架", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo<Object> YFCompletedShelves(@RequestBody @Valid ValidableList<YFCompletedShelvesDTO> yfCompletedShelvesDTOs)
    {
        tCkCkSerivce.YFCompletedShelves(yfCompletedShelvesDTOs);
        return new RestResultVo<Object>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
    }



}
