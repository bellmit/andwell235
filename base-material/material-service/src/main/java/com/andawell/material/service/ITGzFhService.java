package com.andawell.material.service;

import com.andawell.material.dto.TGzFhDTO;
import com.andawell.material.entity.TGzFh;

import java.util.List;

/***
 * @author shs
 * @Date: 2020/5/7 15:40
 * @Description:
 * @version : V1.0
 */
public interface ITGzFhService {

    /**
     * 航材登记接口
     * @param tGzFh
     */
    void insert(List<TGzFh> tGzFh);



    /**
     * 航材发货确认接口
     */
    void update(List<String> list);
}
