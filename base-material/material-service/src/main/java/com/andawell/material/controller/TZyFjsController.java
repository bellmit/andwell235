package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.entity.TZyFjs;
import com.andawell.material.service.ITZyFjsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: zje
 * @date: 2020/5/20
 * @description: 飞机数管理
 */

@Api(value = "飞机数管理", tags = "飞机数管理")
@RestController
@RequestMapping(value = "sys/tzyfjs")
public class TZyFjsController {

    @Autowired
    private ITZyFjsService zyFjsService;

    /**
     *@Auther: zje
     *@Date: 2020/5/20
     *@Description: 增加飞机数
     *@Param: zyFjs
     *@return:
     */
    @ApiOperation(value = "增加飞机数")
    @PostMapping(value = "insert")
    @SysLog(value = "增加飞机数",operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo insert(@RequestBody TZyFjs zyFjs){
        try {
            TZyFjs tZyFjs = zyFjsService.selectByMc(zyFjs.getMc());
            if (tZyFjs != null){
                return new RestResultVo(RestStatus.ERROR,
                        NoticeConstant.RESPONSE_EXIST_ALREADY_MESSAGE);
            }
            zyFjsService.insert(zyFjs);
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
     *@Description: 修改飞机数
     *@Param: zyFjs
     *@return:
     */
    @ApiOperation(value = "修改飞机数")
    @PutMapping(value = "update")
    @SysLog(value = "修改飞机数",operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo update(@RequestBody TZyFjs zyFjs){
        try {
            zyFjsService.update(zyFjs);
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
     *@Date: 2020/5/20
     *@Description: 删除飞机数
     *@Param: id
     *@return:
     */
    @ApiOperation(value = "删除飞机数")
    @DeleteMapping(value = "delete/{id}")
    @SysLog(value = "删除飞机数",operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo delete(@PathVariable("id") Integer id){
        try {
            zyFjsService.delete(id);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
    }
}
