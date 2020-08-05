package com.andawell.upms.query;

import com.andawell.common.entity.dto.PageDto;
import com.andawell.upms.enumeration.AccountStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/***
 * @ClassName: UserInfoQuery
 * @Description:
 * @auther PC
 * @Date: 2019/12/17 17:06
 * @version : V1.0
 */
@Data
@Accessors(chain = true)
public class SysAccountInfoQuery extends PageDto {
    @ApiModelProperty(value = "ID", name = "id", dataType = "String")
    private String id;
    @ApiModelProperty(value = "按名称模糊查询", name = "nicknameLike", dataType = "String")
    private String nicknameLike;
    @ApiModelProperty(value = "按名称模糊查询", name = "nicknameLike", dataType = "String")
    private String nickname;
    @ApiModelProperty(value = "依据账号信息查询", name = "username", dataType = "String")
    private String username;
    @ApiModelProperty(value = "账户邮箱", name = "email", dataType = "String")
    private String email;
    @ApiModelProperty(value = "账户手机", name = "phoneNumber", dataType = "String")
    private String phoneNumber;
    @ApiModelProperty(value = "依据账号信息查询", name = "accountStatus", dataType = "AccountStatus")
    private AccountStatus accountStatus;
    @ApiModelProperty(value = "角色ID", name = "roleId", dataType = "String")
    private String roleId;
    @ApiModelProperty(value = "组织机构ID", name = "organId", dataType = "String")
    private String organId;
}
