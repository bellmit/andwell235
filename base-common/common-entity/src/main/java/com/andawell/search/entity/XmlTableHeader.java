package com.andawell.search.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("xml中tableHeader节点字段映射类")
@XStreamAlias("tableHeader")
public class XmlTableHeader {

    @ApiModelProperty(value = "prop", name = "prop", dataType = "String")
    @XStreamAlias("prop")
    private String prop;

    @ApiModelProperty(value = "居中方式", name = "align", dataType = "String")
    @XStreamAlias("align")
    private String align;

    @ApiModelProperty(value = "列名", name = "label", dataType = "String")
    @XStreamAlias("label")
    private String label;

    @ApiModelProperty(value = "宽度", name = "width", dataType = "String")
    @XStreamAlias("width")
    private String width;

    @ApiModelProperty(value = "最小宽度", name = "minWidth", dataType = "String")
    @XStreamAlias("minWidth")
    private String minWidth;

    @ApiModelProperty(value = "是否过滤", name = "filters", dataType = "String")
    @XStreamAlias("filters")
    private Boolean filters;

    @ApiModelProperty(value = "是否固定列", name = "fixed", dataType = "String")
    @XStreamAlias("fixed")
    private Boolean fixed;

    @ApiModelProperty(value = "列是否排序", name = "sortable", dataType = "String")
    @XStreamAlias("sortable")
    private Boolean sortable;

    @ApiModelProperty(value = "表格是否编辑", name = "isEdit", dataType = "String")
    @XStreamAlias("isEdit")
    private Boolean isEdit;

    @ApiModelProperty(value = "表格编辑的类型", name = "editType", dataType = "String")
    @XStreamAlias("editType")
    private String editType;


    @ApiModelProperty(value = "是否显示", name = "show", dataType = "String")
    @XStreamAlias("show")
    private Boolean show;

    @ApiModelProperty(value = "查询条件", name = "condition", dataType = "String")
    @XStreamAlias("condition")
    private String condition;

    @ApiModelProperty(value = "字段类型", name = "fieldType", dataType = "String")
    @XStreamAlias("fieldType")
    private String fieldType;

    @ApiModelProperty(value = "是否存在父级表头", name = "parent", dataType = "String")
    @XStreamAlias("parent")
    private String parent;

    @ApiModelProperty(value = "是否为子查询条件", name = "isInner", dataType = "Boolean")
    @XStreamAlias("isInner")
    private Boolean isInner;

    @ApiModelProperty(value = "日期格式", name = "dateFormat", dataType = "String")
    @XStreamAlias("dateFormat")
    private String dateFormat;



}
