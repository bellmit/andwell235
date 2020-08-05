package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.dto.TJhJhDTO;
import com.andawell.material.dto.TJhJhjxDTO;
import com.andawell.material.entity.TJhJh;
import com.andawell.material.mapper.TJhJhMapper;
import com.andawell.material.mapper.TJhMapper;
import com.andawell.material.query.JhQuery;
import com.andawell.material.query.TJhJhQuery;
import com.andawell.material.service.ITJhJhService;
import com.andawell.material.service.TJhService;
import com.andawell.material.util.BeanUtils;
import com.andawell.material.vo.TJhJhVO;
import com.andawell.material.vo.TJhVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/***
 * @author zje
 * @Date: 2020/5/9
 * @Description:件号接口
 * @version : V1.0
 */
@Api(value = "件号儿接口", tags = "件号儿接口")
@RestController
@RequestMapping(value = "sys/tjhjh")
public class TJhJhController {

    @Autowired
    ITJhJhService jhJhService;

    @Autowired
    private TJhService tJhService;

    @Autowired
    private TJhJhMapper jhJhMapper;


    @ApiOperation(value = "查询件儿号列表")
    @GetMapping(value = "list")
    public RestResultVo<List<TJhJhVO>> getXtCkList(@Valid TJhJhQuery query) {
        return new RestResultVo<List<TJhJhVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                BeanUtils.copyList(jhJhService.list(query), TJhJhVO.class));
    }

    @ApiOperation(value = "根据机型查询件号")
    @GetMapping(value = "listByJx")
    public RestResultVo<List<TJhVO>> getHList(@Valid JhQuery jhQuery) {
        return new RestResultVo<List<TJhVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                tJhService.getlist(jhQuery));
    }

    /**
     * @Auther:zje
     * @Date:2020/5/9
     * @Description:新增件号
     * @Param:
     * @return:
     */
    @ApiOperation(value = "新增件号")
    @PostMapping(value = "insert")
    @SysLog(value = "新增件号", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo insert(@RequestBody @Valid TJhJhDTO jhJhDTO) {
        try {
            TJhJh tJhJh = jhJhMapper.selectByPrimaryKey(jhJhDTO.getId());
            if (tJhJh != null) {
                return new RestResultVo(RestStatus.ERROR,
                        NoticeConstant.RESPONSE_ID_REPEAT_MESSAGE);
            }
            jhJhService.insert(jhJhDTO);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }
    }

    /**
     * @Auther:zje
     * @Date:2020/5/9
     * @Description:编辑件号
     * @Param:
     * @return:
     */
    @ApiOperation(value = "編輯件号")
    @PutMapping(value = "update")
    @SysLog(value = "编辑件号", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo update(@RequestBody @Valid TJhJhDTO jhJhDTO) {
        try {
            jhJhService.update(jhJhDTO);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE);
        }
    }

    /**
     * @Auther:zje
     * @Date:2020/5/9
     * @Description:删除件号
     * @Param:
     * @return:
     */
    @ApiOperation(value = "刪除件号")
    @DeleteMapping(value = "delete/{id}")
    @SysLog(value = "刪除件号", operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo delete(@PathVariable("id") String id) {
        try {
            jhJhService.delete(id);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
    }

    /**
     * @Auther:gzh
     * @Date:2020/5/22 16:36
     * @Description: 新增件号机型
     */
    @ApiOperation(value = "分配件号机型新增", notes = "分配件号机型新增", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "insertjhjx")
    @SysLog(value = "新增机型", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo insertjhjx(@RequestBody @Valid TJhJhjxDTO tJhJhjxDTO) {
        try {
            jhJhService.insertjhjx(tJhJhjxDTO);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }

    }


    /**
     * @Auther:gzh
     * @Date:2020/5/22 16:36
     * @Description: 删除件号机型
     */
    @ApiOperation(value = "分配件号机型删除", notes = "分配件号机型删除", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @DeleteMapping(value = "deletejhjx")
    @SysLog(value = "分配件号机型新增", operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo deletejhjx(@RequestBody @Valid TJhJhjxDTO tJhJhjxDTO) {
        try {
            jhJhService.deletejhjx(tJhJhjxDTO);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
    }




}
