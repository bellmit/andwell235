package com.andawell.upms.service;

import com.andawell.upms.dto.TXtCkDto;
import com.andawell.upms.entity.TXtCk;
import com.andawell.upms.entity.TXtDw;
import com.andawell.upms.query.TXtCkQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TXtCkService {

    /**
     * 新增仓库
     * @param tXtCkDto
     */
    void insert(TXtCkDto tXtCkDto);

    /**
     * 编辑仓库
     * @param tXtCkDto
     */
    void update(TXtCkDto tXtCkDto);

    /**
     * 查询仓库
     * @param query
     * @return
     */
    List<TXtCk> list(TXtCkQuery query);

    /**
     * 删除仓库
     * @param tXtCkDto
     */
    void delete(TXtCkDto tXtCkDto);


}
