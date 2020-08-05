package com.andawell.upms.vo;

import com.andawell.common.entity.dto.CommonEntityDto;
import com.andawell.upms.entity.SysOrganInfo;
import com.andawell.upms.entity.SysRoleInfo;
import com.andawell.upms.enumeration.AccountStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/***
 * @Description: 账户信息实体类
 * @author DCY
 * @Date: 2019/12/17 16:07
 * @version : V1.0
 */
@Data
public class SysAccountInfoVo extends CommonEntityDto {
    private String id;
    @ApiModelProperty(value = "昵称", name = "nickname", dataType = "String")
    private String nickname;
    @ApiModelProperty(value = "账号", name = "username", dataType = "String")
    private String username;
    @ApiModelProperty(value = "密码", name = "password", dataType = "String")
    private String password;
    @ApiModelProperty(value = "邮箱", name = "email", dataType = "String")
    private String email;
    @ApiModelProperty(value = "手机号", name = "phoneNumber", dataType = "String")
    private String phoneNumber;
    @ApiModelProperty(value = "账户状态", name = "phoneNumber", dataType = "String")
    private AccountStatus accountStatus;
    @ApiModelProperty(value = "最近的登陆时间", name = "lastLoginTime", dataType = "Date")
    private Date lastLoginTime;
    @ApiModelProperty(value = "最近的登陆IP", name = "lastLoginIp", dataType = "String")
    private String lastLoginIp;

    private SysOrganInfo sysOrganInfo;

    private SysRoleInfo sysRoleInfo;

    private String doorCode;

}
