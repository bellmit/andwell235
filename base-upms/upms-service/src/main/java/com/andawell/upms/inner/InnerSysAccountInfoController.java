package com.andawell.upms.inner;

import com.andawell.common.annotation.Inner;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.common.util.WebUtils;
import com.andawell.upms.constant.NoticeConstant;
import com.andawell.upms.dto.LoginAccountInfo;
import com.andawell.upms.entity.SysAccountInfo;
import com.andawell.upms.query.SysAccountInfoQuery;
import com.andawell.upms.service.SysAccountInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/***
 * @ClassName: InnerSysAccountInfoController
 * @Description: 账户信息内部接口
 * @author DCY
 * @Date: 2019/12/19 11:43
 * @version : V1.0
 */
@RestController
@RequestMapping(value = "inner/sys/account", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class InnerSysAccountInfoController {
    @Autowired
    private SysAccountInfoService sysAccountInfoService;

    @Inner
    @ApiOperation(value = "依据账号查询账户详细信息", notes = "账户", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "/{username}")
    public RestResultVo<LoginAccountInfo> findAccountInfo(@PathVariable("username") String username) {
        LoginAccountInfo loginAccountInfo = sysAccountInfoService.findLoginAccountInfoByUsername(username);
        return new RestResultVo<LoginAccountInfo>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE, loginAccountInfo);
    }

    @Inner
    @ApiOperation(value = "依据账号查询账户信息", notes = "账户", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "/detail/{username}")
    public SysAccountInfo findAccountInfoDetail(@PathVariable("username") String username) {
        SysAccountInfo sysAccountInfo =
                sysAccountInfoService.detail(new SysAccountInfoQuery().setUsername(username));
        return sysAccountInfo;
    }

    @Inner
    @ApiOperation(value = "依据id查询账户信息", notes = "账户", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "/detailById/{id}")
    public SysAccountInfo findAccountInfoDetailById(@PathVariable("id") String id) {
        SysAccountInfo sysAccountInfo =
                sysAccountInfoService.detail(new SysAccountInfoQuery().setId(id));
        return sysAccountInfo;
    }
    
}
