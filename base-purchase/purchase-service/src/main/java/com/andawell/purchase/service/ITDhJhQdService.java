package com.andawell.purchase.service;

import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.purchase.dto.LtXqDTO;
import com.andawell.purchase.dto.TDhJhqdDTO;
import com.andawell.purchase.dto.excel.LtXqExcelDTO;
import com.andawell.purchase.entity.TDhJhqd;
import com.andawell.purchase.entity.TDhLtxqTemp;
import com.andawell.purchase.query.TDhJhqdQuery;
import com.andawell.purchase.query.TDhLtxqQuery;
import com.andawell.purchase.query.TDhLtxqTempQuery;
import com.andawell.purchase.vo.TDhJhqdVO;
import com.andawell.purchase.vo.TDhLtxqTempVO;
import com.andawell.purchase.vo.TDhLtxqVO;

import java.util.List;
/***
 * @author lhb
 * @Date: 2020/6/2 8:59
 * @Description:
 * @version : V1.0
 */

public interface ITDhJhQdService {

    /**
     * 导入旅团需求
     */
    void leadingIn(List<TDhLtxqTemp> tempList,String bh);

    /**
     * 导入订货计划
     */
    void leadingInDhJh(List<TDhJhqdVO> tempList, String bh);


    /**
     * 保存接口
     */
    void saveList(List<TDhJhqdDTO> tDhJhqdList);


    /**
     * 保存接口 旅团需求
     */
    void saveLtXQList(List<LtXqDTO> ltXqDTOList);

    /**
     * 根据编号删除excel
     * @param bh
     */
    void deleteLtXQExcelList(String bh);

    /**
     * 订货计划清单删除
     * @param bh
     */
    void delete(String bh);

    /**
     * 获取旅团需求
     */
    ListPageVo<TDhJhqdQuery, TDhJhqdVO> listPage(TDhJhqdQuery query);

    /**
     * 获取旅团需求
     */
    List<TDhLtxqVO> getLtXqList(TDhLtxqQuery tDhLtxqQuery);

    /**
     * 获取旅团需求Excel
     */
    List<TDhLtxqTempVO> getLtXqExcelList(TDhLtxqTempQuery tDhLtxqTempQuery);
}
