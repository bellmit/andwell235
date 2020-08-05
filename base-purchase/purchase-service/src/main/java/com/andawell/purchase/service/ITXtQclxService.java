package com.andawell.purchase.service;


import com.andawell.purchase.entity.TXtQclx;
import com.andawell.purchase.query.TXtQcLxQuery;

import java.util.List;

/**
 * 器材类型
 */
public interface ITXtQclxService {

    /**
     * 器材类型查询
     */
    List<TXtQclx> qclxList(TXtQcLxQuery query);
}
