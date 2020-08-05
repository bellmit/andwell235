package com.andawell.purchase.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.common.util.BusinessException;
import com.andawell.purchase.constant.NoticeConstant;
import com.andawell.purchase.query.THtQuery;
import com.andawell.purchase.service.ITDhHtService;
import com.andawell.purchase.vo.THtVO;
import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.purchase.constant.NoticeConstant;
import com.andawell.purchase.dto.TDhHtDTO;
import com.andawell.purchase.dto.TDhJhDTO;
import com.andawell.purchase.service.ITDhHtService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.util.List;

import javax.validation.Valid;

/***
 * @author lhb
 * @Date: 2020/6/4 13:33
 * @Description:
 * @version : V1.0
 */
@Api(value = "订货合同生成", tags = "订货合同生成")
@RestController
@RequestMapping(value = "sys/dhht")
public class TDhHtController {

    @Autowired
    private ITDhHtService tDhHtService;

    @ApiOperation(value = "往年合同查询")
    @GetMapping("ht/before")
    public RestResultVo<ListPageVo<THtQuery, THtVO>> listBefore(THtQuery query) {

        return new RestResultVo<ListPageVo<THtQuery, THtVO>>(RestStatus.SUCCESS
                , NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE
                ,tDhHtService.listPageBefore(query));
    }

    @ApiOperation(value = "今年合同查询")
    @GetMapping("ht/after")
    public RestResultVo<ListPageVo<THtQuery, THtVO>> listAfter(THtQuery query) {

        return new RestResultVo<ListPageVo<THtQuery, THtVO>>(RestStatus.SUCCESS
                , NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE
                ,tDhHtService.listPageAfter(query));
    }

    @ApiOperation(value = "删除合同")
    @RequestMapping(value = "ht/delete/{mlbh}",method = RequestMethod.DELETE)
    @SysLog(value = "删除合同",operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo<String> delete(@PathVariable("mlbh") String jhbh) {

        try {
            if ( StringUtils.isEmpty(jhbh)) {
                throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE);
            }
            tDhHtService.delete(jhbh);
            return new RestResultVo<>(RestStatus.SUCCESS,NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            if ( e instanceof BusinessException) {
                return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE+","+e.getMessage());
            }
            return new RestResultVo<>(RestStatus.ERROR,NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }

    }


    @ApiOperation(value = "生成合同", notes = "生成合同")
    @PostMapping(value = "save/htAndQd")
    @SysLog(value = "生成合同", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo insert(@RequestBody @Valid TDhHtDTO tDhHtDTO) {
        try {
            tDhHtService.saveHtAndQdList(tDhHtDTO);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE,e.getMessage());
        }
    }
}
