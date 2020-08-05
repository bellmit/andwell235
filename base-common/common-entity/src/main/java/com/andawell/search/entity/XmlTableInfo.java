package com.andawell.search.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/***
 * @ClassName: XmlTableFrom
 * @Description:
 * @Auther: PC
 * @Date: 2020/4/30 9:17
 * @version : V1.0
 */
@Data
@XStreamAlias("tableInfo")
public class XmlTableInfo {
    /**
     * 表标题
     */
    @XStreamAlias("caption")
    private String caption;
    /**
     * 表名称
     */
    @XStreamAlias("tableName")
    private String tableName;
    /**
     * 表的SQL信息
     */
    @XStreamAlias("sql")
    private String sql;
}
