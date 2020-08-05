package com.andawell.material.controller;

import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.query.TJhZlQuery;
import com.andawell.material.service.ITJhZlService;
import com.andawell.material.util.BeanUtils;
import com.andawell.material.vo.TJhZlVO;
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
@Api(value = "质量等级", tags = "质量等级")
@RestController
@RequestMapping(value = "sys/tjhzl")
public class        TJhZlController {
    @Autowired
    ITJhZlService itJhZlService;

    @ApiOperation(value = "查询质量等级列表")
    @GetMapping(value = "list")
    public RestResultVo<List<TJhZlVO>> getXtCkList(@Valid TJhZlQuery query) {
        return new RestResultVo<List<TJhZlVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                BeanUtils.copyList(itJhZlService.list(query),TJhZlVO.class));
    }

}
