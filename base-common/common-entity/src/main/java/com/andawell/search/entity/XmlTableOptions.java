package com.andawell.search.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/***
 * @ClassName: XmlTableProps
 * @Description:
 * @Auther: PC
 * @Date: 2020/4/30 9:37
 * @version : V1.0
 */
@Data
@XStreamAlias("tableOptions")
public class XmlTableOptions {
    @ApiModelProperty(value = "表格展示名称", name = "modelName", dataType = "String")
    @XStreamAlias("modelName")
    private String modelName;

    @ApiModelProperty(value = "表格类型", name = "type", dataType = "String")
    @XStreamAlias("type")
    private String type;
    //    @ApiModelProperty(value = "表格唯一ID_对应数据库表格名称", name = "itemId", dataType = "String")
    //    @XStreamAlias("itemId")
    //    private String itemId;
    @ApiModelProperty(value = "表格下标", name = "index", dataType = "String")
    @XStreamAlias("index")
    private Boolean index;

    @ApiModelProperty(value = "复选框", name = "mutiSelect", dataType = "String")
    @XStreamAlias("mutiSelect")
    private Boolean mutiSelect;

    @ApiModelProperty(value = "初始化表格", name = "initTable", dataType = "String")
    @XStreamAlias("initTable")
    private Boolean initTable;

    @ApiModelProperty(value = "开启分页", name = "pagination", dataType = "String")
    @XStreamAlias("pagination")
    private Boolean pagination;

    @ApiModelProperty(value = "开启边框", name = "border", dataType = "String")
    @XStreamAlias("border")
    private Boolean border;

    @ApiModelProperty(value = "开启表格条纹", name = "stripe", dataType = "String")
    @XStreamAlias("stripe")
    private Boolean stripe;

    @ApiModelProperty(value = "开启加载", name = "loading", dataType = "String")
    @XStreamAlias("loading")
    private Boolean loading;

    @ApiModelProperty(value = "表格高度", name = "height", dataType = "Integer")
    @XStreamAlias("height")
    private String height;
}
