package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.common.util.BusinessException;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.entity.TRyZw;
import com.andawell.material.service.ITRyZwService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: zje
 * @date: 2020/5/20
 * @description:
 */

@Api(value = "人员职位管理", tags = "人员职位")
@RestController
@RequestMapping(value = "sys/tryzw")
public class TRyZwController {

    @Autowired
    private ITRyZwService ryZwService;

    /**
     *@Auther: zje
     *@Date: 2020/5/21
     *@Description: 新增父职位
     *@Param: ryZw
     *@return:
     */
    @ApiOperation(value = "新增父职位", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "insertOne")
    @SysLog(value = "新增父职位", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo insertOne(@RequestBody TRyZw ryZw){
        try {
            TRyZw tRyZw = ryZwService.selectByMc(ryZw.getMc());
            if (tRyZw != null) {
                return new RestResultVo(RestStatus.ERROR,
                        NoticeConstant.RESPONSE_EXIST_ALREADY_MESSAGE);
            }
            ryZwService.insertOne(ryZw);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }
    }

    /**
     *@Auther: zje
     *@Date: 2020/5/21
     *@Description: 新增子职位
     *@Param: ryZw
     *@return:
     */
    @ApiOperation(value = "新增子职位", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "insertTwo")
    @SysLog(value = "新增子职位", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo insertTwo(@RequestBody TRyZw ryZw){
        try {
            TRyZw tRyZw = ryZwService.selectByMc(ryZw.getMc());
            if (tRyZw != null) {
                return new RestResultVo(RestStatus.ERROR,
                        NoticeConstant.RESPONSE_EXIST_ALREADY_MESSAGE);
            }
            ryZwService.insertTwo(ryZw);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }
    }

    /**
     *@Auther: zje
     *@Date: 2020/5/21
     *@Description: 修改职位
     *@Param: ryZw
     *@return:
     */
    @ApiOperation(value = "修改职位", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PutMapping(value = "update")
    @SysLog(value = "修改职位", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo update(@RequestBody TRyZw ryZw){
        try {
            ryZwService.update(ryZw);
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
     *@Date: 2020/5/21
     *@Description: 删除职位
     *@Param: id
     *@return:
     */
    @ApiOperation(value = "删除职位", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @DeleteMapping(value = "delete/{id}")
    @SysLog(value = "删除职位", operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo delete(@PathVariable("id") String id){
        try {
            List<TRyZw> tRyZws = ryZwService.listTwoZw(id);
            if (!tRyZws.isEmpty()){
                return new RestResultVo(RestStatus.ERROR,
                        NoticeConstant.RESPONSE_CHILDREN_NOTNULL_MESSAGE);
            }
            ryZwService.delete(id);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
    }
}
