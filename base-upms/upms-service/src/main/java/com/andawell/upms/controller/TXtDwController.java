package com.andawell.upms.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.common.util.BusinessException;
import com.andawell.upms.constant.NoticeConstant;
import com.andawell.upms.dto.TXtDwDto;
import com.andawell.upms.entity.TQxDwlx;
import com.andawell.upms.entity.TXtCk;
import com.andawell.upms.entity.TXtDw;
import com.andawell.upms.entity.TXtZd;
import com.andawell.upms.query.TQxDwlxQuery;
import com.andawell.upms.query.TXtCkQuery;
import com.andawell.upms.query.TXtDwQuery;
import com.andawell.upms.query.TXtZdQuery;
import com.andawell.upms.service.TQxDwlxService;
import com.andawell.upms.service.TXtCkService;
import com.andawell.upms.service.TXtDwService;
import com.andawell.upms.service.TXtZdService;
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

@Api(value = "军方单位", tags = "军方单位")
@RequestMapping(value = "sys/jf")
@RestController
public class TXtDwController {

    @Autowired
    private TXtDwService tXtDwService;

    @Autowired
    private TQxDwlxService tQxDwlxService;

    @Autowired
    private TXtCkService tXtCkService;

    @Autowired
    private TXtZdService tXtZdService;

    /*
    @ApiOperation(value = "单位分页查询", notes = "单位分页查询", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping("listPage")
    public RestResultVo<ListPageVo<TXtDwQuery,TXtDw>> listPage(TXtDwQuery query){

        return new RestResultVo<ListPageVo<TXtDwQuery,TXtDw>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                tXtDwService.listPage(query));
    }
    */

    /**
     * 全量查询请求
     *
     * @param query
     * @return
     */
    @ApiOperation(value = "单位查询", notes = "单位查询", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping("list")
    public RestResultVo<List<TXtDw>> list(@RequestBody TXtDwQuery query) {
        return new RestResultVo<List<TXtDw>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                tXtDwService.list(query));
    }

    /**
     * 单位详情查询
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "单位详细信息查询", notes = "单位信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "detail/{id}")
    public RestResultVo<TXtDw> detail(@PathVariable("id") String id) {
        return new RestResultVo<TXtDw>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                tXtDwService.getDetail(id));
    }

    /**
     * 本级单位新增
     *
     * @param tXtDw
     * @return
     */
    @ApiOperation(value = "本级单位新增", notes = "本级单位新增", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping("insert")
    @SysLog(value = "本级单位新增", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<String> insert(@RequestBody TXtDw tXtDw) {
        try {
            if (tXtDw==null) {
                throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE);
            }
            String maxId=tXtDwService.getMax2LengthId();
            if (StringUtils.isEmpty(maxId)) {
                tXtDw.setId("10");
            } else {
                tXtDw.setId(String.valueOf(Integer.valueOf(maxId)+1));
            }
            tXtDw.setPid(null);
            tXtDwService.insert(tXtDw);
            return new RestResultVo<>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }
    }

    /**
     * 子级单位新增
     *
     * @param tXtDw
     * @return
     */
    @ApiOperation(value = "子级单位新增", notes = "子级单位新增", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping("zj/insert")
    @SysLog(value = "子级单位新增", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<String> insertZj(@RequestBody TXtDw tXtDw) {
        try {
            if (tXtDw==null) {
                throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE);
            }
            String pid = tXtDw.getId();
            String maxId = tXtDwService.getMaxByPid(pid);
            if (StringUtils.isEmpty(maxId)) {
                tXtDw.setId(pid+0+1);
            } else {
                tXtDw.setId(String.valueOf(Integer.valueOf(maxId) + 1));
            }
            tXtDw.setPid(pid);
            tXtDwService.insert(tXtDw);
            return new RestResultVo<>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }
    }

    /**
     * 单位更新请求
     *
     * @param tXtDw
     * @return
     */
    @ApiOperation(value = "单位编辑", notes = "单位编辑", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    @SysLog(value = "单位编辑", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo<String> update(@RequestBody TXtDw tXtDw) {
        try {
            if (tXtDw==null || StringUtils.isEmpty(tXtDw.getId())) {
                throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE);
            }
            tXtDwService.update(tXtDw);
            return new RestResultVo<>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE);
        }
    }

    /**
     * 单位删除请求
     *
     * @param id
     * @return
     */

    @ApiOperation(value = "单位删除", notes = "单位删除", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    @SysLog(value = "单位删除", operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo<String> delete(@ApiParam(value = "组织机构ID", name = "id") @PathVariable("id") String id) {
        try {
            if (StringUtils.isEmpty(id)) {
                throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE);
            }
            List<TXtDw> dwList = tXtDwService.list(new TXtDwQuery().setPid(id));
            if (!dwList.isEmpty()) {
                throw new BusinessException(NoticeConstant.RESPONSE_CHILDREN_NOTNULL_MESSAGE);
            }
            List<TXtCk> cks = tXtCkService.list(new TXtCkQuery().setDwid(id));
            if (!cks.isEmpty()) {
                throw new BusinessException(NoticeConstant.RESPONSE_CK_NOTNULL_MESSAGE);
            }
            List<TXtZd> zds = tXtZdService.list(new TXtZdQuery().setDwid(id));
            if (!zds.isEmpty()) {
                throw new BusinessException(NoticeConstant.RESPONSE_ZD_NOTNULL_MESSAGE);
            }
            tXtDwService.deleteById(id);
            return new RestResultVo<>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
    }

    /**
     * 单位类型详情查询
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "单位类型详细信息查询", notes = "单位类型信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "dwlx/detail/{id}")
    public RestResultVo<TQxDwlx> dwlxDetail(@PathVariable("id") String id) {
        if (StringUtils.isEmpty(id)) {
            return new RestResultVo<TQxDwlx>(RestStatus.ERROR, NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE);
        }
        return new RestResultVo<TQxDwlx>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                tQxDwlxService.getDetail(id));
    }

    /**
     * 单位类型查询
     *
     * @param query
     * @return
     */
    @ApiOperation(value = "单位类型信息查询", notes = "单位信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "dwlx/list")
    @SysLog(value = "单位类型查询", operationType = LogTypeConstant.LOG_FIND_TYPE)
    public RestResultVo<List<TQxDwlx>> dwlxList(TQxDwlxQuery query) {
        return new RestResultVo<List<TQxDwlx>>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                tQxDwlxService.list(query));
    }
}
