package com.andawell.upms.dto;

import com.andawell.upms.enumeration.AccountStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/***
 * @ClassName: SysAccountInfoDto
 * @Description:
 * @Auther: PC
 * @Date: 2019/12/19 17:26
 * @version : V1.0
 */
@Data
@ApiModel("账户信息新增")
public class SysAccountInfoDto {
    @ApiModelProperty(value = "ID", name = "id", dataType = "String")
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
    @ApiModelProperty(value = "组织机构ID", name = "organId", dataType = "String")
    private String organId;
    @ApiModelProperty(value = "角色ID", name = "roleId", dataType = "String")
    private String roleId;
    @ApiModelProperty(value = "门户编号", name = "doorCode", dataType = "String")
    private String doorCode;
}
