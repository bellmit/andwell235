package com.andawell.upms.service.impl;

import com.andawell.common.entity.search.CountCommon;
import com.andawell.common.entity.search.DetailCommon;
import com.andawell.common.entity.search.ListCommon;
import com.andawell.common.entity.search.ListPageCommon;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.upms.entity.LogInfo;
import com.andawell.upms.mapper.LogInfoMapper;
import com.andawell.upms.query.LogInfoQuery;
import com.andawell.upms.service.LogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class LogInfoServiceImpl implements LogInfoService {
    @Autowired
    private LogInfoMapper logInfoMapper;

    @Override
    public ListPageVo<LogInfoQuery, LogInfo> listPage(LogInfoQuery dto) {
        return new ListPageCommon<LogInfoQuery, LogInfo>(dto, (q) -> logInfoMapper.list(q)).getVo();
    }

    @Override
    public List<LogInfo> list(LogInfoQuery query) {
        return new ListCommon<LogInfoQuery, LogInfo>(query, (q) -> logInfoMapper.list(q)).get();
    }

    @Override
    public long count(LogInfoQuery query) {
        return new CountCommon<LogInfoQuery, LogInfo>(query, (q) -> logInfoMapper.list(q)).get();
    }

    @Override
    public LogInfo detail(String id) {
        return new DetailCommon<LogInfoQuery, LogInfo>(new LogInfoQuery().setId(id), (q) -> logInfoMapper.list(q)).get();
    }

    @Override
    public void insert(LogInfo logInfo) {
        logInfoMapper.insert(logInfo);
    }

    @Override
    public void update(LogInfo logInfo) {
        logInfoMapper.update(logInfo);
    }

    @Override
    public void delete(LogInfo logInfo) {
        logInfoMapper.delete(logInfo);
    }
}
