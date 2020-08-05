package com.andawell.material.service;

import com.andawell.material.entity.*;
import com.andawell.material.query.TTzzWzQuery;
import com.andawell.material.vo.TTzzWzVO;

import java.util.List;

public interface TTzzWzService {

    List<TTzzWzVO> list(TTzzWzQuery query);

    /**
     * 通专装物资新增
     * @param tTzzWz
     */
    void insert(TTzzWz tTzzWz);

    /**
     * 通专装物资编辑
     * @param tTzzWz
     */
    void update(TTzzWz tTzzWz);


    /**
     * 通专装物资删除
     * @param jh
     */
    void delete(String jh);

    /**
     * 入库
     * @param tTzzCrk
     * @param tTzzCkList
     * @param tTzzCrkqdList
     */
    void insertCrk(TTzzCrk tTzzCrk, List<TTzzCk> tTzzCkList, List<TTzzCrkqd> tTzzCrkqdList);

    /**
     * 出库
     * @param tTzzCrk
     * @param tTzzCkList
     * @param tTzzCrkqdList
     */
    void updateCrk(TTzzCrk tTzzCrk, List<TTzzCk> tTzzCkList, List<TTzzCrkqd> tTzzCrkqdList);

    /**
     * 编号生成
     * @param tTzzCrkqd
     * @return
     */
    String getBh(TTzzCrkqd tTzzCrkqd);

    /**
     * 获取文号
     * @param tTzzCrk
     * @return
     */
    String getWh(TTzzCrk tTzzCrk);

}
