package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.common.util.BusinessException;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.entity.TCkFyfs;
import com.andawell.material.entity.TJh;
import com.andawell.material.entity.TJhWxlx;
import com.andawell.material.service.TJhWxlxService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:PCJ
 * @Date:2020/5/21
 * @Version:V1.0.0
 */
@Api(value = "维修类型接口", tags = "维修类型接口")
@RestController
@RequestMapping("sys/cs/wxlx")
public class TJhWxlxController {

    @Autowired
    private TJhWxlxService tJhWxlxService;


    @ApiOperation(value = "维修类型新增", notes = "维修类型新增", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping("insert")
    @SysLog(value = "维修类型新增", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<String> insert(@RequestBody TJhWxlx tJhWxlx) {
        try {
            if (tJhWxlx==null) {
                throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE);
            }
            tJhWxlxService.insert(tJhWxlx);
            return new RestResultVo<>(RestStatus.SUCCESS,NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            if ( e instanceof BusinessException) {
                return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE+","+e.getMessage());
            }
            return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }
    }


    @ApiOperation(value = "维修类型编辑", notes = "维修类型编辑", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    @SysLog(value = "维修类型编辑", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo<String> update(@RequestBody TJhWxlx tJhWxlx) {
        try {
            if (tJhWxlx==null || StringUtils.isEmpty(tJhWxlx.getId())) {
                throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE);
            }
            tJhWxlxService.update(tJhWxlx);
            return new RestResultVo<>(RestStatus.SUCCESS,NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();if ( e instanceof BusinessException) {
                return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE+","+e.getMessage());
            }
            return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE);
        }
    }


    @ApiOperation(value = "维修类型删除", notes = "维修类型删除", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    @SysLog(value = "维修类型删除", operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo<String> delete(@PathVariable("id") String id) {
        try {
            if (StringUtils.isEmpty(id)) {
                throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE);
            }
            tJhWxlxService.delete(id);
            return new RestResultVo<>(RestStatus.SUCCESS,NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();if ( e instanceof BusinessException) {
                return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE+","+e.getMessage());
            }
            return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
    }

}
