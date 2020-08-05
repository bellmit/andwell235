package com.andawell.upms.mapper;

import com.andawell.upms.entity.SysDataDict;
import com.andawell.upms.query.SysDataDictQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author DCY
 * 数据字典信息管理DAO层接口
 */
@Mapper
public interface SysDataDictMapper {
    /**
     * 数据字典列表信息查询Mapper
     *
     * @param query
     * @return
     */
    public List<SysDataDict> list(@Param("query") SysDataDictQuery query);

    /**
     * 数据字典信息新增
     *
     * @param roleInfo
     */
    public void insert(SysDataDict roleInfo);

    /**
     * 数据字典信息修改
     *
     * @param roleInfo
     */
    public void update(SysDataDict roleInfo);

    /**
     * 数据字典信息删除
     *
     * @param id
     */
    public void delete(String id);

    /**
     * 依据ID查询数据字典信息详情
     *
     * @param id
     * @return
     * @throws
     * @author dcy
     * @date 2019/1/14 14:09
     */
    public SysDataDict detail(String id);
}