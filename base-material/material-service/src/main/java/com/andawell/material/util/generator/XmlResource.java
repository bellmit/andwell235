package com.andawell.material.util.generator;

import com.andawell.search.entity.XmlTable;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/***
 * @author lhb
 * @Date: 2020/5/13 12:57
 * @Description:
 * @version : V1.0
 */


@AllArgsConstructor
@NoArgsConstructor
@Data
@XStreamAlias("VIEWS")
public class XmlResource {

    @XStreamImplicit(itemFieldName = "VIEW")
    private List<View> columnList = new ArrayList<View>();
}

