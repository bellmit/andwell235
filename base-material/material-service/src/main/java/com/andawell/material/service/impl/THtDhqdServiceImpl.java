package com.andawell.material.service.impl;


import com.andawell.material.entity.TXtCk;
import com.andawell.material.entity.response.THtDhqdBO;
import com.andawell.material.mapper.THtDhqdMapper;
import com.andawell.material.query.THtDhqdQuery;
import com.andawell.material.query.TXtCkQuery;
import com.andawell.material.service.ITHtDhqdService;
import com.andawell.material.vo.THtDhqdVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Date： 2020/4/29 11:35
 */
@Service
public class THtDhqdServiceImpl implements ITHtDhqdService {

    @Autowired
    private THtDhqdMapper tHtDhqdMapper;

    /**
     * 根据合同id查询合同的详细信息
     * @param tHtDhqdQuery
     * @return
     */
    @Override
    public List<THtDhqdVO> detailedList(THtDhqdQuery tHtDhqdQuery) {
        return tHtDhqdMapper.findDetailListByHtbh(tHtDhqdQuery);
    }
}
