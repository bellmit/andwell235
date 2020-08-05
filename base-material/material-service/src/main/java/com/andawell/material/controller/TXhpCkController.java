package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.dto.TXhpRkBcDTO;
import com.andawell.material.entity.*;
import com.andawell.material.query.*;
import com.andawell.material.service.*;
import com.andawell.material.util.BeanUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.filefilter.MagicNumberFileFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

/**
 * 五金管理
 *
 * @Data: 2020/5/7 14:26
 */
@Api(value = "五金管理", tags = "五金管理")
@RestController
@RequestMapping(value = "sys/xhpck")
public class TXhpCkController {

    @Autowired
    ITXhpCkService itXhpCkService;

    /***
     * @author gzh
     * @Date: 2020/5/15
     * @Description: 来源单位接口
     */
    @Autowired
    private ITXhpCrkService itXhpCrkService;


    /**
     * @Auther:gzh
     * @Date:2020/5/15 15:21
     * @Description: 五金类别
     */
    @Autowired
    private ITXhpLbService itXhpLbService;

    /***
     * @author gzh
     * @Date: 2020/5/15
     * @Description: 出入库类别接口
     */
    @Autowired
    private ITCkCrklbService itCkCrklbService;

    /**
     * @Auther:gzh
     * @Date:2020/5/15 15:56
     * @Description: 计量单位接口
     */
    @Autowired
    private ITXtJldwService itXtJldwService;

    /**
     * @Auther:gzh
     * @Date:2020/5/15 16:38
     * @Description: 仓库号接口
     */
    @Autowired
    private ITXtCkService itXtCkService;



    /**
     *@Auther:gzh
     *@Date:2020/5/25 16:17
     *@Description: 批次号查询接口
     */
    @ApiOperation(value = "批次号查询接口", notes = "批次号查询接口", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "pch")
    public RestResultVo<TXhpCrk> pch() {
        return new RestResultVo<TXhpCrk>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                itXhpCrkService.pch());
    }

    /**
     *@Auther:gzh
     *@Date:2020/5/26 8:32
     *@Description:  入库文号查询接口
     */
    @ApiOperation(value = "入库文号查询接口", notes = "入库文号查询接口", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "wh")
    public RestResultVo<TXhpCrk> wh(String jm) {
        return new RestResultVo<TXhpCrk>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                itXhpCrkService.wh(jm));
    }



    /**
     * @Auther:gzh
     * @Date:2020/5/15 15:38
     * @Description:来源单位查询接口
     * @Param:
     * @return:
     */
    @ApiOperation(value = "来源单位调拨单位查询接口", notes = "来源单位查询接口", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "lydw")
    public RestResultVo<List<TXhpCrk>> lydwList(TXhpCrkQuery query) {
        return new RestResultVo<List<TXhpCrk>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                itXhpCrkService.lydwList(query));
    }

    /**
     * @Auther:gzh
     * @Date:2020/5/15 15:39
     * @Description:出入库类别查询接口
     * @Param:
     * @return:
     */
    @ApiOperation(value = "出入库类别查询接口", notes = "出入库类别查询接口", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "crklb")
    public RestResultVo<List<TCkCrklb>> getTCkCrklbList(TCkCrklbQuery query) {
        return new RestResultVo<List<TCkCrklb>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                itCkCrklbService.rklbList(query));
    }

    @ApiOperation(value = "五金出入库类别查询接口", notes = "五金出入库类别查询接口", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "wjcrklb")
    public RestResultVo<List<TCkCrklb>> getTCkCrkwjlbList() {
        return new RestResultVo<List<TCkCrklb>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                itCkCrklbService.wjcrklbList());
    }


    /**
     * @Auther:gzh
     * @Date:2020/5/15 15:39
     * @Description:五金类别查询接口
     * @Param:
     * @return:
     */
    @ApiOperation(value = "五金类别查询接口", notes = "五金类别查询接口", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "wjlb")
    public RestResultVo<List<TXhpLb>> tXhpLbList(TXhpLbQuery query) {
        return new RestResultVo<List<TXhpLb>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                itXhpLbService.list(query));
    }

    /**
     * @Auther:gzh
     * @Date:2020/5/15 15:49
     * @Description: 计量单位查询接口
     * @Param:
     * @return:
     */
    @ApiOperation(value = "计量单位查询接口", notes = "计量单位查询接口", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "jldw")
    public RestResultVo<List<TXtJldw>> tXtJldwList(TXtJldwQuery query) {
        return new RestResultVo<List<TXtJldw>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                itXtJldwService.list(query));
    }

    /**
     *@Auther:gzh
     *@Date:2020/5/18 16:35
     *@Description:仓库号查询接口
     *@Param:TXtCkQuery
     */
    @ApiOperation(value = "仓库号查询接口", notes = "仓库号查询接口", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "tXtck")
    public RestResultVo<List<TXtCk>> tXtckList(TXtCkQuery query) {
        return new RestResultVo<List<TXtCk>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                itXtCkService.list(query));

    }
    /**
     *@Auther:gzh
     *@Date:2020/5/18 16:35
     *@Description:五金入库保存
     *@Param:TXhpRkBcDTO
     *@return:RestResultVo
     */
    @ApiOperation(value = "五金入库保存", notes = "五金入库保存", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "rkbc")
    @SysLog(value = "五金入库保存", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo rkbc(@RequestBody @Valid TXhpRkBcDTO tXhpRkBcDTO) {
        try {
            itXhpCkService.rkbc(tXhpRkBcDTO);
            return new RestResultVo(RestStatus.SUCCESS, NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR, NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }


    }


    @ApiOperation(value = "五金出库保存", notes = "五金出库保存", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "ckbc")
    @SysLog(value = "五金出库保存", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo ckbc(@RequestBody @Valid TXhpRkBcDTO tXhpRkBcDTO) {
        try {
            itXhpCkService.ckbc(tXhpRkBcDTO);
            return new RestResultVo(RestStatus.SUCCESS, NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR, NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }
    }
}
