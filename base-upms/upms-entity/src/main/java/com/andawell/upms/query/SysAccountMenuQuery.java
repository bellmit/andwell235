package com.andawell.upms.query;

import com.andawell.common.entity.dto.PageDto;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SysAccountMenuQuery extends PageDto {
    private String menuId;
    private String accountId;
}
