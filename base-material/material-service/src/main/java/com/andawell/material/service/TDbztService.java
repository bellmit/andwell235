package com.andawell.material.service;

import com.andawell.material.entity.TDbzt;

public interface TDbztService {

    /**
     * 删除调拨状态
     * @param id
     */
    void delete(String id);

    /**
     * 编辑调拨状态
     * @param tDbzt
     */
    void update(TDbzt tDbzt);

    /**
     * 新增调拨状态
     * @param tDbzt
     */
    void insert(TDbzt tDbzt);

}
