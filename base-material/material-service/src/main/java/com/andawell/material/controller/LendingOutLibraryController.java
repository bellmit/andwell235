package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.dto.LibraryInfoDTO;
import com.andawell.material.dto.OutLibraryInfoDTO;
import com.andawell.material.query.TCkWjkQuery;
import com.andawell.material.service.ILendingService;
import com.andawell.material.service.impl.LendingService;
import com.andawell.material.util.Utils;
import com.andawell.material.vo.TCkWjkVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/***
 * @author lhb
 * @Date: 2020/5/15 15:36
 * @Description:
 * @version : V1.0
 */
@Api(value = "外借库管理", tags = "外借库管理")
@RestController
@RequestMapping(value = "sys/lending")
public class LendingOutLibraryController {


    @Autowired
    LendingService lendingService;

    @ApiOperation(value = "外借出库")
    @PostMapping(value = "save/libraryOut")
    @SysLog(value = "外借出库", operationType = LogTypeConstant.LOG_PUT_OUT_LIBRARY)
    public RestResultVo<Boolean> saveLendingOut(@RequestBody @Valid OutLibraryInfoDTO outLibraryInfoDTO) {
        Boolean isSuccess = lendingService.saveOutLibraryInfo(outLibraryInfoDTO);
        return Utils.getAddResult(isSuccess);
    }


    @ApiOperation(value = "外借入库")
    @PostMapping(value = "save/libraryIn")
    @SysLog(value = "外借入库", operationType = LogTypeConstant.LOG_PUT_IN_LIBRARY)
    public RestResultVo<Boolean> saveOLendingIn(@RequestBody @Valid LibraryInfoDTO libraryInfoDTO) {
        Boolean isSuccess = lendingService.saveInLibraryInfo(libraryInfoDTO);
        return Utils.getAddResult(isSuccess);
    }

    @ApiOperation(value = "外借入库-列表")
    @GetMapping(value = "get/inLibraryList")
    public RestResultVo<ListPageVo<TCkWjkQuery, TCkWjkVO>> saveOLendingIn(TCkWjkQuery tCkWjkQuery) {
        return new RestResultVo<ListPageVo<TCkWjkQuery, TCkWjkVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                lendingService.getListPage(tCkWjkQuery));
    }

}
