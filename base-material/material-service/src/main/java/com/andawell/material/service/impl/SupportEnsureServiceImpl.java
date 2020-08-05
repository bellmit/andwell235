package com.andawell.material.service.impl;

import com.andawell.common.entity.search.ListCommon;
import com.andawell.common.util.BusinessException;
import com.andawell.material.dto.ManualCreationDTO;
import com.andawell.material.dto.TZyBzqdmxDTO;
import com.andawell.material.entity.*;
import com.andawell.material.mapper.*;
import com.andawell.material.service.SupportEnsureService;
import com.andawell.material.util.BeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/***
 * @author hwd
 * @Date: 2020-05-20 13:33
 * @Description:
 * @version : V1.0
 */
@Service
@Slf4j
public class SupportEnsureServiceImpl implements SupportEnsureService {


    @Autowired
    private TZyDyMapper tZyDyMapper;

    @Autowired
    private TZyRwxzMapper tZyRwxzMapper;

    @Autowired
    private TZyFjsMapper tZyFjsMapper;

    @Autowired
    private TZyRwscMapper tZyRwscMapper;


    @Autowired
    private TZyBzqdmxMapper tZyBzqdmxMapper;

    @Autowired
    private TZyBzMapper tZyBzMapper;

    @Autowired
    private TZyBzmxMapper tZyBzmxMapper;

    public List<TZyDy> getTZyDyList()
    {
        return new ListCommon<Object, TZyDy>((query) -> tZyDyMapper.list(null)).get();
    }

    @Override
    public List<TZyRwxz> getTZyRwxzList() {
        return new ListCommon<Object, TZyRwxz>((query) -> tZyRwxzMapper.list(null)).get();
    }

    @Override
    public List<TZyFjs> getTZyFjsList() {
        return new ListCommon<Object, TZyFjs>((query) -> tZyFjsMapper.list(null)).get();
    }

    @Override
    public List<TZyRwsc> getTZyRwscList() {
        return new ListCommon<Object, TZyRwsc>((query) -> tZyRwscMapper.list(null)).get();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveMessage(List<TZyBzqdmxDTO> tZyBzqdmxDTOS) {
        for (TZyBzqdmxDTO tZyBzqdmxDTO : tZyBzqdmxDTOS) {
            try {
                TZyBzqdmx tZyBzqdmx = BeanUtils.dtoTODO(tZyBzqdmxDTO, TZyBzqdmx.class);
                //首先判重
                TZyBzqdmx tZyBzqdmx1 = tZyBzqdmxMapper.selectByPrimaryKey(tZyBzqdmxDTO.getId(), tZyBzqdmxDTO.getJh());

                if(tZyBzqdmx1!=null) {
                    //存在
                    throw  new BusinessException(tZyBzqdmxDTO.getJh());
                }
                tZyBzqdmxMapper.insertSelective(tZyBzqdmx);
            }catch (Exception e)
            {
                e.printStackTrace();
                log.error(e.getMessage());
                throw  new BusinessException("件号："+tZyBzqdmxDTO.getJh()+"已添加");
            }

        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteMessage(List<TZyBzqdmxDTO> tZyBzqdmxDTOS) {
        for (TZyBzqdmxDTO tZyBzqdmxDTO : tZyBzqdmxDTOS) {
            try {
                tZyBzqdmxMapper.deleteByPrimaryKey(tZyBzqdmxDTO.getId(),tZyBzqdmxDTO.getJh());
            }catch (Exception e)
            {
                e.printStackTrace();
                log.error(e.getMessage());
                throw  new BusinessException(tZyBzqdmxDTO.getJh()+"删除失败");
            }

        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void setMessage(ManualCreationDTO message) {
        //获取最大ID
        int maxID = tZyBzMapper.getMaxID();
        TZyBz tZyBz = new TZyBz();
        org.springframework.beans.BeanUtils.copyProperties(message,tZyBz);
        tZyBz.setId(maxID+1);
        tZyBzMapper.insertSelective(tZyBz);
        for (TZyBzmx tZyBzmx : message.getTZyBzmxes()) {
            tZyBzmx.setId(tZyBz.getId());
            tZyBzmxMapper.insertSelective(tZyBzmx);
        }

    }


}
