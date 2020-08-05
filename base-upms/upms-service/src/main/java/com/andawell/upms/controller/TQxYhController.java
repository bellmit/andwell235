package com.andawell.upms.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.upms.constant.NoticeConstant;
import com.andawell.upms.dto.TQxYhDto;
import com.andawell.upms.entity.SysAccountInfo;
import com.andawell.upms.entity.TQxYh;
import com.andawell.upms.entity.TRyZw;
import com.andawell.upms.query.TQxYhQuery;
import com.andawell.upms.query.TRyZwQuery;
import com.andawell.upms.service.TQxYhService;
import com.andawell.upms.service.TRyZwService;
import com.andawell.upms.vo.TQxYhVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 用户信息的增删改查 职务下拉列表查询
 */
@Api(value = "用户信息管理接口", tags = "用户信息管理接口", produces =
        MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
@RequestMapping(value = "sys/tqxyh")
public class TQxYhController {

    @Autowired
    private TQxYhService tQxYhService;

    @Autowired
    private TRyZwService tRyZwService;


    private static final PasswordEncoder ENCODER = new BCryptPasswordEncoder();


    @ApiOperation(value = "职务下拉列表查询", notes = "职务下拉列表查询", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "listzw")
    public RestResultVo<List<TRyZw>> listzw(TRyZwQuery query) {
        return new RestResultVo<List<TRyZw>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                tRyZwService.list(query));
    }

    @ApiOperation(value = "新增用户", notes = "新增用户", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "insert")
    @SysLog(value = "新增用户", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo insert(@RequestBody @Valid TQxYhDto tQxYhDTO) {
        try {
            if(tQxYhDTO.getDlmm().isEmpty()){
                return new RestResultVo(RestStatus.ERROR,
                        NoticeConstant.RESPONSE_LOGIN_PASSWORD_MESSAGE);
            }
            /**
             * 将密码进行加密处理
             */
            tQxYhDTO.setDlmm(ENCODER.encode(tQxYhDTO.getDlmm()));
            /**
             * 登录名称判重
             */
            int pc = tQxYhService.DlmPc(tQxYhDTO.getDlm());
            if (pc == 1) {
                return new RestResultVo(RestStatus.ERROR,
                        NoticeConstant.RESPONSE_USERNAME_REPEAT_MESSAGE);
            }
            tQxYhService.insert(tQxYhDTO);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }
    }

    @ApiOperation(value = "编辑用户", notes = "编辑用户", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PutMapping(value = "update")
    @SysLog(value = "编辑用户", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo update(@RequestBody @Valid TQxYhDto tQxYhDTO) {
        try {
            if(StringUtils.isNotEmpty(tQxYhDTO.getDlmm())){
                /**
                 * 将密码进行加密处理
                 */
                tQxYhDTO.setDlmm(ENCODER.encode(tQxYhDTO.getDlmm()));
            }
            /**
             * 登录名称判重
             */
            //查询出来上一个登录名
            TQxYh tQxYh =tQxYhService.selectDlmById(tQxYhDTO.getId());
            //新旧登录名比较  如果相同不做判重
            if(!tQxYh.getDlm().equals(tQxYhDTO.getDlm())){
                int pc = tQxYhService.DlmPc(tQxYhDTO.getDlm());
                if (pc == 1) {
                    return new RestResultVo(RestStatus.ERROR,
                            NoticeConstant.RESPONSE_USERNAME_REPEAT_MESSAGE);
                }
            }
            tQxYhService.update(tQxYhDTO);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE);
        }

    }

    @ApiOperation(value = "删除用户", notes = "删除用户", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @DeleteMapping(value = "delete/{id}")
    @SysLog(value = "删除用户", operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo delete(@PathVariable("id") String id) {
        try {
            if (StringUtils.isEmpty(id)) {
                return new RestResultVo<SysAccountInfo>(RestStatus.BAD_REQUEST, NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
            }
            tQxYhService.delete(id);
            return new RestResultVo<SysAccountInfo>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<SysAccountInfo>(RestStatus.BAD_REQUEST, NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
    }

}
