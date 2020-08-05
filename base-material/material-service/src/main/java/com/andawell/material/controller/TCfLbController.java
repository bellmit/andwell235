package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.common.util.BusinessException;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.entity.TCfLb;
import com.andawell.material.entity.TJhJxlx;
import com.andawell.material.service.TCfLbService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author:PCJ
 * @Date:2020/5/20
 * @Version:V1.0.0
 */
@Api(value = "厂方类别接口", tags = "厂方类别接口")
@RestController
@RequestMapping("sys/cs/cflb")
public class TCfLbController {

    @Autowired
    private TCfLbService tCfLbService;

    @ApiOperation(value = "厂方类别查询", notes = "厂方类别查询", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping("list")
    public RestResultVo<List<TCfLb>> list() {

            List<TCfLb> list=tCfLbService.list();
            return new RestResultVo<>(RestStatus.SUCCESS,NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,list);
    }


    @ApiOperation(value = "厂方类别本级新增", notes = "厂方类别本级新增", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping("bj/insert")
    @SysLog(value = "厂方类别本级新增", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<String> insertBj(@RequestBody TCfLb tCfLb) {
        try {
            if (tCfLb==null) {
                throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE);
            }
            tCfLb.setPid(null);
            tCfLbService.insertBj(tCfLb);
            return new RestResultVo<>(RestStatus.SUCCESS,NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            if ( e instanceof BusinessException) {
                return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE+","+e.getMessage());
            }
            return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }
    }


    @ApiOperation(value = "厂方类别子级新增", notes = "厂方类别子级新增", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping("zj/insert")
    @SysLog(value = "厂方类别子级新增", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<String> insertZj(@RequestBody TCfLb tCfLb) {
        try {
            if (tCfLb==null || StringUtils.isEmpty(tCfLb.getPid())) {
                throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE);
            }
            tCfLbService.insertZj(tCfLb);
            return new RestResultVo<>(RestStatus.SUCCESS,NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            if ( e instanceof BusinessException) {
                return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE+","+e.getMessage());
            }
            return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }
    }


    @ApiOperation(value = "厂方类别编辑", notes = "厂方类别编辑", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    @SysLog(value = "厂方类别编辑", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo<String> update(@RequestBody TCfLb tCfLb) {
        try {
            if (tCfLb==null || StringUtils.isEmpty(tCfLb.getId())) {
                throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE);
            }
            tCfLbService.update(tCfLb);
            return new RestResultVo<>(RestStatus.SUCCESS,NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            if ( e instanceof BusinessException) {
                return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE+","+e.getMessage());
            }
            return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE);
        }
    }


    @ApiOperation(value = "厂方类别删除", notes = "厂方类别删除", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    @SysLog(value = "厂方类别删除", operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo<String> delete(@PathVariable("id") String id) {
        try {
            if (StringUtils.isEmpty(id)) {
                throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE);
            }
            tCfLbService.delete(id);
            return new RestResultVo<>(RestStatus.SUCCESS,NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            if ( e instanceof BusinessException) {
                return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE+","+e.getMessage());
            }
            return new RestResultVo<>(RestStatus.ERROR,NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
    }
}
