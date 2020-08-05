package com.andawell.material.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Date： 2020/4/27 11:45
 */
@Data
@ApiModel("机型树结构信息")
public class AircaftModelTreelVO {
    @ApiModelProperty(name = "id", value = "id", dataType = "String")
    private String id;

    @ApiModelProperty(name = "mce", value = "机型英文名称", dataType = "String")
    private String mce;

    @ApiModelProperty(name = "mc", value = "机型中文名称", dataType = "String")
    private String mc;

    @ApiModelProperty(name = "jm", value = "机型简码", dataType = "String")
    private String jm;

    @ApiModelProperty(name = "pid", value = "父级id", dataType = "String")
    private String pid;

    @ApiModelProperty(name = "lb", value = "类别", dataType = "String")
    private String lb;

    @ApiModelProperty(name = "sl", value = "数量", dataType = "Integer")
    private Integer sl;

    @ApiModelProperty(name = "sgin", value = "序号指向", dataType = "Integer")
    private Integer sgin;

    @ApiModelProperty(name = "modeTreelVos", value = "子级", dataType = "List")
    private List<AircaftModelTreelVO> modeTreelVos;
}
