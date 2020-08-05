package com.andawell.common.log.util;

import cn.hutool.core.util.URLUtil;
import com.andawell.common.entity.constant.AuthFlagConstant;
import com.andawell.common.util.SysUserUtils;
import com.andawell.upms.entity.LogInfo;
import lombok.experimental.UtilityClass;
import org.checkerframework.checker.signedness.qual.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * 系统日志工具类
 *
 * @author DCY
 */
@UtilityClass
public class SysLogUtils {
    //private static final Logger logger = LoggerFactory.getLogger(SysLogUtils.class);

    public void getSysLogInfo(LogInfo logInfo) {
        HttpServletRequest request = ((ServletRequestAttributes) Objects
                .requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        logInfo.setUsername(Objects.requireNonNull(SysUserUtils.getUsername()));
        logInfo.setName(SysUserUtils.getUser().getName());
        logInfo.setIp(WebUtils.getIpAddr(request));
        logInfo.setRequestUri(URLUtil.getPath(request.getRequestURI()));
        String authFlag = request.getHeader(AuthFlagConstant.AUTH_FLAG_HEADER_NAME);
        logInfo.setAuthFlag(authFlag);
        logInfo.setMethod(request.getMethod());
    }

}
