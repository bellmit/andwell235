package com.andawell.common.service.impl;

import com.andawell.common.service.CommonAccountInfoService;
import com.andawell.upms.entity.SysAccountInfo;
import com.andawell.upms.feign.RemoteAccountService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author DCY
 */
@Service("commonAccountInfoService")
public class CommonAccountInfoServiceImpl implements CommonAccountInfoService {
    //远程获取用户信息
    @Autowired
    private RemoteAccountService remoteAccountService;

    @Override
    public String getAccountInfo(String accountId) {
        if (StringUtils.isEmpty(accountId)) {
            return null;
        }
        SysAccountInfo sysAccountInfo = remoteAccountService.findAccountInfoDetailById(accountId);
        if (sysAccountInfo == null || StringUtils.isEmpty(sysAccountInfo.getId())) {
            return null;
        }
        return sysAccountInfo.getNickname();
    }
}
