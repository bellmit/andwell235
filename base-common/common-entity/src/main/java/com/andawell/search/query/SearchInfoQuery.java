package com.andawell.search.query;

import com.andawell.common.entity.dto.PageDto;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 *
 */
@Data
@Accessors(chain = true)
public class SearchInfoQuery extends PageDto {
    private String sql;
}
