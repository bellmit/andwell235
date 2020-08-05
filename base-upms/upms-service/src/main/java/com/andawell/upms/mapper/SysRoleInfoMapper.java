package com.andawell.upms.mapper;

import com.andawell.upms.entity.SysRoleInfo;
import com.andawell.upms.query.SysRoleInfoQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author DCY
 * 角色信息管理DAO层接口
 */
@Mapper
public interface SysRoleInfoMapper {
    /**
     * 角色列表信息查询Mapper
     *
     * @param query
     * @return
     */
    public List<SysRoleInfo> list(@Param("query") SysRoleInfoQuery query);

    /**
     * 角色信息新增
     *
     * @param roleInfo
     */
    public void insert(SysRoleInfo roleInfo);

    /**
     * 角色信息修改
     *
     * @param roleInfo
     */
    public void update(SysRoleInfo roleInfo);

    /**
     * 角色信息删除
     *
     * @param id
     */
    public void delete(String id);
    /**
     * 依据ID查询员工信息详情
     *
     * @param id
     * @return
     * @throws
     * @author dcy
     * @date 2019/1/14 14:09
     */
    public SysRoleInfo detail(String id);
}