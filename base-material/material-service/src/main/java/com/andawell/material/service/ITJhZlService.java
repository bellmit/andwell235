package com.andawell.material.service;

import com.andawell.material.entity.TJhZl;
import com.andawell.material.query.TJhZlQuery;

import java.util.List;

/***
 * @author lhb
 * @Date: 2020/4/27 14:40
 * @Description:
 * @version : V1.0
 */
public interface ITJhZlService {
    /**
     * 仓库查询接口
     * @param
     * @return
     */
    List<TJhZl> list(TJhZlQuery tJhZlQuery);
}
