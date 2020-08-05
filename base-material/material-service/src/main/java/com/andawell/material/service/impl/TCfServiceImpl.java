package com.andawell.material.service.impl;

import com.andawell.common.entity.search.ListCommon;
import com.andawell.material.entity.TCf;
import com.andawell.material.entity.TJhZylx;
import com.andawell.material.mapper.TCfMapper;
import com.andawell.material.query.TCfQuery;
import com.andawell.material.query.TJhZylxQuery;
import com.andawell.material.service.ITCfService;
import com.andawell.material.util.BeanUtils;
import com.andawell.material.vo.TCfVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: NXX012
 * @date: 2020/5/9
 * @description:
 */
@Service
public class TCfServiceImpl implements ITCfService {

    @Autowired
    private TCfMapper tCfMapper;

    @Override
    public List<TCfVO> list(TCfQuery query) {
        return new ListCommon<TCfQuery, TCfVO>(query,(q) -> {
            List<TCf> tCfs = tCfMapper.getList(q);
            List<TCfVO> tCfVOList = tCfs.stream().map(tCf -> {
                TCfVO tCfVO = BeanUtils.dtoTODO(tCf, TCfVO.class);
                return tCfVO;
            }).collect(Collectors.toList());
            return tCfVOList;
        }).get();
    }
}
