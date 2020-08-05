package com.andawell.upms.service.impl;

import com.andawell.common.entity.search.CountCommon;
import com.andawell.common.entity.search.DetailCommon;
import com.andawell.common.entity.search.ListCommon;
import com.andawell.common.entity.search.ListPageCommon;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.upms.entity.SysMenuInfo;
import com.andawell.upms.mapper.SysMenuInfoMapper;
import com.andawell.upms.query.SysMenuInfoQuery;
import com.andawell.upms.service.SysMenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/***
 * @ClassName: SysSysMenuInfoService
 * @Description:
 * @Auther: PC
 * @Date: 2020/1/2 17:20
 * @version : V1.0
 */
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
@Service("sysMenuInfoService")
public class SysMenuInfoServiceImpl implements SysMenuInfoService {
    @Autowired
    private SysMenuInfoMapper sysMenuInfoMapper;

    @Override
    public ListPageVo<SysMenuInfoQuery, SysMenuInfo> listPage(SysMenuInfoQuery dto) {
        return new ListPageCommon<SysMenuInfoQuery, SysMenuInfo>(dto, (q) -> sysMenuInfoMapper.list(q)).getVo();
    }

    @Override
    public List<SysMenuInfo> list(SysMenuInfoQuery query) {
        return new ListCommon<SysMenuInfoQuery, SysMenuInfo>(query, (q) -> sysMenuInfoMapper.list(q)).get();
    }

    @Override
    public long count(SysMenuInfoQuery query) {
        return new CountCommon<SysMenuInfoQuery, SysMenuInfo>(query, (q) -> sysMenuInfoMapper.list(q)).get();
    }

    @Override
    public SysMenuInfo detail(SysMenuInfoQuery query) {
        return new DetailCommon<SysMenuInfoQuery, SysMenuInfo>(query, (q) -> sysMenuInfoMapper.list(q)).get();
    }

    @Override
    public void insert(SysMenuInfo menuInfo) {
        sysMenuInfoMapper.insert(menuInfo);
    }

    @Override
    public void update(SysMenuInfo menuInfo) {
        sysMenuInfoMapper.update(menuInfo);
    }

    @Override
    public void delete(SysMenuInfo menuInfo) {
        sysMenuInfoMapper.delete(menuInfo);

        //同时删除人员及角色对应的菜单权限信息
    }

//    @Override
//    public List<MenuTreeVo> listTableMenusByRoleId(String roleId, String type) {
//        return sysMenuInfoMapper.listTableMenusByRoleId(roleId, type);
//    }
//
//    @Override
//    public List<String> listPermissionsByRoleIds(String roleId) {
//        return sysMenuInfoMapper.listPermissionsByRoleIds(roleId);
//    }
//
    @Override
    public List<SysMenuInfo> listMenusByRoleIds(String roleId) {
        return sysMenuInfoMapper.listMenusByRoleIds(roleId);
    }
//
//    @Override
//    public List<String> listPermissionsByAccountId(String accountId) {
//        return sysMenuInfoMapper.listPermissionsByAccountId(accountId);
//    }
//
//    @Override
//    public List<MenuTreeVo> listMenusByAccountId(String accountId) {
//        return sysMenuInfoMapper.listMenusByAccountId(accountId);
//    }
//
//    @Override
//    public List<SysMenuInfo> listMenuByAccountId(String accountId) {
//        return sysMenuInfoMapper.listMenuByAccountId(accountId);
//    }
}
