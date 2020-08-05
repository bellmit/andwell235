package com.andawell.upms.service;

import com.andawell.upms.entity.TXtBzlb;
import com.andawell.upms.query.TXtBzlbQuery;

import java.util.List;

public interface TXtBzlbService {

    List<TXtBzlb> list(TXtBzlbQuery query);
}
