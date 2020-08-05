package com.andawell.upms.query;

import com.andawell.common.entity.dto.PageDto;
import com.andawell.upms.enumeration.RoleStatus;
import com.andawell.upms.enumeration.SysDoor;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/***
 * @ClassName: SysRoleInfo
 * @Description:
 * @Auther: PC
 * @Date: 2019/12/19 17:45
 * @version : V1.0
 */
@Data
@Accessors(chain = true)
public class SysRoleInfoQuery extends PageDto {
    private String id;
    @ApiModelProperty(value = "角色名称", name = "roleName", dataType = "String")
    private String roleName;
    @ApiModelProperty(value = "角色名称模糊搜索", name = "roleNameLike", dataType = "String")
    private String roleNameLike;
    @ApiModelProperty(value = "门户编号", name = "doorCode", dataType = "SysDoor")
    private SysDoor doorCode;
    @ApiModelProperty(value = "角色状态", name = "roleStatus", dataType = "RoleStatus")
    private RoleStatus roleStatus;


    @ApiModelProperty(value = "角色描述", name = "remark", dataType = "String")
    private String remark;
    @ApiModelProperty(value = "角色描述(模糊)", name = "remarkLike", dataType = "String")
    private String remarkLike;
}
