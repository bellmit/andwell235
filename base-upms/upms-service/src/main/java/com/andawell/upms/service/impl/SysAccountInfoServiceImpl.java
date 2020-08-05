package com.andawell.upms.service.impl;

import cn.hutool.core.util.ArrayUtil;
import com.andawell.common.entity.search.CountCommon;
import com.andawell.common.entity.search.DetailCommon;
import com.andawell.common.entity.search.ListCommon;
import com.andawell.common.entity.search.ListPageCommon;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.common.util.SysUserUtils;
import com.andawell.upms.constant.NoticeConstant;
import com.andawell.upms.dto.CommonAuthInfo;
import com.andawell.upms.dto.LoginAccountInfo;
import com.andawell.upms.dto.SysAccountInfoDto;
import com.andawell.upms.dto.SysAuthInfoDto;
import com.andawell.upms.entity.*;
import com.andawell.upms.mapper.SysAccountInfoMapper;
import com.andawell.upms.query.*;
import com.andawell.upms.service.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author DCY
 * 账户信息查询接口
 */
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
@Service
public class SysAccountInfoServiceImpl implements SysAccountInfoService {
    @Autowired
    private SysAccountInfoMapper sysAccountInfoMapper;

    /**
     * 账户信息详细信息查询
     *
     * @param query
     * @return
     */
    @Override
    public SysAccountInfo detail(SysAccountInfoQuery query) {
        return new DetailCommon<SysAccountInfoQuery, SysAccountInfo>(query, (q) -> sysAccountInfoMapper.list(q)).get();
    }

    @Override
    public LoginAccountInfo findLoginAccountInfoByUsername(String username) {
        LoginAccountInfo loginAccountInfo = new LoginAccountInfo();
        SysAccountInfo sysAccountInfo = detail(new SysAccountInfoQuery().setUsername(username));
        if (sysAccountInfo != null && StringUtils.isNotEmpty(sysAccountInfo.getId())) {
            loginAccountInfo.setSysAccountInfo(sysAccountInfo);
            String accountId = sysAccountInfo.getId();
            /**
             * 获取人员及角色拥有的权限信息
             */
            Set<String> permissions = new HashSet<>();
//            List<String> roleIds =
//                    sysRoleAccountService.list(new SysRoleAccountQuery().setAccountId(accountId))
//                            .stream()
//                            .map(SysRoleAccount::getRoleId)
//                            .collect(Collectors.toList());
            /**
             * 添加角色信息
             */
            List<String> roleIds = new ArrayList<>();
            roleIds.add(sysAccountInfo.getRoleId());
            loginAccountInfo.setRoles((ArrayUtil.toArray(roleIds, String.class)));
            /**
             * 配置后端功能接口权限
             */
            permissions.add("root");
            loginAccountInfo.setPermissions(ArrayUtil.toArray(permissions, String.class));
            /**
             * 获取组织机构信息
             */
//            List<String> organIds = sysOrganAccountService.list(new SysOrganAccountQuery().setAccountId(accountId))
//                    .stream()
//                    .map(SysOrganAccount::getOrganId)
//                    .collect(Collectors.toList());
            List<String> organIds = new ArrayList<>();
            organIds.add(sysAccountInfo.getOrganId());
            loginAccountInfo.setOrgans(ArrayUtil.toArray(organIds, String.class));
        }
        return loginAccountInfo;
    }


}