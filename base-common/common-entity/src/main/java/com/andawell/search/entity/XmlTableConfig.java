package com.andawell.search.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/***
 * @ClassName: XmlTableHeaders
 * @Description:
 * @Auther: PC
 * @Date: 2020/4/30 9:32
 * @version : V1.0
 */
@Data
@XStreamAlias("tableConfig")
public class XmlTableConfig {
//    @XStreamAlias("tableOptions")
//    private XmlTableOptions tableOptions;
    @XStreamAlias("tableColumns")
    private XmlTableColumns tableColumns;

}
