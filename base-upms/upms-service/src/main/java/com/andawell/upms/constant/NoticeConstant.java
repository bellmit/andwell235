package com.andawell.upms.constant;

import com.andawell.common.entity.constant.RestResultMessageConstant;

/**
 * @author DCY
 */
public class NoticeConstant extends RestResultMessageConstant {
    public static final String RESPONSE_NOTFOUND_MESSAGE = "未找到该记录";
    public static final String RESPONSE_ORGAN_BAN_DELETE_MESSAGE = "当前组织机构下存在账户信息，禁止删除";
    public static final String RESPONSE_ROLE_BAN_DELETE_MESSAGE = "当前角色下存在账户信息，禁止删除";
    public static final String RESPONSE_ROLE_AUTH_ADD_SUCCESS_MESSAGE = "角色权限分配成功";
    public static final String RESPONSE_ROLE_AUTH_ADD_ERROR_MESSAGE = "角色权限分配失败";
    public static final String RESPONSE_LOGIN_PASSWORD_MESSAGE = "登录密码不能为空";
    public static final String RESPONSE_ACCOUNT_AUTH_ADD_SUCCESS_MESSAGE = "人员权限分配成功";
    public static final String RESPONSE_ACCOUNT_AUTH_ADD_ERROR_MESSAGE = "人员权限分配失败";

    public static final String RESPONSE_CONTEXT_ERROR_MESSAGE = "传入对象缺失";
    public static final String RESPONSE_CHILDREN_NOTNULL_MESSAGE = "子级不为空，不能删除";
    public static final String RESPONSE_CK_NOTNULL_MESSAGE = "仓库不为空，不能删除";
    public static final String RESPONSE_ZD_NOTNULL_MESSAGE = "中队不为空，不能删除";
    public static final String RESPONSE_ZDFJ_NOTNULL_MESSAGE = "飞机不为空，不能删除";
    public static final String RESPONSE_COLUMNS_ERROR_MESSAGE = "字段不符合约束条件";
    public static final String RESPONSE_NAME_REPEAT_MESSAGE = "名称已存在，请重新命名";
}
