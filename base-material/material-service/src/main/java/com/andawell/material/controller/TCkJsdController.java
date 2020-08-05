package com.andawell.material.controller;


import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.dto.TCkJsdBcDTO;
import com.andawell.material.service.IBaseLibraryService;
import com.andawell.material.service.ITCkJsdService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * 结算单打印接口  保存   结算单编号生成
 */
@Api(value = "结算单打印接口", tags = "结算单打印接口", produces =
        MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
@RequestMapping(value = "sys/tckjsd")
public class TCkJsdController {

    @Autowired
    ITCkJsdService iTCkJsdService;

    @Autowired
    IBaseLibraryService baseLibraryService;


    /**
     * @Auther:gzh
     * @Date:2020/5/26 8:32
     * @Description: 结算单编号查询接口
     */
    @ApiOperation(value = "结算单编号查询接口", notes = "结算单编号查询接口", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "get/SystemNumber")
    public RestResultVo<String> getJsdSystemNumber() {
        //生成结算单编号接口
        String systemNumber = iTCkJsdService.getSystemNumber();
        return new RestResultVo<String>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                systemNumber);
    }


    @ApiOperation(value = "结算单打印保存接口", notes = "结算单打印保存接口", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "insert")
    @SysLog(value = "结算单打印保存接口", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo insert(@RequestBody @Valid TCkJsdBcDTO tCkJsdBcDTO) {
        try {
            iTCkJsdService.insert(tCkJsdBcDTO);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }

    }


}
