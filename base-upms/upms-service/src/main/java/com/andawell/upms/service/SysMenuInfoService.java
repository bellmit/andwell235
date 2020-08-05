package com.andawell.upms.service;

import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.upms.entity.SysMenuInfo;
import com.andawell.upms.query.SysMenuInfoQuery;
import com.andawell.upms.vo.MenuTreeVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface SysMenuInfoService {

    public ListPageVo<SysMenuInfoQuery, SysMenuInfo> listPage(SysMenuInfoQuery dto);

    public List<SysMenuInfo> list(SysMenuInfoQuery query);

    public long count(SysMenuInfoQuery query);

    public SysMenuInfo detail(SysMenuInfoQuery query);

    public void insert(SysMenuInfo menuInfo);

    public void update(SysMenuInfo menuInfo);

    public void delete(SysMenuInfo menuInfo);

//    public List<MenuTreeVo> listTableMenusByRoleId(String roleId, String type);
//
//    public List<String> listPermissionsByRoleIds(String roleId);
//
    public List<SysMenuInfo> listMenusByRoleIds(String roleId);
//
//    public List<String> listPermissionsByAccountId(String accountId);
//
//    public List<MenuTreeVo> listMenusByAccountId(String accountId);
//
//    public List<SysMenuInfo> listMenuByAccountId(String accountId);


}
