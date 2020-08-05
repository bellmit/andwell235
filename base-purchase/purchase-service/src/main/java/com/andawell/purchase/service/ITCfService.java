package com.andawell.purchase.service;

import com.andawell.common.entity.vo.ListPageVo;

import com.andawell.purchase.query.TCfQuery;
import com.andawell.purchase.vo.TCfVO;

import java.util.List;

public interface ITCfService {
    /**
     * 供方下拉列表
     * @param query
     * @return
     */
    List<TCfVO> list(TCfQuery query);

}
