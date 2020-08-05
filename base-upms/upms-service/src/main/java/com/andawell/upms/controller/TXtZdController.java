package com.andawell.upms.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.common.util.BusinessException;
import com.andawell.upms.constant.NoticeConstant;
import com.andawell.upms.entity.TXtZd;
import com.andawell.upms.entity.TXtZdfj;
import com.andawell.upms.entity.ZdfjDTO;
import com.andawell.upms.query.TXtZdQuery;
import com.andawell.upms.query.TXtZdfjQuery;
import com.andawell.upms.service.TXtZdService;
import com.andawell.upms.service.TXtZdfjService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "中队管理", tags = "中队管理")
@RequestMapping(value = "sys/zd")
@RestController
public class TXtZdController {

    @Autowired
    private TXtZdService tXtZdService;

    @Autowired
    private TXtZdfjService tXtZdfjService;

    /**
     * 中队查询请求
     *
     * @param query
     * @return
     */
    @ApiOperation(value = "中队查询", notes = "中队查询", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping("list")
    public RestResultVo<List<TXtZd>> list(TXtZdQuery query) {

        return new RestResultVo<List<TXtZd>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                tXtZdService.list(query));
    }

    /**
     * 中队新增请求
     *
     * @param tXtZd
     * @return
     */
    @ApiOperation(value = "中队新增", notes = "中队新增", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping("insert")
    @SysLog(value = "中队新增", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<String> insert(@RequestBody TXtZd tXtZd) {

        try {
            if (StringUtils.isEmpty(tXtZd.getDwid())){
                throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE);
            }
            if (StringUtils.isNotEmpty(tXtZd.getYx()) && tXtZd.getYx().length()>=2) {
                throw new BusinessException(NoticeConstant.RESPONSE_COLUMNS_ERROR_MESSAGE);
            }
            String maxZdid = tXtZdService.getMaxZdid(tXtZd.getDwid());
            if (StringUtils.isEmpty(maxZdid)){
                tXtZd.setZdid(""+1);
            }else{
                tXtZd.setZdid(String.valueOf(Integer.valueOf(maxZdid)+1));
            }
            tXtZdService.insert(tXtZd);
            return new RestResultVo<>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }
    }

    /**
     * 中队修改请求
     *
     * @param tXtZd
     * @return
     */
    @ApiOperation(value = "中队修改", notes = "中队修改", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    @SysLog(value = "中队修改", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo<String> update(@RequestBody TXtZd tXtZd) {
        try {
            if (tXtZd.getDwid()==null || tXtZd.getZdid()==null || StringUtils.isEmpty(tXtZd.getMc())) {
                throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE);
            }
            tXtZdService.update(tXtZd);
            return new RestResultVo<>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE);
        }
    }

    /**
     * 中队删除请求
     *
     * @param query
     * @return
     */
    @ApiOperation(value = "中队删除", notes = "中队删除", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    @SysLog(value = "中队删除", operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo<String> delete(TXtZdQuery query) {
        try {
            if (query.getDwid()==null || query.getZdid()==null) {
                throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE);
            }
            tXtZdService.delete(query);
            return new RestResultVo<>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
    }

    /**
     * 飞机查询请求
     *
     * @param query
     * @return
     */
    @ApiOperation(value = "飞机查询", notes = "飞机查询", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping("fj/list")
    public RestResultVo<List<TXtZdfj>> listFj(TXtZdfjQuery query) {

        return new RestResultVo<List<TXtZdfj>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                tXtZdfjService.list(query));
    }

    /**
     * 飞机新增请求
     *
     * @param tXtZdfj
     * @return
     */
    @ApiOperation(value = "飞机新增", notes = "飞机新增", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping("fj/insert")
    @SysLog(value = "飞机新增", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<String> insertFj(@RequestBody TXtZdfj tXtZdfj) {
        try {
            if (StringUtils.isEmpty(tXtZdfj.getDwid()) || StringUtils.isEmpty(tXtZdfj.getZdid()) || StringUtils.isEmpty(tXtZdfj.getMc())) {
                throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE);
            }
            List<TXtZdfj> zdfjList = tXtZdfjService.list(new TXtZdfjQuery().setMc(tXtZdfj.getMc()));
            if (!zdfjList.isEmpty()) {
                throw new BusinessException(NoticeConstant.RESPONSE_NAME_REPEAT_MESSAGE);
            }
            tXtZdfjService.insert(tXtZdfj);
            return new RestResultVo<>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }
    }

    /**
     * 飞机修改请求
     *
     * @param ZdfjDTO
     * @return
     */
    @ApiOperation(value = "飞机修改", notes = "飞机修改", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "fj/update", method = RequestMethod.PUT)
    @SysLog(value = "飞机修改", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo<String> updateFj(@RequestBody ZdfjDTO ZdfjDTO) {
        try {
            if (ZdfjDTO.getXmc().equals(ZdfjDTO.getYmc())) {
                return new RestResultVo<>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
            }
            tXtZdfjService.update(ZdfjDTO);
            return new RestResultVo<>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE);
        }
    }

    /**
     * 中队飞机删除请求
     *
     * @param mc
     * @return
     */
    @ApiOperation(value = "飞机删除", notes = "飞机删除", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "fj/delete/{mc}", method = RequestMethod.DELETE)
    @SysLog(value = "飞机删除", operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo<String> deleteFj(@ApiParam(value = "飞机号", name = "mc") @PathVariable("mc") String mc) {
        try {
            if (StringUtils.isEmpty(mc)) {
                throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE);
            }
            tXtZdfjService.deleteByMc(mc);
            return new RestResultVo<>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
    }
}
