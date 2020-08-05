package com.andawell.material.service.impl;

import com.andawell.common.entity.search.ListCommon;
import com.andawell.material.mapper.TJhMapper;
import com.andawell.material.query.JhQuery;
import com.andawell.material.service.TJhService;
import com.andawell.material.vo.TJhVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * @author hwd
 * @Date: 2020-05-27 10:06
 * @Description:
 * @version : V1.0
 */
@Service
public class TJhServiceImpl implements TJhService {

    @Autowired
    private TJhMapper tJhMapper;


    /**
     * 根据机型获取件号
     */
    public List<TJhVO> getlist(JhQuery jhQuery) {
        return new ListCommon<JhQuery, TJhVO>(jhQuery, (q) -> tJhMapper.getListByjx(q)).get();

    }
}
