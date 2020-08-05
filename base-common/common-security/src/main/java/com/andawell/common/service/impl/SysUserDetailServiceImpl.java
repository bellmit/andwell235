package com.andawell.common.service.impl;

import com.andawell.common.entity.BaseUser;
import com.andawell.common.entity.constant.SecurityConstant;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.common.service.SysUserDetailService;
import com.andawell.upms.dto.LoginAccountInfo;
import com.andawell.upms.entity.SysAccountInfo;
import com.andawell.upms.feign.RemoteAccountService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * 构建平台系统登陆信息
 */
@Service("sysUserDetailService")
public class SysUserDetailServiceImpl implements SysUserDetailService {
    @Autowired
    private RemoteAccountService remoteAccountService;

    /**
     * 用户名密码登陆
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /**
         * 判断当前用户是否登陆，如果已经登陆则，获取登陆后缓存的信息 并返回
         */

        RestResultVo<LoginAccountInfo> result = remoteAccountService.findAccountInfo(username);
        if (result == null || result.getResult() == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        UserDetails userDetails = getUserDetails(result.getResult());
        return userDetails;
    }

    /**
     * 构建userdetails
     *
     * @param loginAccountInfo 用户信息
     * @return
     */
    private UserDetails getUserDetails(LoginAccountInfo loginAccountInfo) {

        SysAccountInfo sysAccountInfo = loginAccountInfo.getSysAccountInfo();
        /**
         * 账户ID
         */
        String accountId = sysAccountInfo.getId();
        /**
         * 账户名称
         */
        String name = sysAccountInfo.getNickname();
        /**
         * 账户账号
         */
        String username = sysAccountInfo.getUsername();
        /**
         * 账户对应的部门
         */
        String organName = sysAccountInfo.getOrganName();
        /**
         * 判断当前账户的使用状态
         */
        //String accountStatus = sysAccountInfo.getAccountStatus().name();
        //boolean enabled = StringUtils.equals(accountStatus, SecurityConstant.STATUS_NORMAL);
        boolean enabled = true;
        String[] organs = loginAccountInfo.getOrgans();
        String organId = null;
        if (organs.length > 0) {
            organId = loginAccountInfo.getOrgans()[0];
        }
        String[] roles = loginAccountInfo.getRoles();
        String roleId = null;
        if (roles.length > 0) {
            roleId = loginAccountInfo.getRoles()[0];
        }
        Set<String> dbAuthSet = new HashSet<>();
        dbAuthSet.add("andawell");
        Collection<? extends GrantedAuthority> authorities
                = AuthorityUtils.createAuthorityList(dbAuthSet.toArray(new String[0]));
        return new BaseUser(accountId, organId, organName, roleId, name, "andawell", dbAuthSet,
                username,
                SecurityConstant.BCRYPT + sysAccountInfo.getPassword(), enabled,
                true, true,
                true
                //!SecurityConstant.STATUS_LOCK.equals(accountStatus)
                , authorities);
    }
}
