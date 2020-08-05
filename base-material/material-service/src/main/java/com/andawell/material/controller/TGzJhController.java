package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.query.TCkCkQuery;
import com.andawell.material.service.TCkCkSerivce;
import com.andawell.material.vo.TCkCkVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:PCJ
 * @Date:2020/6/4
 * @Version:V1.0.0
 */
@Api(value = "关注件", tags = "关注件")
@RequestMapping(value = "sys/gzjh")
@RestController
public class TGzJhController {

    @Autowired
    private TCkCkSerivce tCkCkSerivce;

    @ApiOperation(value = "公共关注件")
    @GetMapping("tckck/gz/all")
    public RestResultVo<ListPageVo<TCkCkQuery, TCkCkVO>> listAllGz(TCkCkQuery query) {

        return new RestResultVo<ListPageVo<TCkCkQuery, TCkCkVO>>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE
                ,tCkCkSerivce.listAllGz(query));
    }

    @ApiOperation(value = "个人关注件")
    @GetMapping("tckck/gz/byuser")
    public RestResultVo<ListPageVo<TCkCkQuery, TCkCkVO>> listUserGz(TCkCkQuery query) {

        return new RestResultVo<ListPageVo<TCkCkQuery, TCkCkVO>>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE
                ,tCkCkSerivce.listUserGz(query));
    }
}
