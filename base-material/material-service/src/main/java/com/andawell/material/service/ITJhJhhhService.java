package com.andawell.material.service;


import com.andawell.material.dto.TJhJhhhDTO;
import com.andawell.material.entity.TJhJhhh;
import com.andawell.material.utils.ValidableList;

/**
 * 通用件号管理
 */
public interface ITJhJhhhService {


    void insert(ValidableList<TJhJhhhDTO>  tJhJhhhDTO);

    void delete(TJhJhhhDTO tJhJhhhDTO);
    /**
     * 判重
     */
    TJhJhhh selectTJhJhhh(TJhJhhhDTO oneTJhJhhh);


}
