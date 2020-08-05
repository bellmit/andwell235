package com.andawell.material.controller;

import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.entity.TJhZylx;
import com.andawell.material.query.TCfQuery;
import com.andawell.material.query.TJhZylxQuery;
import com.andawell.material.service.ITCfService;
import com.andawell.material.util.BeanUtils;
import com.andawell.material.vo.TCfVO;
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
@Api(value = "厂房接口", tags = "厂房接口")
@RestController
@RequestMapping(value = "sys/tCf")
public class TCfController {

    @Autowired
    private ITCfService tCfService;

    /**
     *@Author: zje
     *@Data: 2020/5/12
     *@Description: 查询所有维修单位
     */
    @ApiOperation(value = "查询所有维修单位", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "list")
    public RestResultVo<List<TCfVO>> list(TCfQuery query) {
        return new RestResultVo<List<TCfVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                BeanUtils.copyList(tCfService.list(query), TCfVO.class));
    }
}
