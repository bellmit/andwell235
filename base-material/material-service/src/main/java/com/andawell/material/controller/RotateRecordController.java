package com.andawell.material.controller;

import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.dto.LibraryInfoDTO;
import com.andawell.material.query.RotateQuery;
import com.andawell.material.service.IRotateService;
import com.andawell.material.util.BeanUtils;
import com.andawell.material.vo.CurrencyVO;
import com.andawell.material.vo.RotateVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/***
 * @author lhb
 * @Date: 2020/4/29 13:42
 * @Description:
 * @version : V1.0
 */
@Api(value = "轮换记录", tags = "轮换记录")
@RestController
@RequestMapping(value = "sys/rotateRecord")
public class RotateRecordController {

    @Autowired
    IRotateService rotateService;

    @ApiOperation(value = "根据条件获取乱换记录列表")
    @GetMapping(value = "/condition/list")
    public RestResultVo<List<RotateVO>> newOtherIn(@Valid RotateQuery rotateQuery) {
        return new RestResultVo<List<RotateVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
        BeanUtils.copyList(rotateService.getRotateListByQuery(rotateQuery), RotateVO.class));
    }

}
