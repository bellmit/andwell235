package com.andawell.search.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.Data;

import java.util.List;

/***
 * @ClassName: XmlTableColumns
 * @Description:
 * @Auther: PC
 * @Date: 2020/4/30 9:48
 * @version : V1.0
 */
@Data
@XStreamAlias("tableColumns")
public class XmlTableColumns {
    //    @XStreamAlias("SNUMBER")
//    private XmlTableSNumber xmlTableSNumber;

    @XStreamImplicit(itemFieldName = "tableHeader")
    private List<XmlTableHeader> columns;
    
    @XStreamAlias("tableOptions")
    private XmlTableOptions options;


//    @XStreamAlias("ACTION")
//    private XmlTableAction xmlTableAction;
}
