package com.andawell.material.service.impl;

import com.andawell.common.entity.search.ListCommon;
import com.andawell.material.dto.TJhJhDTO;
import com.andawell.material.dto.TJhPtjhDTO;
import com.andawell.material.entity.TJhJh;
import com.andawell.material.entity.TJhPtjh;
import com.andawell.material.mapper.TJhJhMapper;
import com.andawell.material.mapper.TJhPtjhMapper;
import com.andawell.material.query.TJhJhQuery;
import com.andawell.material.service.ITJhJhService;
import com.andawell.material.service.ITJhPtjhService;
import com.andawell.material.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@Auther:gzh
 *@Date:2020/5/20 15:00
 *@Description: 配套件号管理
 */
@Service
public class TJhPtjhServiceImpl implements ITJhPtjhService {


    @Autowired
    TJhPtjhMapper tJhPtjhMapper;


    /**
     *@Auther:gzh
     *@Date:2020/7/2 15:37
     *@Description:配套件号新增
     * 转换数据类型
     * 添加
     *@Param:
     *@return:
     */
    @Override
    public void insert(TJhPtjhDTO tJhPtjhDTO) {
        tJhPtjhMapper.insert(BeanUtils.dtoTODO(tJhPtjhDTO, TJhPtjh.class));
    }
    /**
     *@Auther:gzh
     *@Date:2020/7/1 10:37
     *@Description:配套件号删除
     * 根据件号机型跟配套件号来进行删除
     *@Param:
     *@return:
     */
    @Override
    public void delete(TJhPtjhDTO tJhPtjhDTO) {
        tJhPtjhMapper.deleteByPrimaryKey(tJhPtjhDTO.getJh(),tJhPtjhDTO.getPtjh(),tJhPtjhDTO.getJx());
    }

    @Override
    public TJhPtjh select(TJhPtjhDTO tJhPtjhDTO) {
        return tJhPtjhMapper.selectByPrimaryKey(tJhPtjhDTO.getJh(), tJhPtjhDTO.getPtjh(), tJhPtjhDTO.getJx());
    }
}
