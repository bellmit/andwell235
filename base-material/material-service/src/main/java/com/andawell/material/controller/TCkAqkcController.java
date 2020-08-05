package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.dto.TCkAqkcDTO;
import com.andawell.material.service.ITCkAqkcService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/***
 * @author shihaosen
 * @Date: 15:50
 * @Description:
 * @version : V1.0
 */
@Api(value = "航材安全库存量设置", tags = "航材安全库存量设置")
@RestController
@RequestMapping(value = "sys/TCkAqkc")
public class TCkAqkcController {
    @Autowired
    private ITCkAqkcService tCkAqkcService;

    /***
     * @author shs
     * @Date: 2020/6/2 17:18
     * @Description:航材安全库存量设置信息删除
     */
    @ApiOperation(value = "航材安全库存量设置信息删除")
    @DeleteMapping(value = "delete")
    @SysLog(value = "航材安全库存量设置信息删除", operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo delete(@RequestBody @Valid TCkAqkcDTO list) {
        try {
            tCkAqkcService.delete(list);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
    }

    /***
     * @author shs
     * @Date: 2020/6/3 8:18
     * @Description:航材安全库存量设置添加
     */
    @ApiOperation(value = "航材安全库存量设置信息添加")
    @PostMapping(value = "insert")
    @SysLog(value = "航材安全库存量设置信息添加", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo insert(@RequestBody @Valid TCkAqkcDTO list) {
        try {
            tCkAqkcService.insert(list);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }
    }

    /***
     * @author shs
     * @Date: 2020/6/3 8:18
     * @Description:航材安全库存量设置修改
     */
    @ApiOperation(value = "航材安全库存量设置信息修改")
    @PutMapping(value = "update")
    @SysLog(value = "航材安全库存量设置信息修改", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo update(@RequestBody @Valid TCkAqkcDTO list) {
        try {
            tCkAqkcService.update(list);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE);
        }
    }

}
