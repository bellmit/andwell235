package com.andawell.common.entity;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @author dcy
 * @date 2019/4/22
 * 扩展用户信息
 */
public class BaseUser extends User {
    private static final long serialVersionUID = 3715937523216717269L;
    @Getter
    private String id;
    @Getter
    private String deptId;
    @Getter
    private String deptName;

    @Getter
    private String roleId;
    @Getter
    private String doorId;
    @Getter
    private String name;
    @Getter
    private Set<String> permission;
    @Getter
    private DefaultInventory defaultInventory;
    @Getter
    private DefaultInventory defaultUsableInventory;
    @Getter
    private DefaultInventory defaultRepairInventory;
    @Getter
    private DefaultInventory defaultScrapInventory;
    @Getter
    private List<MenuAppPermission> menuAppPermission;
    @Getter
    private List<DateDeptPermission> dateDeptPermission;
    @Getter
    private List<DatePlanePermission> datePlanePermission;
    @Getter
    private List<DateMatePermission> dateMatePermission;

    public BaseUser(String id, String deptId,String deptName,String roleId, String name, String doorId, Set<String> permission,

                    DefaultInventory defaultInventory,
                    DefaultInventory defaultUsableInventory,
                    DefaultInventory defaultRepairInventory,
                    DefaultInventory defaultScrapInventory,
                    List<MenuAppPermission> menuAppPermission,
                    List<DateDeptPermission> dateDeptPermission,
                    List<DatePlanePermission> datePlanePermission,
                    List<DateMatePermission> dateMatePermission,

                    String username, String password,
                    boolean enabled,
                    boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.permission = permission;
        this.id = id;
        this.deptId = deptId;
        this.deptName = deptName;
        this.roleId = roleId;
        this.name = name;
        this.doorId = doorId;
        this.defaultInventory = defaultInventory;
        this.defaultUsableInventory = defaultUsableInventory;
        this.defaultRepairInventory = defaultRepairInventory;
        this.defaultScrapInventory = defaultScrapInventory;
        this.menuAppPermission = menuAppPermission;
        this.dateDeptPermission = dateDeptPermission;
        this.datePlanePermission = datePlanePermission;
        this.dateMatePermission = dateMatePermission;


    }


    public BaseUser(String id, String deptId,String deptName,String roleId, String name, String doorCode, Set<String> permission,
                    String username, String password,
                    boolean enabled,
                    boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.permission = permission;
        this.id = id;
        this.deptId = deptId;
        this.deptName = deptName;
        this.roleId = roleId;
        this.name = name;
        this.doorId = doorCode;

    }


}
