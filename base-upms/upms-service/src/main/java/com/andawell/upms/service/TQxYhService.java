package com.andawell.upms.service;


import com.andawell.upms.dto.TQxYhDto;
import com.andawell.upms.dto.TQxYhFpDto;
import com.andawell.upms.entity.TQxYh;
import com.andawell.upms.query.TQxYhQuery;

import java.util.List;

/**
 * 用户管理接口
 */
public interface TQxYhService {
    /**
     * 用户删除接口
     */
    void delete(String id);

    /**
     * 用户新增接口
     */
    void insert(TQxYhDto tQxYhDTO);

    /**
     * 用户登录名称判重接口
     */
    int DlmPc(String dlm);

    /**
     * 用户编辑接口
     */
    void update(TQxYhDto tQxYhDTO);

    /**
     * 用户角色分配接口
     */
    void updateyhfp(TQxYhFpDto tQxYhFpDto);

    /**
     * 用户信息查询接口
     */
    List<TQxYh> list(TQxYhQuery query);
    /**
     * 用户角色分配接口
     */
    TQxYh detail(String id);

    TQxYh selectDlmById(String id);
}
