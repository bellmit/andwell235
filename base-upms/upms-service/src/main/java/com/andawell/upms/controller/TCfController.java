package com.andawell.upms.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.common.util.BusinessException;
import com.andawell.upms.constant.NoticeConstant;
import com.andawell.upms.entity.TCf;
import com.andawell.upms.entity.TCfLb;
import com.andawell.upms.entity.TJhZylx;
import com.andawell.upms.entity.TXtBzlb;
import com.andawell.upms.query.TCfLbQuery;
import com.andawell.upms.query.TCfQuery;
import com.andawell.upms.query.TJhZylxQuery;
import com.andawell.upms.query.TXtBzlbQuery;
import com.andawell.upms.service.TCfLbService;
import com.andawell.upms.service.TCfService;
import com.andawell.upms.service.TJhZylxService;
import com.andawell.upms.service.TXtBzlbService;
import com.andawell.upms.util.POIUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:PCJ
 * @Date:2020/5/9
 * @Version:V1.0.0
 */
@Api(value = "厂方管理",tags = "厂方管理")
@RequestMapping(value = "sys/cf")
@RestController
public class TCfController {

    @Autowired
    private TCfService tCfService;

    @Autowired
    private TCfLbService tCfLbService;

    @Autowired
    private TXtBzlbService tXtBzlbService;

    @Autowired
    private TJhZylxService tJhZylxService;

    /**
     * 承制方查询
     * @param query
     * @return
     */
    @GetMapping("cz/list")
    @ApiOperation(value = "承制方查询", notes = "承制方查询", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RestResultVo<List<TCf>> listCz(TCfQuery query){
        return new RestResultVo<List<TCf>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                tCfService.listCz(query));
    }

    /**
     * 承修方查询
     * @param query
     * @return
     */
    @GetMapping("cx/list")
    @ApiOperation(value = "承修方查询", notes = "承修方查询", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RestResultVo<List<TCf>> listCx(TCfQuery query){
        return new RestResultVo<List<TCf>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                tCfService.listCx(query));
    }

    /**
     * 承制方新增
     * @param tCf
     * @return
     */
    @PostMapping("cz/insert")
    @ApiOperation(value = "承制方新增", notes = "承制方新增", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RestResultVo<String> insertCz(@RequestBody TCf tCf){
        try {
            if (tCf==null) {
                throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE);
            }
            tCfService.insertCz(tCf);
            return new RestResultVo<>(RestStatus.SUCCESS,NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<>(RestStatus.ERROR,NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }
    }

    /**
     * 承修方新增
     * @param tCf
     * @return
     */
    @PostMapping("cx/insert")
    @ApiOperation(value = "承修方新增", notes = "承修方新增", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @SysLog(value = "承修方新增",operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<String> insertCx(@RequestBody TCf tCf){

        try {
            if (tCf==null) {
                throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE);
            }
            tCfService.insertCx(tCf);
            return new RestResultVo<String>(RestStatus.SUCCESS,NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<String>(RestStatus.ERROR,NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }
    }

    /**
     * 承制方厂方类别查询
     * @param query
     * @return
     */
    @GetMapping("cz/lb/list")
    @ApiOperation(value = "承制方厂方类别查询", notes = "承制方厂方类别查询", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @SysLog(value = "承制方厂方类别查询",operationType = LogTypeConstant.LOG_FIND_TYPE)
    public RestResultVo<List<TCfLb>> listCzlb(TCfLbQuery query){
        return new RestResultVo<List<TCfLb>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                tCfLbService.listCzlb(query));
    }

    /**
     * 承修方厂方类别查询
     * @param query
     * @return
     */
    @GetMapping("cx/lb/list")
    @ApiOperation(value = "承修方厂方类别查询", notes = "承修方厂方类别查询", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @SysLog(value = "承修方厂方类别查询",operationType = LogTypeConstant.LOG_FIND_TYPE)
    public RestResultVo<List<TCfLb>> listCxlb(TCfLbQuery query){
        return new RestResultVo<List<TCfLb>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                tCfLbService.listCxlb(query));
    }

    /**
     * 币种类别查询
     * @param query
     * @return
     */
    @GetMapping("bzlb/list")
    @ApiOperation(value = "币种类别查询", notes = "币种类别查询", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @SysLog(value = "币种类别查询",operationType = LogTypeConstant.LOG_FIND_TYPE)
    public RestResultVo<List<TXtBzlb>> listBzlb(TXtBzlbQuery query){
        return new RestResultVo<List<TXtBzlb>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                tXtBzlbService.list(query));
    }

    /**
     * 专业类型查询
     * @param query
     * @return
     */
    @GetMapping("zylx/list")
    @ApiOperation(value = "专业类型查询", notes = "专业类型查询", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @SysLog(value = "专业类型查询",operationType = LogTypeConstant.LOG_FIND_TYPE)
    public RestResultVo<List<TJhZylx>> listZylx(TJhZylxQuery query){
        return new RestResultVo<List<TJhZylx>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                tJhZylxService.list(query));
    }

    /**
     * 厂方删除请求
     * @param
     * @return
     */
    @ApiOperation(value = "厂方删除", notes = "厂方删除", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "delete/{id}",method = RequestMethod.DELETE)
    @SysLog(value = "厂方删除",operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo<String> delete(@ApiParam(value = "厂方ID", name = "id") @PathVariable("id") String id){
        try {
            if(StringUtils.isEmpty(id)) {
                throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE);
            }
            tCfService.delete(id);
            return new RestResultVo<String>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
    }

    /**
     * 厂方编辑
     * @param tCf
     * @return
     */
    @ApiOperation(value = "厂方编辑", notes = "厂方编辑", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @SysLog(value = "厂方编辑",operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    @RequestMapping(value = "update",method = RequestMethod.PUT)
    public RestResultVo<String> update(@RequestBody TCf tCf){
        try {
            if (tCf==null) {
                throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE);
            }
            tCfService.update(tCf);
            return new RestResultVo<String>(RestStatus.SUCCESS,NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE);
        }
    }

    /**
     * 承制方导入
     *
     * @param multipartFile
     * @return
     */
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    @ApiOperation(value = "承制方导入", notes = "承制方导入", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @SysLog(value = "承制方导入", operationType = LogTypeConstant.LOG_IMPORT_TYPE)
    public RestResultVo<String> upload(@RequestParam("excelFile") MultipartFile multipartFile) {
        try {
            List<String[]> list = POIUtils.readExcel(multipartFile);
            if (list != null && list.size() > 0) {
                if (list.get(0).length < 7) {
                    return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE);
                }
                tCfService.upload(list);
                return new RestResultVo<>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_IMPORT_SUCCESS_MESSAGE);
            }
            return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_IMPORT_ERROR_MESSAGE);
        }
    }
}
