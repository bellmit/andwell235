package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.dto.TJhJhDTO;
import com.andawell.material.dto.TJhJxDTO;
import com.andawell.material.dto.TJhJxjhDTO;
import com.andawell.material.dto.TJhJxjhDjazsDTO;
import com.andawell.material.entity.TJhJx;
import com.andawell.material.entity.TJhJxjh;
import com.andawell.material.entity.TJhJxlx;
import com.andawell.material.query.TJhJhQuery;
import com.andawell.material.query.TJhJxQuery;
import com.andawell.material.query.TJhJxlxQuery;

import com.andawell.material.service.ITJhJhService;
import com.andawell.material.service.ITJhJxService;
import com.andawell.material.util.BeanUtils;
import com.andawell.material.vo.AircaftModelTreelVO;
import com.andawell.material.vo.TJhJhVO;
import com.andawell.material.vo.TJhJxVO;
import com.andawell.upms.entity.SysAccountInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * 机型（飞机的型号）的增删改查  机型件号
 */
@Api(value = "机型接口", tags = "机型接口", produces =
        MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
@RequestMapping(value = "sys/tjhjx")
public class TJhJxController {

    @Autowired
    ITJhJxService tJhJxService;

    /**
     *@Author: liuys
     *@Data: 2020/5/13
     *@Description:
     */
    @ApiOperation(value = "机型信息列表查询", notes = "机型信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "list")
    public RestResultVo<List<TJhJxVO>> list(TJhJxQuery query) {
        return new RestResultVo<List<TJhJxVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                BeanUtils.copyList(tJhJxService.getList(query),TJhJxVO.class));
    }


    @ApiOperation(value = "查询机型根据Id", notes = "机型信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "getTJhJxById")
    public RestResultVo<TJhJx> getTJhJxById(String jxId) {
        return new RestResultVo<TJhJx>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                tJhJxService.getTJhJxById(jxId));
    }


    @ApiOperation(value = "机型类型查询", notes = "机型类型查询", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "listlx")
    public RestResultVo<List<TJhJxlx>> list(TJhJxlxQuery query) {
        return new RestResultVo<List<TJhJxlx>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                tJhJxService.listlx(query));
    }



    @ApiOperation(value = "新增机型", notes = "新增机型", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "insert")
    @SysLog(value = "新增机型", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo insert(@RequestBody @Valid TJhJxDTO tJhJxDTO) {
        try {
            tJhJxService.insert(tJhJxDTO);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }

    }

    @ApiOperation(value = "编辑机型", notes = "编辑机型", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PutMapping(value = "update")
    @SysLog(value = "编辑机型", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo update(@RequestBody @Valid TJhJxDTO tJhJxDTO) {
        try {
            tJhJxService.updateByPrimaryKey(tJhJxDTO);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE);
        }

    }

    @ApiOperation(value = "删除机型", notes = "删除机型", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @DeleteMapping(value = "delete/{id}")
    @SysLog(value = "删除机型", operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo delete(@PathVariable("id") String id) {
        try {
            if (StringUtils.isEmpty(id)) {
                return new RestResultVo<SysAccountInfo>(RestStatus.BAD_REQUEST, NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
            }
            List<TJhJx> jhJxList =  tJhJxService.selectById(id);
            if(jhJxList.size()>0){
                return new RestResultVo<SysAccountInfo>(RestStatus.BAD_REQUEST, NoticeConstant.RESPONSE_CHILDREN_NOTNULL_MESSAGE);
            }
            tJhJxService.delete(id);
            return new RestResultVo<SysAccountInfo>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<SysAccountInfo>(RestStatus.BAD_REQUEST, NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
    }


    @ApiOperation(value = "机型分配件号增加", notes = "机型分配件号增加", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "insertjxjh")
    @SysLog(value = "新增机型", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo insertjxjh(@RequestBody @Valid TJhJxjhDTO tJhJxjhDTO) {
        try {
            tJhJxService.insertjxjh(tJhJxjhDTO);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }

    }



    @ApiOperation(value = "机型分配件号删除", notes = "机型分配件号删除", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @DeleteMapping(value = "deletejxjh")
    @SysLog(value = "删除机型", operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo deletejxjh(@RequestBody @Valid TJhJxjhDTO tJhJxjhDTO) {
        try {
            tJhJxService.deletejxjh(tJhJxjhDTO);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
    }

    @ApiOperation(value = "编辑件号单机安装数量", notes = "编辑件号单机安装数量", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PutMapping(value = "updatedjazs")
    @SysLog(value = "编辑件号单机安装数量", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo updatedjazs(@RequestBody @Valid TJhJxjhDjazsDTO tJhJxjhDjazsDTO) {
        try {
            tJhJxService.updatedjazs(tJhJxjhDjazsDTO);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE);
        }

    }

}
