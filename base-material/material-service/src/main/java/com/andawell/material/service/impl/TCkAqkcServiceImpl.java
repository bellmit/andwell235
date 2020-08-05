package com.andawell.material.service.impl;

import com.andawell.common.util.BusinessException;
import com.andawell.material.dto.TCkAqkcDTO;
import com.andawell.material.entity.TCkAqkc;
import com.andawell.material.mapper.TCkAqkcMapper;
import com.andawell.material.service.ITCkAqkcService;
import com.andawell.material.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * @author shs
 * @Date: 2020/5/7 15:42
 * @Description:
 * @version : V1.0
 */
@Service
public class TCkAqkcServiceImpl implements ITCkAqkcService {

    @Autowired
    TCkAqkcMapper tCkAqkcMapper;

    /**
     * 航材安全库存量设置信息删除
     * @param ：shs
     * @return：
     * 1.根据传入的参数进行转换实体
     * 2.根据id删除数据
     */
    @Override
    public void delete(TCkAqkcDTO list) {
        TCkAqkc tCkAqkc = BeanUtils.dtoTODO(list, TCkAqkc.class);
        tCkAqkcMapper.deleteByPrimaryKey(tCkAqkc);
    }
    /**
     * 航材安全库存量设置信息添加
     * @param ：shs
     * @return：
     * 1.根据传入的参数进行转换实体
     * 2.对传入参数进行添加
     */
    @Override
    public void insert(TCkAqkcDTO list) {
        TCkAqkc tCkAqkc = BeanUtils.dtoTODO(list, TCkAqkc.class);
        TCkAqkc tCkAqkc1 = tCkAqkcMapper.selectByPrimaryKey(list.getJx(),list.getJh());
        if(tCkAqkc1!=null){
            throw new BusinessException("该机型，件号已设置库存量预警");
        }
        tCkAqkcMapper.insertSelective(tCkAqkc);
    }
    /**
     * 航材安全库存量设置信息修改
     * @param ：shs
     * @return：
     * 1.根据传入的参数进行转换实体
     * 2.对传入参数进行修改
     */
    @Override
    public void update(TCkAqkcDTO list) {
        TCkAqkc tCkAqkc = BeanUtils.dtoTODO(list, TCkAqkc.class);
        tCkAqkcMapper.updateByPrimaryKeySelective(tCkAqkc);
    }
}
