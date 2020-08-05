package com.andawell.material.controller;

import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.entity.TJhZylx;
import com.andawell.material.entity.TSxLb;
import com.andawell.material.query.TJhZylxQuery;
import com.andawell.material.query.TSxLbQuery;
import com.andawell.material.service.ITSxLbService;
import com.andawell.material.util.BeanUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: zje
 * @date: 2020/5/9
 * @description:
 */
@Api(value = "送修类别接口", tags = "送修类别接口")
@RestController
@RequestMapping(value = "sys/tsxlb")
public class TSxLbController {

    @Autowired
    private ITSxLbService sxLbService;


    /**
     *@Author: zje
     *@Data: 2020/5/9
     *@Description: 查询所有送修类别
     */
    @ApiOperation(value = "查询所有送修类别", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "list")
    public RestResultVo<List<TSxLb>> list(TSxLbQuery query) {
        return new RestResultVo<List<TSxLb>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                BeanUtils.copyList(sxLbService.list(query), TSxLb.class));
    }
}
