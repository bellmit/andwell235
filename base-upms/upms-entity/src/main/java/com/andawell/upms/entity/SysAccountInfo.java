package com.andawell.upms.entity;

import com.andawell.common.entity.dto.CommonEntityDto;
import com.andawell.upms.enumeration.AccountStatus;
import com.andawell.upms.enumeration.SysDoor;
import io.swagger.annotations.ApiModel;
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
@ApiModel("账户信息")
public class SysAccountInfo extends CommonEntityDto {
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
    @ApiModelProperty(value = "账户状态", name = "accountStatus", dataType = "AccountStatus")
    private AccountStatus accountStatus;
    @ApiModelProperty(value = "最近的登陆时间", name = "lastLoginTime", dataType = "Date")
    private Date lastLoginTime;
    @ApiModelProperty(value = "最近的登陆IP", name = "lastLoginIp", dataType = "String")
    private String lastLoginIp;


    @ApiModelProperty(value = "组织机构ID", name = "organId", dataType = "String")
    private String organId;
    @ApiModelProperty(value = "组织机构名称", name = "organName", dataType = "String")
    private String organName;
    @ApiModelProperty(value = "角色ID", name = "roleId", dataType = "String")
    private String roleId;
    @ApiModelProperty(value = "角色名称", name = "roleName", dataType = "String")
    private String roleName;
    @ApiModelProperty(value = "门户编号", name = "doorCode", dataType = "String")
    private SysDoor doorCode;


}
