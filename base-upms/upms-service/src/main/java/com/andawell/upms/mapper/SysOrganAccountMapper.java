package com.andawell.upms.mapper;

import com.andawell.upms.entity.SysOrganAccount;
import com.andawell.upms.query.SysOrganAccountQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author DCY
 * 组织机构账户关联信息管理DAO层接口
 */
@Mapper
public interface SysOrganAccountMapper {
    /**
     * 条件查询组织机构账户关联信息
     *
     * @param query
     * @return
     * @throws
     * @author dcy
     * @date 2019/1/7 13:56
     */
    public List<SysOrganAccount> list(@Param("query") SysOrganAccountQuery query);


    /**
     * 通过用户ID查询组织机构ID信息
     *
     * @param accountId
     * @return
     * @throws
     * @author dcy
     * @date 2019/4/28 16:26
     */
    public List<String> listOrganIdsByAccountId(@Param("accountId") String accountId);


    /**
     * 增加组织机构账户信息
     *
     * @param sysOrganAccount
     * @return
     * @throws
     * @author dcy
     * @date 2019/1/7 13:56
     */
    public void insert(SysOrganAccount sysOrganAccount);

    /**
     * 修改组织机构账户关联信息
     *
     * @param sysOrganAccount
     * @return
     * @throws
     * @author dcy
     * @date 2019/1/7 13:56
     */
    public void update(SysOrganAccount sysOrganAccount);

    /**
     * 依据组织机构账户关联信息删除与员工的关联信息
     *
     * @param sysOrganAccount
     * @return
     * @throws
     * @author dcy
     * @date 2019/1/7 13:56
     */
    public void delete(SysOrganAccount sysOrganAccount);

    /**
     * 批量依据组织机构账户关联信息删除与员工的关联信息
     *
     * @param sysAccountOrganList
     * @return
     * @throws
     * @author dcy
     * @date 2019/1/7 13:56
     */
    public void deleteList(@Param("list") List<String> sysAccountOrganList);
}