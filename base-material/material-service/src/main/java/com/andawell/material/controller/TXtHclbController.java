package com.andawell.material.controller;

/**
 * @Date： 2020/4/26 18:28
 */

import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.service.ITXtHclbService;
import com.andawell.material.util.BeanUtils;
import com.andawell.material.vo.TXtHclbVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 统计类别的增删改查
 */
@Api(value = "统计类别接口", tags = "统计类别接口")
@RestController
@RequestMapping(value = "sys/txthclb")
public class TXtHclbController {

    @Autowired
    private ITXtHclbService tXtHclbService;

    @ApiOperation(value = "统计类别列表查询")
    @GetMapping(value = "list")
    public RestResultVo<List<TXtHclbVO>> list() {
        return new RestResultVo<List<TXtHclbVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                BeanUtils.copyList(tXtHclbService.list(null),TXtHclbVO.class));
    }
}
