package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.common.util.BusinessException;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.entity.TCkCrklb;
import com.andawell.material.query.TCkCrklbQuery;
import com.andawell.material.util.BeanUtils;
import com.andawell.material.vo.TCkCrklbVO;
import com.andawell.material.service.ITCkCrklbService;
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
@Api(value = "出入库类别接口", tags = "出入库类别接口")
@RestController
@RequestMapping("sys/cs/crklb")
public class TCkCrklbController {

    @Autowired
    private ITCkCrklbService tCkCrklbService;

    @ApiOperation(value = "出入库类别本级新增", notes = "出入库类别本级新增", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping("bj/insert")
    @SysLog(value = "出入库类别本级新增", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<String> insertBj(@RequestBody TCkCrklb tCkCrklb) {
        try {
            if (tCkCrklb==null) {
                throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE);
            }
            tCkCrklbService.insertBj(tCkCrklb);
            return new RestResultVo<>(RestStatus.SUCCESS,NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            if ( e instanceof BusinessException) {
                return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE+","+e.getMessage());
            }
            return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }
    }


    @ApiOperation(value = "出入库类别子级新增", notes = "出入库类别子级新增", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping("zj/insert")
    @SysLog(value = "出入库类别子级新增", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<TCkCrklb> insertZj(@RequestBody TCkCrklb tCkCrklb) {
        try {
            if (StringUtils.isEmpty(tCkCrklb.getPid())) {
                return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
            }
            tCkCrklbService.insertZj(tCkCrklb);
            return new RestResultVo<>(RestStatus.SUCCESS,NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE,tCkCrklb);
        } catch (Exception e) {
            e.printStackTrace();
            if ( e instanceof BusinessException) {
                return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE+","+e.getMessage());
            }
            return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }
    }


    @ApiOperation(value = "出入库类别编辑", notes = "出入库类别编辑", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    @SysLog(value = "出入库类别编辑", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo<TCkCrklb> update(@RequestBody TCkCrklb tCkCrklb) {
        try {
            if (StringUtils.isEmpty(tCkCrklb.getId())) {
                return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE);
            }
            tCkCrklbService.update(tCkCrklb);
            return new RestResultVo<>(RestStatus.SUCCESS,NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            if ( e instanceof BusinessException) {
                return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE+","+e.getMessage());
            }
            return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE);
        }
    }


    @ApiOperation(value = "出入库类别删除", notes = "出入库类别删除", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    @SysLog(value = "出入库类别删除", operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo<TCkCrklb> delete(@PathVariable("id") String id) {
        try {
            if (StringUtils.isEmpty(id)) {
                return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
            }
            tCkCrklbService.delete(id);
            return new RestResultVo<>(RestStatus.SUCCESS,NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            if ( e instanceof BusinessException) {
                return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE+","+e.getMessage());
            }
            return new RestResultVo<>(RestStatus.ERROR,NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
    }

    @ApiOperation(value = "出库类型", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "list")
    public RestResultVo<List<TCkCrklbVO>> list(TCkCrklbQuery query) {
        return new RestResultVo<List<TCkCrklbVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                BeanUtils.copyList(tCkCrklbService.rklbList(query),TCkCrklbVO.class));
    }

}
