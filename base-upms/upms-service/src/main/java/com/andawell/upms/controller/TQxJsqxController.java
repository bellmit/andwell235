package com.andawell.upms.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.common.util.SysUserUtils;
import com.andawell.upms.constant.NoticeConstant;
import com.andawell.upms.dto.*;
import com.andawell.upms.entity.*;
import com.andawell.upms.query.SysMenuInfoQuery;
import com.andawell.upms.query.TQxJsqxQuery;
import com.andawell.upms.query.TQxJxQuery;
import com.andawell.upms.query.TQxYhQuery;
import com.andawell.upms.service.*;
import com.andawell.upms.utils.ValidableList;
import com.andawell.upms.vo.TQxJxVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 权限管理 权限分配
 */
@Api(value = "角色权限管理接口", tags = "角色权限管理接口", produces =
        MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
@RequestMapping(value = "sys/jsqx")
public class TQxJsqxController {
    /**
     * 角色权限管理接口
     */
    @Autowired
    private TQxJsqxService tQxJsqxService;
    @Autowired
    private SysMenuInfoService sysMenuInfoService;
    /**
     * 角色管理接口
     */
    @Autowired
    private TQxJsService tQxJsService;
    /**
     * 用户管理接口
     */
    @Autowired
    private TQxYhService tQxYhService;
    /**
     * 角色仓库接口
     */
    @Autowired
    private TQxCKService tQxCKService;
    /**
     * 角色机型接口
     */
    @Autowired
    private TQxJxService tQxJxService;


    @ApiOperation(value = "角色权限查询", notes = "角色权限查询", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "list")
    public RestResultVo<String[]> listjsqx(TQxJsqxQuery query) {
        return new RestResultVo<String[]>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                tQxJsqxService.list(query));
    }


    @ApiOperation(value = "角色权限保存", notes = "角色权限保存", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "insert")
    @SysLog(value = "角色权限保存", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo insert(@RequestBody @Valid TQxJsqxDto tQxJsqxDto) {
        try {
            tQxJsqxService.Insert(tQxJsqxDto);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }

    }

    @ApiOperation(value = "角色权限删除", notes = "角色权限删除", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @DeleteMapping(value = "delete")
    @SysLog(value = "删除角色", operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo delete(@RequestBody @Valid TQxJsqxDto tQxJsqxDto) {
        try {
            tQxJsqxService.delete(tQxJsqxDto);
            return new RestResultVo<SysAccountInfo>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<SysAccountInfo>(RestStatus.BAD_REQUEST, NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
    }

    @ApiOperation(value = "新增角色", notes = "新增角色", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "insertqxjs")
    @SysLog(value = "新增角色", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo insertqxjs(@RequestBody @Valid TQxJsDto tQxJsDto) {
        try {
            /**
             *新增角色id判重
             */
      /*      int pc = tQxJsService.selectById(tQxJsDto.getId());
            if (pc == 1) {
                return new RestResultVo(RestStatus.ERROR,
                        NoticeConstant.RESPONSE_USERNAME_REPEAT_MESSAGE);
            }*/
            tQxJsService.insert(tQxJsDto);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }
    }


    @ApiOperation(value = "编辑角色", notes = "编辑角色", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PutMapping(value = "updateqxjs")
    @SysLog(value = "编辑角色", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo updateqxjs(@RequestBody @Valid TQxJsDto tQxJsDto) {
        try {
            tQxJsService.update(tQxJsDto);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE);
        }

    }

    @ApiOperation(value = "删除角色", notes = "删除角色", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @DeleteMapping(value = "deleteqxjs/{id}")
    @SysLog(value = "删除角色", operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo deleteqxjs(@PathVariable("id") String id) {
        try {
            if (StringUtils.isEmpty(id)) {
                return new RestResultVo<SysAccountInfo>(RestStatus.BAD_REQUEST, NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
            }
            List<TQxJs> list =  tQxJsService.selectByPidId(id);
            if(list.size()>0){
                return new RestResultVo<SysAccountInfo>(RestStatus.ERROR, NoticeConstant.RESPONSE_CHILDREN_NOTNULL_MESSAGE);
            }
            tQxJsService.delete(id);
            return new RestResultVo<SysAccountInfo>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<SysAccountInfo>(RestStatus.BAD_REQUEST, NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
    }

    /***
     * @author gzh
     * @Date: 2020/5/14
     * @Description: 添加，批量添加用户，删除，批量删除用户
     */
    @ApiOperation(value = "分配用户", notes = "分配用户", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PutMapping(value = "updateqxyh")
    @SysLog(value = "分配用户", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo updateqxyh(@RequestBody @Valid TQxYhFpDto tQxYhFpDto) {
        try {
            tQxYhService.updateyhfp(tQxYhFpDto);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE);
        }

    }


    @ApiOperation(value = "新增角色仓库", notes = "新增角色仓库", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "insertqxck")
    @SysLog(value = "新增角色仓库", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo insertqxck(@RequestBody @Valid TQxCkDto tQxCkDto) {
        try {
            tQxCKService.insert(tQxCkDto);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }
    }

    @ApiOperation(value = "删除角色仓库", notes = "删除角色仓库", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @DeleteMapping(value = "deleteqxck")
    @SysLog(value = "删除角色仓库", operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo deleteqxck(@RequestBody @Valid TQxCkDto tQxCkDto) {
        try {
            tQxCKService.delete(tQxCkDto);
            return new RestResultVo<SysAccountInfo>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<SysAccountInfo>(RestStatus.BAD_REQUEST, NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
    }


    @ApiOperation(value = "新增角色机型", notes = "新增角色机型", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "insertqxjx")
    @SysLog(value = "新增角色机型", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo insertqxjx(@RequestBody @Valid TQxJxDto tQxJxDto) {
        try {
            tQxJxService.insert(tQxJxDto);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }
    }

    @ApiOperation(value = "删除角色机型", notes = "删除角色机型", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @DeleteMapping(value = "deleteqxjx")
    @SysLog(value = "删除角色机型", operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo deleteqxjx(@RequestBody @Valid TQxJxDto tQxJxDto) {
        try {
            tQxJxService.delete(tQxJxDto);
            return new RestResultVo<SysAccountInfo>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<SysAccountInfo>(RestStatus.BAD_REQUEST, NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
    }


    @ApiOperation(value = "当前登录人员对应的权限信息", notes = "权限信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "auth")
    public RestResultVo listAuthByUserId() {
        //获取当前登录人员的ID
        String userId = SysUserUtils.getUserId();
        TQxYh tQxYh = tQxYhService.detail(userId);
        if (tQxYh == null || StringUtils.isEmpty(tQxYh.getId())) {
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE);
        }

        String role = tQxYh.getJs();
        List<SysMenuInfo> sysMenuInfos = sysMenuInfoService.list(new SysMenuInfoQuery());
        if (sysMenuInfos != null && sysMenuInfos.size() > 0) {
            sysMenuInfos.parallelStream().forEach(sysMenuInfo -> {

            });
        }
        return new RestResultVo(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE);
    }

    @ApiOperation(value = "查询当前角色下的机型", notes = "权限信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "role/nuder/moder/{js}")
    public RestResultVo<List<String>> getRoleNuderModer(@ApiParam(value = "角色id", name = "js") @PathVariable("js") String js) {
        return new RestResultVo<List<String>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                tQxJxService.getRoleNuderModer(js));
    }


    @ApiOperation(value = "查询当前角色下的仓库", notes = "权限信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "role/nuder/warehouse/{js}")
    public RestResultVo<List<String>> getRoleNuderWarehouse(@ApiParam(value = "角色id", name = "js") @PathVariable("js") String js) {
        return new RestResultVo<List<String>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                tQxCKService.getRoleNuderWarehouse(js));
    }
}
