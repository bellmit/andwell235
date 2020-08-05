package com.andawell.purchase.service;


import com.andawell.purchase.entity.TCsJglx;
import com.andawell.purchase.entity.TXtQclx;
import com.andawell.purchase.query.TCsJglxQuery;
import com.andawell.purchase.query.TXtQcLxQuery;

import java.util.List;

/**
 * 价格类型
 */
public interface ITCsJglxService {

    /**
     * 价格类型查询
     */
    List<TCsJglx> jglxList(TCsJglxQuery query);
}
