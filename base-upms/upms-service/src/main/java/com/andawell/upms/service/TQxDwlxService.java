package com.andawell.upms.service;

import com.andawell.upms.entity.TQxDwlx;
import com.andawell.upms.query.TQxDwlxQuery;

import java.util.List;

public interface TQxDwlxService {
    TQxDwlx getDetail(String id);


    List<TQxDwlx> list(TQxDwlxQuery query);
}
