package com.andawell.search.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/***
 * @ClassName: XmlTableAction
 * @Description:
 * @Auther: PC
 * @Date: 2020/4/30 9:49
 * @version : V1.0
 */
@Data
@ToString
@XStreamAlias("action")
public class XmlTableAction {
    @ApiModelProperty(value = "fixed", name = "fixed", dataType = "String")
    @XStreamAlias("fixed")
    private String fixed;
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
