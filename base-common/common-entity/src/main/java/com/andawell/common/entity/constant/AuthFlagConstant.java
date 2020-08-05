package com.andawell.common.entity.constant;

/***
 * @ClassName: 请求头常量
 * @Description:
 * @Auther: DCY
 * @Date: 2019/12/4 9:04
 * @version : V1.0
 */
public class AuthFlagConstant {

    /**
     * 权限标识
     * authFlag为true则为外部请求（gateway直接请求）
     * authFlag为false则为内部服务请求
     * authFlag为null则为非法请求
     */
    public final static String AUTH_FLAG_HEADER_NAME = "AuthFlag";
    public final static String AUTH_FLAG_TRUE = "true";
    public final static String AUTH_FLAG_FALSE = "false";
}
