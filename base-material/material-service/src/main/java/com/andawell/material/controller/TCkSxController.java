package com.andawell.material.controller;

import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.entity.TCkSx;
import com.andawell.material.entity.response.TCkSxBO;
import com.andawell.material.query.TCkSxLikeQuery;
import com.andawell.material.query.TCkSxQuery;
import com.andawell.material.service.ITCkSxService;
import com.andawell.material.util.BeanUtils;
import com.andawell.material.vo.TCkSxVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @Date： 2020/5/6 14:18
 */
@Api(value = "送修信息", tags = "送修信息")
@RestController
@RequestMapping(value = "sys/tcksx")
public class TCkSxController {
    @Autowired
    private ITCkSxService itCkSxService;

    @ApiOperation(value = "送修返回入库列表", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "repair/return/list")
    public RestResultVo<List<TCkSxVO>> repairReturn(@Valid TCkSxQuery tCkSxQuery) {
        return new RestResultVo<List<TCkSxVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                BeanUtils.copyList(itCkSxService.repairReturn(tCkSxQuery), TCkSxVO.class));
    }

    @ApiOperation(value = "待修退修入库列表", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "repair/retreat/list")
    public RestResultVo<List<TCkSxVO>> repairRetreat(@Valid TCkSxQuery tCkSxQuery) {
        return new RestResultVo<List<TCkSxVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                BeanUtils.copyList(itCkSxService.repairRetreat(tCkSxQuery), TCkSxVO.class));
    }

}