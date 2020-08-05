package com.andawell.material.service.impl;

import com.andawell.common.entity.search.ListCommon;
import com.andawell.material.dto.TJhJhDTO;
import com.andawell.material.dto.TJhJhjxDTO;
import com.andawell.material.entity.TJhJh;
import com.andawell.material.entity.TJhJxjh;
import com.andawell.material.mapper.TJhJhMapper;
import com.andawell.material.mapper.TJhJxjhMapper;
import com.andawell.material.query.TJhJhQuery;

import com.andawell.material.service.ITJhJhService;
import com.andawell.material.util.BeanUtils;
import com.andawell.material.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/***
 * @author lhb
 * @Date: 2020/4/26 17:29
 * @Description:
 * @version : V1.0
 */
@Service
public class TJhJhServiceImpl implements ITJhJhService {


    @Autowired
    TJhJhMapper tJhJhMapper;

    /**
     * 机型件号中间表mapper
     */
    @Autowired
    TJhJxjhMapper tJhJxjhMapper;


    @Override
    public List<TJhJhDTO> list(TJhJhQuery tJhJhQuery) {
        return new ListCommon<TJhJhQuery, TJhJhDTO>(tJhJhQuery,
                (q) -> tJhJhMapper.list(q)).get();
}

    @Override
    public void insert(TJhJhDTO tJhJhDTO) {

        TJhJh tJhJh = BeanUtils.dtoTODO(tJhJhDTO, TJhJh.class);
        tJhJh.setDw(tJhJhDTO.getJhDwMc());
        tJhJhMapper.insertSelective(tJhJh);
    }

    @Override
    public void update(TJhJhDTO jhJhDTO) {
        TJhJh tJhJh = BeanUtils.dtoTODO(jhJhDTO, TJhJh.class);
        tJhJh.setDw(jhJhDTO.getJhDwMc());
        tJhJhMapper.updateByPrimaryKeySelective(tJhJh);
    }

    @Override
    public void delete(String id) {
        tJhJhMapper.deleteByPrimaryKey(id);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertjhjx(TJhJhjxDTO tJhJhjxDTO) {
        TJhJxjh tJhJxjh = new TJhJxjh();
        tJhJxjh.setJh(tJhJhjxDTO.getJh());
        tJhJhjxDTO.getJx().stream().forEach(oneJx->{
            tJhJxjh.setJx(oneJx);
            tJhJxjhMapper.insert(tJhJxjh);
        });
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deletejhjx(TJhJhjxDTO tJhJhjxDTO) {
        tJhJhjxDTO.getJx().stream().forEach(oneJx->{
            tJhJxjhMapper.deleteByPrimaryKey(oneJx,tJhJhjxDTO.getJh());
        });
    }

}
