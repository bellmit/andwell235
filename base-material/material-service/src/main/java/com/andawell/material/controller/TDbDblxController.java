package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.entity.TDbDblx;
import com.andawell.material.service.ITDbDblxService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author: zje
 * @date: 2020/5/20
 * @description:调拨类型管理
 */

@Api(value = "调拨类型管理", tags = "调拨类型管理")
@RestController
@RequestMapping(value = "sys/tdbdblx")
public class TDbDblxController {

    @Autowired
    private ITDbDblxService itDbDblxService;

    /**
     *@Auther:zje
     *@Date:2020/5/20
     *@Description:添加调拨类型
     *@Param:tDbDblx
     *@return:
     */
    @ApiOperation(value = "添加调拨类型", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "insert")
    @SysLog(value = "外部油封登记", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo insert(@RequestBody TDbDblx tDbDblx){
        try {
            TDbDblx tDbDblx1 = itDbDblxService.selectByMc(tDbDblx.getMc());
            if (tDbDblx1 != null){
                return new RestResultVo(RestStatus.ERROR,
                        NoticeConstant.RESPONSE_EXIST_ALREADY_MESSAGE);
            }
            itDbDblxService.insert(tDbDblx);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }
    }

    /**
     *@Auther:zje
     *@Date:2020/5/20
     *@Description:修改调拨类型
     *@Param:tDbDblx
     *@return:
     */
    @ApiOperation(value = "修改调拨类型", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PutMapping(value = "update")
    @SysLog(value = "外部油封登记", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo update(@RequestBody TDbDblx tDbDblx){
        try {
            itDbDblxService.update(tDbDblx);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE);
        }
    }

    /**
     *@Auther:zje
     *@Date:2020/5/20
     *@Description:删除调拨类型
     *@Param:id
     *@return:
     */
    @ApiOperation(value = "删除调拨类型", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @DeleteMapping(value = "delete/{id}")
    @SysLog(value = "外部油封登记", operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo delete(@PathVariable("id") String id){
        try {
            itDbDblxService.delete(id);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
    }
}
