package com.andawell.material.controller;


import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.dto.TZbBzDTO;
import com.andawell.material.service.ITZbBzService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/***
 * @author ZhangYanBo
 * @Date: 11:50
 * @Description:
 * @version : V1.0
 */
@Api(value = "战备管理", tags = "战备管理")
@RestController
@RequestMapping(value = "sys/TZbBz")
public class TZbBzController {

    @Autowired
    private ITZbBzService tZbBzService;


    /**
     * 战备器材标准新增
     * @param tZbBzDTO
     * @return
     */
    @ApiOperation(value = "战备器材标准新增", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "insert/standard")
    @SysLog(value = "战备器材标准新增",operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo insertStandard(@Valid @RequestBody TZbBzDTO tZbBzDTO) {
        try {
            tZbBzService.insert(tZbBzDTO);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }

    }

    /**
     * 战备器材标准删除
     * @param tZbBzDTO
     * @return
     */
    @ApiOperation(value = "战备器材标准删除", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @DeleteMapping(value = "delete/standard")
    @SysLog(value = "战备器材标准删除",operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo deleteStandard(TZbBzDTO tZbBzDTO) {
        try {
            tZbBzService.delete(tZbBzDTO);
            return new RestResultVo<>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
    }
}
