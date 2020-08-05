package com.andawell.search.service.impl;

import com.andawell.search.entity.XmlSearchAccount;
import com.andawell.search.mapper.XmlSearchAccountMapper;
import com.andawell.search.query.XmlSearchAccountQuery;
import com.andawell.search.service.XmlSearchAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XmlSearchAccountServiceImpl implements XmlSearchAccountService {
    @Autowired
    private XmlSearchAccountMapper xmlSearchAccountMapper;


    @Override
    public List<XmlSearchAccount> list(XmlSearchAccountQuery query) {
        return xmlSearchAccountMapper.list(query);
    }


    @Override
    public void insert(XmlSearchAccount xmlSearchAccount) {
        xmlSearchAccountMapper.insert(xmlSearchAccount);
    }
}
