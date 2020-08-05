package com.andawell.material.controller;

import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.query.TXtCkQuery;
import com.andawell.material.service.ITXtCkService;
import com.andawell.material.util.BeanUtils;
import com.andawell.material.vo.TXtCkVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/***
 * @author lhb
 * @Date: 2020/4/27 14:59
 * @Description:
 * @version : V1.0
 */
@Api(value = "仓库接口", tags = "仓库接口")
@RestController
@RequestMapping(value = "sys/xtCk")
public class TXtCkController {
    @Autowired
    ITXtCkService tXtCkService;

    @ApiOperation(value = "查询仓库列表")
    @GetMapping(value = "list")
    public RestResultVo<List<TXtCkVO>> getXtCkList(@Valid TXtCkQuery query) {
        return new RestResultVo<List<TXtCkVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                BeanUtils.copyList(tXtCkService.list(query),TXtCkVO.class));
    }
}
