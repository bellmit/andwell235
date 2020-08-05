package com.andawell.purchase.service;

import com.andawell.purchase.dto.TDhJhDTO;
import com.andawell.purchase.entity.TDhJhqd;
import com.andawell.purchase.entity.TDhLtxq;
import com.andawell.purchase.query.TDhJhQuery;
import com.andawell.purchase.vo.TDhJhVO;

import java.util.List;

/***
 * @author GZH
 * @Date: 2020/6/2 8:59
 * @Description:
 * @version : V1.0
 */

public interface ITDhJhService {

    /**
     * 新增订货计划
     */
    void insert(TDhJhDTO tDhJhDTO);

    /**
     * 查询订货计划
     */
    void updateStatus(String bh);

    /**
     * 获取草稿状态
     * @return
     */
    TDhJhVO getInvalid();

    /**
     * 修改订货计划
     */
    void update(TDhJhDTO tDhJhDTO);

    /**
     * 订货计划下拉列表
     * @param query
     * @return
     */
    List<TDhJhVO> listJhbh(TDhJhQuery query);

}
