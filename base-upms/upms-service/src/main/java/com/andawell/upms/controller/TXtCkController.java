package com.andawell.upms.controller;


import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.common.util.BusinessException;
import com.andawell.upms.constant.NoticeConstant;
import com.andawell.upms.dto.TXtCkDto;
import com.andawell.upms.entity.TXtCk;
import com.andawell.upms.query.TXtCkQuery;
import com.andawell.upms.service.TXtCkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "仓库", tags = "仓库")
@RequestMapping("sys/ck")
@RestController
public class TXtCkController {

    @Autowired
    private TXtCkService tXtCkService;

    /**
     * 仓库查询请求
     *
     * @param query
     * @return
     */
    @ApiOperation(value = "仓库查询", notes = "仓库查询", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping("list")
    public RestResultVo<List<TXtCk>> list(TXtCkQuery query) {

        return new RestResultVo<List<TXtCk>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                tXtCkService.list(query));
    }

    /**
     * 仓库详细信息查询
     *
     * @param
     * @return
     */
    @ApiOperation(value = "仓库详细信息查询", notes = "仓库详细信息查询", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "detail")
    public RestResultVo<List<TXtCk>> detail(TXtCkQuery query) {
        return new RestResultVo<List<TXtCk>>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                tXtCkService.list(query));
    }

    /**
     * 仓库新增请求
     *
     * @param tXtCkDto
     * @return
     */
    @ApiOperation(value = "仓库新增", notes = "仓库新增", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping("insert")
    @SysLog(value = "仓库新增", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<String> insert(@RequestBody TXtCkDto tXtCkDto) {
        try {

            tXtCkService.insert(tXtCkDto);
            return new RestResultVo<String>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }
    }

    /**
     * 仓库编辑请求
     *
     * @param tXtCkDto
     * @return
     */
    @ApiOperation(value = "仓库编辑", notes = "仓库编辑", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    @SysLog(value = "仓库编辑", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo<String> update(@RequestBody TXtCkDto tXtCkDto) {
        try {

            if (StringUtils.isEmpty(tXtCkDto.getCkid())) {
                throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE);
            }
            tXtCkService.update(tXtCkDto);
            return new RestResultVo<>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE);
        }
    }

    /**
     * 仓库删除请求
     *
     * @param
     * @return
     */
    @ApiOperation(value = "仓库删除", notes = "仓库删除", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    @SysLog(value = "仓库删除", operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo<String> delete(TXtCkDto tXtCkDto) {
        try {
            if (StringUtils.isEmpty(tXtCkDto.getCkid())) {
                throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE);
            }
            tXtCkService.delete(tXtCkDto);
            return new RestResultVo<>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
    }
}
