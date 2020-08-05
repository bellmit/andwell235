package com.andawell.upms.dto;

import com.andawell.upms.entity.SysAccountInfo;
import lombok.Data;

import java.io.Serializable;

@Data
public class LoginAccountInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 用户的基本信息
     */
    private SysAccountInfo sysAccountInfo;
    /**
     * 权限集合
     */
    private String[] permissions;
    /**
     * 角色集合
     */
    private String[] roles;
    /**
     * 组织机构信息
     */
    private String[] organs;


}
