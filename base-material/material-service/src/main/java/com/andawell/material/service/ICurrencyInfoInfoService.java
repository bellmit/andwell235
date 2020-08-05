package com.andawell.material.service;

import com.andawell.material.entity.CurrencyInfo;
import com.andawell.material.query.CurrencyQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/***
 * @author lhb
 * @Date: 2020/4/26 17:17
 * @Description:
 * @version : V1.0
 */

public interface ICurrencyInfoInfoService {

    /**
     * 货币查询接口
     * @param query
     * @return
     */
    List<CurrencyInfo> list(CurrencyQuery query);
}
