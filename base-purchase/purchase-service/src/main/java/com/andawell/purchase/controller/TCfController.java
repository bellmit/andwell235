package com.andawell.purchase.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.ListPageVo;

import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.purchase.constant.NoticeConstant;
import com.andawell.purchase.query.TCfQuery;

import com.andawell.purchase.service.ITCfService;

import com.andawell.purchase.vo.TCfVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author:PCJ
 * @Date:2020/6/5
 * @Version:V1.0.0
 */
@Api(value = "供方下拉列表", tags = "供方下拉列表")
@RestController
@RequestMapping(value = "sys/gf")
public class TCfController {

    @Autowired
    private ITCfService tCfService;

    @ApiOperation(value = "供方下拉列表",notes = "供方下拉列表")
    @GetMapping("cj/list")
    public RestResultVo<List<TCfVO>> listPage(TCfQuery query) {
        return new RestResultVo<List<TCfVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,tCfService.list(query));
    }
}
