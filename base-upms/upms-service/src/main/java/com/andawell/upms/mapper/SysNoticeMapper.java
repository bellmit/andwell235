package com.andawell.upms.mapper;

import com.andawell.upms.entity.SysNoticeInfo;
import com.andawell.upms.query.SysNoticeQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统公告Dao层接口
 * @author zoucx
 */
@Mapper
public interface SysNoticeMapper {
    /**
     * 系统公告新增mapper
     * @param sysNoticeInfo
     */
    void insert(SysNoticeInfo sysNoticeInfo);

    /**
     * 系统公共详情mapper
     * @param id
     * @return
     */
    SysNoticeInfo deatil(String id);

    /**
     * 系统公告修改mapper
     * @param sysNoticeInfo
     */
    void update(SysNoticeInfo sysNoticeInfo);

    /**
     * 系统公告发布mapper
     * @param sysNoticeInfo
     */
    void releaseNotice(SysNoticeInfo sysNoticeInfo);

    /**
     * 查询公告系统列表
     * @param query
     * @return
     */
    List<SysNoticeInfo> list(@Param("query") SysNoticeQuery query);

    /**
     * 系统公告删除
     * @param detail
     */
    void delete(SysNoticeInfo detail);
}
