package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.common.util.BusinessException;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.entity.TJhJxlx;
import com.andawell.material.entity.TQxZylb;
import com.andawell.material.service.TQxZylbService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:PCJ
 * @Date:2020/5/20
 * @Version:V1.0.0
 */
@Api(value = "资源类别接口", tags = "资源类别接口")
@RestController
@RequestMapping("sys/cs/zylb")
public class TQxZylbController {

    @Autowired
    private TQxZylbService tQxZylbService;

    @ApiOperation(value = "资源类别新增", notes = "资源类别新增", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping("insert")
    @SysLog(value = "资源类别新增", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<String> insert(@RequestBody TQxZylb tQxZylb) {
        try {
            if (tQxZylb==null) {
                throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE);
            }
            tQxZylbService.insert(tQxZylb);
            return new RestResultVo<>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            if ( e instanceof BusinessException) {
                return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE+","+e.getMessage());
            }
            return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }
    }


    @ApiOperation(value = "资源类别编辑", notes = "资源类别编辑", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    @SysLog(value = "资源类别编辑", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo<String> update(@RequestBody TQxZylb tQxZylb) {
        try {
            if (StringUtils.isEmpty(tQxZylb.getMc()) || StringUtils.isEmpty(tQxZylb.getId())) {
                throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE);
            }
            tQxZylbService.update(tQxZylb);
            return new RestResultVo<>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            if ( e instanceof BusinessException) {
                return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE+","+e.getMessage());
            }
            return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE);
        }
    }


    @ApiOperation(value = "资源类别删除", notes = "资源类别删除", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    @SysLog(value = "资源类别删除", operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo<String> delete(@PathVariable("id") String id) {
        try {
            if (StringUtils.isEmpty(id)) {
                throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE);
            }
            tQxZylbService.delete(id);
            return new RestResultVo<>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            if ( e instanceof BusinessException) {
                return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE+","+e.getMessage());
            }
            return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
    }

}
