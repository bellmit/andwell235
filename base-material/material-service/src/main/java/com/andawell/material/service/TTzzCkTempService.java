package com.andawell.material.service;

import com.andawell.material.entity.TTzzCkTemp;

import java.util.List;

public interface TTzzCkTempService {

    /**
     * 批量导入
     * @param tTzzCkTempList
     */
    void insertAll(List<TTzzCkTemp> tTzzCkTempList);

}
