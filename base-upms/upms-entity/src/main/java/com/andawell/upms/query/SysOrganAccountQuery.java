package com.andawell.upms.query;

import com.andawell.common.entity.dto.PageDto;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SysOrganAccountQuery extends PageDto {
    private String accountId;
    private String organId;
}
