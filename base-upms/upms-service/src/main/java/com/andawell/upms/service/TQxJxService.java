package com.andawell.upms.service;



import com.andawell.upms.dto.TQxJxDto;
import com.andawell.upms.entity.TQxJx;
import com.andawell.upms.query.TQxJxQuery;

import java.util.List;

/**
 * 角色机型接口
 */
public interface TQxJxService {


    /***
     * @author gzh
     * @Date: 2020/4/28 14:36
     * @Description: 新增角色机型
     */
    void insert(TQxJxDto tQxJxDto);
    /***
     * @author gzh
     * @Date: 2020/4/28 14:36
     * @Description: 删除角色机型
     */
    void delete(TQxJxDto tQxJxDto);

    /***
     * @author gzh
     * @Date: 2020/4/28 14:36
     * @Description: 角色下的机型
     */
    List<String> getRoleNuderModer(String js);
}
