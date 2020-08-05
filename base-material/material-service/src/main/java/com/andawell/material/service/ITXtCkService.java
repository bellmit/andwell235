package com.andawell.material.service;

import com.andawell.common.entity.dto.PageDto;
import com.andawell.material.entity.CurrencyInfo;
import com.andawell.material.entity.TXtCk;
import com.andawell.material.query.CurrencyQuery;
import com.andawell.material.query.TXtCkQuery;

import java.util.List;

/***
 * @author lhb
 * @Date: 2020/4/27 14:40
 * @Description:
 * @version : V1.0
 */
public interface ITXtCkService {
    /**
     * 仓库查询接口
     * @param
     * @return
     */
    List<TXtCk> list(TXtCkQuery tXtCkQuery);
}
