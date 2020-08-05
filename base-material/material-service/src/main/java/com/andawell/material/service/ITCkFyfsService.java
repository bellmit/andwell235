package com.andawell.material.service;

import com.andawell.material.entity.TCkFyfs;
import com.andawell.material.entity.TXtCk;
import com.andawell.material.query.TCKFyfsQuery;
import com.andawell.material.query.TXtCkQuery;

import java.util.List;

/***
 * @author lhb
 * @Date: 2020/4/27 14:40
 * @Description:
 * @version : V1.0
 */
public interface ITCkFyfsService {
    /**
     * 运输方式查询接口
     * @param
     * @return
     */
    List<TCkFyfs> list(TCKFyfsQuery tckFyfsQuery);

    /**
     * 编辑运输方式
     * @param tCkFyfs
     */
    void update(TCkFyfs tCkFyfs);

    /**
     * 删除运输方式
     * @param id
     */
    void delete(String id);

    /**
     * 新增运输方式
     * @param tCkFyfs
     */
    void insert(TCkFyfs tCkFyfs);

}
