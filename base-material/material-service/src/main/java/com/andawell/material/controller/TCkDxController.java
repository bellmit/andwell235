package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.dto.BatchChangeDTO;
import com.andawell.material.entity.TCkDx;
import com.andawell.material.query.TCKFyfsQuery;
import com.andawell.material.query.TCkDxQuery;
import com.andawell.material.query.TCkSxQuery;
import com.andawell.material.service.ITCkSxService;
import com.andawell.material.service.TCkDxService;
import com.andawell.material.util.BeanUtils;
import com.andawell.material.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/***
 * @author hwd
 * @Date: 2020/5/7 13:52
 * @Description:待修库管理
 * @version : V1.0
 */
@Api(value = "待修库管理", tags = "待修库管理")
@RestController
@RequestMapping(value = "sys/tckdx")
public class TCkDxController
{

    @Autowired
    private TCkDxService tCkDxService;

    @Autowired
    private ITCkSxService itCkSxService;

    @ApiOperation(value = "待修库查询")
    @GetMapping(value = "get/list")
    public RestResultVo<ListPageVo<TCkDxQuery, TCkDxStatusVO>> getTCKDXList(TCkDxQuery query) {
        return new RestResultVo<ListPageVo<TCkDxQuery, TCkDxStatusVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                tCkDxService.list(query));
    }

    @ApiOperation(value = "待修出库-待修库查询")
    @GetMapping(value = "get/outLibrary/list")
    public RestResultVo<ListPageVo<TCkDxQuery, TCkDxOutLibraryVO>> outLibraryList( @Valid TCkDxQuery query) {
        return new RestResultVo<ListPageVo<TCkDxQuery, TCkDxOutLibraryVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                tCkDxService.outLibraryList(query));
    }

    @ApiOperation(value = "待修库查询")
    @GetMapping(value = "get/sendForRepair/list")
    public RestResultVo<ListPageVo<TCkDxQuery, TCkDxSendForRepairVO>> getSendRepairList( @Valid TCkDxQuery query) {
        return new RestResultVo<ListPageVo<TCkDxQuery, TCkDxSendForRepairVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                tCkDxService.getSendRepairList(query));
    }



    @ApiOperation(value = "待修库查询状态变更")
    @PutMapping(value = "update/batchChange")
    @SysLog(value = "待修库查询状态变更", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo<Object>batchChange(@RequestBody @Valid BatchChangeDTO batchChangeDTO)
    {
        tCkDxService.batchChange(batchChangeDTO);
        return new RestResultVo<Object>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
    }

    @ApiOperation(value = "待修退修入库列表", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "repair/retreat/list")
    public RestResultVo<List<TCkSxVO>> repairRetreat(@Valid TCkSxQuery tCkSxQuery) {
        return new RestResultVo<List<TCkSxVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                BeanUtils.copyList(itCkSxService.repairRetreat(tCkSxQuery), TCkSxVO.class));
    }
}

