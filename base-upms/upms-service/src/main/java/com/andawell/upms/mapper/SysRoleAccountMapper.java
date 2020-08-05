package com.andawell.upms.mapper;

import com.andawell.upms.entity.SysRoleAccount;
import com.andawell.upms.query.SysRoleAccountQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author DCY
 * 角色账户关联信息管理DAO层接口
 */
@Mapper
public interface SysRoleAccountMapper {
    /**
     * 条件查询角色账户关联信息
     *
     * @param query
     * @return
     * @throws
     * @author dcy
     * @date 2019/1/7 13:56
     */
    public List<SysRoleAccount> list(@Param("query") SysRoleAccountQuery query);


    /**
     * 通过用户ID查询角色ID信息
     *
     * @param accountId
     * @return
     * @throws
     * @author dcy
     * @date 2019/4/28 16:26
     */
    public List<String> listRoleIdsByAccountId(@Param("accountId") String accountId);


    /**
     * 增加角色账户信息
     *
     * @param sysRoleAccount
     * @return
     * @throws
     * @author dcy
     * @date 2019/1/7 13:56
     */
    public void insert(SysRoleAccount sysRoleAccount);

    /**
     * 修改角色账户关联信息
     *
     * @param sysRoleAccount
     * @return
     * @throws
     * @author dcy
     * @date 2019/1/7 13:56
     */
    public void update(SysRoleAccount sysRoleAccount);

    /**
     * 依据角色账户关联信息删除与员工的关联信息
     *
     * @param sysRoleAccount
     * @return
     * @throws
     * @author dcy
     * @date 2019/1/7 13:56
     */
    public void delete(SysRoleAccount sysRoleAccount);

    /**
     * 批量依据角色账户关联信息删除与员工的关联信息
     *
     * @param sysAccountRoleList
     * @return
     * @throws
     * @author dcy
     * @date 2019/1/7 13:56
     */
    public void deleteList(@Param("list") List<String> sysAccountRoleList);
}