package com.andawell.search.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/***
 * @ClassName: XmlData
 * @Description:
 * @Auther: PC
 * @Date: 2020/4/30 9:14
 * @version : V1.0
 */
@Data
@XStreamAlias("table")
public class XmlTable {
    @XStreamAlias("tableInfo")
    private XmlTableInfo xmlTableInfo;
    @XStreamAlias("tableConfig")
    private XmlTableConfig xmlTableConfig;
}
