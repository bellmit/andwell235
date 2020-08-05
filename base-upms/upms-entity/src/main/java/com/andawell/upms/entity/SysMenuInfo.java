package com.andawell.upms.entity;

import com.andawell.common.entity.dto.CommonEntityDto;
import com.andawell.upms.enumeration.SysDoor;
import com.andawell.upms.enumeration.SysMenuType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("菜单信息")
public class SysMenuInfo extends CommonEntityDto {
    @ApiModelProperty(name = "id", value = "id", dataType = "String")
    private String id;

    @ApiModelProperty(name = "name", value = "菜单名称", dataType = "String")
    private String name;

    @ApiModelProperty(name = "title", value = "菜单标题", dataType = "String")
    private String title;

    @ApiModelProperty(name = "permission", value = "菜单权限标识", dataType = "String")
    private String permission;

    @ApiModelProperty(name = "component", value = "组成", dataType = "String")
    private String component;

    @ApiModelProperty(name = "pid", value = "上级菜单ID", dataType = "String")
    private String pid;

    @ApiModelProperty(name = "path", value = "前端URL", dataType = "String")
    private String path;

    @ApiModelProperty(name = "icon", value = "图标", dataType = "String")
    private String icon;

    @ApiModelProperty(name = "sort", value = "排序", dataType = "Integer")
    private int sort;
    /**
     * 系统菜单类型
     */
    @ApiModelProperty(name = "type", value = "类型", dataType = "SysMenuType")
    private SysMenuType type;
    /**
     * 菜单对应的系统门户
     */
    @ApiModelProperty(name = "sysDoor", value = "菜单对应的门户类型", dataType = "SysDoor")
    private SysDoor sysDoor;


    private String status;


}
