package com.andawell.search.query;

import com.andawell.search.enumeration.SearchConditionEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CommonListQuery {

    @ApiModelProperty(value = "字段名称", name = "name", dataType = "String")
    private String name;

    @ApiModelProperty(value = "字段值", name = "value", dataType = "Object")
    private Object value;

    @ApiModelProperty(value = "字段类型", name = "type", dataType = "String")
    private String type;

    @ApiModelProperty(value = "字段的查询条件", name = "condition", dataType = "SearchConditionEnum")
    private SearchConditionEnum condition;


}
