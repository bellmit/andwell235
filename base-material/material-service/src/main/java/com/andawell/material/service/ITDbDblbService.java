package com.andawell.material.service;

import com.andawell.material.entity.TDbDblb;
import com.andawell.material.query.TDbDblbQuery;

import java.util.List;

/**
 * @author: zje
 * @date: 2020/6/5
 * @description:
 */
public interface ITDbDblbService {

    List<TDbDblb> list(TDbDblbQuery query);
}
