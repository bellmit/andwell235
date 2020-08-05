package com.andawell.material.controller;


import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;

import com.andawell.material.dto.TJhPtjhDTO;
import com.andawell.material.service.ITJhPtjhService;
import com.andawell.upms.entity.SysAccountInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 *@Auther:gzh
 *@Date:2020/5/20 13:59
 *@Description: 儿接口
 */
@Api(value = "件号儿配套接口", tags = "件号儿配套接口")
@RestController
@RequestMapping(value = "sys/tjhptjh")
public class TJhPtjhController {

    @Autowired
    private  ITJhPtjhService iTJhPtjhService;


    @ApiOperation(value = "配套件号保存", notes = "配套件号保存", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "insert")
    @SysLog(value = "配套件号保存", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo insert(@RequestBody @Valid TJhPtjhDTO tJhPtjhDTO) {
        try {
            if(iTJhPtjhService.select(tJhPtjhDTO)!=null){
                return new RestResultVo(RestStatus.ERROR,
                        NoticeConstant.RESPONSE_INSERT_REPEAT_MESSAGE);
            }
            if(tJhPtjhDTO.getJh().equals(tJhPtjhDTO.getPtjh())){
                return new RestResultVo(RestStatus.ERROR,
                        NoticeConstant.RESPONSE_JHPTJH_REPEAT_MESSAGE);
            }
            iTJhPtjhService.insert(tJhPtjhDTO);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }

    }


    @ApiOperation(value = "删除配套件号", notes = "删除配套件号", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @DeleteMapping(value = "delete")
    @SysLog(value = "删除配套件号", operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo delete(@RequestBody @Valid TJhPtjhDTO tJhPtjhDTO) {
        try {
            iTJhPtjhService.delete(tJhPtjhDTO);
            return new RestResultVo<SysAccountInfo>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<SysAccountInfo>(RestStatus.BAD_REQUEST, NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
    }















}
