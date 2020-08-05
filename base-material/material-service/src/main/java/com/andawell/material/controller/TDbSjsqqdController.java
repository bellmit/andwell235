package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.service.ITDbSjsqqdService;
import com.andawell.material.util.Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zje
 * @date: 2020/6/4
 * @description:
 */

@Api(value = "上级申请清单", tags = "上级申请清单")
@RestController
@RequestMapping(value = "sys/tdbsjsqqd")
public class TDbSjsqqdController {

    @Autowired
    private ITDbSjsqqdService itDbSjsqqdService;

}
