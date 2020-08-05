package com.andawell.upms.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.common.util.BusinessException;
import com.andawell.upms.constant.NoticeConstant;
import com.andawell.upms.entity.TCf;
import com.andawell.upms.entity.TXtJgf;
import com.andawell.upms.service.TXtJgfService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author:PCJ
 * @Date:2020/5/27
 * @Version:V1.0.0
 */
@Api(value = "监管方管理",tags = "监管方管理")
@RequestMapping(value = "sys/jgf")
@RestController
public class TXtJgfController {

    @Autowired
    private TXtJgfService tXtJgfService;

    /**
     * 监管方查询
     * @param
     * @return
     */
    @GetMapping("list")
    @ApiOperation(value = "监管方查询", notes = "监管方查询", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RestResultVo<List<TXtJgf>> list(){
            List<TXtJgf> list=tXtJgfService.list();
            return new RestResultVo<>(RestStatus.SUCCESS,NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,list);

    }

    /**
     * 监管方新增
     * @param tXtJgf
     * @return
     */
    @PostMapping("insert")
    @ApiOperation(value = "监管方新增", notes = "监管方新增", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @SysLog(value = "监管方新增",operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<String> insert(@RequestBody TXtJgf tXtJgf){
        try {
            if (tXtJgf==null) {
                throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE);
            }
            List<String> list=tXtJgfService.listMc(tXtJgf.getMc());
            if (!list.isEmpty()) {
                return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_NAME_REPEAT_MESSAGE);
            }
            tXtJgfService.insert(tXtJgf);
            return new RestResultVo<>(RestStatus.SUCCESS,NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            if ( e instanceof BusinessException) {
                return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE+","+e.getMessage());
            }
            return new RestResultVo<>(RestStatus.ERROR,NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }
    }

    /**
     * 监管方编辑
     * @param tXtJgf
     * @return
     */
    @RequestMapping(value = "update",method = RequestMethod.PUT)
    @ApiOperation(value = "监管方编辑", notes = "监管方编辑", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @SysLog(value = "监管方编辑",operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo<String> update(@RequestBody TXtJgf tXtJgf){
        try {
            if (tXtJgf==null || StringUtils.isEmpty(tXtJgf.getId())) {
                throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE);
            }
            List<String> list=tXtJgfService.listMc(tXtJgf.getMc());
            if (!list.isEmpty() && (list.size()>=2 ||list.get(0)!=tXtJgf.getId())) {
                return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_NAME_REPEAT_MESSAGE);
            }
            tXtJgfService.update(tXtJgf);
            return new RestResultVo<>(RestStatus.SUCCESS,NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            if ( e instanceof BusinessException) {
                return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE+","+e.getMessage());
            }
            return new RestResultVo<>(RestStatus.ERROR,NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE);
        }
    }

    /**
     * 监管方删除
     * @param id
     * @return
     */
    @RequestMapping(value = "delete/{id}",method = RequestMethod.DELETE)
    @ApiOperation(value = "监管方删除", notes = "监管方删除", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @SysLog(value = "监管方删除",operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo<String> delete(@PathVariable("id") String id){
        try {
            if (StringUtils.isEmpty(id)) {
                throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE);
            }
            tXtJgfService.delete(id);
            return new RestResultVo<>(RestStatus.SUCCESS,NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<>(RestStatus.ERROR,NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
    }
}
