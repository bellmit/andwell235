package com.andawell.search.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class XmlSearchMainQuery {
    @ApiModelProperty(value = "主键",name = "id",dataType = "String")
    private String id;
    @ApiModelProperty(value = "表名",name = "tableName",dataType = "String")
    private String tableName;
}
