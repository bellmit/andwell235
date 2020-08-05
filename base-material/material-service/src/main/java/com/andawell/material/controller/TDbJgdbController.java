package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.dto.TDbjgDTO;
import com.andawell.material.dto.ZQSaveDTO;
import com.andawell.material.query.TDbJgdbQuery;
import com.andawell.material.service.ITDbJgdbService;
import com.andawell.material.service.ITDbSjsqService;
import com.andawell.material.util.Utils;
import com.andawell.material.vo.TDbSjsqAndQDVO;
import com.andawell.material.vo.TDbSjsqVO;
import com.andawell.material.vo.TDbjgVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: zje
 * @date: 2020/5/28
 * @description:
 */

@Api(value = "机关调拨", tags = "机关调拨")
@RestController
@RequestMapping(value = "sys/tdbjgdb")
public class TDbJgdbController {

    @Autowired
    private ITDbJgdbService dbJgdbService;

    @Autowired
    private ITDbSjsqService tDbSjsqService;

    /**
     * @Auther: zje
     * @Date: 2020/6/2
     * @Description: 获取调拨编号
     * @Param: type
     * @return:
     */
    @ApiOperation(value = "获取调拨编号", notes = "获取调拨编号", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "getBh")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "1：部队调拨/2：工厂调拨", dataType = "String", required = true)})
    public RestResultVo<String> getAllotBh(Integer type) {
        if (type==null){
            return new RestResultVo<String>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE,
                    "编号类型为空");
        }
        return new RestResultVo<String>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                dbJgdbService.getAllotBh(type));
    }

    /**
     * @Auther: zje
     * @Date: 2020/6/2
     * @Description: 修改处理状态
     * @Param: sqdh
     * @return:
     */
    @ApiOperation(value = "修改处理状态", notes = "修改处理状态", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PutMapping(value = "update")
    @SysLog(value = "修改处理状态", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo update(String sqdh) {
        if (sqdh.isEmpty()){
            return new RestResultVo<String>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE,
                    "申请编号为空");
        }
        try {
            dbJgdbService.update(sqdh);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE);
        }
    }

    /**
     *@Auther: zje
     *@Date: 2020/6/5
     *@Description: 机关调拨下发
     *@Param: sqdh
     *@return: 
     */
    @ApiOperation(value = "下发")
    @PostMapping(value = "transmission")
    @SysLog(value = "下发", operationType = LogTypeConstant.LOG_DOWNLOAD_TYPE)
    public void transmission(HttpServletResponse response,@RequestBody List<String> sqdh) {
       dbJgdbService.transmission(response,sqdh);
    }

    /**
     *@Auther: hwd
     *@Date: 2020/6/8
     *@Description: 查询sqlite数据并返回
     *@Param: multipartFile
     *@return:
     */
    @ApiOperation(value = "查询sqlite数据并返回")
    @PostMapping(value = "listSqlite")
    public RestResultVo<List<TDbSjsqAndQDVO>> listSqlite(@RequestParam("file") MultipartFile multipartFile) {
        try {
            return new RestResultVo<List<TDbSjsqAndQDVO>>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                    dbJgdbService.listSqlite(multipartFile));
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE);
        }

    }

    /**
     *@Auther: zje
     *@Date: 2020/6/10
     *@Description: sqlite数据插入临时表
     *@Param: tDbjgDTO
     *@return:
     */
//    @ApiOperation(value = "sqlite数据插入临时表")
//    @PostMapping(value = "insertTemp")
//    @SysLog(value = "sqlite数据插入临时表", operationType = LogTypeConstant.LOG_FIND_TYPE)
//    public RestResultVo insertTemp(@RequestBody TDbjgDTO tDbjgDTO){
//
//        try {
//            dbJgdbService.insertTemp(tDbjgDTO);
//            return new RestResultVo(RestStatus.SUCCESS,
//                    NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new RestResultVo<>(RestStatus.ERROR,
//                    NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
//        }
//    }

    /**
     *@Auther: hwd
     *@Date: 2020/6/9
     *@Description: 保存导入明细表中数据
     *@Param: sqdhs
     *@return: 暂时不用
     */
    @ApiOperation(value = "保存导入明细表中数据")
    @PostMapping(value = "insert")
    @SysLog(value = "临时表数据插入业务表", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<Boolean> insert( @RequestBody ZQSaveDTO zqSaveDTO){
        Boolean insert = dbJgdbService.insert(zqSaveDTO);
        return Utils.getAddResult(insert);
    }

    /**
     *@Auther: zje
     *@Date: 2020/6/10
     *@Description: 删除临时表中数据
     *@Param: sqdhs
     *@return:
     */
    @ApiOperation(value = "删除临时表中数据")
    @DeleteMapping(value = "delete")
    @SysLog(value = "删除临时表中数据", operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo delete(@RequestBody List<String> sqdh){
        if (sqdh.isEmpty()){
            return new RestResultVo<String>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE,
                    "申请编号为空");
        }
        try {
            dbJgdbService.delete(sqdh);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
    }
}
