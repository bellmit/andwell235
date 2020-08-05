package com.andawell.upms.query;

import com.andawell.common.entity.dto.PageDto;
import com.andawell.upms.enumeration.SysDoor;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author DCY
 */
@Data
@ApiModel("角色信息查询条件")
@Accessors(chain = true)
public class SysMenuInfoQuery extends PageDto {
    @ApiModelProperty(name = "id", value = "id", dataType = "String")
    private String id;
    @ApiModelProperty(name = "name", value = "菜单名称", dataType = "String")
    private String name;
    @ApiModelProperty(name = "permission", value = "菜单权限标识", dataType = "String")
    private String permission;
    @ApiModelProperty(name = "pid", value = "父级ID", dataType = "String")
    private String pid;
    @ApiModelProperty(name = "path", value = "前端URL", dataType = "String")
    private String path;
    @ApiModelProperty(name = "icon", value = "图标", dataType = "String")
    private String icon;
    @ApiModelProperty(name = "component", value = "页面", dataType = "String")
    private String component;
    @ApiModelProperty(name = "sort", value = "排序", dataType = "Integer")
    private int sort;
    @ApiModelProperty(name = "type", value = "类型", dataType = "String")
    private String type;
    @ApiModelProperty(name = "sysDoor", value = "类型", dataType = "SysDoor")
    private SysDoor sysDoor;
}
