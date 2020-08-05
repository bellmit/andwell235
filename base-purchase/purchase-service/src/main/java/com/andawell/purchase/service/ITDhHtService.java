package com.andawell.purchase.service;

import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.purchase.query.THtQuery;
import com.andawell.purchase.vo.THtVO;

import com.andawell.purchase.dto.TDhHtDTO;

/***
 * @author lhb
 * @Date: 2020/6/4 13:35
 * @Description:
 * @version : V1.0
 */
public interface ITDhHtService {

    /**
     * 往年合同查询
     * @param query
     * @return
     */
    ListPageVo<THtQuery, THtVO> listPageBefore(THtQuery query);

    /**
     * 今年合同查询
     * @param query
     * @return
     */
    ListPageVo<THtQuery, THtVO> listPageAfter(THtQuery query);

    /**
     * 合同删除
     * @param jhbh
     */
    void delete(String jhbh);


    /**
     * 生成合同
     * @param tDhHtDTO
     */
    void saveHtAndQdList(TDhHtDTO tDhHtDTO);
}
