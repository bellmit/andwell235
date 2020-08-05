package com.andawell.upms.service;


import com.andawell.upms.dto.TQxJsDto;
import com.andawell.upms.dto.TQxJsqxDto;
import com.andawell.upms.entity.TQxJs;
import com.andawell.upms.entity.TQxJsqx;
import com.andawell.upms.query.TQxJsqxQuery;

import java.util.List;

/**
 * 角色管理接口
 */

public interface TQxJsService {

    /***
     * @author gzh
     * @Date: 2020/5/13 14:41
     * @Description: 新增角色
     */
    //TQxJsDto
    void insert(TQxJsDto tQxJsDto);

    /***
     * @author gzh
     * @Date: 2020/5/13 14:41
     * @Description: 修改角色
     */
    void update(TQxJsDto tQxJsDto);

    /***
     * @author gzh
     * @Date: 2020/4/28 14:36
     * @Description: 删除角色
     */
    void delete(String id);

    /**
     *@Auther:gzh
     *@Date:2020/5/20 14:15
     *@Description: 新增角色id判重
     */
    int selectById(String id);

    List<TQxJs> selectByPidId(String id);
}
