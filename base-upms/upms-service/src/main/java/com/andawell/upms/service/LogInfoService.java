package com.andawell.upms.service;

import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.upms.entity.LogInfo;
import com.andawell.upms.query.LogInfoQuery;

import java.util.List;

public interface LogInfoService {
    public ListPageVo<LogInfoQuery, LogInfo> listPage(LogInfoQuery dto);

    public List<LogInfo> list(LogInfoQuery query);

    public long count(LogInfoQuery query);

    public LogInfo detail(String id);

    public void insert(LogInfo logInfo);

    public void update(LogInfo logInfo);

    public void delete(LogInfo logInfo);

}
