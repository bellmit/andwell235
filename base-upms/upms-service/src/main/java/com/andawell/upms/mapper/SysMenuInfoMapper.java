package com.andawell.upms.mapper;

import com.andawell.upms.entity.SysMenuInfo;
import com.andawell.upms.query.SysMenuInfoQuery;
import com.andawell.upms.vo.MenuTreeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysMenuInfoMapper {

    /**
     * 条件查询菜单信息
     *
     * @param query
     * @return
     * @throws
     * @author dcy
     * @date 2019/4/28 16:26
     */
    public List<SysMenuInfo> list(@Param("query") SysMenuInfoQuery query);

    /**
     * 增加菜单信息
     *
     * @param menuInfo
     * @return
     * @throws
     * @author dcy
     * @date 2019/4/28 16:26
     */
    public void insert(SysMenuInfo menuInfo);

    /**
     * 修改菜单信息
     *
     * @param menuInfo
     * @return
     * @throws
     * @author dcy
     * @date 2019/4/28 16:26
     */
    public void update(SysMenuInfo menuInfo);

    /**
     * 删除菜单信息（逻辑删除）
     *
     * @param menuInfo
     * @return
     * @throws
     * @author dcy
     * @date 2019/4/28 16:26
     */
    public void delete(SysMenuInfo menuInfo);


    /**
     * 通过角色ID查询菜单
     *
     * @param roleId
     * @return
     * @throws
     * @author dcy
     * @date 2019/4/28 16:26
     */
    public List<SysMenuInfo> listMenusByRoleIds(@Param("roleId") String roleId);

}
