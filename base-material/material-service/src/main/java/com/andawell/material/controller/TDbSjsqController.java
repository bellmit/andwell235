package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.query.TDbJgdbQuery;
import com.andawell.material.service.ITDbJgdbService;
import com.andawell.material.service.ITDbSjsqService;
import com.andawell.material.service.ITDbSjsqqdService;
import com.andawell.material.util.Utils;
import com.andawell.material.vo.TDbSjsqVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author: zje
 * @date: 2020/6/1
 * @description:
 */

@Api(value = "上级申请", tags = "上级申请")
@RestController
@RequestMapping(value = "sys/tdbsjsq")
public class TDbSjsqController {

    @Autowired
    private ITDbSjsqService itDbSjsqService;

    /**
     *@Auther: zje
     *@Date: 2020/5/30
     *@Description: 上级申请查询
     *@Param: query
     *@return:
     */
    @ApiOperation(value = "上级申请查询")
    @GetMapping(value = "list")
    public RestResultVo<ListPageVo<TDbJgdbQuery,TDbSjsqVO>> list(@Valid TDbJgdbQuery query){
        ListPageVo<TDbJgdbQuery,TDbSjsqVO> dbTDbSjsqVOS = itDbSjsqService.list(query);
        return new RestResultVo<ListPageVo<TDbJgdbQuery,TDbSjsqVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                dbTDbSjsqVOS);
    }

}
