package com.andawell.purchase.controller;


import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.vo.TCkCrkqdVO;
import com.andawell.purchase.constant.NoticeConstant;
import com.andawell.purchase.dto.TDhJhDTO;
import com.andawell.purchase.dto.THtFkDTO;
import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.purchase.constant.NoticeConstant;
import com.andawell.purchase.entity.THtQd;
import com.andawell.purchase.query.THtFkQuery;
import com.andawell.purchase.service.ITHtFkService;

import com.andawell.purchase.vo.TDhJhqdVO;
import com.andawell.purchase.vo.THtFkVO;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/***
 * @author gzh
 * @Date: 2020/6/2 13:40
 * @Description:
 * @version : V1.0
 */
@Api(value = "合同付款", tags = "合同付款")
@RestController
@RequestMapping(value = "sys/htfk")
@Slf4j
public class THtFkController {

    @Autowired
    ITHtFkService itHtFkService;


    @ApiOperation(value = "合同付款保存", notes = "合同付款保存", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "post/insert")
    @SysLog(value = "合同付款保存", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo insert(@RequestBody @Valid THtFkDTO tHtFkDTO) {
        try {
            itHtFkService.insert(tHtFkDTO);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE,e.getMessage());
        }
    }

    @ApiOperation(value = "合同入库单明细查询",notes = "合同入库单明细查询")
    @GetMapping("get/rkdDetail")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "rkbh", value = "入库编号", dataType = "String", required = true)
    }
    )
    public RestResultVo<List<TCkCrkqdVO>> getRkdDetail (String rkbh) {
        try {
            // 合同入库单明细

            List<TCkCrkqdVO> list = itHtFkService.getHtRkDList(rkbh);

            return new RestResultVo (RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,list);
        }catch (Exception e){
            e.printStackTrace();
            return new RestResultVo<List<TCkCrkqdVO>>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE);
        }
    }

    @ApiOperation(value = "合同入库单查询", notes = "合同入库单查询", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "rkd/listPage")
    public RestResultVo<ListPageVo<THtFkQuery, THtFkVO>> listHtFk(THtFkQuery query) {
        return new RestResultVo<ListPageVo<THtFkQuery, THtFkVO>>(RestStatus.SUCCESS,NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE
                ,itHtFkService.listPageHtFk(query));
    }


    @ApiOperation(value = "合同入库单查看", notes = "合同入库单查看", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "rkd/listckPage")
    public RestResultVo<ListPageVo<THtFkQuery, THtFkVO>> listHtFkck(THtFkQuery query) {
        return new RestResultVo<ListPageVo<THtFkQuery, THtFkVO>>(RestStatus.SUCCESS,NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE
                ,itHtFkService.listPageHtFkck(query));
    }
}
