package com.andawell.upms.service;

import com.andawell.upms.entity.TXtZd;
import com.andawell.upms.entity.TXtZdfj;
import com.andawell.upms.query.TXtZdQuery;

import java.util.List;

public interface TXtZdService {
    /**
     * 编辑中队
     * @param tXtZd
     */
    void update(TXtZd tXtZd);

    /**
     * 新增中队
     * @param tXtZd
     */
    void insert(TXtZd tXtZd);

    /**
     * 查询中队
     * @param query
     * @return
     */
    List<TXtZd> list(TXtZdQuery query);

    /**
     * 获取单位下最大id值
     * @param dwid
     * @return
     */
    String getMaxZdid(String dwid);

    /**
     * 删除中队
     * @param query
     */
    void delete(TXtZdQuery query);

}
