package com.andawell.upms.mapper;

import com.andawell.upms.entity.SystemNoticeAppendix;
import com.andawell.upms.query.SysNoticeAppendixQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

/**
 * 系统公告附件Dao层接口
 * @author  zoucx
 *
 */
@Mapper
public interface SystemNoticeAppendixMapper {
    /**
     * 批量插入系统公告附件
     * @param systemNoticeAppendixList
     */
     void insertBatch(@Param("systemNoticeAppendixList") List<SystemNoticeAppendix> systemNoticeAppendixList);

    /**
     * 系统公告附件列表
     * @param sysNoticeAppendixQuery
     * @return
     */
    List<SystemNoticeAppendix> list(@Param("query") SysNoticeAppendixQuery sysNoticeAppendixQuery);

    /**
     * 根据系统公告id查询附件列表
     * @param id
     * @return
     */
    List<String> findAppendixUrlList(String id);

    /**
     * 删除公告附件
     * @param sNoticeId
     */
    void delete(String sNoticeId);
}
