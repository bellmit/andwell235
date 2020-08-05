package com.andawell.material.service;

import com.andawell.material.entity.response.THtDhqdBO;
import com.andawell.material.query.THtDhqdQuery;
import com.andawell.material.vo.THtDhqdVO;

import java.util.List;

/**
 * @Date： 2020/4/29 11:35
 */
public interface ITHtDhqdService {

    /**
     * 根据合同id查询合同的详细信息
     * @param tHtDhqdQuery
     * @return
     */
    List<THtDhqdVO> detailedList(THtDhqdQuery tHtDhqdQuery);
}
