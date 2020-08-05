package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.dto.TJhDjDTO;
import com.andawell.material.query.TJhDjQuery;
import com.andawell.material.service.ITJhDjService;
import com.andawell.material.vo.TJhDjVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/***
 * @author shs
 * @Date: 2020/5/15 14:18
 * @Description:大件信息管理  （大件信息模糊查询，大件信息添加，大件信息删除）
 * @version : V1.0
 */
@Api(value = "大件信息管理接口", tags = "大件信息管理接口")
@RestController
@RequestMapping(value = "sys/tjhdj")
public class TJhDjController {
    @Autowired
    private ITJhDjService tJhDjService;

    /***
     * @author shs
     * @Date: 2020/5/15 14:18
     * @Description:大件信息添加管理
     */
    @ApiOperation(value = "大件信息管理添加")
    @PostMapping(value = "insert")
    @SysLog(value = "大件信息管理添加", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<String> insert(@RequestBody @Valid TJhDjDTO tJhDjDTO) {
        try {
            tJhDjService.insert(tJhDjDTO);
            return new RestResultVo<String>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<String>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_EXIST_ALREADY_MESSAGE);
        }
    }

    /***
     * @author shs
     * @Date: 2020/5/15 16:18
     * @Description:大件信息查询
     */
    @ApiOperation(value = "大件信息查询", notes = "大件信息查询", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "list")
    public RestResultVo<List<TJhDjVO>> list(TJhDjQuery tJhDjQuery) {
        try {
            List<TJhDjVO> list = tJhDjService.list(tJhDjQuery);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE, list);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE);
        }
    }


    /***
     * @author shs
     * @Date: 2020/5/15 17:18
     * @Description:大件信息删除
     */
    @ApiOperation(value = "大件信息删除")
    @DeleteMapping(value = "delete")
    @SysLog(value = "大件信息删除", operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo delete(@RequestBody List<String> list) {
        try {
            tJhDjService.delete(list);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
    }
}
