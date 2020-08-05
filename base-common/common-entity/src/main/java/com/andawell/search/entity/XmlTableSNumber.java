package com.andawell.search.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("xml中SNUMBER节点字段映射类")
@XStreamAlias("sNumber")
public class XmlTableSNumber{
    @ApiModelProperty(value = "居中方式", name = "align", dataType = "String")
    @XStreamAlias("align")
    private String align;
    @ApiModelProperty(value = "fixed", name = "fixed", dataType = "String")
    @XStreamAlias("fixed")
    private String fixed;
    @ApiModelProperty(value = "dataIndex", name = "dataIndex", dataType = "String")
    @XStreamAlias("dataIndex")
    private String dataIndex;
    @ApiModelProperty(value = "key", name = "key", dataType = "String")
    @XStreamAlias("key")
    private String key;
    @ApiModelProperty(value = "标题", name = "title", dataType = "String")
    @XStreamAlias("title")
    private String title;
    @ApiModelProperty(value = "宽度", name = "width", dataType = "String")
    @XStreamAlias("width")
    private String width;
    @ApiModelProperty(value = "是否显示", name = "show", dataType = "String")
    @XStreamAlias("show")
    private String show;

}

