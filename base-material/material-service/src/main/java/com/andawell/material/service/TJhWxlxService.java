package com.andawell.material.service;

import com.andawell.material.entity.TJhWxlx;

public interface TJhWxlxService {

    /**
     * 删除维修类型
     * @param id
     */
    void delete(String id);

    /**
     * 编辑维修类型
     * @param tJhWxlx
     */
    void update(TJhWxlx tJhWxlx);

    /**
     * 新增维修类型
     * @param tJhWxlx
     */
    void insert(TJhWxlx tJhWxlx);

}
