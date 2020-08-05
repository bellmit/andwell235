package com.andawell.upms.mapper;

import com.andawell.upms.entity.SysAccountMenu;
import com.andawell.upms.query.SysAccountMenuQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface SysAccountMenuMapper {
    /**
     * 条件查询账户权限信息
     *
     * @param query
     * @return
     * @throws
     * @author dcy
     * @date 2019/1/7 13:56
     */
    public List<SysAccountMenu> list(@Param("query") SysAccountMenuQuery query);

    /**
     * 增加账户权限信息
     *
     * @param sysAccountMenu
     * @return
     * @throws
     * @author dcy
     * @date 2019/1/7 13:56
     */
    public void insert(SysAccountMenu sysAccountMenu);

    /**
     * 修改账户权限信息
     *
     * @param sysAccountMenu
     * @return
     * @throws
     * @author dcy
     * @date 2019/1/7 13:56
     */
    public void update(SysAccountMenu sysAccountMenu);

    /**
     * 依据菜单信息删除账户的关联信息
     *
     * @param sysAccountMenu
     * @return
     * @throws
     * @author dcy
     * @date 2019/1/7 13:56
     */
    public void delete(SysAccountMenu sysAccountMenu);


    /**
     * 批量添加账户权限信息
     *
     * @param sysAccountMenuList
     * @return
     * @throws
     * @author dcy
     * @date 2019/1/7 13:56
     */
    public void insertList(@Param("list") List<SysAccountMenu> sysAccountMenuList);

}
