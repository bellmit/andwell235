package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.dto.ManualCreationDTO;
import com.andawell.material.dto.TZyBzqdmxDTO;
import com.andawell.material.entity.TZyDy;
import com.andawell.material.entity.TZyFjs;
import com.andawell.material.entity.TZyRwsc;
import com.andawell.material.entity.TZyRwxz;
import com.andawell.material.service.SupportEnsureService;
import com.andawell.material.util.BeanUtils;
import com.andawell.material.util.Utils;
import com.andawell.material.utils.ValidableList;
import com.andawell.material.vo.RotateVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/***
 * @author hwd
 * @Date: 2020-05-20 13:24
 * @Description:支援保障
 * @version : V1.0
 *
 */
@Api(value = "支援保障管理", tags = "支援保障管理")
@RestController
@RequestMapping(value = "sys/supportEnsure")
public class SupportEnsureController {


    @Autowired
    private SupportEnsureService supportEnsureService;

    /**
     * 获取地域列表
     */
    @ApiOperation(value = "获取地域列表")
    @GetMapping(value = "region/list")
    public RestResultVo<List<TZyDy>> getTZyDyList()
    {
        return new RestResultVo<List<TZyDy>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                supportEnsureService.getTZyDyList());
    }

    /**
     * 获取任务性质列表
     */
    @ApiOperation(value = "获取任务性质列表")
    @GetMapping(value = "task/list")
    public RestResultVo<List<TZyRwxz>> getTZyRwxzList()
    {
        return new RestResultVo<List<TZyRwxz>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                supportEnsureService.getTZyRwxzList());
    }


    /**
     * 获取飞机数列表
     */
    @ApiOperation(value = "获取飞机数列表")
    @GetMapping(value = "plane/list")
    public RestResultVo<List<TZyFjs>> getTZyFjsList()
    {
        return new RestResultVo<List<TZyFjs>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                supportEnsureService.getTZyFjsList());
    }


    /**
     * 获取任务时长列表
     */
    @ApiOperation(value = "获取任务时长列表")
    @GetMapping(value = "taskTime/list")
    public RestResultVo<List<TZyRwsc>> getTZyRwscList()
    {
        return new RestResultVo<List<TZyRwsc>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                supportEnsureService.getTZyRwscList());
    }



    /**
     * 保存库存信息
     */
    @ApiOperation(value = "保存库存信息")
    @PostMapping(value = "save/message")
    @SysLog(value = "保存库存信息", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<Object> saveMessage(@RequestBody @Valid ValidableList<TZyBzqdmxDTO> tZyBzqdmxDTO)
    {
        Boolean aBoolean = supportEnsureService.saveMessage(tZyBzqdmxDTO);
        return  Utils.getAddResult(aBoolean);
    }



    /**
     * 删除库存信息
     */
    @ApiOperation(value = "删除库存信息")
    @DeleteMapping(value = "delete/message")
    @SysLog(value = "删除库存信息", operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo<Object> deleteMessage(@RequestBody @Valid ValidableList<TZyBzqdmxDTO> tZyBzqdmxDTO)
    {
        supportEnsureService.deleteMessage(tZyBzqdmxDTO);
        return new RestResultVo<Object>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE);
    }

    /**
     * 手动创建
     */
    @ApiOperation(value = "手动创建")
    @PostMapping(value = "save/setMessage")
    @SysLog(value = "手动创建", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<Object> setMessage(@RequestBody @Valid ManualCreationDTO manualCreationDTO)
    {
        supportEnsureService.setMessage(manualCreationDTO);
        return new RestResultVo<Object>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_IMPORT_SUCCESS_MESSAGE);
    }














}
