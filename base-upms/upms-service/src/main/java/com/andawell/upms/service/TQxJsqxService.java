package com.andawell.upms.service;


import com.andawell.upms.dto.TQxJsqxDto;
import com.andawell.upms.entity.TQxJsqx;
import com.andawell.upms.query.TQxJsqxQuery;

import java.util.List;

/**
 * 角色权限管理接口
 */

public interface TQxJsqxService {

    /***
     * @author gzh
     * @Date: 2020/5/13 10:11
     * @Description: 角色权限查询
     */
    String[] list(TQxJsqxQuery query);

    /**
     *@Auther:gzh
     *@Date:2020/5/15 14:53
     *@Description: 角色权限添加
     *@Param:
     *@return:
     */
    void Insert(TQxJsqxDto tQxJsqxDto);
    /**
     *@Auther:gzh
     *@Date:2020/5/15 14:53
     *@Description: 角色权限删除
     *@Param:
     *@return:
     */
    void delete(TQxJsqxDto tQxJsqxDto);
}
