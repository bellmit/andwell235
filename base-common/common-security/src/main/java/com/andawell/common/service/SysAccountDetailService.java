package com.andawell.common.service;

import com.andawell.upms.entity.SysAccountInfo;

import java.util.Map;

/**
 * @author DCY
 */
public interface SysAccountDetailService {
    public SysAccountInfo loadAccountByUsername(String username);

    public Map<String, Object> sysLogin(String username, String password, String grantType);
}
