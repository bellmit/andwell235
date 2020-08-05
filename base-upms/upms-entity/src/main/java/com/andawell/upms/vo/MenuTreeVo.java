package com.andawell.upms.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("菜单树信息")
public class MenuTreeVo {
    @ApiModelProperty(name = "id", value = "id", dataType = "String")
    private String id;
    @ApiModelProperty(name = "name", value = "菜单名称", dataType = "String")
    private String name;
    @ApiModelProperty(name = "pid", value = "父级ID", dataType = "String")
    private String pid;

    /**
     * 左侧菜单栏所需字段
     */
    /**
     * 图标
     */
    private String icon;
    /**
     * 页面跳转
     */
    private String jump;

    /**
     * 子级
     */
    private List<MenuTreeVo> children;
}
