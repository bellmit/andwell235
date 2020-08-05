package com.andawell.material.controller;/**
 * @Date： 2020/5/27 8:53
 */

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.dto.TDbLtsqDTO;
import com.andawell.material.dto.ZQSaveDTO;
import com.andawell.material.dto.groups.First;
import com.andawell.material.entity.TDbLtsq;
import com.andawell.material.entity.TDbLtsqqd;
import com.andawell.material.query.TCkCkQuery;
import com.andawell.material.query.TDbLtsqQuery;
import com.andawell.material.service.IBrigadeApplyService;
import com.andawell.material.util.Utils;
import com.andawell.material.vo.ReasonVO;
import com.andawell.material.vo.StockVO;
import com.andawell.material.vo.TDbLtsqAndQDVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Auther:liuys
 * @Date:2020/5/27 08:53
 * @Description:
 */
@Api(value = "调拨管理-旅团申请", tags = "调拨管理-旅团申请")
@RestController
@RequestMapping(value = "sys/brigade/apply")
public class BrigadeApplyController {
    @Autowired
    IBrigadeApplyService brigadeApplyService;

    @ApiOperation(value = "查询全新-可用-待修-在修数量")
    @GetMapping(value = "get/statistics")
    public RestResultVo<StockVO> getStatistics(@Validated({First.class}) TCkCkQuery tCkCkQuery) {
        return new RestResultVo<StockVO>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                brigadeApplyService.getStatistics(tCkCkQuery));
    }


    /**
     *@Author: liuys
     *@Data: 2020/5/27
     *@Description: 旅团航材申请批量添加
     */
    @ApiOperation(value = "旅团航材申请批量添加")
    @PostMapping(value = "insert")
    @SysLog(value = "旅团航材申请批量添加", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<String> insert(@RequestBody TDbLtsqDTO tDbLtsqDTO) {
        Boolean aBoolean = brigadeApplyService.insert(tDbLtsqDTO);
        return Utils.getAddResult(aBoolean);
    }

    /**
     *@Author: liuys
     *@Data: 2020/5/27
     *@Description: 旅团申请单号
     */
    @ApiOperation(value = "旅团申请单号")
    @GetMapping(value = "get/number")
    public RestResultVo<String> getNumber() {
        return new RestResultVo<String>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                brigadeApplyService.getNumber());
    }

    /**
     *@Author: liuys
     *@Data: 2020/5/29
     *@Description: 申请原因下拉列表
     */
    @ApiOperation(value = "申请原因下拉列表")
    @GetMapping(value = "get/reason")
    public RestResultVo<List<ReasonVO>> getReason() {
        return new RestResultVo<List<ReasonVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                brigadeApplyService.getReason());
    }

    /**
     *@Author: liuys
     *@Data: 2020/6/2
     *@Description:
     */
    @ResponseBody
    @ApiOperation(value = "下发")
    @PostMapping(value = "transmission")
    @SysLog(value = "下发", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo<String> transmission(HttpServletResponse response, @RequestBody List<String> ltsqdh) {
        brigadeApplyService.transmission(response, ltsqdh);
        return new RestResultVo<String>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_EXPORT_SUCCESS_MESSAGE);
    }
    /**
     *@Author: liuys
     *@Data: 2020/6/2
     *@Description:
     */
    @ApiOperation(value = "上传")
    @PostMapping(value = "upload")
    @SysLog(value = "上传", operationType = LogTypeConstant.LOG_UPLOAD_TYPE)
    public RestResultVo<List<TDbLtsqAndQDVO>> upload(@RequestParam("file") MultipartFile multipartFile) {
        return new RestResultVo<List<TDbLtsqAndQDVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_UPLOAD_SUCCESS_MESSAGE,
                brigadeApplyService.upload(multipartFile));
    }


    @ApiOperation(value = "查询明细")
    @GetMapping(value = "get/ltsqmx")
    public RestResultVo<ListPageVo<TDbLtsqQuery, TDbLtsqqd>> getList(TDbLtsqQuery tDbLtsqQuery) {
        return new RestResultVo<ListPageVo<TDbLtsqQuery, TDbLtsqqd>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                brigadeApplyService.getList(tDbLtsqQuery));
    }

    @ApiOperation(value = "保存到历史信息表")
    @PostMapping(value = "save/historyLt")
    @SysLog(value = "保存到历史信息表", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<Boolean> saveToLtHistory(@RequestBody List<String> ltsqdh) {
        Boolean aBoolean = brigadeApplyService.saveToLtHistory(ltsqdh);
        return Utils.getAddResult(aBoolean);
    }


    @ApiOperation(value = "删除历史信息表中的数据")
    @DeleteMapping(value = "delete/historyLt")
    @SysLog(value = "删除历史信息表中的数据", operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo<Boolean> deleteToLtHistory(@RequestBody List<String> ltsqdh) {
        Boolean aBoolean = brigadeApplyService.deleteToLtHistory(ltsqdh);
        return Utils.deleteDataResult(aBoolean);
    }




    @ApiOperation(value = "保存到业务数据库")
    @PostMapping(value = "save/ltSQ")
    @SysLog(value = "保存到历史信息表", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<Boolean> saveToLtSQ(@RequestBody ZQSaveDTO zqSaveDTO) {
        Boolean aBoolean = brigadeApplyService.saveToLtSQ(zqSaveDTO);
        return Utils.getAddResult(aBoolean);
    }

}
