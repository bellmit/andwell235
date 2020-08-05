package com.andawell.upms.mapper;

import com.andawell.upms.entity.SysRoleMenu;
import com.andawell.upms.entity.SysRoleMenu;
import com.andawell.upms.query.SysRoleMenuQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author DCY
 * 角色菜单关联信息管理DAO层接口
 */
@Mapper
public interface SysRoleMenuMapper {
    /**
     * 条件查询角色菜单关联信息
     *
     * @param query
     * @return
     * @throws
     * @author dcy
     * @date 2019/1/7 13:56
     */
    public List<SysRoleMenu> list(@Param("query") SysRoleMenuQuery query);

    /**
     * 增加角色菜单信息
     *
     * @param sysRoleMenu
     * @return
     * @throws
     * @author dcy
     * @date 2019/1/7 13:56
     */
    public void insert(SysRoleMenu sysRoleMenu);

    /**
     * 修改角色菜单关联信息
     *
     * @param sysRoleMenu
     * @return
     * @throws
     * @author dcy
     * @date 2019/1/7 13:56
     */
    public void update(SysRoleMenu sysRoleMenu);

    /**
     * 依据角色菜单关联信息删除与员工的关联信息
     *
     * @param sysRoleMenu
     * @return
     * @throws
     * @author dcy
     * @date 2019/1/7 13:56
     */
    public void delete(SysRoleMenu sysRoleMenu);

    /**
     * 批量添加账户权限信息
     *
     * @param sysRoleMenuList
     * @return
     * @throws
     * @author dcy
     * @date 2019/1/7 13:56
     */
    public void insertList(@Param("list") List<SysRoleMenu> sysRoleMenuList);
}