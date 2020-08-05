package com.andawell.upms.controller;

import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.common.util.SysUserUtils;
import com.andawell.upms.constant.NoticeConstant;
import com.andawell.upms.entity.SysMenuInfo;
import com.andawell.upms.enumeration.SysMenuType;
import com.andawell.upms.query.SysMenuInfoQuery;
import com.andawell.upms.service.SysMenuInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description: 菜单信息管理
 * @Author: dcy
 * @Version: 1.0
 */
@Api(value = "SysMenuInfoControllerApi", description = "SysMenuInfoController的接口", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
@RequestMapping(value = "sys/menu", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SysMenuInfoController {
    @Autowired
    private SysMenuInfoService sysMenuInfoService;


    @ApiOperation(value = "分页查询")/*直接单表查询*/
    @GetMapping(value = "list")
    public RestResultVo<List<SysMenuInfo>> listPage(SysMenuInfoQuery queryDto) {
        try {
            return new RestResultVo<List<SysMenuInfo>>(RestStatus.SUCCESS, "查询成功", sysMenuInfoService.list(queryDto));
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR, "操作异常");
        }
    }


    @ApiOperation(value = "查看详细信息")
    @GetMapping(value = "detail/{id}")
    public RestResultVo<SysMenuInfo> detail(@ApiParam(value = "菜单ID", name = "id") @PathVariable("id") String id) {
        try {
            String resultById = checkedParamsById(id);
            if (StringUtils.isNotEmpty(resultById)) {
                return new RestResultVo(RestStatus.ERROR, resultById);
            }
            SysMenuInfo sysMenuInfo = sysMenuInfoService.detail(new SysMenuInfoQuery().setId(id));

            return new RestResultVo<SysMenuInfo>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE, sysMenuInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR, "操作异常");
        }
    }

    @ApiOperation(value = "添加菜单信息", notes = "菜单", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "insert")
    public RestResultVo<SysMenuInfo> insert(@ApiParam(value = "新增信息", name = "sysMenuInfo") @RequestBody SysMenuInfo sysMenuInfo) {
        try {
            /**
             * 通用参数验证
             */
            String resultByBase = checkedParamsByBase(sysMenuInfo);
            if (StringUtils.isNotEmpty(resultByBase)) {
                return new RestResultVo(RestStatus.ERROR, resultByBase);
            }
            sysMenuInfo.setCreator(SysUserUtils.getUserId());
            sysMenuInfoService.insert(sysMenuInfo);
            return new RestResultVo<SysMenuInfo>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR, NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }
    }

    @ApiOperation(value = "更新菜单信息", notes = "菜单", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PutMapping(value = "update")
    public RestResultVo<SysMenuInfo> update(@ApiParam(value = "更新菜单信息", name = "sysMenuInfo") @RequestBody SysMenuInfo sysMenuInfo) {
        try {
            /**
             * 通用ID验证
             */
            String resultById = checkedParamsById(sysMenuInfo.getId());
            if (StringUtils.isNotEmpty(resultById)) {
                return new RestResultVo(RestStatus.ERROR, resultById);
            }
            /**
             * 通用参数验证
             */
            String resultByBase = checkedParamsByBase(sysMenuInfo);
            if (StringUtils.isNotEmpty(resultByBase)) {
                return new RestResultVo(RestStatus.ERROR, resultByBase);
            }
            sysMenuInfo.setModifier(SysUserUtils.getUserId());
            sysMenuInfoService.update(sysMenuInfo);
            return new RestResultVo<SysMenuInfo>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR, NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE);
        }
    }

    @ApiOperation(value = "删除菜单信息", notes = "菜单", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @DeleteMapping(value = "{id}")
    public RestResultVo<SysMenuInfo> delete(@ApiParam(value = "菜单ID", name = "id") @PathVariable("id") String id) {
        try {
            /**
             * 通用ID验证
             */
            String resultById = checkedParamsById(id);
            if (StringUtils.isNotEmpty(resultById)) {
                return new RestResultVo(RestStatus.ERROR, resultById);
            }
            SysMenuInfo sysMenuInfo = sysMenuInfoService.detail(new SysMenuInfoQuery().setId(id));
            sysMenuInfoService.delete(sysMenuInfo);
            /**
             * 同时删除角色及人员对应的权限信息
             */
            return new RestResultVo<SysMenuInfo>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<SysMenuInfo>(RestStatus.ERROR, NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
    }

    @ApiOperation(value = "获取登录人员对应角色菜单")
    @GetMapping(value = "getRoleMenu")
    public RestResultVo<List<SysMenuInfo>> getMenuInfoByRoleId() {
        try {
            String roleId = SysUserUtils.getUser().getRoleId();
            List<SysMenuInfo> sysMenuInfoList = sysMenuInfoService.listMenusByRoleIds(roleId);
            return new RestResultVo<List<SysMenuInfo>>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE, sysMenuInfoList);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR, "操作异常");
        }
    }


    private String checkedParamsById(String id) {
        if (StringUtils.isEmpty(id)) {
            return NoticeConstant.RESPONSE_NOTFOUND_MESSAGE;
        }
        SysMenuInfo sysMenuInfo = sysMenuInfoService.detail(new SysMenuInfoQuery().setId(id));
        if (sysMenuInfo == null || StringUtils.isEmpty(sysMenuInfo.getId())) {
            return NoticeConstant.RESPONSE_NOTFOUND_MESSAGE;
        }
        return null;
    }

    private String checkedParamsByBase(SysMenuInfo sysMenuInfo) {
        if (StringUtils.isEmpty(sysMenuInfo.getName())) {
            return "请填写菜单名称";
        }
        if (SysMenuType.button.name().equals(sysMenuInfo.getType().name())) {
            if (StringUtils.isEmpty(sysMenuInfo.getPid())) {
                return "请选择正确的菜单类型";
            }
            SysMenuInfo sysMenuInfoParent =
                    sysMenuInfoService.detail(new SysMenuInfoQuery().setId(sysMenuInfo.getPid()));
            if (sysMenuInfoParent == null || StringUtils.isEmpty(sysMenuInfoParent.getId())) {
                return "请选择有效的上级菜单信息";
            }
        }
        return null;
    }
}
