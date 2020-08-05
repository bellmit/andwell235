package com.andawell.upms.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class SysRoleAccount implements Serializable {
    private static final long serialVersionUID = 1L;
    private String accountId;
    private String roleId;
}
