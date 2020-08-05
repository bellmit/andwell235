package com.andawell.material.service;

import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.material.query.TDbJgdbQuery;
import com.andawell.material.vo.TDbSjsqVO;

import java.util.List;

/**
 * @author: zje
 * @date: 2020/6/1
 * @description:
 */
public interface ITDbSjsqService {

    ListPageVo<TDbJgdbQuery,TDbSjsqVO> list(TDbJgdbQuery query);

    void update(String sqdh);

}
