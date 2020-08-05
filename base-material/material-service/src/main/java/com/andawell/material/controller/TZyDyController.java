package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.entity.TZyDy;
import com.andawell.material.service.ITZyDyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: zje
 * @date: 2020/5/20
 * @description: 地域管理
 */

@Api(value = "地域管理", tags = "地域管理")
@RestController
@RequestMapping(value = "sys/tzydy")
public class TZyDyController {

    @Autowired
    private ITZyDyService itZyDyService;

    /**
     *@Auther: zje
     *@Date: 2020/5/20
     *@Description: 增加地域
     *@Param: zyDy
     *@return:
     */
    @ApiOperation(value = "增加地域")
    @PostMapping(value = "insert")
    @SysLog(value = "增加地域",operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo insert(@RequestBody TZyDy zyDy){
        try {
            TZyDy tZyDy = itZyDyService.selectByMc(zyDy.getMc());
            if (tZyDy != null){
                return new RestResultVo(RestStatus.ERROR,
                        NoticeConstant.RESPONSE_EXIST_ALREADY_MESSAGE);
            }
            itZyDyService.insert(zyDy);
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
     *@Date: 2020/5/20
     *@Description: 修改地域
     *@Param: zyDy
     *@return:
     */
    @ApiOperation(value = "修改地域")
    @PutMapping(value = "update")
    @SysLog(value = "修改地域",operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo update(@RequestBody TZyDy zyDy){
        try {
            itZyDyService.update(zyDy);
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
     *@Description: 删除地域
     *@Param: id
     *@return:
     */
    @ApiOperation(value = "删除地域")
    @DeleteMapping(value = "delete/{id}")
    @SysLog(value = "删除地域",operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo delete(@PathVariable("id") Integer id){
        try {
            itZyDyService.delete(id);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
    }
}
