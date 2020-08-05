package com.andawell.material.controller;

import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.query.CurrencyQuery;
import com.andawell.material.service.ICurrencyInfoInfoService;
import com.andawell.material.util.BeanUtils;
import com.andawell.material.vo.CurrencyVO;
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
 * @Date: 16:50
 * @Description:
 * @version : V1.0
 */
@Api(value = "币种接口", tags = "币种接口")
@RestController
@RequestMapping(value = "sys/currency")
public class CurrencyController {

    @Autowired
    ICurrencyInfoInfoService currencyInfoInfoService;

    @ApiOperation(value = "查询币种列表")
    @GetMapping(value = "list")
    public RestResultVo<List<CurrencyVO>> getCurrencyList(@Valid CurrencyQuery query) {
        return new RestResultVo<List<CurrencyVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                BeanUtils.copyList(currencyInfoInfoService.list(query),CurrencyVO.class));
    }

}
