package com.andawell.material.service.impl;

import com.andawell.common.util.SysUserUtils;
import com.andawell.material.dto.TZbBzDTO;
import com.andawell.material.entity.TZbBz;
import com.andawell.material.mapper.TZbBzMapper;
import com.andawell.material.service.ITZbBzService;
import com.andawell.material.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TZbBzServiceImpl implements ITZbBzService {


    @Autowired
    private TZbBzMapper tZbBzMapper;

    @Override
    public void insert(TZbBzDTO tZbBzDTO) {
        TZbBz tZbBz = BeanUtils.dtoTODO(tZbBzDTO, TZbBz.class);
        tZbBz.setDwid(SysUserUtils.getUser().getDeptId());
        tZbBzMapper.insertSelective(tZbBz);
    }

    @Override
    public void delete(TZbBzDTO tZbBzDTO) {
        tZbBzMapper.deleteByPrimaryKey(tZbBzDTO.getDwid(),tZbBzDTO.getJx(),tZbBzDTO.getJh());
    }
}
