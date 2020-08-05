package com.andawell.upms.service;

import com.andawell.upms.entity.TXtZdfj;
import com.andawell.upms.entity.ZdfjDTO;
import com.andawell.upms.query.TXtZdfjQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TXtZdfjService {
    /**
     * 新增飞机号
     * @param tXtZdfj
     */
    void insert(TXtZdfj tXtZdfj);

    /**
     * 编辑飞机号
     * @param zdfjDTO
     */
    void update(ZdfjDTO zdfjDTO);

    /**
     * 飞机号删除
     * @param mc
     */
    void deleteByMc(String mc);

    /**
     * 查询飞机号
     * @param query
     * @return
     */
    List<TXtZdfj> list(TXtZdfjQuery query);


}
