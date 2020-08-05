package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.entity.TZyRwxz;
import com.andawell.material.service.ITZyRwxzService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author: zje
 * @date: 2020/5/20
 * @description:
 */

@Api(value = "任务性质管理", tags = "任务性质管理")
@RestController
@RequestMapping(value = "sys/tzyrwxz")
public class TZyRwxzController {

    @Autowired
    private ITZyRwxzService itZyRwxzService;

    /**
     *@Auther:zje
     *@Date:2020/5/21
     *@Description:添加任务性质
     *@Param:zyRwxz
     *@return:
     */
    @ApiOperation(value = "添加任务性质", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "insert")
    @SysLog(value = "添加任务性质",operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo insert(@RequestBody TZyRwxz zyRwxz){
        try {
            TZyRwxz tZyRwxz = itZyRwxzService.selectByMc(zyRwxz.getMc());
            if (tZyRwxz != null){
                return new RestResultVo(RestStatus.ERROR,
                        NoticeConstant.RESPONSE_EXIST_ALREADY_MESSAGE);
            }
            itZyRwxzService.insert(zyRwxz);
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
     *@Date:2020/5/21
     *@Description:修改任务性质
     *@Param:zyRwxz
     *@return:
     */
    @ApiOperation(value = "修改任务性质", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PutMapping(value = "update")
    @SysLog(value = "修改任务性质",operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo update(@RequestBody TZyRwxz zyRwxz){
        try {
            itZyRwxzService.update(zyRwxz);
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
     *@Date:2020/5/21
     *@Description:删除任务性质
     *@Param:id
     *@return:
     */
    @ApiOperation(value = "删除任务性质", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @DeleteMapping(value = "delete/{id}")
    @SysLog(value = "删除任务性质",operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo delete(@PathVariable("id") Integer id){
        try {
            itZyRwxzService.delete(id);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
    }


}
