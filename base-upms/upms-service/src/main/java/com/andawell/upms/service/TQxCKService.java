package com.andawell.upms.service;


import com.andawell.upms.dto.TQxCkDto;
import com.andawell.upms.dto.TQxYhDto;
import com.andawell.upms.dto.TQxYhFpDto;

import java.util.List;

/**
 * 角色仓库接口
 */
public interface TQxCKService {


    /***
     * @author gzh
     * @Date: 2020/5/13
     * @Description:新增角色仓库
     *
     */
    void insert(TQxCkDto tQxCkDto);
    /***
     * @author gzh
     * @Date: 2020/5/13
     * @Description:s删除角色仓库
     */
    void delete(TQxCkDto tQxCkDto);


    List<String> getRoleNuderWarehouse(String js);
}
