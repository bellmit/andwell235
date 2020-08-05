package com.andawell.upms.service;

import com.andawell.upms.dto.LoginAccountInfo;
import com.andawell.upms.entity.SysAccountInfo;
import com.andawell.upms.query.SysAccountInfoQuery;

/**
 * @author DCY
 * 账户信息逻辑处理接口
 */

public interface SysAccountInfoService {

    public SysAccountInfo detail(SysAccountInfoQuery query);

    public LoginAccountInfo findLoginAccountInfoByUsername(String username);

}
