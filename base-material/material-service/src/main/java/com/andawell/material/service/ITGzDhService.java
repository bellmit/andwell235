package com.andawell.material.service;

import com.andawell.material.dto.TGzDhDTO;
import com.andawell.material.entity.TGzDh;

import java.util.List;

/***
 * @author shs
 * @Date: 2020/5/7 15:40
 * @Description:
 * @version : V1.0
 */
public interface ITGzDhService {
    /**
     * 航材添加功能
     * @param
     * @return
     */
    void insertTGzDhList(List<TGzDh> tGzDh);
    /**
     * 航材入库确认
     * @param
     * @return
     */
    void updateTGzDh(TGzDhDTO tGzDhDTO);


}
