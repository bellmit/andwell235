package com.andawell.material.service;

import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.material.entity.PKCX;
import com.andawell.material.query.PKCXQuery;
import com.andawell.material.query.TCkWjkQuery;
import com.andawell.material.vo.TCkWjkVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: yzy
 * @Description:
 * @Date: created in 2020/5/25 11:04
 */
public interface IPKCXService {
    /**
     * 盘库查询
     * @param
     * @return
     */
    List<PKCX> list(PKCXQuery pkcxQuery);

    /**
     *
     * @param pkcxQuery
     * @return
     */
    ListPageVo<PKCXQuery, PKCX> getPageList(PKCXQuery pkcxQuery);
}
