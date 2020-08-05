package com.andawell.purchase.service;




/**
 * 合同付款
 */

import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.material.vo.TCkCrkqdVO;
import com.andawell.purchase.dto.THtFkDTO;


import com.andawell.purchase.query.THtFkQuery;
import com.andawell.purchase.vo.TDhJhqdVO;
import com.andawell.purchase.vo.THtFkVO;

import java.util.List;

/**
 *@Auther:gzh
 *@Date:2020/6/9 8:52
 */
public interface ITHtFkService {

    /**
     *@Auther:gzh
     *@Date:2020/6/9 9:16
     *@Description: 合同付款保存
     */
    void insert(THtFkDTO tHtFkDTO);

    /**
     * 过去 合同入库单明细
     * @param rkbh
     * @return
     */
    List<TCkCrkqdVO> getHtRkDList(String rkbh);

    /**
     * 合同入库单查询
     * @param query
     * @return
     */
    ListPageVo<THtFkQuery, THtFkVO> listPageHtFk(THtFkQuery query);
    /**
     * 合同入库单查看
     * @param query
     * @return
     */
    ListPageVo<THtFkQuery, THtFkVO> listPageHtFkck(THtFkQuery query);
}
