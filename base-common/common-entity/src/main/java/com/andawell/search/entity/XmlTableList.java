package com.andawell.search.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@XStreamAlias("tableList")
public class XmlTableList {
    @XStreamImplicit(itemFieldName = "table")
    private List<XmlTable> xmlTable;

    @XStreamAsAttribute
    private String describe;

    @XStreamAsAttribute
    private String xmlName;
}
