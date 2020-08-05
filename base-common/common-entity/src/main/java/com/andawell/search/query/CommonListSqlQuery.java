package com.andawell.search.query;

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class CommonListSqlQuery extends PageDto {
    @ApiModelProperty(value = "sql", name = "sql", dataType = "String")
    private String sql;

    private List<CommonListQuery> commonListQuery;

}
