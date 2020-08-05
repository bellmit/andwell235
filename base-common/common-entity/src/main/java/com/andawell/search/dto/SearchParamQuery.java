package com.andawell.search.dto;

import com.andawell.common.entity.dto.PageDto;
import com.andawell.search.query.CommonListQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class SearchParamQuery  {

    @ApiModelProperty(value = "xml的名称", name = "xmlName", dataType = "String")
    private String xmlName;

    @ApiModelProperty(value = "表的名称", name = "tableName", dataType = "String")
    private String tableName;

    @ApiModelProperty(value = "查询条件", name = "commonListQuery", dataType = "List")
    private List<CommonListQuery> commonListQuery;

    private final static int DEFAULT_SIZE = 10;

    @ApiModelProperty(value = "每页记录数", name = "pageSize", dataType = "int", example = "10")
    private int pageSize = DEFAULT_SIZE;

    @ApiModelProperty(value = "页序", name = "pageIndex", dataType = "int", example = "1")
    private int pageIndex = 1;

    @ApiModelProperty(value = "排序字段", name = "sortField", dataType = "String")
    private String sortField;

    @ApiModelProperty(value = "排序方式", name = "sortOrder", dataType = "String")
    private String sortOrder;

}
