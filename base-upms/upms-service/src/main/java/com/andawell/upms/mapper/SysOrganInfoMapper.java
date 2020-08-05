package com.andawell.upms.mapper;

import com.andawell.upms.entity.SysOrganInfo;
import com.andawell.upms.entity.SysRoleInfo;
import com.andawell.upms.query.SysOrganInfoQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author DCY
 * 组织机构信息管理DAO层接口
 */
@Mapper
public interface SysOrganInfoMapper {
    /**
     * 组织机构列表信息查询Mapper
     *
     * @param query
     * @return
     */
    public List<SysOrganInfo> list(@Param("query") SysOrganInfoQuery query);

    /**
     * 组织机构信息新增
     *
     * @param organInfo
     */
    public void insert(SysOrganInfo organInfo);

    /**
     * 组织机构信息修改
     *
     * @param organInfo
     */
    public void update(SysOrganInfo organInfo);

    /**
     * 组织机构信息删除
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
    public SysOrganInfo detail(String id);
}