package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.dto.TDbDbAndQdDTO;
import com.andawell.material.dto.TDbLtsqDTO;
import com.andawell.material.dto.TheaterAllocationDTO;
import com.andawell.material.dto.groups.First;
import com.andawell.material.entity.TDbLtsq;
import com.andawell.material.entity.TDbLtsqqd;
import com.andawell.material.query.TDbLtsqQuery;
import com.andawell.material.query.TDbLtsqqdQuery;
import com.andawell.material.service.ITDbLtsqService;
import com.andawell.material.service.ITDbLtsqqdService;
import com.andawell.material.service.ITJhJhService;
import com.andawell.material.util.Utils;
import com.andawell.material.vo.TDbLtsqVO;
import com.andawell.material.vo.TDbLtsqqdVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/***
 * @author shs
 * @Date: 2020/5/13 14:18
 * @Description:调拨管理  （装备仓库）旅团航材申请/机关调拨
 * @version : V1.0
 */
@Api(value = "旅团调拨管理接口", tags = "旅团调拨管理接口")
@RestController
@RequestMapping(value = "sys/tdbltsq")
public class TDbLtsqController {
    @Autowired
    private ITDbLtsqService tDbLtsqService;
    @Autowired
    ITJhJhService jhJhService;

    @Autowired
    ITDbLtsqqdService tDbLtsqqdService;

    /***
     * @author shs
     * @Date: 2020/5/13 14:18
     * @Description:《装备仓库管理》旅团航材申请批量添加
     */
    @ApiOperation(value = "旅团航材申请批量添加")
    @PostMapping(value = "insert")
    @SysLog(value = "旅团航材申请批量添加", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<String> insert(@RequestBody TDbLtsqDTO tDbLtsqDTO) {
        try {
            tDbLtsqService.insert(tDbLtsqDTO);
            return new RestResultVo<String>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR, NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }
    }

    /***
     * @author shs
     * @Date: 2020/5/14 14:18
     * @Description:《装备仓库管理》季度下拉接口
     */
    @ApiOperation(value = "季度下拉列表", notes = "季度下拉列表查询", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "getQuartal")
    public RestResultVo<List<TDbLtsq>> getQuartal(TDbLtsqQuery query) {
        return new RestResultVo<List<TDbLtsq>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                tDbLtsqService.listjd(query));
    }

    /***
     * @author shs
     * @Date: 2020/5/14 14:50
     * @Description:《装备仓库管理》申请原因下拉列表
     * @return
     */
    @ApiOperation(value = "申请原因下拉列表", notes = "申请原因下拉列表", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "getGrundist")
    public RestResultVo<List<TDbLtsqqd>> getGrundist(TDbLtsqQuery query) {
        return new RestResultVo<List<TDbLtsqqd>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                tDbLtsqService.getGrundist(query));
    }

    /***
     * @author shs
     * @Date: 2020/5/14 16:50
     * @Description:《装备仓库管理》根据器材带入全新数，可用数，待修数目，在修数
     * @return
     */
    @ApiOperation(value = "数目带入", notes = "数目带入", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "list")
    public RestResultVo<TDbLtsqqdVO> smList(@Valid TDbLtsqqdQuery query) {
        return new RestResultVo<TDbLtsqqdVO>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                tDbLtsqService.smList(query));
    }







}
