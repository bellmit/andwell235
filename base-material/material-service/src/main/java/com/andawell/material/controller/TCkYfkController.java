package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.dto.OutYFRegisterDTO;
import com.andawell.material.entity.TCkSyyl;
import com.andawell.material.entity.TXtFcff;
import com.andawell.material.query.OutYFQuery;
import com.andawell.material.query.TCkDxQuery;
import com.andawell.material.service.TCkYfkService;
import com.andawell.material.utils.ValidableList;
import com.andawell.material.vo.TCkDxStatusVO;
import com.andawell.material.vo.TCkYfkVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/***
 * @author hwd
 * @Date: 2020-05-08 11:37
 * @Description:外部油封登记
 * @version : V1.0
 */
@Api(value = "外部油封管理", tags = "外部油封管理")
@RestController
@RequestMapping(value = "sys/tckyfk")
public class TCkYfkController
{

    @Autowired
    private TCkYfkService tCkYfkService;

    /**
     * 返回封存方法
     */
    @ApiOperation(value = "返回封存方法")
    @GetMapping(value = "get/getFCMethodList")
    public RestResultVo<List<TXtFcff>> getFCMethodList() {
        return new RestResultVo<List<TXtFcff>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                tCkYfkService.getFcList());
    }

    /**
     * 返回使用油料 下拉列表
     */
    @ApiOperation(value = "返回全部的使用油料")
    @GetMapping(value = "get/getYlList")
    public RestResultVo<List<TCkSyyl>> getYlList()
    {
        return new RestResultVo<List<TCkSyyl>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                tCkYfkService.getList());
    }

    /**
     * 保存明细
     */
    @ApiOperation(value = "外部油封登记-保存明细信息")
    @PostMapping(value = "save/mx")
    @SysLog(value = "外部油封登记", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<Object> saveMx(@RequestBody @Valid ValidableList<OutYFRegisterDTO> outYFRegisterDTOs)
    {
        tCkYfkService.saveMx(outYFRegisterDTOs);
        return new RestResultVo<Object>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
    }

    /**
     * 外部油封查询
     */
    @ApiOperation(value = "外部油封查询")
    @GetMapping(value = "get/getYFList")
    public RestResultVo<List<TCkYfkVO>> getYFList(@Valid OutYFQuery outYFQuery)
    {
        return new RestResultVo<List<TCkYfkVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                tCkYfkService.getYFList(outYFQuery));
    }

}
