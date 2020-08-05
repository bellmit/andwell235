package com.andawell.material.util.generator;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * @author lhb
 * @Date: 2020/5/13 9:03
 * @Description:
 * @version : V1.0
 */
@XStreamAlias("COLUMN")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Column {

    @XStreamAsAttribute
    private String CAPTION;

    @XStreamAsAttribute
    private String FIELD;

    @XStreamAsAttribute
    private String SHOW;

    @Override
    public String toString() {
        return "Column{" +
                "CAPTION='" + CAPTION + '\'' +
                ", FIELD='" + FIELD + '\'' +
                ", SHOW='" + SHOW + '\'' +
                '}';
    }
}
