package com.andawell.common.util;

import com.andawell.common.entity.BaseUser;
import com.andawell.common.entity.DateDeptPermission;
import com.andawell.common.entity.DateMatePermission;
import com.andawell.common.entity.DatePlanePermission;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;
import java.util.List;

public class SysUserUtils {
    /**
     * 获取Authentication
     */
    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取用户
     */
    public static BaseUser getUser(Authentication authentication) {
        Object principal = authentication.getPrincipal();
        if (principal instanceof BaseUser) {
            return (BaseUser) principal;
        }
        return null;
    }

    /**
     * 获取用户ID
     */
    public static String getUserId() {
        Authentication authentication = getAuthentication();
        if (authentication == null) {
            return null;
        }
        return getUser(authentication).getId();
    }

    /**
     * 获取用户名称
     */
    public static String getUserName() {
        Authentication authentication = getAuthentication();
        if (authentication == null) {
            return null;
        }
        return getUser(authentication).getName();
    }

    /**
     * 获取用户
     */
    public static BaseUser getUser() {
        Authentication authentication = getAuthentication();
        if (authentication == null) {
            return null;
        }
        return getUser(authentication);
    }

    /**
     * 获取用户名称
     *
     * @return username
     */
    public static String getUsername() {
        Authentication authentication = getAuthentication();
        if (authentication == null) {
            return null;
        }
        return authentication.getName();
    }

    /**
     * 获取用户名称
     *
     * @return username
     */
    public static Collection<? extends GrantedAuthority> getAuthorities() {
        Authentication authentication = getAuthentication();
        if (authentication == null) {
            return null;
        }
        return authentication.getAuthorities();
    }

    public static String dataMatePermission() {
        List<DateMatePermission> dateMatePermissionList = getUser().getDateMatePermission();
        String listString = "";
        if (dateMatePermissionList != null && dateMatePermissionList.size() > 0) {
            for (DateMatePermission dateMatePermission : dateMatePermissionList) {
                listString += "'" + dateMatePermission.getId() + "',";
            }
            if (listString.length() > 0) {
                listString = listString.substring(0, listString.length() - 1);
                listString = "(" + listString + ")";
            }
            System.out.println("航材类型数据权限" + listString);
        }
        return listString;
    }

    public static String dataPlanePermission() {
        List<DatePlanePermission> datePlanePermissionList = getUser().getDatePlanePermission();
        String listString = "";
        if (datePlanePermissionList != null && datePlanePermissionList.size() > 0) {
            for (DatePlanePermission datePlanePermission : datePlanePermissionList) {
                listString += "'" + datePlanePermission.getId() + "',";
            }
            if (listString.length() > 0) {
                listString = listString.substring(0, listString.length() - 1);
                listString = "(" + listString + ")";
            }
            System.out.println("飞机数据权限" + listString);
        }
        return listString;
    }

    public static String dataDeptPermission() {
        List<DateDeptPermission> dateDeptPermissionList = SysUserUtils.getUser().getDateDeptPermission();
        String listString = "";
        if (dateDeptPermissionList != null && dateDeptPermissionList.size() > 0) {
            for (DateDeptPermission dateDeptPermission : dateDeptPermissionList) {
                listString += "'" + dateDeptPermission.getId() + "',";
            }
            if (listString.length() > 0) {
                listString = listString.substring(0, listString.length() - 1);
                listString = "(" + listString + ")";
            }
            System.out.println("部门数据权限" + listString);
        }
        return listString;
    }


}
