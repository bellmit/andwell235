package com.andawell.material.util.generator;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/***
 * @author lhb
 * @Date: 2020/5/13 8:53
 * @Description:
 * @version : V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XStreamAlias("VIEW")
public class ResourceXml {


    @XStreamAsAttribute
    private String SQL;

    @XStreamAsAttribute
    private String NAME;

    @XStreamImplicit(itemFieldName = "COLUMN")
    private List<Column> columnList = new ArrayList<Column>();

    @Override
    public String toString() {
        return "ResourceXml{" +
                "SQL='" + SQL + '\'' +
                ", NAME='" + NAME + '\'' +
                ", columnList=" + columnList +
                '}';
    }
}
