package com.andawell.material.service;

import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.material.dto.BatchChangeDTO;
import com.andawell.material.entity.TCkDx;
import com.andawell.material.query.TCkDxQuery;
import com.andawell.material.vo.TCkDxOutLibraryVO;
import com.andawell.material.vo.TCkDxSendForRepairVO;
import com.andawell.material.vo.TCkDxStatusVO;

import java.util.List;

public interface TCkDxService {

    /**
     *@Author: liuys
     *@Data: 2020/6/15
     *@Description: 修改待修状态
     */
    int updateByStatusKey(TCkDx tCkDx);


     ListPageVo<TCkDxQuery,TCkDxStatusVO> list(TCkDxQuery query);

    /**
     * 出库待修列表
     * @param query
     * @return
     */
    ListPageVo<TCkDxQuery, TCkDxOutLibraryVO>  outLibraryList(TCkDxQuery query);


    /**
     * 送修待修列表
     * @param query
     * @return
     */
    ListPageVo<TCkDxQuery, TCkDxSendForRepairVO>  getSendRepairList(TCkDxQuery query);




    void batchChange(BatchChangeDTO batchChangeDTO);


}
