package com.andawell.auth.constant;

import com.andawell.common.entity.constant.RestResultMessageConstant;

public class NoticeConstant extends RestResultMessageConstant {
    public static final String RESPONSE_ACCOUNT_USERNAME_ISNULL_MESSAGE = "账户账号为空";
    public static final String RESPONSE_ACCOUNT_NOT_EXIST_MESSAGE = "账户账号不存在";
    public static final String RESPONSE_ACCOUNT_PASSWORD_ISNULL_MESSAGE = "账户密码为空";
    public static final String RESPONSE_ACCOUNT_PASSWORD_ERROR_MESSAGE = "账户密码错误";
    public static final String RESPONSE_ACCOUNT_LOGIN_LOCATION_IS_OTHER_MESSAGE = "当前用户已在其他地方进行登陆,是否继续";
    public static final String RESPONSE_TOKEN_ISNULL_MESSAGE = "TOKEN为空";
    public static final String RESPONSE_TOKEN_IS_DISABLED_MESSAGE = "TOKEN失效";
}
