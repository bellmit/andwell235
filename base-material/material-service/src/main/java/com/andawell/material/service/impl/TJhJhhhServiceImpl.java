package com.andawell.material.service.impl;

import com.andawell.material.dto.TJhJhhhDTO;
import com.andawell.material.dto.TJhPtjhDTO;
import com.andawell.material.entity.TJhJhhh;
import com.andawell.material.entity.TJhPtjh;
import com.andawell.material.mapper.TJhJhhhMapper;
import com.andawell.material.mapper.TJhPtjhMapper;
import com.andawell.material.service.ITJhJhhhService;
import com.andawell.material.service.ITJhPtjhService;
import com.andawell.material.util.BeanUtils;
import com.andawell.material.utils.ValidableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *@Auther:gzh
 *@Date:2020/5/20 15:00
 *@Description: 通用件号管理
 */
@Service
public class TJhJhhhServiceImpl implements ITJhJhhhService {


    @Autowired
    TJhJhhhMapper tJhJhhhMapper;


    /**
     *@Auther:gzh
     *@Date:2020/7/1 10:37
     *@Description:通用件号新增
     * 遍历集合出单个的对象
     * 转换对象数据
     * 向数据库插入数据
     *@Param:
     *@return:
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(ValidableList<TJhJhhhDTO> tJhJhhhDTO) {
        tJhJhhhDTO.stream().forEach(oneJhJhhh->{
            tJhJhhhMapper.insert(BeanUtils.dtoTODO(oneJhJhhh, TJhJhhh.class));
        });
    }


    /**
     *@Auther:gzh
     *@Date:2020/7/1 10:37
     *@Description:通用件号删除
     * 根据件号跟替换件号来进行删除
     *@Param:
     *@return:
     */
    @Override
    public void delete(TJhJhhhDTO tJhJhhhDTO) {
        tJhJhhhMapper.deleteByPrimaryKey(tJhJhhhDTO.getJh(),tJhJhhhDTO.getThjh());
    }

    /**
     * 判重
     *
     * @param oneTJhJhhh
     */
    @Override
    public TJhJhhh selectTJhJhhh(TJhJhhhDTO oneTJhJhhh) {
        return tJhJhhhMapper.selectByPrimaryKey(oneTJhJhhh.getJh(),oneTJhJhhh.getThjh());
    }


}
