package com.andawell.purchase.controller;


import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;

import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.common.util.ValidableList;
import com.andawell.purchase.config.SQLiteInstance;
import com.andawell.purchase.constant.NoticeConstant;
import com.andawell.purchase.dto.TCkCrkXfDTO;
import com.andawell.purchase.dto.TDhJhqdDTO;
import com.andawell.purchase.dto.THtDTO;
import com.andawell.purchase.enumeration.SqlLiteTableNameEnum;
import com.andawell.purchase.dto.THtXfDTO;
import com.andawell.purchase.service.OrgansBrigadeService;

import com.andawell.purchase.vo.TCfVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;


/***
 * @author gzh
 * @Date: 2020/6/10 13:40
 * @Description: 机关旅团的下发导入
 * @version : V1.0
 */
@Api(value = "机关旅团的下发导入", tags = "机关旅团的下发导入")
@RestController
@RequestMapping(value = "sys/uploadAndSend")
@Slf4j
public class OrgansBrigadeController {


    @Autowired
    OrgansBrigadeService organsBrigadeService;

    /**
     *@Auther:gzh
     *@Date:2020/6/10 15:53
     *@Description:
     *@Param:
     *@return:
     */
    @ApiOperation(value = "机关生成合同下发旅团返回DB文件")
    @PostMapping(value = "transmission")
    @SysLog(value = "机关生成合同下发旅团返回DB文件", operationType = LogTypeConstant.LOG_EXPORT_TYPE)
    public RestResultVo transmission(HttpServletResponse response, @RequestBody @Valid ValidableList<THtXfDTO> tHtXfDTOS) {
        try {
            organsBrigadeService.transmission(response, tHtXfDTOS);
            return new RestResultVo<Boolean>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_EXPORT_SUCCESS_MESSAGE);
        }catch (Exception e){
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_EXPORT_ERROR_MESSAGE,e.getMessage());
        }
    }

    /**
     *@Auther:gzh
     *@Date:2020/6/10 15:53
     *@Description:
     *@Param:
     *@return:
     */
    @ApiOperation(value = "旅团合同入库单上报")
    @PostMapping(value = "ntransmission")
    @SysLog(value = "旅团合同入库单上报", operationType = LogTypeConstant.LOG_EXPORT_TYPE)
    public RestResultVo ntransmission(HttpServletResponse response, @RequestBody @Valid ValidableList<TCkCrkXfDTO> tCkCrkXfDTOS) {
        try {
            organsBrigadeService.ntransmission(response, tCkCrkXfDTOS);
            return new RestResultVo<Boolean>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_EXPORT_SUCCESS_MESSAGE);
        }catch (Exception e){
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_EXPORT_ERROR_MESSAGE,e.getMessage());
        }
    }


    @GetMapping
    @ApiOperation(value = "sqlLit 测试")
    public void test(){
        //清楚数据
        SQLiteInstance.getInstance().closezb(SqlLiteTableNameEnum.T_HT.getCode());
        SQLiteInstance.getInstance().closezb(SqlLiteTableNameEnum.T_HT_QD.getCode());
    }

    @ApiOperation(value = "旅团接收合同数据")
    @PostMapping(value = "lt/receive/data")
    @SysLog(value = "旅团接收合同数据",operationType = LogTypeConstant.LOG_IMPORT_TYPE)
    public RestResultVo ltReceiveData(@RequestParam("file") MultipartFile multipartFile){
        Boolean upload = organsBrigadeService.ltReceiveData(multipartFile);
        return getLeadResult(upload);
    }

    @ApiOperation(value = "机关接收采购数据")
    @PostMapping(value = "jg/receive/cg/data")
    @SysLog(value = "机关接收采购数据",operationType = LogTypeConstant.LOG_IMPORT_TYPE)
    public RestResultVo jgReceiveCgData(@RequestParam("file") MultipartFile multipartFile){
        Boolean upload = organsBrigadeService.jgReceiveCgData(multipartFile);
        return getLeadResult(upload);
    }

    @ApiOperation(value = "机关接收采购数据保存")
    @PostMapping(value = "jg/save/cg/data")
    @SysLog(value = "机关接收采购数据",operationType = LogTypeConstant.LOG_IMPORT_TYPE)
    public RestResultVo jgSaveCgData(@RequestBody @Valid ValidableList<TCkCrkXfDTO> list){
        Boolean upload = organsBrigadeService.saveJgCgData(list);
        return getLeadResult(upload);
    }

    @ApiOperation(value = "机关缓存数据删除")
    @PostMapping(value = "lt/delete/jg/receive/data")
    @SysLog(value = "机关缓存数据删除",operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo deleteJgReceiveData(@RequestBody @Valid ValidableList<TCkCrkXfDTO> list){
        Boolean upload = organsBrigadeService.deleteJgReceiveData(list);
        return getDeleteResult(upload);
    }

    @ApiOperation(value = "旅团接收合同数据保存")
    @PostMapping(value = "lt/save/receive/data")
    @SysLog(value = "旅团接收合同数据保存",operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo saveReceiveData(@RequestBody @Valid ValidableList<THtDTO> list){
        Boolean upload = organsBrigadeService.saveReceiveData(list);
        return getLeadResult(upload);
    }

    @ApiOperation(value = "旅团缓存数据删除")
    @PostMapping(value = "lt/delete/receive/data")
    @SysLog(value = "旅团缓存数据删除",operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo deleteReceiveData(@RequestBody @Valid ValidableList<THtDTO> list){
        Boolean upload = organsBrigadeService.deleteReceiveData(list);
        return getDeleteResult(upload);
    }


    /**
     * 导入成功失败
     * @param isSuccess
     * @return
     */
    public RestResultVo getLeadResult(Boolean isSuccess){
        RestResultVo<Boolean> responseResult;
        if (isSuccess) {
            responseResult = new RestResultVo<Boolean>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_IMPORT_SUCCESS_MESSAGE);
        } else {
            responseResult = new RestResultVo<Boolean>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_IMPORT_ERROR_MESSAGE);
        }
        return responseResult;
    }

    /**
     * 删除成功失败
     * @param isSuccess
     * @return
     */
    public RestResultVo getDeleteResult(Boolean isSuccess){
        RestResultVo<Boolean> responseResult;
        if (isSuccess) {
            responseResult = new RestResultVo<Boolean>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } else {
            responseResult = new RestResultVo<Boolean>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
        return responseResult;
    }
}
