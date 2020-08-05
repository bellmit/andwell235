package com.andawell.upms.service;

import com.andawell.upms.entity.TJhZylx;
import com.andawell.upms.query.TJhZylxQuery;

import java.util.List;

public interface TJhZylxService {
    List<TJhZylx> list(TJhZylxQuery query);
}
