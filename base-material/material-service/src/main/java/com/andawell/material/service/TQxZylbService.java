package com.andawell.material.service;

import com.andawell.material.entity.TQxZylb;

public interface TQxZylbService {

    /**
     * 编辑资源类别
     * @param tQxZylb
     */
    void update(TQxZylb tQxZylb);

    /**
     * 删除资源类别
     * @param id
     */
    void delete(String id);

    /**
     * 新增资源类别
     * @param tQxZylb
     */
    void insert(TQxZylb tQxZylb);

}
