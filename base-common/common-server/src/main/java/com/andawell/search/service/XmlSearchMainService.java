package com.andawell.search.service;

import com.andawell.search.entity.XmlSearchMain;
import com.andawell.search.query.XmlSearchMainQuery;

import java.util.List;

public interface XmlSearchMainService {
    List<XmlSearchMain> list(XmlSearchMainQuery query);
}
