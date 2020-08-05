package com.andawell.material.service.impl;

import com.andawell.common.entity.search.ListCommon;
import com.andawell.material.entity.CurrencyInfo;
import com.andawell.material.mapper.CurrencyInfoMapper;
import com.andawell.material.query.CurrencyQuery;
import com.andawell.material.service.ICurrencyInfoInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/***
 * @author lhb
 * @Date: 2020/4/26 17:29
 * @Description:
 * @version : V1.0
 */
@Service
public class CurrencyInfoServiceImpl implements ICurrencyInfoInfoService {

    @Autowired
    CurrencyInfoMapper currencyInfoMapper;

    @Override
    public List<CurrencyInfo> list(CurrencyQuery query) {
        return new ListCommon<CurrencyQuery, CurrencyInfo>(query,
                (q) -> currencyInfoMapper.list(q)).get();
    }
}
