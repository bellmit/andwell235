package com.andawell.material.service;

import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.material.dto.LibraryInfoDTO;
import com.andawell.material.dto.OutLibraryInfoDTO;
import com.andawell.material.query.TCkWjkQuery;
import com.andawell.material.vo.TCkWjkVO;

import java.util.List;

/***
 * @author lhb
 * @Date: 2020/5/15 15:38
 * @Description:
 * @version : V1.0
 */
public interface ILendingService {


    /**
     * 入库页面
     * @param query
     * @return
     */
    ListPageVo<TCkWjkQuery, TCkWjkVO> getListPage(TCkWjkQuery query);
}
