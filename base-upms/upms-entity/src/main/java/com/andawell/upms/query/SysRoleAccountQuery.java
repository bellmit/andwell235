package com.andawell.upms.query;

import com.andawell.common.entity.dto.PageDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class SysRoleAccountQuery extends PageDto {
    private String accountId;
    private String roleId;
}
