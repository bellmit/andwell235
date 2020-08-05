package com.andawell.material.controller;

import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.query.THtDhQuery;
import com.andawell.material.query.THtDhqdQuery;
import com.andawell.material.service.ITHtDhService;
import com.andawell.material.service.ITHtDhqdService;
import com.andawell.material.util.BeanUtils;
import com.andawell.material.vo.THtDhVO;
import com.andawell.material.vo.THtDhqdVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Date： 2020/4/28 11:29
 */
@Api(value = " 合同接口", tags = "合同接口", produces =
        MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
@RequestMapping(value = "sys/thtdh", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class  THtDhController {
    @Autowired
    private ITHtDhService itHtDhService;
    @Autowired
    private ITHtDhqdService itHtDhqdService;


    @ApiOperation(value = "根据机型查询合同", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "list")
    public RestResultVo<List<THtDhVO>> list(@Valid THtDhQuery tHtDhQuery) {
        return new RestResultVo<List<THtDhVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                BeanUtils.copyList(itHtDhService.getListAndCfmc(tHtDhQuery), THtDhVO.class));
    }

    @ApiOperation(value = "根据合同查询合同清单", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "detailed/list")
    public RestResultVo<List<THtDhqdVO>> detailedList(@Valid THtDhqdQuery tHtDhqdQuery) {
        return new RestResultVo<List<THtDhqdVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                itHtDhqdService.detailedList(tHtDhqdQuery));
    }

}
