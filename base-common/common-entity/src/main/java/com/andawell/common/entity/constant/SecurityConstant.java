package com.andawell.common.entity.constant;

/**
 * @author dcy
 * @date 2019/4/23
 */
public class SecurityConstant {
    /**
     * OAUTH URL   认证路径
     */
    public static final String OAUTH_TOKEN_URL = "/oauth/token";
    /**
     * 自定义登陆接口信息
     */
    public static final String LOGIN_URL = "/cas/login/system/info";
    /**
     * 刷新token
     */
    public static final String REFRESH_TOKEN = "refresh_token";
    /**
     * 刷新token
     */
    public static final String PASSWORD_TOKEN = "password";
    /**
     * 项目的认证许可
     */
    public static final String ANDAWELL_LICENSE = "made by andawell";

    /**
     * 用户ID字段
     */
    public static final String DETAILS_USER_ID = "userId";
    /**
     * 角色ID
     */
    public static final String DETAILS_ROLE_ID = "roleId";
    /**
     * 账号
     */
    public static final String DETAILS_USERNAME = "username";
    /**
     * 名称
     */
    public static final String DETAILS_NAME = "name";
    /**
     * 名称
     */
    public static final String DETAILS_PERMISSION = "permission";
    /**
     * 默认存储地
     */
    public static final String DETAILS_DEFAULT_INVENTORY = "defaultInventory";
    /**
     * 默认可用库
     */
    public static final String DETAILS_DEFAULT_USABLE_INVENTORY = "defaultUsableInventory";
    /**
     * 默认待修库
     */
    public static final String DETAILS_DEFAULT_REPAIR_INVENTORY = "defaultRepairInventory";
    /**
     * 默认报废库
     */
    public static final String DETAILS_DEFAULT_SCRAP_INVENTORY = "defaultScrapInventory";
    /**
     * 菜单权限
     */
    public static final String DETAILS_MENUAPPPERMISSION = "menuAppPermission";
    /**
     * 部门数据权限
     */
    public static final String DETAILS_DATEDEPTPERMESSION = "dateDeptPermission";

    /**
     * 飞机数据权限
     */
    public static final String DETAILS_DATEPLANEPERMISSION = "datePlanePermission";
    /**
     * 航材数据权限
     */

    public static final String DETAILS_DATEMATEPERMISSION = "dateMatePermission";

    /**
     * 用户部门字段
     */
    public static final String DETAILS_DEPT_ID = "deptId";
    /**
     * 用户所在部门名称
     */
    public static final String DETAILS_DEPT_NAME = "deptName";
    /**
     * 用户部门字段
     */
    public static final String DETAILS_DOOR_ID = "doorId";

    /**
     * 协议字段
     */
    public static final String DETAILS_LICENSE = "license";
    /**
     * 角色前缀
     */
    public static final String ROLE = "ROLE_";

    /**
     * 正常
     */
    public static final String STATUS_NORMAL = "usable";

    /**
     * 禁用
     */
    public static final String STATUS_LOCK = "unusable";
    /**
     * 资源服务器默认bean名称
     */
    public static final String RESOURCE_SERVER_CONFIGURER = "resourceServerConfigurerAdapter";
    /**
     * oauth 客户端信息
     */
    public static final String CLIENT_DETAILS_KEY = "base_oauth_client_details";
    /**
     * sys_oauth_client_details 表的字段，不包括client_id、client_secret
     */
    public static final String CLIENT_FIELDS = "client_id, CONCAT('{noop}',client_secret) as client_secret, " +
            "resource_ids, scope, "
            + "authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, "
            + "refresh_token_validity, additional_information, autoapprove";
    /**
     * JdbcClientDetailsService 查询语句
     */
    public static final String BASE_FIND_STATEMENT = "select " + CLIENT_FIELDS
            + " from sys_oauth_client_details";

    /**
     * 默认的查询语句
     */
    public static final String DEFAULT_FIND_STATEMENT = BASE_FIND_STATEMENT + " order by client_id";
    /**
     * 按条件client_id 查询
     */
    public static final String DEFAULT_SELECT_STATEMENT = BASE_FIND_STATEMENT + " where client_id = ?";


    public static final String CAPTCHA_CODE_TIME = "codeTime";
    public static final String CAPTCHA_STRING_ENSURE = "strEnsure";
    /**
     * 客户端模式
     */
    public static final String CLIENT_CREDENTIALS = "client_credentials";
    /**
     * {bcrypt} 加密的特征码
     */
    public static final String BCRYPT = "{bcrypt}";
}
