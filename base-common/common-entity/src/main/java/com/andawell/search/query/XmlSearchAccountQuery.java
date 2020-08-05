package com.andawell.search.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class XmlSearchAccountQuery {
    @ApiModelProperty(value = "主键",name = "id",dataType = "String")
    private String id;
    @ApiModelProperty(value = "所属的主XML",name = "mainId",dataType = "String")
    private String mainId;
    @ApiModelProperty(value = "表名",name = "tableName",dataType = "String")
    private String tableName;
    @ApiModelProperty(value = "所属账户ID",name = "accountId",dataType = "String")
    private String accountId;
}
