package com.andawell.material.controller;

import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.entity.TDbDblb;
import com.andawell.material.query.JhQuery;
import com.andawell.material.query.TDbDblbQuery;
import com.andawell.material.service.ITDbDblbService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author: zje
 * @date: 2020/6/5
 * @description:
 */

@Api(value = "调拨类别管理", tags = "调拨类别管理")
@RestController
@RequestMapping(value = "sys/tdbdblb")
public class TDbDblbController {

    @Autowired
    private ITDbDblbService itDbDblbService;

    @ApiOperation(value = "查询调拨类别管理", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "list")
    public RestResultVo<List<TDbDblb>> list(@Valid TDbDblbQuery query) {
        try {
            List<TDbDblb> tDbDblbs = itDbDblbService.list(query);
            return new RestResultVo<>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                    tDbDblbs);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE);
        }
    }
}
