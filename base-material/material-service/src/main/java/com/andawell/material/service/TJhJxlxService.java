package com.andawell.material.service;

import com.andawell.material.entity.TJhJxlx;

public interface TJhJxlxService {

    /**
     * 新增件号机型类型
     * @param tJhJxlx
     */
    void insert(TJhJxlx tJhJxlx);

    /**
     * 编制件号机型类型
     * @param tJhJxlx
     */
    void update(TJhJxlx tJhJxlx);

    /**
     * 删除件号机型类型
     * @param id
     */
    void delete(String id);

}
