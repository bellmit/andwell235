package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.common.util.BusinessException;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.dto.TTzzWzCrkDto;
import com.andawell.material.entity.*;
import com.andawell.material.query.TTzzWzQuery;
import com.andawell.material.query.TTzzWzlbQuery;
import com.andawell.material.service.TTzzCkService;
import com.andawell.material.service.TTzzWzService;
import com.andawell.material.service.TTzzWzlbService;
import com.andawell.material.util.POIUtils;
import com.andawell.material.vo.TTzzWzVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author:PCJ
 * @Date:2020/5/13
 * @Version:V1.0.0
 */
@Api(value = "通专装物资接口", tags = "通专装物资接口")
@RestController
@RequestMapping(value = "sys/ttzzwz")
public class TTzzWzController {

    @Autowired
    private TTzzWzService tTzzWzService;

    @Autowired
    private TTzzCkService tTzzCkService;

    @Autowired
    private TTzzWzlbService tTzzWzlbService;





    /**
     * 通专装库存数据导入
     *
     * @param multipartFile
     * @return
     */
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    @ApiOperation(value = "通专装库存数据导入", notes = "通专装库存数据导入", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @SysLog(value = "通专装库存数据导入", operationType = LogTypeConstant.LOG_IMPORT_TYPE)
    public RestResultVo<String> upload(@RequestParam("excelFile") MultipartFile multipartFile) {

        try {
            List<String[]> list = POIUtils.readExcel(multipartFile);

            if (list != null && list.size() > 0) {
                if (list.get(0).length < 10) {
                    throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE);
                }

                tTzzCkService.insertAll(list);
                return new RestResultVo<>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_IMPORT_SUCCESS_MESSAGE);
            }
            throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            if ( e instanceof BusinessException) {
                return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_IMPORT_ERROR_MESSAGE+","+e.getMessage());
            }
            return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_IMPORT_ERROR_MESSAGE);
        }
    }

    /**
     * 通专装物资新增
     *
     * @param tTzzWz
     * @return
     */
    @PostMapping("insert")
    @ApiOperation(value = "通专装物资新增", notes = "通专装物资新增", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @SysLog(value = "通专装物资新增", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<String> insert(@RequestBody TTzzWz tTzzWz) {
        try {
            if (tTzzWz==null) {
                throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE);
            }
            List<TTzzWzVO> tTzzWzList = tTzzWzService.list(new TTzzWzQuery().setJh(tTzzWz.getJh()));
            if (!tTzzWzList.isEmpty())
                throw new BusinessException(NoticeConstant.RESPONSE_EXIST_ALREADY_MESSAGE);
            tTzzWzService.insert(tTzzWz);
            return new RestResultVo<>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            if ( e instanceof BusinessException) {
                return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE+","+e.getMessage());
            }
            return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE,e.getMessage());
        }
    }

    /**
     * 通专装物资编辑
     *
     * @param tTzzWz
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    @ApiOperation(value = "通专装物资编辑", notes = "通专装物资编辑", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @SysLog(value = "通专装物资编辑", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo<String> update(@RequestBody TTzzWz tTzzWz) {
        try {
            if (StringUtils.isEmpty(tTzzWz.getJh())) {
                throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE);
            }
            tTzzWzService.update(tTzzWz);
            return new RestResultVo<>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            if ( e instanceof BusinessException) {
                return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE+","+e.getMessage());
            }
            return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE);
        }
    }


    /**
     * 通专装物资删除
     *
     * @param jh
     * @return
     */
    @RequestMapping(value = "delete/{jh}", method = RequestMethod.DELETE)
    @ApiOperation(value = "通专装物资删除", notes = "通专装物资删除", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @SysLog(value = "通专装物资删除", operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo<String> delete(@ApiParam(value = "通专装物资jh", name = "jh") @PathVariable("jh") String jh) {
        try {
            if (StringUtils.isEmpty(jh)) {
                throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE);
            }
            tTzzWzService.delete(jh);
            return new RestResultVo<>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            if ( e instanceof BusinessException) {
                return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE+","+e.getMessage());
            }
            return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
    }


    /**
     * 物资类别查询
     *
     * @param
     * @return
     */
    @GetMapping("wzlb/list")
    @ApiOperation(value = "物资类别查询", notes = "物资类别查询", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RestResultVo<List<TTzzWzlb>> listWzlb(TTzzWzlbQuery query) {

        return new RestResultVo<List<TTzzWzlb>>(RestStatus.SUCCESS
                , NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE
                , tTzzWzlbService.list(query));
    }


    /**
     * 通专装物资查询
     *
     * @param tTzzWz
     * @return
     */
    @GetMapping("list")
    @ApiOperation(value = "通专装物资查询", notes = "通专装物资查询", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RestResultVo<List<TTzzWzVO>> list(TTzzWz tTzzWz) {

        List<TTzzWzVO> tTzzWzList = tTzzWzService.list(new TTzzWzQuery().setJh(tTzzWz.getJh()));
        return new RestResultVo<>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE, tTzzWzList);
    }

    /**
     * 获取系统编号
     *
     * @param
     * @return
     */
    @GetMapping("bh")
    @ApiOperation(value = "获取系统编号", notes = "获取系统编号", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RestResultVo<String> getBh(TTzzCrkqd tTzzCrkqd) {


        return new RestResultVo<String>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE, tTzzWzService.getBh(tTzzCrkqd));
    }

    /**
     * 获取系统编号
     *
     * @param
     * @return
     */
    @GetMapping("wh")
    @ApiOperation(value = "获取出入库文号", notes = "获取出入库文号", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RestResultVo<String> getWh(TTzzCrk tTzzCrk) {


        return new RestResultVo<String>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE, tTzzWzService.getWh(tTzzCrk));
    }

    /**
     * 通专装入库
     *
     * @param
     * @return
     */
    @PostMapping("crk/insert")
    @ApiOperation(value = "通专装入库", notes = "通专装入库", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @SysLog(value = "通专装入库", operationType = LogTypeConstant.LOG_PUT_IN_LIBRARY)
    public RestResultVo<String> insertCrk(@RequestBody TTzzWzCrkDto tTzzWzCrkDto) {
        try {
            List<TTzzCk> tTzzCkList = tTzzWzCrkDto.getTTzzCkList();
            TTzzCrk tTzzCrk = tTzzWzCrkDto.getTTzzCrk();
            List<TTzzCrkqd> tTzzCrkqdList = tTzzWzCrkDto.getTTzzCrkqdList();
            if (StringUtils.isEmpty(tTzzCrk.getBh()) || tTzzCkList.isEmpty() || tTzzCrkqdList.isEmpty()) {
                throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE);
            }
            tTzzWzService.insertCrk(tTzzCrk, tTzzCkList, tTzzCrkqdList);
            return new RestResultVo<>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_INPUT_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            if ( e instanceof BusinessException) {
                return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_INPUT_ERROR_MESSAGE+","+e.getMessage());
            }
            return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_INPUT_ERROR_MESSAGE);
        }
    }


    /**
     * 通专装出库
     *
     * @param tTzzWzCrkDto
     * @return
     */
    @RequestMapping(value = "crk/update",method = RequestMethod.PUT)
    @ApiOperation(value = "通专装出库", notes = "通专装出库", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @SysLog(value = "通专装出库", operationType = LogTypeConstant.LOG_PUT_OUT_LIBRARY)
    public RestResultVo<String> updateCrk(@RequestBody TTzzWzCrkDto tTzzWzCrkDto) {
        try {
            List<TTzzCk> tTzzCkList = tTzzWzCrkDto.getTTzzCkList();
            TTzzCrk tTzzCrk = tTzzWzCrkDto.getTTzzCrk();
            List<TTzzCrkqd> tTzzCrkqdList = tTzzWzCrkDto.getTTzzCrkqdList();
            if (StringUtils.isEmpty(tTzzCrk.getBh()) || tTzzCkList.isEmpty() || tTzzCrkqdList.isEmpty()) {
                throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE);
            }
            tTzzWzService.updateCrk(tTzzCrk,tTzzCkList,tTzzCrkqdList);
            return new RestResultVo<>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_OUTPUT_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            if ( e instanceof BusinessException) {
                return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_OUTPUT_ERROR_MESSAGE+","+e.getMessage());
            }
            return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_OUTPUT_ERROR_MESSAGE);
        }
    }
}



