package com.andawell.material.service.impl;


import com.andawell.common.entity.search.ListCommon;
import com.andawell.common.util.BusinessException;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.dto.TJhJhDTO;
import com.andawell.material.entity.TRyZw;
import com.andawell.material.mapper.TQxYhMapper;
import com.andawell.material.mapper.TRyZwMapper;
import com.andawell.material.query.TJhJhQuery;
import com.andawell.material.query.listzwQuery;
import com.andawell.material.service.ITQxYhService;
import com.andawell.material.service.ITRyZwService;
import com.netflix.discovery.converters.Auto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 职务下拉列表查询
 *
 * @Date： 2020/5/8 14:12
 */
@Service
public class TRyZwServiceImpl implements ITRyZwService {

    @Autowired
    private TRyZwMapper tRyZwMapper;

    /**
     * 职务查询
     */
    @Override
    public List<TRyZw> list(listzwQuery query) {
        return new ListCommon<listzwQuery, TRyZw>(query,
                (q) -> tRyZwMapper.list(q)).get();
    }

    @Override
    public void insertOne(TRyZw ryZw) {

        int id = 0;
        try {
            String maxId = tRyZwMapper.getMaxId();
            id = Integer.parseInt(maxId)+1;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            id = 1;
        }
        ryZw.setId(String.valueOf(id));
        tRyZwMapper.insertSelective(ryZw);
    }

    @Override
    public void insertTwo(TRyZw ryZw) {

        String twoMaxId = tRyZwMapper.getTwoMaxId(ryZw.getId());
        if (StringUtils.isEmpty(twoMaxId)){
            String id = ryZw.getId()+"01";
            ryZw.setPid(ryZw.getId());
            ryZw.setId(id);

        }else {
            int id = Integer.parseInt(twoMaxId)+1;
            ryZw.setPid(ryZw.getId());
            ryZw.setId(String.valueOf(id));
        }
        tRyZwMapper.insertSelective(ryZw);
    }

    @Override
    public TRyZw selectByMc(String mc) {
        return tRyZwMapper.selectByMc(mc);
    }

    @Override
    public List<TRyZw> listTwoZw(String id) {
        return tRyZwMapper.listTwoZw(id);
    }

    @Override
    public void update(TRyZw ryZw) {
        tRyZwMapper.updateByPrimaryKeySelective(ryZw);
    }

    @Override
    public void delete(String id) {
        tRyZwMapper.deleteByPrimaryKey(id);
    }



  /*  @Override
    public List<TJhJhDTO> list(TJhJhQuery tJhJhQuery) {
        return new ListCommon<TJhJhQuery, TJhJhDTO>(tJhJhQuery,
                (q) -> tJhJhMapper.list(q)).get();
    }*/


}
