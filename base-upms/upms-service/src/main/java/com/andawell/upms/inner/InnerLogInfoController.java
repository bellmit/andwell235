package com.andawell.upms.inner;

import com.andawell.common.annotation.Inner;
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
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;

@Api(value = "LogInfoControllerApi", description = "LogInfoController的接口", produces =
        MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
@RequestMapping(value = "inner/sys/log")
public class InnerLogInfoController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private LogInfoService logInfoService;

    @Inner
    @ApiOperation(value = "新增信息", notes = "日志", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RestResultVo insert(@RequestBody LogInfo logInfo) {
        try {
            logInfoService.insert(logInfo);
            return new RestResultVo<LogInfo>(RestStatus.SUCCESS, "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<>(RestStatus.ERROR, "添加异常");
        }
    }

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
