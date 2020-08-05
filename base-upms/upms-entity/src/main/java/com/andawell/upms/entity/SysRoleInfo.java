package com.andawell.upms.entity;

import com.andawell.common.entity.dto.CommonEntityDto;
import com.andawell.upms.enumeration.RoleStatus;
import com.andawell.upms.enumeration.SysDoor;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/***
 * @ClassName: SysOrganInfo
 * @Description:
 * @Auther: PC
 * @Date: 2019/12/19 17:45
 * @version : V1.0
 */
@Data
@ApiModel("系统角色信息")
public class SysRoleInfo extends CommonEntityDto {
    private String id;
    @ApiModelProperty(value = "角色名称", name = "roleName", dataType = "String")
    private String roleName;
    @ApiModelProperty(value = "门户编码", name = "doorCode", dataType = "SysDoor")
    private SysDoor doorCode;

    @ApiModelProperty(value = "角色状态", name = "roleStatus", dataType = "RoleStatus")
    private RoleStatus roleStatus;
    @ApiModelProperty(value = "角色描述", name = "remark", dataType = "String")
    private String remark;
}
