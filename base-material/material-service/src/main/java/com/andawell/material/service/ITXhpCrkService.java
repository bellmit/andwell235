package com.andawell.material.service;

import com.andawell.material.entity.TCkCrklb;
import com.andawell.material.entity.TXhpCrk;
import com.andawell.material.query.TXhpCrkQuery;

import java.util.List;

public interface ITXhpCrkService {

    /***
     * @author gzh
     * @Date: 2020/4/28 14:36
     * @Description: 来源单位查询
     */
    List<TXhpCrk> lydwList(TXhpCrkQuery query);

    /**
     *@Auther:gzh
     *@Date:2020/5/25 14:16
     *@Description: 查询批次号
     */
    TXhpCrk pch();
    /**
     *@Auther:gzh
     *@Date:2020/5/26 8:33
     *@Description: 入库文号
     */
    TXhpCrk wh(String jm);
}
