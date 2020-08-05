package com.andawell.material.service;

import com.andawell.material.dto.TCkAqkcDTO;
import com.andawell.material.dto.TJhDjDTO;
import com.andawell.material.query.TJhDjQuery;
import com.andawell.material.vo.TJhDjVO;

import java.util.List;

/***
 * @author shs
 * @Date: 2020/5/7 15:40
 * @Description:
 * @version : V1.0
 */
public interface ITCkAqkcService {
    /**
     * 航材安全库存量设置信息删除
     * @param
     * @param list
     * @return
     */
    void delete(TCkAqkcDTO list);

    /**
     * 航材安全库存量设置信息添加
     * @param
     * @param list
     * @return
     */
    void insert(TCkAqkcDTO list);
    /**
     * 航材安全库存量设置信息修改
     * @param
     * @param list
     * @return
     */
    void update(TCkAqkcDTO list);
}
