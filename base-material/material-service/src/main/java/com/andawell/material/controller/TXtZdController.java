package com.andawell.material.controller;

import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.dto.LibraryInfoDTO;
import com.andawell.material.entity.TCkCrklb;
import com.andawell.material.entity.TXtZd;
import com.andawell.material.query.TXtZdQuery;
import com.andawell.material.service.ITXtZdService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @Date： 2020/5/6 11:48
 */
@Api(value = "交旧单位接口", tags = "交旧单位接口")
@RestController
@RequestMapping(value = "sys/xtzd")
public class TXtZdController {

    @Autowired
    private ITXtZdService itXtZdService;

    @ApiOperation(value = "根据单位id查找交旧单位")
    @PostMapping(value = "get/old/unit")
    public RestResultVo<List<TXtZd>> oldUnit(@Valid TXtZdQuery tXtZdQuery) {
        return new RestResultVo<List<TXtZd>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                itXtZdService.list(tXtZdQuery));
    }

}
