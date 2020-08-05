package com.andawell.upms.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/***
 * @ClassName: SysAccountInfoDto
 * @Description:
 * @author DCY
 * @Date: 2019/12/19 17:26
 * @version : V1.0
 */
@Data
@ApiModel("权限信息新增接口")
public class SysAuthInfoDto {

    @ApiModelProperty(value = "ID", name = "id", dataType = "String")
    private String id;

    @ApiModelProperty(value = "功能菜单权限", name = "menuPermissions", dataType = "List")
    private List<CommonAuthInfo> menuPermissions;

    @ApiModelProperty(value = "APP端功能权限菜单", name = "appPermissions", dataType = "List")
    private List<CommonAuthInfo> appPermissions;

    @ApiModelProperty(value = "组织机构数据权限", name = "organDataPermissions", dataType = "List")
    private List<CommonAuthInfo> organDataPermissions;
}
