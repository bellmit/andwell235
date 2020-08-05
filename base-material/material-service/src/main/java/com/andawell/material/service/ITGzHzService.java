package com.andawell.material.service;

import com.andawell.material.dto.TCkCrkDTO;
import com.andawell.material.dto.TGzHzDTO;
import com.andawell.material.entity.TGzHz;

import java.util.List;

/***
 * @author shs
 * @Date: 2020/5/7 15:40
 * @Description:
 * @version : V1.0
 */
public interface ITGzHzService {

    /**
     * 入库回执跟踪登记
     * @param
     * @return
     */
    void insert(List<TGzHz> tGzHzDTO);
    /**
     * 出库回执跟踪
     * @param
     * @return
     */
    void updateTCkCrk(TCkCrkDTO tCkCrkDTO);
    /**
     * 入库回执查询
     * @param
     * @return
     */
    void updaterkhz(TGzHzDTO tGzHz);
    /**
     * 入库回执查询添加
     * @param
     * @return
     */
    void inserttgzhz(List<TGzHzDTO> tGzHzDTO);
}
