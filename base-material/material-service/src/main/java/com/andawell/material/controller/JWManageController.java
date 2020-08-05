package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.dto.JWManageDTO;
import com.andawell.material.dto.LibraryInfoDTO;
import com.andawell.material.service.JWManageService;
import com.andawell.material.util.Utils;
import com.andawell.material.utils.ValidableList;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/***
 * @author hwd
 * @Date: 2020-05-15 10:27
 * @Description:架位管理
 * @version : V1.0
 */
@Api(value = "库房管理-架位管理", tags = "库房管理-架位管理")
@RestController
@RequestMapping(value = "sys/jwManage")
public class JWManageController {


    @Autowired
    private JWManageService jwManageService;


    @ApiOperation(value = "架位更新-根据主信息修改全部的明细")
    @PutMapping(value = "update/all/jwUpdate")
    @SysLog(value = "根据主信息修改全部的明细", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo<Boolean> jwAllUpdate(@RequestBody @Valid JWManageDTO jwManageDTOs){

        Boolean aBoolean = jwManageService.jwAllUpdate(jwManageDTOs);

        if (aBoolean) {
            return new RestResultVo<Boolean>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
        } else {
            return  new RestResultVo<Boolean>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE);
        }
    }


    @ApiOperation(value = "架位更新-单独修改明细")
    @PutMapping(value = "update/one/jwUpdate")
    @SysLog(value = "单独修改明细", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo<Boolean> jwOneUpdate(@RequestBody @Valid JWManageDTO jwManageDTOs){

        Boolean aBoolean = jwManageService.jwOneUpdate(jwManageDTOs);

        if (aBoolean) {
            return new RestResultVo<Boolean>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
        } else {
            return  new RestResultVo<Boolean>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE);
        }
    }

    @ApiOperation(value = "待修航材架位管理")
    @PutMapping(value = "update/pendHCJWManage")
    @SysLog(value = "待修航材架位管理", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo<Boolean> pendJWManage(@RequestBody @Valid ValidableList<JWManageDTO> jwManageDTOs){

        Boolean aBoolean = jwManageService.pendHCJWManage(jwManageDTOs);
        if (aBoolean) {
            return new RestResultVo<Boolean>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
        } else {
            return  new RestResultVo<Boolean>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE);
        }
    }


    @ApiOperation(value = "报废航材架位管理")
    @PutMapping(value = "update/discardJWManage")
    @SysLog(value = "报废航材架位管理", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo<Boolean> discardJWManage(@RequestBody @Valid ValidableList<JWManageDTO> jwManageDTOs){

        Boolean aBoolean = jwManageService.discardJWManage(jwManageDTOs);
        if (aBoolean) {
            return new RestResultVo<Boolean>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
        } else {
            return  new RestResultVo<Boolean>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE);
        }
    }


}
