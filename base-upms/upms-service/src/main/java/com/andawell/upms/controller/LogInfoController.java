package com.andawell.upms.controller;

import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.common.util.SysUserUtils;
import com.andawell.upms.entity.LogInfo;
import com.andawell.upms.query.LogInfoQuery;
import com.andawell.upms.service.LogInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;

@Api(value = "LogInfoControllerApi", description = "LogInfoController的接口", produces =
        MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
@RequestMapping(value = "sys/log")
public class LogInfoController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private LogInfoService logInfoService;

    @ApiOperation(value = "系统日志分页查询", notes = "系统日志", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RestResultVo<ListPageVo<LogInfoQuery, LogInfo>> listPage(LogInfoQuery queryDto) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            if (queryDto.getStartTime() != null) {
                String startDate = sdf.format(queryDto.getStartTime());
                queryDto.setStartTime(sdf.parse(startDate));
            }
            if (queryDto.getEndTime() != null) {
                String endDate = sdf.format(queryDto.getEndTime());
                queryDto.setEndTime(sdf.parse(endDate));
            }
            return new RestResultVo<ListPageVo<LogInfoQuery, LogInfo>>(RestStatus.SUCCESS, "查询成功", logInfoService.listPage(queryDto));
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR, "操作异常");
        }
    }

    @ApiOperation(value = "用户系统日志分页查询", notes = "用户日志", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "/username", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RestResultVo<ListPageVo<LogInfoQuery, LogInfo>> listPageByUsername(LogInfoQuery queryDto) {
        try {
            logger.info("用户名" + SysUserUtils.getUsername());
            //将Date转换成制定格式的
            queryDto.setUsername(SysUserUtils.getUsername());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            if (queryDto.getStartTime() != null) {
                String startDate = sdf.format(queryDto.getStartTime());
                queryDto.setStartTime(sdf.parse(startDate));
            }
            if (queryDto.getEndTime() != null) {
                String endDate = sdf.format(queryDto.getEndTime());
                queryDto.setEndTime(sdf.parse(endDate));
            }
            return new RestResultVo<ListPageVo<LogInfoQuery, LogInfo>>(RestStatus.SUCCESS, "查询成功", logInfoService.listPage(queryDto));
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR, "操作异常");
        }
    }


    @ApiOperation(value = "查看详细信息", notes = "日志", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RestResultVo<LogInfo> detail(@ApiParam(value = "日志ID", name = "id") @PathVariable("id") String id) {
        try {
            if (StringUtils.isEmpty(id)) {
                return new RestResultVo(RestStatus.BAD_REQUEST, "未找到对应日志信息");
            }
            LogInfo logInfo = logInfoService.detail(id);
            if (logInfo == null) {
                return new RestResultVo(RestStatus.BAD_REQUEST, "未找到所选日志信息");
            }
            return new RestResultVo<LogInfo>(RestStatus.SUCCESS, "查询成功", logInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<>(RestStatus.ERROR, "操作异常");
        }
    }

//    @Inner
//    @ApiOperation(value = "新增信息", notes = "日志", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public RestResultVo insert(@RequestBody LogInfo logInfo) {
//        try {
//            logInfoService.insert(logInfo);
//            return new RestResultVo<LogInfo>(RestStatus.SUCCESS, "添加成功");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new RestResultVo<>(RestStatus.ERROR, "添加异常");
//        }
//    }

//    @ApiOperation(value = "更新信息", notes = "日志", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @PutMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public RestResultVo<LogInfo> update(@RequestBody LogInfo logInfo) {
//        try {
//            if (logInfo.getId() <= 0) {
//                return new RestResultVo(RestStatus.BAD_REQUEST, "未找到所选日志信息");
//            }
//            LogInfo role = logInfoService.detail(logInfo.getId());
//            if (role == null) {
//                return new RestResultVo<LogInfo>(RestStatus.BAD_REQUEST, "未找到所选日志信息");
//            }
//            logInfoService.update(logInfo);
//            return new RestResultVo<LogInfo>(RestStatus.SUCCESS, "更新成功");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new RestResultVo<LogInfo>(RestStatus.ERROR, "更新异常");
//        }
//    }

//    @ApiOperation(value = "删除日志信息", notes = "日志", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public RestResultVo<LogInfo> delete(@ApiParam(value = "日志ID", name = "id") @PathVariable("id") int id) {
//        try {
//            if (id <= 0) {
//                return new RestResultVo(RestStatus.ERROR, "未找到所选日志");
//            }
//            LogInfo logInfo = logInfoService.detail(id);
//            if (logInfo == null || logInfo.getId() < 0) {
//                return new RestResultVo<LogInfo>(RestStatus.BAD_REQUEST, "未找到所选日志");
//            }
//            logInfoService.delete(logInfo);
//            return new RestResultVo<LogInfo>(RestStatus.SUCCESS, "删除成功");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new RestResultVo<LogInfo>(RestStatus.ERROR, "删除异常");
//        }
//    }

}
