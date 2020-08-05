package com.andawell.search.service;

import com.andawell.search.entity.XmlSearchAccount;
import com.andawell.search.query.XmlSearchAccountQuery;

import java.util.List;

public interface XmlSearchAccountService {
    List<XmlSearchAccount> list(XmlSearchAccountQuery query);

    void insert(XmlSearchAccount xmlSearchAccount);
}
