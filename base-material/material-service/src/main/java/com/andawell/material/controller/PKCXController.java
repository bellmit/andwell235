package com.andawell.material.controller;

import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.entity.PKCX;
import com.andawell.material.query.PKCXQuery;
import com.andawell.material.service.IPKCXService;
import com.andawell.material.util.BeanUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: yzy
 * @Description:
 * @Date: created in 2020/5/25 11:08
 */
@Api(value = "库房管理-盘库查询", tags = "库房管理-盘库查询")
@RestController
@RequestMapping(value = "sys/pkQuery/query")
public class PKCXController {

    @Autowired
    IPKCXService pkcxService;

    @ApiOperation(value = "盘库全部查询")
    @PostMapping("/all/pkQuery")
    public RestResultVo<List<PKCX>> pkcx(@RequestBody PKCXQuery pkcxQuery){
        return  new RestResultVo<List<PKCX>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                BeanUtils.copyList(pkcxService.list(pkcxQuery), PKCX.class));
    }

    @ApiOperation(value = "盘库分页查询")
    @PostMapping("/page/pkQuery")
    public RestResultVo<ListPageVo<PKCXQuery, PKCX>> pkcxPage(@RequestBody PKCXQuery pkcxQuery){
        return  new RestResultVo<ListPageVo<PKCXQuery, PKCX>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                 pkcxService.getPageList(pkcxQuery));
    }
}
