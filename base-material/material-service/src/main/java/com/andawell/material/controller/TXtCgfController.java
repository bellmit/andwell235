package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;

import com.andawell.material.dto.TJhJxDTO;
import com.andawell.material.dto.TXtCgfDTO;

import com.andawell.material.entity.TXtCgf;

import com.andawell.material.service.ITXtCgfService;
import com.andawell.upms.entity.SysAccountInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * @Auther:gzh
 * @Date:2020/5/28 10:13
 * @Description: 采购方管理
 */
@Api(value = "采购方管理接口", tags = "采购方管理接口")
@RestController
@RequestMapping(value = "sys/txtcgf")
public class TXtCgfController {


    @Autowired
    private ITXtCgfService iTXtCgfService;



    @ApiOperation(value = "编号接口", notes = "编号接口", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "bh")
    public RestResultVo<TXtCgf> list() {
        return new RestResultVo<TXtCgf>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                iTXtCgfService.bh());
    }




    @ApiOperation(value = "新增采购方", notes = "新增采购方", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "insert")
    @SysLog(value = "新增采购方", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo insert(@RequestBody @Valid TXtCgfDTO tXtCgfDTO) {
        try {

          int pc = iTXtCgfService.dwmc(tXtCgfDTO.getDwmc());
          if(pc==1){
              return new RestResultVo(RestStatus.ERROR,
                      NoticeConstant.RESPONSE_DWMC_REPEAT_MESSAGE);
          }
            iTXtCgfService.insert(tXtCgfDTO);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }

    }

    @ApiOperation(value = "编辑采购方", notes = "编辑采购方", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PutMapping(value = "update")
    @SysLog(value = "编辑采购方", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo update(@RequestBody @Valid TXtCgfDTO tXtCgfDTO) {
        try {
            iTXtCgfService.updateById(tXtCgfDTO);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE);
        }

    }



    @ApiOperation(value = "删除采购方", notes = "删除采购方", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @DeleteMapping(value = "delete/{id}")
    @SysLog(value = "删除采购方", operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo delete(@PathVariable("id") String id) {
        try {
            if (StringUtils.isEmpty(id)) {
                return new RestResultVo<SysAccountInfo>(RestStatus.BAD_REQUEST, NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
            }
            iTXtCgfService.delete(id);
            return new RestResultVo<SysAccountInfo>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<SysAccountInfo>(RestStatus.BAD_REQUEST, NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
    }










}
